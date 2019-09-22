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
import sv.edu.bitlab.tarea6.mainActivity.recyclerView.OrdenItemViewHolder

class OrdenDetalleViewHolder(itemView : View, val listener: OrdenItemListener)  : RecyclerView.ViewHolder(itemView){

    var txtcantidad: TextView? = null
    var txtdescripcion : TextView? =null
    var contenedor:View? = null
    lateinit var keys:ArrayList<Int>






    fun bindData(hashArroz: HashMap<Int,Int>,hashMaiz: HashMap<Int, Int>) {

        contenedor = itemView.itemOrderDetalleContainer
        txtcantidad=itemView.txtcantidad
        txtdescripcion=itemView.txtdescripcion
        keys=getKeys(hashArroz,hashMaiz)
      displayDetalle(keys,hashArroz,hashMaiz,this.adapterPosition)

   contenedor!!.setOnClickListener { Log.d("RECYCLER_VIEW", "Click en contenedor") }

    }


    fun displayDetalle(keys: ArrayList<Int>, hashArroz: HashMap<Int, Int>, hashMaiz: HashMap<Int, Int>, position: Int){

        Log.d("SIZEARROZ",hashArroz.size.toString())
        Log.d("SIZEMAIZ",hashMaiz.size.toString())
        Log.d("SIZEARROZ2",hashArroz.toString())
        Log.d("SIZEMAIZ2",hashMaiz.size.toString())
        if (hashArroz.size!=0&&position<=keys.size/2) {
            var key = keys[position]
            txtcantidad!!.text = "X${hashArroz[key].toString()}"
            val relleno= getRelleno(key)
            txtdescripcion!!.text="maiz $relleno"

        }else{
            if (hashMaiz.size!=0) {
                var key = keys[position]
                val relleno = getRelleno(key)
                txtcantidad!!.text = "X${hashMaiz[key].toString()}"
                txtdescripcion!!.text = "arroz $relleno"
            }

        }



    }

    fun getRelleno(key:Int):String{

        var relleno=""

        when(key){

            QUESO->{ relleno="QUESO"}
            FRIJOLES->{relleno= "FRIJOLES"}
            REVUELTAS->{relleno= "REVUELTAS"}
            AJO->{relleno= "AJO"}
            CHICHARRON->{relleno= "CHICHARRON"}
            FRIJOL_QUESO->{relleno= "FRIJOL QUESO"}

        }


        return relleno
    }
    fun getKeys(hashArroz: HashMap<Int, Int>, hashMaiz: HashMap<Int, Int>):ArrayList<Int>{

         var keys=ArrayList<Int>()

        for ((key,value)in hashArroz){

            if (value!=0){
                   keys.add(key)
            }

        }

        for ((key2,value2)in hashMaiz){

            if (value2!=0){
                keys.add(key2)

            }
        }
        Log.d("KEYS","${keys.toString()}")
return keys
    }


    interface OrdenItemListener{
        fun onOrdenarDenuevoClick(orden: Orden)
        fun onItemClick(position: Int)
        fun onTextInput(input:String, position: Int)
    }

}