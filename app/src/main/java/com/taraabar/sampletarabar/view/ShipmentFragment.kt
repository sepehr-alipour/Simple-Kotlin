package com.taraabar.sampletarabar.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.taraabar.sampletarabar.R
import com.taraabar.sampletarabar.model.Shipment
import com.taraabar.sampletarabar.view.`interface`.OnShipmentClickListener
import com.taraabar.sampletarabar.view.adapter.ShipmentAdapter
import com.taraabar.sampletarabar.view.viewmodel.ShipmentViewModel

class ShipmentFragment : Fragment(), OnShipmentClickListener {

    lateinit var list: RecyclerView
    var shipmnetItems = ArrayList<Shipment>()
    override fun onShipmentClicked(position: Int) {
        val bundle = bundleOf("position" to position)
        findNavController().navigate(R.id.action_shipmentFragment_to_shipmentDetailFragment, bundle)
    }


    private lateinit var viewModel: ShipmentViewModel
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getShipments(10)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_shipment, container, false)
        list = view.findViewById(R.id.list) as RecyclerView
        val layoutManager = LinearLayoutManager(context)
        list.layoutManager = layoutManager
        val scrollListener = object : EndlessRecyclerView(layoutManager) {
            override fun onLoadMore(page: Int, totalItemsCount: Int, view: RecyclerView?) {
                getShipments(totalItemsCount + 10)
            }

        }
        list.addOnScrollListener(scrollListener)
        viewModel = ViewModelProviders.of(activity!!).get(ShipmentViewModel::class.java)
        return view
    }

    fun getShipments(offset: Int) {
        shipmnetItems.clear()
        shipmnetItems.addAll(viewModel.getShipments())
        if (offset > 10)
            list.adapter?.notifyDataSetChanged()
        else {
            val adapter = ShipmentAdapter(shipmnetItems, this)
            list.adapter = adapter
        }
    }


}
