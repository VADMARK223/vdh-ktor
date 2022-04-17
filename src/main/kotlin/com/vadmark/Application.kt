package com.vadmark

import com.github.mustachejava.DefaultMustacheFactory
import com.typesafe.config.ConfigFactory
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import com.vadmark.plugins.*
import io.ktor.server.application.*
import io.ktor.server.config.*
import io.ktor.server.mustache.*

fun main() {
    embeddedServer(Netty, environment = applicationEngineEnvironment {
        config = HoconApplicationConfig(ConfigFactory.load())

        module {
            install(Mustache) {
                mustacheFactory = DefaultMustacheFactory("templates/mustache")
            }
            configureRouting()
            configureTemplating()
            configureSecurity()
            configureSerialization()
        }

        connector {
            port = config.property("ktor.deployment.port").getString().toInt()
            host = config.property("ktor.deployment.host").getString()
        }
    }).start(wait = true)
}
