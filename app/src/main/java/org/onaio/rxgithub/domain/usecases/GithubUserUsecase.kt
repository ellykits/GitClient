package org.onaio.rxgithub.domain.usecases

import io.reactivex.Observable
import io.reactivex.Single
import org.onaio.rxgithub.domain.entities.GithubUser
import org.onaio.rxgithub.domain.repository.GithubUsersRepository

class FetchUsers(private val usersRepository: GithubUsersRepository) : ObservableBaseUseCase<GithubUser>() {
     override fun makeObservable(): Observable<GithubUser> {
        return usersRepository.getUsers()
    }
}

class GetUserDetails(private val username: String, private val usersRepository: GithubUsersRepository) :
    SingleBaseUseCase<GithubUser>() {
    override fun makeSingle(): Single<GithubUser> {
        return usersRepository.getUserDetails(username)
    }

}