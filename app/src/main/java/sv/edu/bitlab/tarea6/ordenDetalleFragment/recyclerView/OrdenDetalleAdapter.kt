package sv.edu.bitlab.tarea6.ordenDetalleFragment.recyclerView

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import sv.edu.bitlab.tarea6.*
import sv.edu.bitlab.tarea6.entity.Orden
import sv.edu.bitlab.tarea6.entity.Pupusa
import sv.edu.bitlab.tarea6.mainActivity.recyclerView.OrdenItemViewHolder


class OrdenDetalleAdapter(var orden: Orden, val listener: OrdenDetalleViewHolder.OrdenItemListener
) : RecyclerView.Adapter<OrdenDetalleViewHolder>() {


    var pupusas=parseData2(orden.arroz,orden.maiz)



    override fun onBindViewHolder(holder: OrdenDetalleViewHolder, position: Int) {
        holder.bindData(pupusas,orden)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrdenDetalleViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_row_detalle, parent, false)
        return OrdenDetalleViewHolder(view, listener)
    }

    override fun getItemCount(): Int {



        return pupusas.size+ RESULT_ORDER


    }


    fun parseData2(hash_arroz:HashMap<Int,Int>,hash_maiz: HashMap<Int, Int>):ArrayList<Pupusa>{

        var pupusas = ArrayList<Pupusa>()

        for ((key,value) in hash_arroz){

            if (value!=0){

                var relleno = getRelleno(key)
                var tipo_masa="arroz"
                var cantidad=value
                val pupusa=Pupusa(relleno, cantidad, tipo_masa)
                pupusas.add(pupusa)

            }


        }

        for ((key,value) in hash_maiz){

            if (value!=0){

                var relleno = getRelleno(key)
                var tipo_masa="maiz"
                var cantidad=value
                val pupusa=Pupusa(relleno, cantidad, tipo_masa)
                pupusas.add(pupusa)

            }


        }




return pupusas
    }

    fun getRelleno(key:Int):String{

        var relleno=""

        when(key){

            QUESO ->{ relleno="QUESO"}
            FRIJOLES ->{relleno= "FRIJOLES"}
            REVUELTAS ->{relleno= "REVUELTAS"}
            AJO ->{relleno= "AJO"}
            CHICHARRON ->{relleno= "CHICHARRON"}
            FRIJOL_QUESO ->{relleno= "FRIJOL QUESO"}

        }


        return relleno
    }

    companion object {

        const val RESULT_ORDER=1

    }
}