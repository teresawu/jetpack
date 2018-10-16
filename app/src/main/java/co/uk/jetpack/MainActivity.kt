package co.uk.jetpack

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.view_coroutine.*
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.launch
import kotlinx.coroutines.experimental.timeunit.TimeUnit

class MainActivity : AppCompatActivity() {

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_coroutine -> {
                btnCoroutine.setText(R.string.title_coroutine)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_nav -> {
                btnCoroutine.setText(R.string.title_nav)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_na -> {
                btnCoroutine.setText(R.string.title_na)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        startCoroutine()
    }

    private fun startCoroutine() {
        btnCoroutine.setOnClickListener {
            launch(UI) {
                setTextAfterDelay(2, "Hello from a coroutine!")
            }
        }
    }

    private suspend fun setTextAfterDelay(seconds: Long, text: String) {
        delay(seconds, TimeUnit.SECONDS)
        txtCoroutine.text = text
    }
}
