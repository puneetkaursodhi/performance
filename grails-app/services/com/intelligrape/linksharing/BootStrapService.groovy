package com.intelligrape.linksharing

import com.intelligrape.linksharing.enums.Seriousness
import com.intelligrape.linksharing.enums.Visibility
import com.intelligrape.linksharing.utils.Constants
import grails.transaction.Transactional

@Transactional
class BootStrapService {
    def springSecurityService

    def addSampleData() {
        createRoles()
        createCities()
        createDefaultUsers()
        addTopics()
        addResources()
        addSubscribers()
    }

    def createRoles() {
        Role.findOrSaveWhere(authority: Constants.ADMIN_ROLE)
        Role.findOrSaveWhere(authority: Constants.USER_ROLE)
    }

    def createCities() {
        if (City.count() == 0) {
            10.times {
                City.findOrSaveByName("City-${it + 1}")
            }
        }
    }

    public void createDefaultUsers() {
        if (User.count() == 0) {
            Role userRole = Role.findByAuthority(Constants.USER_ROLE)
            createUserIfNotExists("himanshu@intelligrape.com", "Himanshu", "Seth", "123456")
            createUserIfNotExists("bhagwat@intelligrape.com", "Bhagwat", "Kumar", "123456")
            createUserIfNotExists("puneet@intelligrape.com", "Puneet", "kaur", "123456")
            createUserIfNotExists("roni@intelligrape.com", "Roni", "Thomas", "123456", userRole)
            createUserIfNotExists("nikhil.bhandari@intelligrape.com", "Nikhil", "Bhandari", "123456", userRole)
        }
    }

    private void createUserIfNotExists(String email, String firstName, String lastName, String password, Role role = null) {
        User user = new User(email: email, firstName: firstName, lastName: lastName, password: springSecurityService.encodePassword(password), confirmPassword: password, accountLocked: false, enabled: true)
        if (!user.validate()) {
            user.errors.allErrors.each { log.error it }
        } else {
            user.save()
            UserRole.findOrSaveWhere(user: user, role: role ?: Role.findByAuthority(Constants.ADMIN_ROLE))
        }
    }

    def addTopics() {
        if (Topic.count() == 0) {
            List<User> users = User.list([offset: 0, max: 3])
            users.eachWithIndex { User user, int index ->
                addTopicAndSubscribe("Topic-${user.firstName}-${index + 1}", "This is test description for topic", Visibility.PUBLIC, user)
                addTopicAndSubscribe("Topic-${user.lastName}-${index + 1}", "This is test description for topic", Visibility.PRIVATE, user)
            }
        }
    }

    private addTopicAndSubscribe(String title, String description, Visibility visibility, User user) {
        Topic topic = new Topic(title: title, description: description, creator: user, visibility: visibility).save(failOnError: true)
        if (topic) {
            new Subscription(seriousness: Seriousness.VERY_SERIOUS, subscriber: user, topic: topic).save(failOnError: true)
        }

    }

    def addResources() {
        if (Resource.count() == 0) {
            List<Topic> topics = Topic.list([offset: 0, max: 4])
            topics.eachWithIndex { Topic topic, int index ->
                10.times {
                    LinkResource linkResource = new LinkResource(title: "This is resource for topic ${topic.title}  ${it} - by ${topic.creator.firstName}",
                            description: "popping and locking", url: "http://google.com", creator: topic.creator, topic: topic)
                    if (linkResource.save(failOnError: true)) {
                        new ReadStatus(reader: topic.creator, resource: linkResource).save()
                    }
                }
            }
        }

    }

    def addSubscribers() {
        List<User> users = User.list([offset: 2, max: 2])
        users.each { User user ->
            List<Topic> topicList = Topic.findAllByCreatorNotEqual(user, [max: 2, offset: 0])
            topicList.each { Topic topic ->
                new Subscription(seriousness: Seriousness.VERY_SERIOUS, subscriber: user, topic: topic).save(failOnError: true)
            }

        }
    }

}
