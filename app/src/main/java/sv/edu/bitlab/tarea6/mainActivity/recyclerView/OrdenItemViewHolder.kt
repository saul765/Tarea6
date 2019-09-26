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
     updateMaiz(orden,this.adapterPosition,"add")

      Log.d("RECYCLER_VIEW", " hash arroz ${orden.arroz.toString()} hash maiz${orden.maiz.toString()}")

    }
   btnmaiz!!.setOnLongClickListener {

     updateMaiz(orden,this.adapterPosition,"reset")
     return@setOnLongClickListener true
   }
    btnarroz!!.setOnClickListener {
      listener.onItemClick(this.adapterPosition)
      updateArroz(orden,this.adapterPosition,"add")
      Log.d("RECYCLER_VIEW", " hash arroz ${orden.arroz.toString()} hash maiz${orden.maiz.toString()}")
    }
    contenedor!!.setOnClickListener { Log.d("RECYCLER_VIEW", "Click en contenedor") }

    btnarroz!!.setOnLongClickListener {

      updateArroz(orden,this.adapterPosition,"reset")
      return@setOnLongClickListener true
    }
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

  fun updateMaiz(orden:Orden,position: Int,action:String) {



      when (position) {

        QUESO -> {
          if (action.equals("add")){
            Log.d("ADD","im in add")
            orden.maiz[QUESO] = orden.maiz[QUESO]!! + 1
          }else{
            Log.d("NOT ADD","not in add")
            orden.maiz[QUESO]=0
          }

          var cantidad = orden.maiz[QUESO]
          var relleno = itemView.context.resources.getString(R.string.queso)
          btnmaiz!!.text = "QUESO ${orden.maiz[QUESO]}"
          //btnmaiz!!.text = itemView.context.resources.getString(R.string.relleno, relleno, cantidad)


        }
        FRIJOLES -> {
          if (action.equals("add")){
            orden.maiz[FRIJOLES] = orden.maiz[FRIJOLES]!! + 1
          }else{
            orden.maiz[FRIJOLES]=0
          }
          /*btnmaiz!!.text = "FRIJOLES ${orden.maiz[FRIJOLES]}"*/
          var cantidad = orden.maiz[FRIJOLES]
          var relleno = itemView.context.resources.getString(R.string.frijol)
          /* btnmaiz!!.text = "QUESO ${orden.maiz[QUESO]}"*/
          btnmaiz!!.text = itemView.context.resources.getString(R.string.relleno, relleno, cantidad)


        }
        REVUELTAS -> {
          if (action.equals("add")){
            orden.maiz[REVUELTAS] = orden.maiz[REVUELTAS]!! + 1
          }else{
            orden.maiz[REVUELTAS]=0
          }
         /* btnmaiz!!.text = "REVUELTAS ${orden.maiz[REVUELTAS]}"*/
          var cantidad = orden.maiz[REVUELTAS]
          var relleno = itemView.context.resources.getString(R.string.revuelta)
          /* btnmaiz!!.text = "QUESO ${orden.maiz[QUESO]}"*/
          btnmaiz!!.text = itemView.context.resources.getString(R.string.relleno, relleno, cantidad)


        }
        AJO -> {
          if (action.equals("add")){
            orden.maiz[AJO] = orden.maiz[AJO]!! + 1
          }else{
            orden.maiz[AJO]=0
          }
          /*btnmaiz!!.text = "AJO ${orden.maiz[AJO]}"*/
          var cantidad = orden.maiz[AJO]
          var relleno = itemView.context.resources.getString(R.string.ajo)
          /* btnmaiz!!.text = "QUESO ${orden.maiz[QUESO]}"*/
          btnmaiz!!.text = itemView.context.resources.getString(R.string.relleno, relleno, cantidad)


        }
        CHICHARRON -> {
          if (action.equals("add")){
            orden.maiz[CHICHARRON] = orden.maiz[CHICHARRON]!! + 1
          }else{
            orden.maiz[CHICHARRON]=0
          }
         /* btnmaiz!!.text = "CHICHARRON ${orden.maiz[CHICHARRON]}"*/
          var cantidad = orden.maiz[CHICHARRON]
          var relleno = itemView.context.resources.getString(R.string.chicharron)
          /* btnmaiz!!.text = "QUESO ${orden.maiz[QUESO]}"*/
          btnmaiz!!.text = itemView.context.resources.getString(R.string.relleno, relleno, cantidad)


        }
        FRIJOL_QUESO -> {
          if (action.equals("add")){
            orden.maiz[FRIJOL_QUESO] = orden.maiz[FRIJOL_QUESO]!! + 1
          }else{
            orden.maiz[FRIJOL_QUESO]=0
          }
         /* btnmaiz!!.text = "FRIJOL QUESO ${orden.maiz[FRIJOL_QUESO]}"*/
          var cantidad = orden.maiz[FRIJOL_QUESO]
          var relleno = itemView.context.resources.getString(R.string.frijol_queso)
          /* btnmaiz!!.text = "QUESO ${orden.maiz[QUESO]}"*/
          btnmaiz!!.text = itemView.context.resources.getString(R.string.relleno, relleno, cantidad)


        }


      }

  }

    fun updateArroz(orden: Orden, position: Int, action: String) {



      when (position) {

        QUESO -> {
          if (action.equals("add")){
            Log.d("ADD","im in add")
            orden.arroz[QUESO] = orden.arroz[QUESO]!! + 1
          }else{
            Log.d("NOT ADD","not in add")
            orden.arroz[QUESO]=0
          }

          var cantidad = orden.arroz[QUESO]
          var relleno = itemView.context.resources.getString(R.string.queso)
         // btnmaiz!!.text = "QUESO ${orden.maiz[QUESO]}"
          btnarroz!!.text = itemView.context.resources.getString(R.string.relleno, relleno, cantidad)


        }
        FRIJOLES -> {
          if (action.equals("add")){
            orden.arroz[FRIJOLES] = orden.arroz[FRIJOLES]!! + 1
          }else{
            orden.arroz[FRIJOLES]=0
          }
          /*btnmaiz!!.text = "FRIJOLES ${orden.maiz[FRIJOLES]}"*/
          var cantidad = orden.arroz[FRIJOLES]
          var relleno = itemView.context.resources.getString(R.string.frijol)
          /* btnmaiz!!.text = "QUESO ${orden.maiz[QUESO]}"*/
          btnarroz!!.text = itemView.context.resources.getString(R.string.relleno, relleno, cantidad)


        }
        REVUELTAS -> {
          if (action.equals("add")){
            orden.arroz[REVUELTAS] = orden.arroz[REVUELTAS]!! + 1
          }else{
            orden.arroz[REVUELTAS]=0
          }
          /* btnmaiz!!.text = "REVUELTAS ${orden.maiz[REVUELTAS]}"*/
          var cantidad = orden.arroz[REVUELTAS]
          var relleno = itemView.context.resources.getString(R.string.revuelta)
          /* btnmaiz!!.text = "QUESO ${orden.maiz[QUESO]}"*/
          btnarroz!!.text = itemView.context.resources.getString(R.string.relleno, relleno, cantidad)


        }
        AJO -> {
          if (action.equals("add")){
            orden.arroz[AJO] = orden.arroz[AJO]!! + 1
          }else{
            orden.arroz[AJO]=0
          }
          /*btnmaiz!!.text = "AJO ${orden.maiz[AJO]}"*/
          var cantidad = orden.arroz[AJO]
          var relleno = itemView.context.resources.getString(R.string.ajo)
          /* btnmaiz!!.text = "QUESO ${orden.maiz[QUESO]}"*/
          btnarroz!!.text = itemView.context.resources.getString(R.string.relleno, relleno, cantidad)


        }
        CHICHARRON -> {
          if (action.equals("add")){
            orden.arroz[CHICHARRON] = orden.arroz[CHICHARRON]!! + 1
          }else{
            orden.arroz[CHICHARRON]=0
          }
          /* btnmaiz!!.text = "CHICHARRON ${orden.maiz[CHICHARRON]}"*/
          var cantidad = orden.arroz[CHICHARRON]
          var relleno = itemView.context.resources.getString(R.string.chicharron)
          /* btnmaiz!!.text = "QUESO ${orden.maiz[QUESO]}"*/
          btnarroz!!.text = itemView.context.resources.getString(R.string.relleno, relleno, cantidad)


        }
        FRIJOL_QUESO -> {
          if (action.equals("add")){
            orden.arroz[FRIJOL_QUESO] = orden.arroz[FRIJOL_QUESO]!! + 1
          }else{
            orden.arroz[FRIJOL_QUESO]=0
          }
          /* btnmaiz!!.text = "FRIJOL QUESO ${orden.maiz[FRIJOL_QUESO]}"*/
          var cantidad = orden.arroz[FRIJOL_QUESO]
          var relleno = itemView.context.resources.getString(R.string.frijol_queso)
          /* btnmaiz!!.text = "QUESO ${orden.maiz[QUESO]}"*/
          btnarroz!!.text = itemView.context.resources.getString(R.string.relleno, relleno, cantidad)


        }


      }


    }

  interface OrdenItemListener{
    fun onOrdenarDenuevoClick(orden: Orden)
    fun onItemClick(position: Int)
    fun onTextInput(input:String, position: Int)
  }

}

