package com.taraabar.sampletarabar.view.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.taraabar.sampletarabar.model.Shipment

class ShipmentViewModel(application: Application) : AndroidViewModel(application) {
    private var isSelected: Boolean = false
    private var shipmentLiveData = MutableLiveData<Shipment>()
    private var shipments = ArrayList<Shipment>()

    fun getShipmentDetail(position: Int?): Shipment {
        return shipments[position!!]
    }

    fun unSelectShipmnet() {
        isSelected = false
    }

    fun onSelectedShipment(): MutableLiveData<Shipment> {
        return shipmentLiveData
    }

    fun selectShipment(position: Int?) {
        if (!isSelected) {
            shipmentLiveData.value = getShipmentDetail(position)
            isSelected = true
        }
    }

    fun getShipments(): ArrayList<Shipment> {

        for (i in 1..10) {
            val item = Shipment(
                shipments.size.toString()
                , (shipments.size + 1).toString()
                , shipments.size * 10
                , shipments.size
            )
            shipments.add(item)
        }
        return shipments

    }
}