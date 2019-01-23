package org.onaio.rxgithub.domain.repository

import io.reactivex.Observable
import io.reactivex.Single
import org.koin.standalone.KoinComponent
import org.onaio.rxgithub.domain.entities.GithubUser

interface DataSource : KoinComponent {
    fun getGithubUser(username: String): Single<GithubUser>
    fun fetchGithubUsers(): Observable<GithubUser>
}