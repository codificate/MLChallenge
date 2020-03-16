package com.candidate.servando.sharedresources

import io.reactivex.Completable
import io.reactivex.Maybe
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

fun Completable.onDefaultSchedulers(): Completable =
    subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())

fun <T> Observable<T>.onDefaultSchedulers(): Observable<T> =
    subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())

fun <T> Single<T>.onDefaultSchedulers(): Single<T> =
    subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())

fun <T> Maybe<T>.onDefaultSchedulers(): Maybe<T> =
    subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())

fun Completable.logOnError(): Completable =
    doOnError { ExceptionLogger.log(it) }

fun <T> Observable<T>.logOnError(): Observable<T> =
    doOnError { ExceptionLogger.log(it) }

fun <T> Maybe<T>.logOnError(): Maybe<T> =
    doOnError { ExceptionLogger.log(it) }

fun <T> Single<T>.logOnError(): Single<T> =
    doOnError { ExceptionLogger.log(it) }