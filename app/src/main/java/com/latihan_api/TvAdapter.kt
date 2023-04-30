package com.latihan_api

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.latihan_api.databinding.ItemTvBinding
import com.latihan_api.model.Result

class TvAdapter(var listTv: List<Result>): RecyclerView.Adapter<TvAdapter.ViewHolder>() {
    class ViewHolder(var binding : ItemTvBinding): RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvAdapter.ViewHolder {
        val view = ItemTvBinding.inflate(LayoutInflater.from(parent.context), parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: TvAdapter.ViewHolder, position: Int) {
        holder.binding.JudulTv.text = listTv[position].originalName
        holder.binding.TanggalTv.text = listTv[position].firstAirDate
        holder.binding.RatingTv.text = listTv[position].voteAverage.toString()
        Glide.with(holder.itemView).load("https://image.tmdb.org/t/p/w500${listTv[position].posterPath}").into(holder.binding.imageView)
    }

    override fun getItemCount(): Int {
        return listTv.size
    }
}