package com.plusmobileapps

import com.slack.api.Slack
import io.ktor.application.call
import io.ktor.response.respondText
import io.ktor.routing.Routing
import io.ktor.routing.get

fun Routing.homeRoute() {
    get("/") {
        val token = System.getenv("SLACK_TOKEN")
        val slack = Slack.getInstance()
        val response = slack.methods(token).chatPostMessage {
            it.channel("#general")
                .text("Hello :wave:")
        }
        call.respondText("Response is: $response")
    }
}