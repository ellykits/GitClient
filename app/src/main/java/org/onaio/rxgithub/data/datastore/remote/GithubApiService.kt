package org.onaio.rxgithub.data.datastore.remote

import io.reactivex.Observable
import io.reactivex.Single
import org.onaio.rxgithub.domain.entities.GithubUser
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface GithubApiService {
    @GET("users")
    fun fetchUsers(@Query("since") since: Int): Observable<List<GithubUser>>

    @GET("users/{id}")
    fun fetchUserInformation(@Path("id") username: String?): Single<GithubUser>
}