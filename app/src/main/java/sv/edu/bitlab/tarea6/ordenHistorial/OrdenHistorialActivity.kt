package sv.edu.bitlab.tarea6.ordenHistorial

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import sv.edu.bitlab.tarea6.R
import sv.edu.bitlab.tarea6.entity.Orden
import sv.edu.bitlab.tarea6.mainActivity.MainActivity
import sv.edu.bitlab.tarea6.mainActivity.OrdenFragment

class OrdenHistorialActivity : AppCompatActivity(),OrdenHistorialFragment.OnListFragmentInteractionListener{

    override fun onListFragmentInteraction(uri: Uri) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_orden_historial)


        val fragment2 = OrdenHistorialFragment.newInstance()
        val builder = supportFragmentManager
            .beginTransaction()
            .replace(R.id.frag_historial, fragment2, MainActivity.FRAGMENT_TAG3)
        // .addToBackStack(FRAGMENT_TAG)
        builder.commitAllowingStateLoss()
    }
}
