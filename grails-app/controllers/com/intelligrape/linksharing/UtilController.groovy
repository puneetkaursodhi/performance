package com.intelligrape.linksharing

import grails.plugin.springsecurity.annotation.Secured

@Secured(['permitAll'])
class UtilController {
    def grailsCacheAdminService

    def index() {
        grailsCacheAdminService.clearBlocksCache()
    }
}
