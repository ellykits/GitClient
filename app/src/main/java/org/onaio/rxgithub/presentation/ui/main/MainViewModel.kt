package org.onaio.rxgithub.presentation.ui.main

import androidx.lifecycle.MutableLiveData
import com.github.ajalt.timberkt.Timber
import com.github.ajalt.timberkt.e
import com.github.ajalt.timberkt.i
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers
import org.onaio.rxgithub.domain.usecases.FetchUsers
import org.onaio.rxgithub.presentation.utils.BaseViewModel
import org.onaio.rxgithub.presentation.utils.SingleLiveEvent


class MainViewModel(private val fetchUsers: FetchUsers) : BaseViewModel() {
    private val _state = MutableLiveData<MainActivityViewState>()
    val state: MutableLiveData<MainActivityViewState>
        get() = _state

     val errorEvent = SingleLiveEvent<Throwable>()

    fun retrieveUsers() {
        launch {
            fetchUsers.execute()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribeBy(  // named arguments for lambda Subscribers
                    onNext = {
                        Timber.tag("MainViewModel").i { "New data -> $it" }
                        state.value = MainActivityViewState(it, false)
                    },
                    onError = {
                        Timber.tag("MainViewModel").e { "Error $it" }
                        errorEvent.value = it
                    },
                    onComplete = { Timber.tag("MainViewModel").i { "We are done here" } }
                )
        }
    }
}
