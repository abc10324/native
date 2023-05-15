package com.demo.service

import com.demo.model.po.User
import com.demo.repository.UserRepository
import java.util.*
import javax.enterprise.context.ApplicationScoped
import javax.inject.Inject

@ApplicationScoped
class UserService {

    @Inject
    lateinit var userRepository: UserRepository

    fun findAllUser() = userRepository.findAll().list()

    fun findByName(name: String) = userRepository.findByName(name)

    fun addUser() {
        var currentUserCount = genCurrentUserCount()

        var user = User()
        user.account = "account-${currentUserCount + 1}"
        user.password = "1qaz@WSX"
        user.name = "user-${currentUserCount + 1}"

        userRepository.persist(user)
    }

    fun deleteUser(account: String){
        userRepository.findByAccount(account)?.let { userRepository.delete(it) }
    }

    private fun genCurrentUserCount() = findAllUser()
        .asSequence()
        .map { it.name }
        .map { it.substringAfterLast("-").toIntOrNull() }
        .filterNotNull()
        .maxOrNull() ?: 0

}
