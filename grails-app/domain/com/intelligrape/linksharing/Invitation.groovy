package com.intelligrape.linksharing

class Invitation {

    List<String> emails
    Date dateCreated
    Date lastUpdated
    static belongsTo = [topic: Topic, sender: User]

    static constraints = {
    }
}
