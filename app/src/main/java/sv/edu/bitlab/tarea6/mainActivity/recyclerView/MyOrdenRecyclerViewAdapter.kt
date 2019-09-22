package sv.edu.bitlab.tarea6.mainActivity.recyclerView

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView


import sv.edu.bitlab.tarea6.mainActivity.OrdenFragment.OrdenFragmentInteractionListener


import kotlinx.android.synthetic.main.fragment_orden.view.*
import sv.edu.bitlab.tarea6.R
import sv.edu.bitlab.tarea6.entity.Orden


class MyOrdenRecyclerViewAdapter(var orden: Orden,  val listener:OrdenItemViewHolder.OrdenItemListener
) : RecyclerView.Adapter<OrdenItemViewHolder>() {

    override fun onBindViewHolder(holder: OrdenItemViewHolder, position: Int) {
        holder.bindData(orden)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrdenItemViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_row, parent, false)
        return OrdenItemViewHolder(view, listener)
    }

    override fun getItemCount(): Int {
        return orden.arroz.size
    }


}
