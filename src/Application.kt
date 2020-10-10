package com.plusmobileapps

import io.ktor.application.*
import io.ktor.response.*
import io.ktor.request.*
import io.ktor.features.*
import org.slf4j.event.*
import io.ktor.routing.*
import io.ktor.http.*
import io.ktor.gson.*
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty

fun main(args: Array<String>) {
    val port = System.getenv("PORT").toIntOrNull() ?: 8080

    embeddedServer(Netty, port) {
        install(CallLogging) {
            level = Level.INFO
            filter { call -> call.request.path().startsWith("/") }
        }

        install(ContentNegotiation) {
            gson {
            }
        }

        routing {
            homeRoute()
            githubWebhookRoute()
            get("/json/gson") {
                call.respond(mapOf("hello" to "world"))
            }
        }
    }.start(wait = true)
}

