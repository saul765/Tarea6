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


        if (position==pupusas.size){

            //txtcantidad!!.text = "Total"
            txtcantidad!!.text = itemView.context.resources.getString(R.string.total)
            //txtdescripcion!!.text=" $${getTotal(pupusas)}"
            txtdescripcion!!.text=itemView.context.resources.getString(R.string.precio_total,getTotal(pupusas).toString())
        }else{
            //txtcantidad!!.text = "X${pupusas.get(position).cantidad}"
            var cantidad=pupusas.get(position).cantidad
            txtcantidad!!.text = itemView.context.resources.getString(R.string.cantidad,cantidad)
            //txtdescripcion!!.text="${pupusas.get(position).tipo_masa} ${pupusas.get(position).relleno}"
            var tipo_masa= pupusas.get(position).tipo_masa
            var relleno= pupusas.get(position).relleno
            txtdescripcion!!.text=itemView.context.resources.getString(R.string.masa_relleno,tipo_masa,relleno)

        }


    }

    fun getTotal(pupusas: ArrayList<Pupusa>):Float{
        var total=0.0F

        for (x in pupusas){

            total=total+x.cantidad*0.5F
        }
        return total
    }




    interface OrdenItemListener{
        fun onOrdenarDenuevoClick(orden: Orden)
        fun onItemClick(position: Int)
        fun onTextInput(input:String, position: Int)
    }

}