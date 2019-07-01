package com.mirzayogy.bengkelban.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.mirzayogy.bengkelban.R
import com.mirzayogy.bengkelban.model.Bengkel

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val bengkel: Bengkel =  intent.getParcelableExtra(EXTRA_BENGKEL)
        val imageView: ImageView = findViewById(R.id.imageView2)
        val tx_name: TextView = findViewById(R.id.tx_name)
        val tx_owner: TextView = findViewById(R.id.tx_owner)
        val tx_car: TextView = findViewById(R.id.tx_car)
        val tx_bike: TextView = findViewById(R.id.tx_bike)


        tx_name.text = bengkel.name
        tx_owner.text = bengkel.owner
        tx_car.text = bengkel.car
        tx_bike.text = bengkel.bike
        Glide
            .with(this)
            .load(bengkel.photo)
            .into(imageView)
    }

    companion object{
        const val EXTRA_BENGKEL = "extra_bengkel";
    }
}
