package org.onaio.rxgithub.domain.repository

import io.reactivex.Observable
import io.reactivex.Single
import org.onaio.rxgithub.domain.entities.GithubUser

interface GithubUsersRepository {
    fun getUsers(): Observable<GithubUser>
    fun getUserDetails(username: String): Single<GithubUser>
}