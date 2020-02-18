package com.pcsalt.example.debouncetext.listener

import android.text.Editable
import android.text.TextWatcher
import java.util.*

abstract class DebounceTextWatcher: TextWatcher {

    private var timer: Timer? = null

    abstract fun onTextReceived(text: String)

    override fun afterTextChanged(s: Editable?) {
        debounce(s)
    }

    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
    }

    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
    }

    private fun getText(text: CharSequence?): String =  text?.toString() ?: ""

    private fun debounce(text: CharSequence?) {
        timer?.cancel()
        timer = null
        timer = Timer()
        timer?.schedule(object: TimerTask() {
            override fun run() {
                onTextReceived(getText(text))
            }
        }, 1000L)
    }
}