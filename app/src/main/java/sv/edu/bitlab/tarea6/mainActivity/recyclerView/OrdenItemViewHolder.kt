package sv.edu.bitlab.tarea6.mainActivity.recyclerView

import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.list_row.view.*
import sv.edu.bitlab.tarea6.*
import sv.edu.bitlab.tarea6.entity.Orden

class OrdenItemViewHolder(itemView : View, val listener:OrdenItemListener) : RecyclerView.ViewHolder(itemView) {


  var btnmaiz: Button? = null
  var btnarroz :Button? =null
  var contenedor:View? = null




  fun bindData(orden: Orden) {


    contenedor = itemView.itemContainer
    btnarroz=itemView.button_arroz
    btnmaiz=itemView.button_maiz
    displayRellenos(orden,this.adapterPosition)


    btnmaiz!!.setOnClickListener {
      listener.onItemClick(this.adapterPosition)
     updateMaiz(orden,this.adapterPosition)
      Log.d("RECYCLER_VIEW", " hash arroz ${orden.arroz.toString()} hash maiz${orden.maiz.toString()}")

    }
    btnarroz!!.setOnClickListener {
      listener.onItemClick(this.adapterPosition)
      updateArroz(orden,this.adapterPosition)
      Log.d("RECYCLER_VIEW", " hash arroz ${orden.arroz.toString()} hash maiz${orden.maiz.toString()}")
    }
    contenedor!!.setOnClickListener { Log.d("RECYCLER_VIEW", "Click en contenedor") }

  }

  fun displayRellenos(orden:Orden,position: Int){

    when(position){

      QUESO->{
        /*btnmaiz!!.text="QUESO ${orden.maiz[QUESO]}"
        btnarroz!!.text="QUESO ${orden.arroz[QUESO]}"*/
        var cantidad_maiz=orden.maiz[QUESO]
        var relleno=itemView.context.getString(R.string.queso)
        btnmaiz!!.text=itemView.context.getString(R.string.relleno,relleno,cantidad_maiz)
        var cantidad_arroz=orden.arroz[QUESO]
        btnarroz!!.text=itemView.context.getString(R.string.relleno,relleno,cantidad_arroz)

      }
      FRIJOLES->{
        /*btnmaiz!!.text="FRIJOLES ${orden.maiz[FRIJOLES]}"
        btnarroz!!.text="FRIJOLES ${orden.arroz[FRIJOLES]}"*/

        var cantidad_maiz=orden.maiz[FRIJOLES]
        var relleno=itemView.context.getString(R.string.frijol)
        btnmaiz!!.text=itemView.context.getString(R.string.relleno,relleno,cantidad_maiz)
        var cantidad_arroz=orden.arroz[FRIJOLES]
        btnarroz!!.text=itemView.context.getString(R.string.relleno,relleno,cantidad_arroz)

      }
      REVUELTAS->{
       /* btnmaiz!!.text="REVUELTAS ${orden.maiz[REVUELTAS]}"
        btnarroz!!.text="REVUELTAS ${orden.arroz[REVUELTAS]}"*/
        var cantidad_maiz=orden.maiz[REVUELTAS]
        var relleno=itemView.context.getString(R.string.revuelta)
        btnmaiz!!.text=itemView.context.getString(R.string.relleno,relleno,cantidad_maiz)
        var cantidad_arroz=orden.arroz[REVUELTAS]
        btnarroz!!.text=itemView.context.getString(R.string.relleno,relleno,cantidad_arroz)

      }
      AJO->{
        /*btnmaiz!!.text="AJO ${orden.maiz[AJO]}"
        btnarroz!!.text="AJO ${orden.arroz[AJO]}"*/
        var cantidad_maiz=orden.maiz[AJO]
        var relleno=itemView.context.getString(R.string.ajo)
        btnmaiz!!.text=itemView.context.getString(R.string.relleno,relleno,cantidad_maiz)
        var cantidad_arroz=orden.arroz[AJO]
        btnarroz!!.text=itemView.context.getString(R.string.relleno,relleno,cantidad_arroz)

      }
      CHICHARRON->{
     /*   btnmaiz!!.text="CHICHARRON ${orden.maiz[CHICHARRON]}"
        btnarroz!!.text="CHICHARRON ${orden.arroz[CHICHARRON]}"*/
        var cantidad_maiz=orden.maiz[CHICHARRON]
        var relleno=itemView.context.getString(R.string.chicharron)
        btnmaiz!!.text=itemView.context.getString(R.string.relleno,relleno,cantidad_maiz)
        var cantidad_arroz=orden.arroz[CHICHARRON]
        btnarroz!!.text=itemView.context.getString(R.string.relleno,relleno,cantidad_arroz)

      }
      FRIJOL_QUESO->{
        /*btnmaiz!!.text="FRIJOL QUESO ${orden.maiz[FRIJOL_QUESO]}"
        btnarroz!!.text="FRIJOL QUESO ${orden.arroz[FRIJOL_QUESO]}"*/

        var cantidad_maiz=orden.maiz[FRIJOL_QUESO]
        var relleno=itemView.context.getString(R.string.frijol_queso)
        btnmaiz!!.text=itemView.context.getString(R.string.relleno,relleno,cantidad_maiz)
        var cantidad_arroz=orden.arroz[FRIJOL_QUESO]
        btnarroz!!.text=itemView.context.getString(R.string.relleno,relleno,cantidad_arroz)

      }




    }

  }

