package com.intelligrape.linksharing

import com.intelligrape.linksharing.utils.Constants
import grails.plugin.springsecurity.annotation.Secured

@Secured([Constants.USER_ROLE])
class HomePageController {
    def springSecurityService

    def index() {
        List<UserTopicCountVO> userTopicCountVOs = []
        List<User> users = User.list()
        users.each { User user ->
            int count = Topic.countByCreator(user)
            userTopicCountVOs << new UserTopicCountVO(user: user, count: count)
        }

//        def topics = Topic.createCriteria().list() {
//            projections {
//                groupProperty('creator')
//                count('creator')
//            }
//        }
//        topics.each {
//            userTopicCountVOs << new UserTopicCountVO(user: it[0], count: it[1])
//        }
//        List<User> users = User.findAllByIdNotInList(userTopicCountVOs.collect{it.user.id})
//        users.each {User user->
//            userTopicCountVOs << new UserTopicCountVO(user: user, count: 0)
//        }
        [userTopicCountVOs: userTopicCountVOs]

    }
}
