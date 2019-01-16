package io.wellingtoncosta.android.rxbus.demo.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import io.wellingtoncosta.android.rxbus.demo.R
import io.wellingtoncosta.android.rxbus.demo.bus.RxBus
import io.wellingtoncosta.android.rxbus.demo.ui.MainActivity.Companion.FINISH_APP_TAG
import io.wellingtoncosta.android.rxbus.demo.ui.MainActivity.Companion.FRAGMENT_ONE_TAG
import io.wellingtoncosta.android.rxbus.demo.ui.MainActivity.Companion.MAIN_ACTIVITY_SUBJECT
import kotlinx.android.synthetic.main.fragment_fragment_two.view.*

/**
 * @author Wellington Costa on 15/01/2019.
 **/
class FragmentTwo : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_fragment_two, container, false).apply {
            this.back_to_fragment_one.setOnClickListener {
                RxBus.instance.publish(MAIN_ACTIVITY_SUBJECT, FRAGMENT_ONE_TAG)
            }

            this.finish_app.setOnClickListener {
                RxBus.instance.publish(MAIN_ACTIVITY_SUBJECT, FINISH_APP_TAG)
            }
        }
    }

}
