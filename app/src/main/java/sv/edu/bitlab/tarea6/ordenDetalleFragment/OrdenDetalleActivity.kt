package sv.edu.bitlab.tarea6.ordenDetalleFragment

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import sv.edu.bitlab.tarea6.R
import sv.edu.bitlab.tarea6.entity.Pupusa

import sv.edu.bitlab.tarea6.mainActivity.MainActivity

class OrdenDetalleActivity : AppCompatActivity(),OrdenDetalle.OnFragmentInteractionListener {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_orden_detalle)
       // setContentView(R.layout.activity_orden_detalle)
        val ordenaux=intent.getStringArrayListExtra("rellenos")
        //val orden=  intent.getParcelableExtra<Orden>("parcel")

        val listaPupusas = intent.extras?.getParcelableArrayList<Pupusa>("Orden");

        val fragment = OrdenDetalle.newInstance(listaPupusas!!)
        val builder = supportFragmentManager
            .beginTransaction()
            .add(R.id.listContainerOrdenDetalle, fragment, MainActivity.FRAGMENT_TAG2)

        builder.commitAllowingStateLoss()


    }
    override fun onFragmentInteraction(uri: Uri) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


}
