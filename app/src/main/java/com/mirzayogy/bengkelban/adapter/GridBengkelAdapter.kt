package com.mirzayogy.bengkelban.adapter

import android.content.Context
import android.content.Intent
import android.support.v4.content.ContextCompat
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.mirzayogy.bengkelban.R
import com.mirzayogy.bengkelban.activity.DetailActivity
import com.mirzayogy.bengkelban.activity.ImageActivity
import com.mirzayogy.bengkelban.model.Bengkel

class GridBengkelAdapter(val context: Context, val listBengkels: ArrayList<Bengkel>) : RecyclerView.Adapter<GridBengkelAdapter.GridViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): GridBengkelAdapter.GridViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_grid_bengkel, parent, false)
        return GridViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listBengkels.size
    }

    override fun onBindViewHolder(holder: GridViewHolder, position: Int) {
        val bengkel = listBengkels[position]
        
        Glide.with(holder.itemView.context)
            .load(listBengkels[position].photo)
            .error(ContextCompat.getDrawable(context, R.drawable.no_img))
//            .apply(RequestOptions().override(350, 550))
            .into(holder.imgPhoto)
        
        holder.itemView.setOnClickListener {
            val moveWithDataIntent = Intent(context, DetailActivity::class.java)
            moveWithDataIntent.putExtra(DetailActivity.EXTRA_BENGKEL, bengkel)
            context.startActivity(moveWithDataIntent)
        }
    }

    inner class GridViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
    }

}