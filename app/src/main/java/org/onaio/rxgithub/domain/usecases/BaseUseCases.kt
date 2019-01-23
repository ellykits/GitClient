package org.onaio.rxgithub.domain.usecases

import io.reactivex.Observable
import io.reactivex.Single

abstract class ObservableBaseUseCase<T> {
     protected abstract fun makeObservable(): Observable<T>
    fun execute(): Observable<T> {
        return makeObservable()
    }
}

abstract class SingleBaseUseCase<T> {
    protected abstract fun makeSingle(): Single<T>
    fun execute(): Single<T> {
        return makeSingle()
    }
}