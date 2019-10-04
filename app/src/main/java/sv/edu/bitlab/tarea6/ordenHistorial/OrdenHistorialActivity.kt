package sv.edu.bitlab.tarea6.ordenHistorial

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import sv.edu.bitlab.tarea6.R
import sv.edu.bitlab.tarea6.entity.HistorialOrden
import sv.edu.bitlab.tarea6.entity.Orden
import sv.edu.bitlab.tarea6.entity.Relleno
import sv.edu.bitlab.tarea6.mainActivity.MainActivity
import sv.edu.bitlab.tarea6.mainActivity.OrdenFragment

class OrdenHistorialActivity : AppCompatActivity(),OrdenHistorialFragment.OnListFragmentInteractionListener,OrdenHistorialDetalleFragment.OnFragmentInteractionListener{


    private lateinit var rellenos:ArrayList<String>
    override fun onFragmentInteraction(uri: Uri) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun changetoFragmentOrden(historial:ArrayList<HistorialOrden>,position:Int) {
        var id_maiz=1
        var id_arroz=1
        if (historial.get(position).maiz.size!=0){
             id_maiz=historial.get(position).maiz.get(0).relleno_id.toInt()
        }
        if (historial.get(position).arroz.size!=0){

             id_arroz=historial.get(position).arroz.get(0).relleno_id.toInt()
        }
      //  val id_maiz=historial.get(position).maiz.get(0).relleno_id.toInt()
        //val id_arroz=historial.get(position).arroz.get(0).relleno_id.toInt()

        val relleno_maiz=rellenos.get(id_maiz-1)
        val relleno_arroz=rellenos.get(id_arroz-1)
        val history=historial.get(position)

      //  val fragment = OrdenHistorialDetalleFragment.newInstance(historial,rellenos)
        val fragment = OrdenHistorialDetalleFragment.newInstance(history,relleno_maiz,relleno_arroz)

        val builder = supportFragmentManager
            .beginTransaction()
            .replace(R.id.frag_historial, fragment, MainActivity.FRAGMENT_TAG4)
         .addToBackStack(MainActivity.FRAGMENT_TAG4)
        builder.commitAllowingStateLoss()
    }

    override fun onListFragmentInteraction(uri: Uri) {

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_orden_historial)

        rellenos=intent.getStringArrayListExtra("rellenos")



        val fragment2 = OrdenHistorialFragment.newInstance()
        val builder = supportFragmentManager
            .beginTransaction()
            .replace(R.id.frag_historial, fragment2, MainActivity.FRAGMENT_TAG3)
         //.addToBackStack(MainActivity.FRAGMENT_TAG3)
        builder.commitAllowingStateLoss()
    }
}
