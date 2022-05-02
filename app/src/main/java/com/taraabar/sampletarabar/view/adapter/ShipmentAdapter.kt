package com.taraabar.sampletarabar.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.recyclerview.widget.RecyclerView
import com.taraabar.sampletarabar.R
import com.taraabar.sampletarabar.model.Shipment
import com.taraabar.sampletarabar.view.`interface`.OnShipmentClickListener
import kotlinx.android.synthetic.main.list_item_shipment.view.*

class ShipmentAdapter(items: ArrayList<Shipment>?, listener: OnShipmentClickListener) :
    RecyclerView.Adapter<ShipmentAdapter.ViewHolder>() {

    private var shipments: ArrayList<Shipment>? = null
    private var listener: OnShipmentClickListener? = null

    init {
        this.shipments = items
        this.listener = listener
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.list_item_shipment, parent, false)
        return ViewHolder(view)
    }


    override fun getItemCount(): Int {
        return shipments?.count() ?: 0
    }

    override fun onBindViewHolder(holder: ShipmentAdapter.ViewHolder, position: Int) {
        val shipmentItem = shipments?.get(position)
        holder.txtOrigin.text =
            holder.txtOrigin.context.getString(R.string.text_origin, shipmentItem?.origin)
        holder.txtDestination.text =
            holder.txtOrigin.context.getString(R.string.text_destination, shipmentItem?.destination)
        holder.txtTonnage.text =
            holder.txtOrigin.context.getString(R.string.text_tonnage, shipmentItem?.tonnage)
        holder.txtPrice.text =
            holder.txtOrigin.context.getString(R.string.text_price, shipmentItem?.price)
        holder.itemView.setOnClickListener(View.OnClickListener {
            listener?.onShipmentClicked(position)
        })

    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val txtOrigin = view.txt_origin;
        val txtDestination = view.txt_destination;
        val txtPrice = view.txt_price;
        val txtTonnage = view.txt_tonnage;

    }
}