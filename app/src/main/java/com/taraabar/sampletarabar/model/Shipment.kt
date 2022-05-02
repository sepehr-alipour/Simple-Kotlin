package com.taraabar.sampletarabar.model

class Shipment(
    val origin: String,
    val destination: String,
    val tonnage: Int,
    val price: Int,
    val type: String = "",
    val packing: String = "",
    val date: String = ""
) {


}