package com.mirzayogy.bengkelban.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.mirzayogy.bengkelban.R

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
    }

    companion object{
        const val EXTRA_BENGKEL = "extra_bengkel";
    }
}
