package org.onaio.rxgithub.presentation.ui.main

import org.onaio.rxgithub.domain.entities.GithubUser

data class MainActivityViewState(
    val githubUser: GithubUser,
    val isLoading: Boolean
)