package com.taraabar.sampletarabar.view

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.taraabar.sampletarabar.R
import com.taraabar.sampletarabar.databinding.ActivityMainBinding
import com.taraabar.sampletarabar.view.viewmodel.ShipmentViewModel

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityMainBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_main)
        val shipmentViewModel = ViewModelProviders.of(this).get(ShipmentViewModel::class.java)
        shipmentViewModel.onSelectedShipment().observe(this, Observer {
            binding.selectedLayout.visibility = View.VISIBLE
            Toast.makeText(this, it.origin, Toast.LENGTH_LONG).show()
            binding.txtSelectedShipment.text =
                getString(R.string.text_selected_shipment, it.origin, it.destination)
        })
        binding.btnCancel.setOnClickListener(View.OnClickListener {

            binding.selectedLayout.visibility = View.GONE
            shipmentViewModel.unSelectShipmnet()
        })

    }
}
