package com.mirzayogy.bengkelban.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import com.bumptech.glide.Glide
import com.mirzayogy.bengkelban.R
import com.mirzayogy.bengkelban.model.Bengkel

class ImageActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image)

        val bengkel: Bengkel =  intent.getParcelableExtra(EXTRA_PHOTO)
        val imageView: ImageView = findViewById(R.id.imageView)


        Glide.with(this).load(bengkel.photo).into(imageView)
        Toast.makeText(this,bengkel.photo, Toast.LENGTH_SHORT).show()
    }

    companion object{
        const val EXTRA_PHOTO = "extra_photo";
    }
}
