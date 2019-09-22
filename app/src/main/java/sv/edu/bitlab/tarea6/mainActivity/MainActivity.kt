package sv.edu.bitlab.tarea6.mainActivity

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import sv.edu.bitlab.tarea6.R
import sv.edu.bitlab.tarea6.entity.Orden
import sv.edu.bitlab.tarea6.ordenDetalleFragment.OrdenDetalle
import sv.edu.bitlab.tarea6.ordenDetalleFragment.OrdenDetalleActivity

class MainActivity : AppCompatActivity(),OrdenFragment.OrdenFragmentInteractionListener,OrdenDetalle.OnFragmentInteractionListener {

    val orden=Orden()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val ordenes = Orden.randomOrders()
        //val orden = Orden()
        val fragment = OrdenFragment.newInstance(ordenes,orden)
        val builder = supportFragmentManager
            .beginTransaction()
            .add(R.id.listContainer, fragment, FRAGMENT_TAG)
           // .addToBackStack(FRAGMENT_TAG)
        builder.commitAllowingStateLoss()

        sendOrder.setOnClickListener {
            val intent = Intent(this,OrdenDetalleActivity::class.java).apply {

                putExtra("parcel",orden)
                putExtra("hello","hello")

            }
            startActivity(intent)
            Log.d("MAIN ACT", " hash arroz ${orden.arroz.toString()} hash maiz${orden.maiz.toString()}")


        }

    }
    override fun onFragmentInteraction(uri: Uri) {

    }


    companion object{
        const val FRAGMENT_TAG = "ORDENES"
        const val FRAGMENT_TAG2= "ORDEN DETALLE"
    }
}
