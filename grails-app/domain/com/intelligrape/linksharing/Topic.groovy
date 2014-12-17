package com.intelligrape.linksharing

import com.intelligrape.linksharing.enums.Visibility

class Topic {
    transient def grailsCacheAdminService

    String title
    String description
    Visibility visibility
    Date dateCreated
    Date lastUpdated

    static belongsTo = [creator: User]
    static hasMany = [resources: Resource, subscriptions: Subscription, invitations: Invitation]

    static mapping = {
        creator lazy: false
    }
    static constraints = {
        title(blank: false, unique: true)
        description(blank: false, maxSize: 1024)

    }

    def afterInsert(){
//        grailsCacheAdminService.clearBlocksCache()
    }
}
