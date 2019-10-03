package sv.edu.bitlab.tarea6.ordenHistorial.recyclerView

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import sv.edu.bitlab.tarea6.R
import sv.edu.bitlab.tarea6.entity.HistorialOrden
import sv.edu.bitlab.tarea6.entity.Pupusa


import sv.edu.bitlab.tarea6.ordenHistorial.OrdenHistorialFragment.OnListFragmentInteractionListener


/**
 * [RecyclerView.Adapter] that can display a [DummyItem] and makes a call to the
 * specified [OnListFragmentInteractionListener].
 * TODO: Replace the implementation with code for your data type.
 */
class MyordenHistorialRecyclerViewAdapter(var historial: ArrayList<HistorialOrden>, private val listener: OrdenHistorialViewHolder.OrdenHistorialItemListener
) : RecyclerView.Adapter<OrdenHistorialViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrdenHistorialViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_row_historial, parent, false)
        return OrdenHistorialViewHolder(view,listener)
    }

    override fun onBindViewHolder(holder: OrdenHistorialViewHolder, position: Int) {
            holder.bindData(historial)
    }

    override fun getItemCount(): Int {

 return historial.size

    }


}
