package sv.edu.bitlab.tarea6.ordenDetalleFragment.recyclerView

import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.list_row.view.*
import kotlinx.android.synthetic.main.list_row_detalle.view.*
import sv.edu.bitlab.tarea6.*
import sv.edu.bitlab.tarea6.entity.Orden
import sv.edu.bitlab.tarea6.entity.Pupusa
import sv.edu.bitlab.tarea6.mainActivity.recyclerView.OrdenItemViewHolder

class OrdenDetalleViewHolder(itemView : View, val listener: OrdenItemListener)  : RecyclerView.ViewHolder(itemView){

    var txtcantidad: TextView? = null
    var txtdescripcion : TextView? =null
    var contenedor:View? = null


    fun bindData(pupusas:ArrayList<Pupusa>) {

        contenedor = itemView.itemOrderDetalleContainer
        txtcantidad=itemView.txtcantidad
        txtdescripcion=itemView.txtdescripcion



        displayDetalle(pupusas,this.adapterPosition)

   contenedor!!.setOnClickListener { Log.d("RECYCLER_VIEW", "Click en contenedor") }

    }




    fun displayDetalle(pupusas: ArrayList<Pupusa>,position: Int){

        txtcantidad!!.text = "X${pupusas.get(position).cantidad}"
        txtdescripcion!!.text="${pupusas.get(position).tipo_masa} ${pupusas.get(position).relleno}"


    }




    interface OrdenItemListener{
        fun onOrdenarDenuevoClick(orden: Orden)
        fun onItemClick(position: Int)
        fun onTextInput(input:String, position: Int)
    }

}