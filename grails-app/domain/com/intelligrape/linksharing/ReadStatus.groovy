package com.intelligrape.linksharing

class ReadStatus {
    Date dateCreated
    Date lastUpdated


    static belongsTo = [reader:User, resource:Resource]
    static constraints = {
    }
}
