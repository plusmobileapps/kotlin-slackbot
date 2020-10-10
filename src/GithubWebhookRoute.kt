package com.plusmobileapps

import com.slack.api.Slack
import io.ktor.application.call
import io.ktor.request.receive
import io.ktor.response.respondText
import io.ktor.routing.Route
import io.ktor.routing.post

fun Route.githubWebhookRoute() {
    //test
    post("kotlin-slackbot-github") {
        val request = call.receive<GithubPushEvent>()

        val token = System.getenv("SLACK_TOKEN")
        val slack = Slack.getInstance()
        val response = slack.methods(token).chatPostMessage {
            it.channel("#general")
                .text("""
                    New commit pushed to `${request.repository.full_name}` by ${request.pusher.name}
                    ${request.head_commit.url}
                """.trimIndent())
        }
        call.respondText("Response is: $response")
    }
}