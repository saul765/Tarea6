package sv.edu.bitlab.tarea6.mainActivity

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import sv.edu.bitlab.tarea6.R
import sv.edu.bitlab.tarea6.entity.Orden
import sv.edu.bitlab.tarea6.entity.Orden2
import sv.edu.bitlab.tarea6.entity.Relleno
import sv.edu.bitlab.tarea6.entity.RellenoWrapper
import sv.edu.bitlab.tarea6.ordenDetalleFragment.OrdenDetalle
import sv.edu.bitlab.tarea6.ordenDetalleFragment.OrdenDetalleActivity
import sv.edu.bitlab.tarea6.startservice.ApiService

class MainActivity : AppCompatActivity(),OrdenFragment.OrdenFragmentInteractionListener,OrdenDetalle.OnFragmentInteractionListener {

    val orden=Orden()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val ordenes = Orden.randomOrders()
       /* val orden2= Orden2()

        ApiService.create().getRellenos().enqueue(object : Callback<List<Relleno>>{
            override fun onResponse(
                call: Call<List<Relleno>>,
                response: Response<List<Relleno>>
            ) {

                var array= response.body()
                parseData(array!!,orden2)

                Log.d("JSON", array.toString())

            }

            override fun onFailure(call: Call<List<Relleno>>, t: Throwable) {
                Log.d("ERROR","NO SE PUEDE MOSTRAR EL JSON")
            }

        })*/

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

    fun parseData(list: List<Relleno>,orden2: Orden2){

        for (item in list){

            orden2.setHashPupusas(item.nombre)

        }


        Log.d("HASHMAPS","${orden2.maiz} ${orden2.arroz}")


    }
    companion object{
        const val FRAGMENT_TAG = "ORDENES"
        const val FRAGMENT_TAG2= "ORDEN DETALLE"
    }
}
