package com.demo.route

import com.demo.service.UserService
import org.jboss.resteasy.reactive.RestPath
import javax.inject.Inject
import javax.ws.rs.DELETE
import javax.ws.rs.GET
import javax.ws.rs.POST
import javax.ws.rs.Path

@Path("/user")
class UserRoute {

    @Inject
    lateinit var userService: UserService

    @GET
    fun findAllUser() = userService.findAllUser()

    @Path("/name/{name}")
    @GET
    fun findByName(@RestPath name: String) = userService.findByName(name)

    @POST
    fun addUser() : MutableMap<String,String> {
        userService.addUser()

        return okResponse()
    }

    @Path("/account/{account}")
    @DELETE
    fun deleteUser(@RestPath account: String) : MutableMap<String,String>{
        userService.deleteUser(account)

        return okResponse()
    }

    private fun okResponse() : MutableMap<String,String> {
        var resp = mutableMapOf<String,String>()
        resp["status"] = "success"

        return resp
    }
}