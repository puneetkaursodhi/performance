package com.intelligrape.linksharing

import grails.plugin.springsecurity.annotation.Secured

@Secured(['permitAll'])
class UtilController {
    def bootStrapService
    def springSecurityService

    def index() {
    render "hello"
    }
}
