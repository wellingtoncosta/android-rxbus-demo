package io.wellingtoncosta.android.rxbus.demo.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.transaction
import io.wellingtoncosta.android.rxbus.demo.R
import io.wellingtoncosta.android.rxbus.demo.bus.RxBus

/**
 * @author Wellington Costa on 15/01/2019.
 **/
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        observeEvents()
        RxBus.instance.publish(MAIN_ACTIVITY_SUBJECT, FRAGMENT_ONE_TAG)
    }

    private fun observeEvents() {
        RxBus.instance.subscribe(MAIN_ACTIVITY_SUBJECT, this) {
            when (it as String) {
                FRAGMENT_ONE_TAG -> {
                    supportFragmentManager.transaction {
                        replace(R.id.frame_layout, FragmentOne(), FRAGMENT_ONE_TAG)
                    }
                }
                FRAGMENT_TWO_TAG -> {
                    supportFragmentManager.transaction {
                        replace(R.id.frame_layout, FragmentTwo(), FRAGMENT_TWO_TAG)
                    }
                }
                FINISH_APP_TAG -> this.finish()
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        RxBus.instance.unregister(this)
    }

    companion object {
        const val MAIN_ACTIVITY_SUBJECT = "MAIN_ACTIVITY_SUBJECT"
        const val FRAGMENT_ONE_TAG = "FRAGMENT_ONE"
        const val FRAGMENT_TWO_TAG = "FRAGMENT_TWO"
        const val FINISH_APP_TAG = "FINISH_APP"
    }

}