  fun updateMaiz(orden:Orden,position: Int){

    when(position){

      QUESO->{
        orden.maiz[QUESO]=orden.maiz[QUESO]!!+1
        btnmaiz!!.text="QUESO ${orden.maiz[QUESO]}"


      }
      FRIJOLES->{
        orden.maiz[FRIJOLES]=orden.maiz[FRIJOLES]!!+1
        btnmaiz!!.text="FRIJOLES ${orden.maiz[FRIJOLES]}"


      }
      REVUELTAS->{
        orden.maiz[REVUELTAS]=orden.maiz[REVUELTAS]!!+1
        btnmaiz!!.text="REVUELTAS ${orden.maiz[REVUELTAS]}"


      }
      AJO->{
        orden.maiz[AJO]=orden.maiz[AJO]!!+1
        btnmaiz!!.text="AJO ${orden.maiz[AJO]}"


      }
      CHICHARRON->{
        orden.maiz[CHICHARRON]=orden.maiz[CHICHARRON]!!+1
        btnmaiz!!.text="CHICHARRON ${orden.maiz[CHICHARRON]}"


      }
      FRIJOL_QUESO->{
        orden.maiz[FRIJOL_QUESO]=orden.maiz[FRIJOL_QUESO]!!+1
        btnmaiz!!.text="FRIJOL QUESO ${orden.maiz[FRIJOL_QUESO]}"


      }





    }

  }

  fun updateArroz(orden:Orden,position: Int){

    when(position){

      QUESO->{
        orden.arroz[QUESO]=orden.arroz[QUESO]!!+1
        btnarroz!!.text="QUESO ${orden.arroz[QUESO]}"


      }
      FRIJOLES->{
        orden.arroz[FRIJOLES]=orden.arroz[FRIJOLES]!!+1
        btnarroz!!.text="FRIJOLES ${orden.arroz[FRIJOLES]}"


      }
      REVUELTAS->{
        orden.arroz[REVUELTAS]=orden.arroz[REVUELTAS]!!+1
        btnarroz!!.text="REVUELTAS ${orden.arroz[REVUELTAS]}"


      }
      AJO->{
        orden.arroz[AJO]=orden.arroz[AJO]!!+1
        btnarroz!!.text="AJO ${orden.arroz[AJO]}"


      }
      CHICHARRON->{
        orden.arroz[CHICHARRON]=orden.arroz[CHICHARRON]!!+1
        btnarroz!!.text="CHICHARRON ${orden.arroz[CHICHARRON]}"


      }
      FRIJOL_QUESO->{
        orden.arroz[FRIJOL_QUESO]=orden.arroz[FRIJOL_QUESO]!!+1
        btnarroz!!.text="FRIJOL QUESO ${orden.arroz[FRIJOL_QUESO]}"


      }


    }

  }

  interface OrdenItemListener{
    fun onOrdenarDenuevoClick(orden: Orden)
    fun onItemClick(position: Int)
    fun onTextInput(input:String, position: Int)
  }
}