package org.onaio.rxgithub.presentation.di

import android.content.Context
import com.squareup.picasso.Picasso
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.experimental.builder.viewModel
import org.koin.dsl.module.module
import org.onaio.rxgithub.data.datastore.remote.RemoteDataSource
import org.onaio.rxgithub.data.repository.GithubUserRepositoryImpl
import org.onaio.rxgithub.domain.repository.DataSource
import org.onaio.rxgithub.domain.repository.GithubUsersRepository
import org.onaio.rxgithub.domain.usecases.FetchUsers
import org.onaio.rxgithub.presentation.utils.Constants
import org.onaio.rxgithub.presentation.ui.main.GithubUsersRecyclerAdapter
import org.onaio.rxgithub.presentation.ui.main.MainFragment
import org.onaio.rxgithub.presentation.ui.main.MainViewModel
import org.onaio.rxgithub.presentation.ui.main.UserDetailsFragment

object Modules {

    private fun providePicasso(context: Context): Picasso {
        return Picasso.Builder(context)
            .loggingEnabled(false)
            .build()
    }

    private val viewModules = module {
        factory { GithubUsersRecyclerAdapter() }
        scope(Constants.Scope.mainActivityScope) { MainFragment() }
        scope(Constants.Scope.mainActivityScope) {  UserDetailsFragment() }
        viewModel<MainViewModel>()
        single { providePicasso(androidContext()) }
    }
    private val viewModelModules = module {
        single<DataSource> { RemoteDataSource() }
        single<GithubUsersRepository> { GithubUserRepositoryImpl(get()) }
        single { FetchUsers(get()) }
    }
    val presentationModules = listOf(viewModules, viewModelModules)
}