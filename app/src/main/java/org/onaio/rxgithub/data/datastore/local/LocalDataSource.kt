package org.onaio.rxgithub.data.datastore.local

import io.reactivex.Observable
import io.reactivex.Single
import org.onaio.rxgithub.domain.entities.GithubUser
import org.onaio.rxgithub.domain.repository.DataSource

class LocalDataSource : DataSource {
    override fun fetchGithubUsers(): Observable<GithubUser> {
        return Observable.just(
            GithubUser(fullName = "Elly Kitoto", username = "@ellykits"),
            GithubUser(fullName = "Benjamin Mwalimu", username = "@dubadabasoduba"),
            GithubUser(fullName = "Ephrahim Muhia", username = "@keymane"),
            GithubUser(fullName = "Martin Ndegwa", username = "@martin"),
            GithubUser(fullName = "Pharis Kahama", username = "@kahummer"),
            GithubUser(fullName = "Winny Kiragu", username = "@winnytroy")
        )
    }

    override fun getGithubUser(username: String): Single<GithubUser> {
        return Single.just(GithubUser(fullName = "Elly Kitoto", username = "@ellykits"))
    }
}