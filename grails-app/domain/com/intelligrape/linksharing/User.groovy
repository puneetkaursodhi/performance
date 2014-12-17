package com.intelligrape.linksharing


class User {
     def springSecurityService

    String email
    String password
    String firstName
    String lastName
    Date dateCreated
    Date lastUpdated
    String confirmPassword
    boolean enabled = true
    boolean accountExpired = false
    boolean accountLocked = false
    boolean passwordExpired = false
    City city

    static hasMany = [topics: Topic, subscriptions: com.intelligrape.linksharing.Subscription, resources: Resource, read: ReadStatus]

    static transients = ['confirmPassword']
    static constraints = {
        email(unique: true, email: true)

        confirmPassword bindable: true

//        password(validator: { val, obj ->
//            if (!val?.equals(obj.confirmPassword)) {
//                return false
//            }
//        })
        city(nullable: true)
    }

    static mapping = {
        password column: '`password`'
        cache true
    }


    Set<Role> getAuthorities() {
        UserRole.findAllByUser(this).collect { it.role }
    }

    def beforeInsert() {
//        encodePassword()
    }

    def beforeUpdate() {
//        if (isDirty('password')) {
//            encodePassword()
//        }
    }

    protected void encodePassword() {
       password = springSecurityService.encodePassword(password)
    }

}
