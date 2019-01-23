package org.onaio.rxgithub.domain.entities

import com.squareup.moshi.Json

data class GithubUser(
    @field:Json(name = "name")
    var fullName: String? = null,
    @field:Json(name = "login")
    val username: String?,
    @field:Json(name = "avatar_url")
    var imageUri: String? = null,
    @field:Json(name = "company")
    var company: String? = null,
    @field:Json(name = "blog")
    val blog: String? = null,
    @field:Json(name = "email")
    val email: String? = null,
    @field:Json(name = "bio")
    var bio: String? = null,
    @field:Json(name = "public_repos")
    var publicRepos: String? = null,
    @field:Json(name = "public_gists")
    var publicGists: String? = null,
    @field:Json(name = "followers")
    var followers: String? = null,
    @field:Json(name = "following")
    var following: String? = null,
    @field:Json(name = "location")
    var location: String? = null
)