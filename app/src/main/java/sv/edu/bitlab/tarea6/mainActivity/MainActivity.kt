package sv.edu.bitlab.tarea6.mainActivity

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_main.*
import sv.edu.bitlab.tarea6.R
import sv.edu.bitlab.tarea6.entity.*
import sv.edu.bitlab.tarea6.ordenDetalleFragment.OrdenDetalle
import sv.edu.bitlab.tarea6.ordenDetalleFragment.OrdenDetalleActivity
import sv.edu.bitlab.tarea6.ordenHistorial.OrdenHistorialActivity

class MainActivity : AppCompatActivity(),OrdenFragment.OrdenFragmentInteractionListener,OrdenDetalle.OnFragmentInteractionListener {
    override fun returnOrden(orden: Orden) {
        //this.orden=orden
    }
    val maiz=HashMap<Int,Int>()
    val arroz=HashMap<Int,Int>()
    val rellenos= mutableListOf<String>()
    val orden=Orden()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val ordenes = Orden.randomOrders()

        val fragment = OrdenFragment.newInstance(orden)
        val builder = supportFragmentManager
            .beginTransaction()
            .add(R.id.listContainer, fragment, FRAGMENT_TAG)
           // .addToBackStack(FRAGMENT_TAG)
        builder.commitAllowingStateLoss()

        sendOrder.setOnClickListener {
            val rellenos= ArrayList<String>()
            val a = arrayListOf<Int>(1,2,3)
            rellenos.addAll(orden.rellenos)
            val intent = Intent(this,OrdenDetalleActivity::class.java).apply {
                putExtra("parcel",orden)
                putExtra("rellenos",rellenos)
                putExtra("ddd",a)
                putStringArrayListExtra("rellenos",rellenos)
               // putExtra("reparcel",orderDetail)

                Log.d("MAIN ACT parce", " ${orden.rellenos}")
                Log.d("RELLENOS","$rellenos")
            }
            startActivity(intent)
            Log.d("MAIN ACT", " hash arroz ${orden.arroz.toString()} hash maiz${orden.maiz.toString()}")


        }

    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.mymenu,menu)

        return super.onCreateOptionsMenu(menu)
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        val id=item.itemId

        when(id){

            R.id.historial->{

                val intent2 = Intent(this,OrdenHistorialActivity::class.java).apply {

                }
                startActivity(intent2)

            }

        }

        return super.onOptionsItemSelected(item)
    }
    override fun onFragmentInteraction(uri: Uri) {

    }

    fun parseData(list: List<Relleno>,orden2: Orden2){

        for (item in list){

            orden2.setHashPupusas(item.nombre)

        }


        Log.d("HASHMAPS","${orden2.maiz} ${orden2.arroz}")


    }
    companion object{
        const val FRAGMENT_TAG = "ORDENES"
        const val FRAGMENT_TAG2= "ORDEN DETALLE"
        const val FRAGMENT_TAG3= "ORDEN HISTORIAL"
    }
}
