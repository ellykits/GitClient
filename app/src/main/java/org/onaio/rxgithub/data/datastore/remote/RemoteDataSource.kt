package org.onaio.rxgithub.data.datastore.remote

import io.reactivex.Observable
import io.reactivex.Single
import org.koin.standalone.inject
import org.onaio.rxgithub.domain.entities.GithubUser
import org.onaio.rxgithub.domain.repository.DataSource

class RemoteDataSource : DataSource {

    private val apiService by inject<GithubApiService>()

    private fun getRandomNumber(): Int {
        return (0..500).random()
    }

    override fun getGithubUser(username: String): Single<GithubUser> {
        return apiService.fetchUserInformation(username)
    }

    override fun fetchGithubUsers(): Observable<GithubUser> {
        val since = getRandomNumber()
        return apiService.fetchUsers(since)
            .flatMap { Observable.fromIterable(it) }
            .take(5)
            .flatMap { apiService.fetchUserInformation(it.username).toObservable() }
    }
}