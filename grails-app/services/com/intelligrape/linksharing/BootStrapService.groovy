package com.intelligrape.linksharing

import com.intelligrape.linksharing.utils.Constants
import grails.transaction.Transactional

@Transactional
class BootStrapService {
    def springSecurityService

    def addSampleData() {
        createRoles()
        createCities()
        createDefaultUsers()
    }

    def createRoles() {
        Role.findOrSaveWhere(authority: Constants.ADMIN_ROLE)
        Role.findOrSaveWhere(authority: Constants.USER_ROLE)
    }

    def createCities() {
        if (City.count() == 0) {
            10.times {
                City.findOrSaveByName("City-${it+1}")
            }
        }
    }

    public void createDefaultUsers() {
        if (User.count() == 0) {
            createUserIfNotExists("himanshu@intelligrape.com", "Himanshu", "Seth", "123456")
            createUserIfNotExists("bhagwat@intelligrape.com", "Bhagwat", "Kumar", "123456")
            createUserIfNotExists("puneet@intelligrape.com", "Puneet", "kaur", "123456")
            createUserIfNotExists("roni@intelligrape.com", "Roni", "Thomas", "123456")
            createUserIfNotExists("nikhil.bhandari@intelligrape.com", "Nikhil", "Bhandari", "123456")
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

    def save(def object) {
        if (object.validate()) {
            if (object.save(flush: true)) {
                log.info "Saved. $object \n"
            } else {
                throw new RuntimeException("E_SAVE: Failed Creating ${object.class}")
            }
        } else {
            throw new RuntimeException("E_INVALID: Failed Creating ${object.class}")
        }
    }

}
