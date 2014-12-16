package com.intelligrape.linksharing

import grails.plugin.cache.CacheEvict
import grails.plugin.cache.Cacheable
import grails.transaction.Transactional

class CacheService {

    @Cacheable(value = 'subscribedTopicsCount', key = "'subscribedTopicCount'+#user.id")
    def getSubscribedTopicsCount(User user){
     return Subscription.countBySubscriber(user)
    }

    @CacheEvict(value = "subscribedTopicsCount", key = "'subscribedTopicCount'+#user.id")
    void expireSubscribedTopicsCount(User user) {}
}
