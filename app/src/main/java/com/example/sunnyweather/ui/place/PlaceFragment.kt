package com.example.sunnyweather.ui.place

import android.annotation.SuppressLint
import android.os.Binder
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sunnyweather.databinding.FragmentPlaceBinding
import com.example.sunnyweather.showToast

class PlaceFragment : Fragment() {

    val viewModel by lazy {
        ViewModelProvider(this).get(PlaceViewModel::class.java)
    }

    lateinit var placeAdapter: PlaceAdapter

    private var _binder: FragmentPlaceBinding? = null
    private val binder get() = _binder!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binder = FragmentPlaceBinding.inflate(inflater, container, false)
        return binder.root
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val layoutManager = LinearLayoutManager(activity)
        binder.recyclerView.layoutManager = layoutManager
        placeAdapter = PlaceAdapter(this, viewModel.livesList)
        binder.recyclerView.adapter = placeAdapter
        binder.searchPlaceEdit.addTextChangedListener {
            val content = it.toString()
            if (content.isNotEmpty()) {
                viewModel.searchPlaces(content)
            } else {
                binder.recyclerView.visibility = View.GONE
                binder.bgImageView.visibility = View.VISIBLE
                viewModel.livesList.clear()
                placeAdapter.notifyDataSetChanged()
            }
        }
        viewModel.livesLiveData.observe(viewLifecycleOwner, Observer {
            val lives = it.getOrNull()
            if (lives != null) {
                binder.recyclerView.visibility = View.VISIBLE
                binder.bgImageView.visibility = View.GONE
                viewModel.livesList.clear()
                viewModel.livesList.addAll(lives)
                placeAdapter.notifyDataSetChanged()
            } else {
                "未能查询到任何地点".showToast(Toast.LENGTH_SHORT)
                it.exceptionOrNull()?.printStackTrace()
            }
        })
    }

    override fun onDestroy() {
        super.onDestroy()
        _binder = null
    }
}