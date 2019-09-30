package sv.edu.bitlab.tarea6.ordenHistorial.recyclerView

import android.view.View
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import sv.edu.bitlab.tarea6.entity.Orden

class OrdenHistorialViewHolder(itemView: View, val listener: OrdenHistorialItemListener) : RecyclerView.ViewHolder(itemView)  {

    var txt_estado: Button? = null
    var txt_cantidad : Button? =null
    var contenedor:View? = null

    interface OrdenHistorialItemListener{
        fun onOrdenarDenuevoClick(orden: Orden)
        fun onItemClick(position: Int)
        fun onTextInput(input:String, position: Int)
    }
}