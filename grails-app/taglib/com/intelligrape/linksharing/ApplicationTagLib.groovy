package com.intelligrape.linksharing

class ApplicationTagLib {
    static defaultEncodeAs = [taglib: 'html']
    //static encodeAsForTags = [tagName: [taglib:'html'], otherTagName: [taglib:'none']]
    static namespace = "ls"
    def springSecurityService

    def showCreatedTopicsCount = { attrs ->
        User user = springSecurityService.currentUser as User
        Integer totalCount = 0
        if (user) {
            totalCount = Topic.countByCreator(user)
        }
        out << totalCount
    }

    def showTotalTopicsCount = { attrs ->
       out << Topic.count()
    }

    def showSubscribedTopicsCount = { attrs ->
        User user = springSecurityService.currentUser as User
        Integer totalCount = 0
        if (user) {
            totalCount = Subscription.countBySubscriber(user)
        }
        out << totalCount
    }


}
