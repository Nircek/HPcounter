package io.github.nircek.hpcounter

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.counter_fragment.*

class CounterFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return LayoutInflater.from(container?.context).inflate(R.layout.counter_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        plus.setOnClickListener {
            counter.setText((counter.text.toString().toInt()+1).toString())
        }
        minus.setOnClickListener {
            counter.setText((counter.text.toString().toInt()-1).toString())
        }
        reset.setOnClickListener {
            counter.setText("20")
        }
    }
}
