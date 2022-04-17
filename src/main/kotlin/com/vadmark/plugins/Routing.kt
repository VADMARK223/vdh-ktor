package com.vadmark.plugins

import com.vadmark.dto.MessageDto
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.configureRouting() {

    routing {
        get("/") {
            call.respondText("Hello World1!")
        }
    }

    routing {
        get("/hello") {
            val data = listOf("1", "2", "3", "4", "5")
                .drop(1)
                .take(2)
                .map { MessageDto(it) }
            call.respond(data)
        }
    }
}
