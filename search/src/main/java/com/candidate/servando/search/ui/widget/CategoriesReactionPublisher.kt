package com.candidate.servando.search.ui.widget

import io.reactivex.subjects.PublishSubject

object CategoriesReactionPublisher {

    private val publisher = PublishSubject.create<String>()

    fun observe() = publisher

    fun clicked(ID: String) = publisher.onNext(ID)

}