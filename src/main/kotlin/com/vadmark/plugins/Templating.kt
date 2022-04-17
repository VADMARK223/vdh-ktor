package com.vadmark.plugins

import com.github.mustachejava.DefaultMustacheFactory
import io.ktor.server.mustache.Mustache
import io.ktor.server.mustache.MustacheContent
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.request.*
import io.ktor.server.routing.*

fun Application.configureTemplating() {
    routing {
        get("/") {
            val user = call.request.queryParameters["user"] ?: "Nobody"
            call.respond(MustacheContent("index.hbs", mapOf("user" to user)))
        }
    }
}

data class MustacheUser(val id: Int, val name: String)
