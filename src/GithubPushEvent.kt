package com.plusmobileapps

import java.io.Serializable

data class GithubPushEvent(
    val ref: String,
    val before: String,
    val after: String,
    val repository: GithubRepository,
    val pusher: GithubPusher,
    val created: Boolean,
    val deleted: Boolean,
    val forced: Boolean,
    val commits: List<GitCommit>,
    val head_commit: GitCommit
): Serializable

data class GitCommit(
    val id: String,
    val tree_id: String,
    val distinct: Boolean,
    val message: String,
    val timestamp: String,
    val url: String,
    val author: GithubUser,
    val committer: GithubUser,
    val added: List<String>,
    val removed: List<String>,
    val modified: List<String>
): Serializable

data class GithubUser(
    val name: String,
    val email: String,
    val username: String
): Serializable

data class GithubPusher(
    val name: String,
    val email: String
): Serializable

data class GithubRepository(
    val id: Int,
    val node_id: String,
    val name: String,
    val full_name: String,
    val private: Boolean,
    val owner: GithubOwner,
    val html_url: String,
    val updated_at: String,
): Serializable

data class GithubOwner(
    val name: String,
    val email: String,
    val login: String,
    val id: Int,
    val node_id: String,
    val avatar_url: String,
    val gravatar_id: String,
    val url: String,
    val html_url: String,
    val followers_url: String,
    val following_url: String,
    val gists_url: String,
    val starred_url: String,
    val subscriptions_url: String,
    val organizations_url: String,
    val repos_url: String,
    val events_url: String,
    val received_events_url: String,
    val type: String,
    val site_admin: Boolean
): Serializable