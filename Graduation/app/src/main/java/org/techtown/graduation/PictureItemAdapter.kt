package org.techtown.graduation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class PictureItemAdapter:ListAdapter<PictureItem, PictureItemAdapter.ViewHolder>(diffUtil) {
    inner class ViewHolder(private val view: View):RecyclerView.ViewHolder(view){
        fun bind(pictureItem : PictureItem){
            view.findViewById<TextView>(R.id.pictureDateText).text = pictureItem.pictureDate
            view.findViewById<TextView>(R.id.pictureContentText).text = pictureItem.pictureContent
            Glide.with(view.context).load(pictureItem.pictureUrl)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ViewHolder(inflater.inflate(R.layout.picture_item, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(currentList[position])
    }

    companion object{
        val diffUtil = object:DiffUtil.ItemCallback<PictureItem>(){
            override fun areItemsTheSame(oldItem: PictureItem, newItem: PictureItem): Boolean {
                return oldItem.pictureId == newItem.pictureId
            }

            override fun areContentsTheSame(oldItem: PictureItem, newItem: PictureItem): Boolean {
                return oldItem == newItem
            }

        }
    }
}