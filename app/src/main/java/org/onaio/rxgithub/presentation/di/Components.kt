package org.onaio.rxgithub.presentation.di

import com.squareup.picasso.Picasso
import org.koin.standalone.KoinComponent
import org.koin.standalone.inject
import org.onaio.rxgithub.presentation.ui.main.UserDetailsFragment

object Components : KoinComponent {
    val picasso by inject<Picasso>()
    val detailsFragment by inject<UserDetailsFragment>()
}