package com.taraabar.sampletarabar.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.taraabar.sampletarabar.R
import com.taraabar.sampletarabar.databinding.FragmentShipmentDetailBinding
import com.taraabar.sampletarabar.view.viewmodel.ShipmentViewModel

class ShipmentDetailFragment : Fragment() {


    private lateinit var viewModel: ShipmentViewModel
    private lateinit var binding: FragmentShipmentDetailBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            LayoutInflater.from(context),
            R.layout.fragment_shipment_detail,
            container,
            false
        )
        viewModel = ViewModelProviders.of(activity!!).get(ShipmentViewModel::class.java)
        binding.btnAccept.setOnClickListener(View.OnClickListener {

            viewModel.selectShipment(arguments?.getInt("position"))
        })
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.shipment = viewModel.getShipmentDetail(arguments?.getInt("position"))

    }

}
