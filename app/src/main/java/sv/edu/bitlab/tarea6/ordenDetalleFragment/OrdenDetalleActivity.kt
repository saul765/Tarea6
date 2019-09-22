package sv.edu.bitlab.tarea6.ordenDetalleFragment

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import sv.edu.bitlab.tarea6.R
import sv.edu.bitlab.tarea6.entity.Orden
import sv.edu.bitlab.tarea6.mainActivity.MainActivity
import sv.edu.bitlab.tarea6.mainActivity.OrdenFragment

class OrdenDetalleActivity : AppCompatActivity(),OrdenDetalle.OnFragmentInteractionListener {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_orden_detalle)
       // setContentView(R.layout.activity_orden_detalle)
         val orden=  intent.getParcelableExtra<Orden>("parcel")

        Log.d("OrdenDetalle ACT", " hash arroz ${orden.arroz.toString()} hash maiz${orden.maiz.toString()}")

        val fragment = OrdenDetalle.newInstance(orden)
        val builder = supportFragmentManager
            .beginTransaction()
            .add(R.id.listContainerOrdenDetalle, fragment, MainActivity.FRAGMENT_TAG2)

        builder.commitAllowingStateLoss()


    }
    override fun onFragmentInteraction(uri: Uri) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


}
