package org.onaio.rxgithub.presentation.utils

import android.widget.ImageView
import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import org.onaio.rxgithub.R
import org.onaio.rxgithub.presentation.di.Components
import org.onaio.rxgithub.presentation.di.Components.picasso

open class BaseViewModel : ViewModel() {
    private val compositeDisposable = CompositeDisposable()
    open fun launch(job: () -> Disposable) {
        compositeDisposable.add(job())
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }
}

object Constants {
    object Scope {
        const val mainActivityScope = "MainActivityScope"
    }
}

class CommonUtils {
    companion object {
        fun loadImage(path: String?, imageView: ImageView) {
            picasso.load(path)
                .error(R.drawable.user)
                .placeholder(R.drawable.user)
                .fit()
                .into(imageView)

        }
    }
}
