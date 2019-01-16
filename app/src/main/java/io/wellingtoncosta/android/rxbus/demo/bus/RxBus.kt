package io.wellingtoncosta.android.rxbus.demo.bus

import io.reactivex.disposables.Disposable
import io.reactivex.subjects.PublishSubject

/**
 * @author Wellington Costa on 15/01/2019.
 **/
class RxBus private constructor() {

    private val subject = PublishSubject.create<Any>()

    fun publish(message: Any) {
        subject.onNext(message)
    }

    fun subscribe(action: (Any) -> Unit): Disposable {
        return subject.subscribe { action(it) }
    }

    companion object {
        val instance by lazy { RxBus() }
    }

}