package io.github.grishaninvyacheslav.reddit_pagging

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import io.github.grishaninvyacheslav.reddit_pagging.ui.main.MainFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MainFragment.newInstance())
                .commitNow()
        }
    }
}