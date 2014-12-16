package com.intelligrape.linksharing.enums

public enum EmailTemplate {

    FORGOT_PASSWORD('/mail/forgotPassword'),
    REGISTER_USER('/mail/userRegistered'),
    INVITE_FRIENDS('/mail/inviteFriends')

    String templatePath

    EmailTemplate(String templatePath){
        this.templatePath = templatePath
    }

}