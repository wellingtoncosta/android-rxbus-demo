package io.wellingtoncosta.android.rxbus.demo.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import io.wellingtoncosta.android.rxbus.demo.R
import io.wellingtoncosta.android.rxbus.demo.bus.RxBus
import io.wellingtoncosta.android.rxbus.demo.ui.MainActivity.Companion.FINISH_APP_TAG
import io.wellingtoncosta.android.rxbus.demo.ui.MainActivity.Companion.FRAGMENT_TWO_TAG
import kotlinx.android.synthetic.main.fragment_fragment_one.view.*

/**
 * @author Wellington Costa on 15/01/2019.
 **/
class FragmentOne : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_fragment_one, container, false).apply {
            this.go_to_fragment_two.setOnClickListener {
                RxBus.instance.publish(FRAGMENT_TWO_TAG)
            }

            this.finish_app.setOnClickListener {
                RxBus.instance.publish(FINISH_APP_TAG)
            }
        }
    }

}
