package sv.edu.bitlab.tarea6.ordenDetalleFragment.recyclerView

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import sv.edu.bitlab.tarea6.R
import sv.edu.bitlab.tarea6.entity.Orden
import sv.edu.bitlab.tarea6.mainActivity.recyclerView.OrdenItemViewHolder

class OrdenDetalleAdapter(var orden: Orden, val listener: OrdenDetalleViewHolder.OrdenItemListener
) : RecyclerView.Adapter<OrdenDetalleViewHolder>() {

    var hash_maiz=parseData(orden.arroz)
    var hash_arroz=parseData(orden.maiz)

    override fun onBindViewHolder(holder: OrdenDetalleViewHolder, position: Int) {
        holder.bindData(hash_arroz ,hash_maiz)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrdenDetalleViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_row_detalle, parent, false)
        return OrdenDetalleViewHolder(view, listener)
    }

    override fun getItemCount(): Int {
       // val hash_maiz=parseData(orden.arroz)
        //val hash_arroz=parseData(orden.maiz)

        Log.d("NEW HASH","${hash_arroz.toString()} ${hash_maiz.toString()}")

        return hash_maiz.size+hash_arroz.size
        //orden.arroz.size

    }

    fun parseData(hashMap: HashMap<Int,Int>):HashMap<Int,Int>{
        var hash=  HashMap<Int,Int>()

        for ((key,value) in hashMap){

                if (value!=0){

                    hash.put(key,value)
                }

            Log.d("ADAPTER","$key $value")
        }



        return hash
    }
}