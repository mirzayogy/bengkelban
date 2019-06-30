package com.mirzayogy.bengkelban.adapter

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.mirzayogy.bengkelban.R
import com.mirzayogy.bengkelban.activity.ImageActivity
import com.mirzayogy.bengkelban.model.Bengkel

class ListBengkelAdapter(val context: Context, val listBengkel: ArrayList<Bengkel>) : RecyclerView.Adapter<ListBengkelAdapter.CategoryViewHolder>(){

    var onItemClickListener: ((Bengkel) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val itemRow = LayoutInflater.from(parent.context).inflate(R.layout.item_row_bengkel, parent, false)
        return CategoryViewHolder(itemRow)
    }

    override fun getItemCount(): Int {
        return listBengkel.size
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {

        val bengkel = Bengkel()
        bengkel.name = listBengkel[position].name
        bengkel.owner = listBengkel[position].owner
        bengkel.photo = listBengkel[position].photo

        holder.tvName.text = bengkel.name
        holder.tvOwner.text = bengkel.owner
        Glide.with(holder.itemView.context)
            .load(listBengkel[position].photo)
//            .apply(RequestOptions().override(55, 55))
            .into(holder.imgPhoto)

        holder.imgPhoto.setOnClickListener{
            val moveWithDataIntent = Intent(context, ImageActivity::class.java)
            moveWithDataIntent.putExtra(ImageActivity.EXTRA_PHOTO, bengkel)
            context.startActivity(moveWithDataIntent)
        }
        holder.itemView.setOnClickListener {
            onItemClickListener?.invoke(listBengkel[holder.adapterPosition])
        }
    }

    inner class CategoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        var tvOwner: TextView = itemView.findViewById(R.id.tv_item_owner)
        var imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
    }
}