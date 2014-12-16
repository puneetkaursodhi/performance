package com.intelligrape.linksharing

import com.intelligrape.linksharing.enums.Seriousness

class Subscription {
    Seriousness seriousness

    Date dateCreated
    Date lastUpdated

    static mapping = {
        subscriber fetch: 'join'
        topic fetch: 'join'
    }
    static belongsTo = [topic: Topic, subscriber: User]

    static constraints = {
    }
}
