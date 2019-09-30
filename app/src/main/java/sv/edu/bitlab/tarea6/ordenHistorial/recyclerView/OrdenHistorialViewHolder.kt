package sv.edu.bitlab.tarea6.ordenHistorial.recyclerView

import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.list_row_detalle.view.*
import kotlinx.android.synthetic.main.list_row_historial.view.*
import org.w3c.dom.Text
import sv.edu.bitlab.tarea6.entity.HistorialOrden
import sv.edu.bitlab.tarea6.entity.Orden
import sv.edu.bitlab.tarea6.entity.Pupusa

class OrdenHistorialViewHolder(itemView: View, val listener: OrdenHistorialItemListener) : RecyclerView.ViewHolder(itemView)  {

    var id_txt: TextView? = null
    var fecha_txt : TextView? =null
    var total_txt: TextView?=null
    var btn_detalle:Button? =null
    var status_txt:TextView?=null


    fun bindData(pupusas:ArrayList<HistorialOrden>) {


        id_txt=itemView.idTxt
        fecha_txt=itemView.fechaTxt
        total_txt=itemView.totalTxt
        btn_detalle=itemView.verDetalleBtn
        status_txt=itemView.statusTxt


        listener.onViewDetalleOrden(id_txt!!,fecha_txt!!,total_txt!!,status_txt!!,this.adapterPosition)

        btn_detalle!!.setOnClickListener {

            listener.onItemClickDetalle(btn_detalle!!,this.adapterPosition)

        }








    }


    interface OrdenHistorialItemListener{
        fun onViewDetalleOrden(id:TextView,fecha: TextView,total:TextView,status:TextView,position: Int)
        fun onItemClickDetalle(btn_detalle:Button,position: Int)
        fun onTextInput(input:String, position: Int)
    }
}