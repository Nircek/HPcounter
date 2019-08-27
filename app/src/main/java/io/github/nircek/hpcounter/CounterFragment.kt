package io.github.nircek.hpcounter

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SeekBar
import kotlinx.android.synthetic.main.counter_fragment.*

class CounterFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return LayoutInflater.from(container?.context)
            .inflate(R.layout.counter_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        plus.setOnClickListener { counterAdd(1) }
        minus.setOnClickListener { counterAdd(-1) }
        reset.setOnClickListener { counterSet(20) }
        custom.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onStartTrackingTouch(seekBar: SeekBar?) { }
            override fun onStopTrackingTouch(seekBar: SeekBar?) { }

            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                minus_custom.text = resources.getString(R.string.minus_custom, progress)
            }
        })
        minus_custom.text = resources.getString(R.string.minus_custom, custom.progress)
        minus_custom.setOnClickListener { counterAdd(-custom.progress) }
    }
    private fun counterAdd(x: Int) {
        counter.setText((counter.text.toString().toInt()+x).toString())
    }
    private fun counterSet(x: Int) {
        counter.setText(x.toString())
    }
}
