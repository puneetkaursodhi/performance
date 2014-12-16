import org.apache.log4j.Level
import org.apache.log4j.Logger
import org.hibernate.stat.Statistics

class ApplicationFilters {
    def sessionFactory
    def springSecurityService

    def filters = {

        all(controller: '*', action: '*') {
            before = {
                log.info("GrailsAccessLog at ${new Date()}:${request.getHeader("User-Agent")}   :${loggedInUserDetail()} : ${params?.findAll { !(it.key in ['password', 'confirmPassword']) }}");
            }
        }

        defaultTextForConsolePlugin(controller: 'console', action: '*') {
            before = {
                def defaultCode = grailsApplication.config.console.defaultCode
                if (!session['_grails_console_last_code_'] && defaultCode) {
                    session['_grails_console_last_code_'] = defaultCode
                }
            }
        }

        logHibernateStats(uri: "/**") {
            before = {
                if (profileRequest(grailsApplication.config.performace.analysis.enabled, params)) {
                    request.appRequestStartTime = System.currentTimeMillis()
                    Statistics stats = sessionFactory.statistics;
                    if (!stats.statisticsEnabled) {
                        stats.setStatisticsEnabled(true)
                    }
                    Logger sqlLogger = Logger.getLogger("org.hibernate.SQL");
                    request.currentLevel = sqlLogger.level
                    sqlLogger.setLevel(Level.TRACE)
                }
            }

            afterView = {
                if (profileRequest(grailsApplication.config.performace.analysis.enabled, params)) {
                    Long requestEndTime = System.currentTimeMillis()
                    log.info("Total time taken for displaying the page is : ${(requestEndTime - request.appRequestStartTime)}")
                    Statistics stats = sessionFactory.getStatistics()
                    double queryCacheHitCount = stats.getQueryCacheHitCount();
                    double queryCacheMissCount = stats.getQueryCacheMissCount();
                    double queryCacheHitRatio = (queryCacheHitCount / ((queryCacheHitCount + queryCacheMissCount) ?: 1))
                    log.info """
    ######################## Hibernate Stats for $controllerName/$actionName ##############################################
    Transaction Count:${stats.transactionCount}
    Flush Count:${stats.flushCount}
    Total Collections Fetched:${stats.collectionFetchCount}
    Total Collections Loaded:${stats.collectionLoadCount}
    Total Entities Fetched:${stats.entityFetchCount}
    Total Entities Loaded:${stats.entityFetchCount}
    Total Queries:${stats.queryExecutionCount}
    queryCacheHitCount:${queryCacheHitCount}
    queryCacheMissCount:${queryCacheMissCount}
    queryCacheHitRatio:${queryCacheHitRatio}
    ######################## Hibernate Stats ##############################################
                        """
                    stats.clear()
                    Logger sqlLogger = Logger.getLogger("org.hibernate.SQL");
                    sqlLogger.setLevel(request.currentLevel)
                }
            }

        }

    }

    boolean profileRequest(boolean performanceAnalysisEnabled, params) {
        return (performanceAnalysisEnabled && params.profileApp)
    }

    private String loggedInUserDetail() {
        if (springSecurityService.isLoggedIn()) {
            return "(User#${springSecurityService.principal.id})"
        } else {
            return "(Anonymous)"
        }
    }
}
