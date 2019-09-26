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
    lateinit var orden:Orden

    fun bindData(pupusas:ArrayList<Pupusa>,orden: Orden) {

        contenedor = itemView.itemOrderDetalleContainer
        txtcantidad=itemView.txtcantidad
        txtdescripcion=itemView.txtdescripcion
        this.orden=orden



        displayDetalle(pupusas,this.adapterPosition)

   contenedor!!.setOnClickListener { Log.d("RECYCLER_VIEW", "Click en contenedor") }

    }




    fun displayDetalle(pupusas: ArrayList<Pupusa>,position: Int){


        if (position==pupusas.size){

            txtcantidad!!.text = "Total"
            txtdescripcion!!.text=" $${getTotal(pupusas)}"
        }else{
            txtcantidad!!.text = "X${pupusas.get(position).cantidad}"
            txtdescripcion!!.text="${pupusas.get(position).tipo_masa} ${pupusas.get(position).relleno}"

        }


    }

    fun getTotal(pupusas: ArrayList<Pupusa>):Float{
        var total=0.0F

        for (x in pupusas){

            total=total+x.cantidad*orden.precioUnidad
        }
        return total
    }




    interface OrdenItemListener{
        fun onOrdenarDenuevoClick(orden: Orden)
        fun onItemClick(position: Int)
        fun onTextInput(input:String, position: Int)
    }

}