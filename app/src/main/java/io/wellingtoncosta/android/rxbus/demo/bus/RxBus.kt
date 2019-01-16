package io.wellingtoncosta.android.rxbus.demo.bus

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.subjects.PublishSubject

/**
 * @author Wellington Costa on 15/01/2019.
 **/
class RxBus private constructor() {

    private val subjects = HashMap<String, PublishSubject<Any>>()
    private val subscriptions = HashMap<Any, CompositeDisposable>()

    private fun subject(key: String) = subjects.getOrPut(key) { PublishSubject.create() }

    private fun disposable(key: Any) = subscriptions.getOrPut(key) { CompositeDisposable() }

    fun subscribe(subject: String, owner: Any, action: (Any) -> Unit) {
        val disposable = subject(subject).subscribe(action)
        disposable(owner).add(disposable)
    }

    fun unregister(lifecycle: Any) { subscriptions.remove(lifecycle)?.dispose() }

    fun publish(subject: String, message: Any) { subject(subject).onNext(message) }

    companion object {
        val instance by lazy { RxBus() }
    }

}