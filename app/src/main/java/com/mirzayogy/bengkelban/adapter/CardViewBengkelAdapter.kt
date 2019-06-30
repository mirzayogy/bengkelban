package com.mirzayogy.bengkelban.adapter

import android.content.Context
import android.content.Intent
import android.support.v4.content.ContextCompat
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.bumptech.glide.Glide
import com.mirzayogy.bengkelban.R
import com.mirzayogy.bengkelban.activity.DetailActivity
import com.mirzayogy.bengkelban.activity.ImageActivity
import com.mirzayogy.bengkelban.model.Bengkel

class CardViewBengkelAdapter(val context: Context, private val listBengkels: ArrayList<Bengkel>) :
    RecyclerView.Adapter<CardViewBengkelAdapter.CardViewViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): CardViewViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_cardview_bengkel, parent, false)
        return CardViewViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listBengkels.size
    }

    override fun onBindViewHolder(holder: CardViewViewHolder, position: Int) {
        val bengkel = listBengkels[position]

        Glide.with(holder.itemView.context)
            .load(bengkel.photo)
            .error(ContextCompat.getDrawable(context, R.drawable.no_img))
//            .apply(RequestOptions().override(350, 550))
            .into(holder.imgPhoto)
        holder.tvName.text = bengkel.name
        holder.tvFrom.text = bengkel.owner
        holder.btnFavorite.setOnClickListener {
            Toast.makeText(holder.itemView.context, "Favorite " + listBengkels[position].name, Toast.LENGTH_SHORT).show()
        }
        holder.btnShare.setOnClickListener {
            Toast.makeText(holder.itemView.context, "Share " + listBengkels[position].name, Toast.LENGTH_SHORT).show()
        }

        holder.imgPhoto.setOnClickListener{
            val moveWithDataIntent = Intent(context, ImageActivity::class.java)
            moveWithDataIntent.putExtra(ImageActivity.EXTRA_PHOTO, bengkel)
            context.startActivity(moveWithDataIntent)
        }

        holder.itemView.setOnClickListener {
            val moveWithDataIntent = Intent(context, DetailActivity::class.java)
            moveWithDataIntent.putExtra(DetailActivity.EXTRA_BENGKEL, bengkel)
            context.startActivity(moveWithDataIntent)
        }
    }

    inner class CardViewViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
        var tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        var tvFrom: TextView = itemView.findViewById(R.id.tv_item_from)
        var btnFavorite: Button = itemView.findViewById(R.id.btn_set_favorite)
        var btnShare: Button = itemView.findViewById(R.id.btn_set_share)
    }

}