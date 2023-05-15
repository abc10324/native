package com.demo.repository

import com.demo.model.po.User
import io.quarkus.mongodb.panache.kotlin.PanacheMongoRepository
import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
class UserRepository : PanacheMongoRepository<User> {

    fun findByName(name: String) = find("name", name).list()

    fun findByAccount(account: String) = find("account", account).firstResult()

}