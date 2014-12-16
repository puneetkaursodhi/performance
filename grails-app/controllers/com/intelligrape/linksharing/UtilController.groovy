package com.intelligrape.linksharing

import com.intelligrape.linksharing.utils.Constants
import grails.plugin.springsecurity.annotation.Secured

@Secured([Constants.ADMIN_ROLE])
class UtilController {
    def grailsCacheAdminService
    def springSecurityService
    def cacheService

    def index() {
        grailsCacheAdminService.clearBlocksCache()
        render "done"
    }

    def expireSubscribedTopicCache() {
        cacheService.expireSubscribedTopicsCount(springSecurityService.currentUser as User)
        render "done"

    }
}
