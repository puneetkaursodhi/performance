package com.intelligrape.linksharing

class Resource {
    String title
    String description
    Date dateCreated
    Date lastUpdated
    static mapping = {
        tablePerHierarchy false
    }
    static belongsTo = [creator: User, topic: Topic]
    static hasMany = [readStatus: ReadStatus, subscribers: Subscription]
    static constraints = {
        title(blank: false)
        description(blank: false, maxSize: 1024,type: 'text')
    }
}
