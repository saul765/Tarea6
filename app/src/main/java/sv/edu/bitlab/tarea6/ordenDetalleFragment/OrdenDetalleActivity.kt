package sv.edu.bitlab.tarea6.ordenDetalleFragment

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_orden_detalle.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import sv.edu.bitlab.tarea6.R
import sv.edu.bitlab.tarea6.entity.HistorialOrden
import sv.edu.bitlab.tarea6.entity.HistorialOrdenPOST
import sv.edu.bitlab.tarea6.entity.Pupusa

import sv.edu.bitlab.tarea6.mainActivity.MainActivity
import sv.edu.bitlab.tarea6.startservice.ApiService

class OrdenDetalleActivity : AppCompatActivity(),OrdenDetalle.OnFragmentInteractionListener {
    override fun onClickOrder(orden: HistorialOrden,ordenPOST: HistorialOrdenPOST) {


        confirm_order.setOnClickListener {


            Toast.makeText(applicationContext,"SENDING ORDER test",Toast.LENGTH_LONG).show()

            //Log.d("historial","$orden")
           ApiService.create().submitOrden(ordenPOST).enqueue(object : Callback<HistorialOrdenPOST> {
                override fun onResponse(
                    call: Call<HistorialOrdenPOST>,
                    response: Response<HistorialOrdenPOST>
                ) {

                    Toast.makeText(applicationContext,"ORDER SENT",Toast.LENGTH_LONG).show()
                    Log.d("STATUS","SE ENVIO")
                    Log.d("STATUS2","$ordenPOST")

                }

                override fun onFailure(call: Call<HistorialOrdenPOST>, t: Throwable) {
                    Toast.makeText(applicationContext,"ORDER FAIL",Toast.LENGTH_LONG).show()
                    Log.d("STATUS","NO SE ENVIO")
                }

            })



        }
    }


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

//
//        confirm_order.setOnClickListener {
//            Toast.makeText(applicationContext,"aprete",Toast.LENGTH_LONG).show()
//
//        }

    }
    override fun onFragmentInteraction(uri: Uri) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


}
