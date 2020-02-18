package com.pcsalt.example.debouncetext

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.pcsalt.example.debouncetext.listener.DebounceTextWatcher
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        et_text.addTextChangedListener(object: DebounceTextWatcher(){
            override fun onTextReceived(text: String) {
                runOnUiThread {
                    tv_search_for.append("\n")
                    tv_search_for.append(text)
                }
            }
        })
    }
}