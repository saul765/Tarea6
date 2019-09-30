package sv.edu.bitlab.tarea6.ordenDetalleFragment.recyclerView

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import sv.edu.bitlab.tarea6.*
import sv.edu.bitlab.tarea6.entity.Orden
import sv.edu.bitlab.tarea6.entity.Pupusa


class OrdenDetalleAdapter(var pupusas: ArrayList<Pupusa>, val listener: OrdenDetalleViewHolder.OrdenItemListener
) : RecyclerView.Adapter<OrdenDetalleViewHolder>() {




    override fun onBindViewHolder(holder: OrdenDetalleViewHolder, position: Int) {
        holder.bindData(pupusas)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrdenDetalleViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_row_detalle, parent, false)
        return OrdenDetalleViewHolder(view, listener)
    }

    override fun getItemCount(): Int {



        return pupusas.size+ RESULT_ORDER


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