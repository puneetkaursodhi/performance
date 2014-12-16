package com.intelligrape.linksharing

import com.intelligrape.linksharing.utils.Constants
import grails.plugin.springsecurity.annotation.Secured

@Secured([Constants.USER_ROLE])
class HomePageController {

    def index() {

    }
}
