package org.onaio.rxgithub.data.repository

import io.reactivex.Observable
import io.reactivex.Single
import org.onaio.rxgithub.domain.entities.GithubUser
import org.onaio.rxgithub.domain.repository.DataSource
import org.onaio.rxgithub.domain.repository.GithubUsersRepository

class GithubUserRepositoryImpl(private val dataSource: DataSource) : GithubUsersRepository {

    override fun getUsers(): Observable<GithubUser> {
        return dataSource.fetchGithubUsers()
    }

    override fun getUserDetails(username: String): Single<GithubUser> {
        return dataSource.getGithubUser(username)
    }

}