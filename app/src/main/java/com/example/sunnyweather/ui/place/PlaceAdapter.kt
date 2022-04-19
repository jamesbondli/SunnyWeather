package com.example.sunnyweather.ui.place

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.sunnyweather.databinding.PlaceItemBinding
import com.example.sunnyweather.logic.model.Lives

class PlaceAdapter(private val fragment: Fragment, private val placeList: List<Lives>) :
    RecyclerView.Adapter<PlaceAdapter.MyViewHolder>() {

    inner class MyViewHolder(binder: PlaceItemBinding) :
        RecyclerView.ViewHolder(binder.root) {

        val placeName = binder.placeName
        val placeAddress = binder.placeAddress
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val binder = PlaceItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent, false
        )
        return MyViewHolder(binder)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val place = placeList[position]
        holder.placeName.text = place.province
        holder.placeAddress.text = place.city
    }

    override fun getItemCount() = placeList.size
}