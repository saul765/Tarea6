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

    override fun returnPupusaList(list: ArrayList<Relleno>) {
        listaAPI=list
        Log.d("lISTA PUPA", "$listaPupusas")
        sendOrder.setOnClickListener {
            parseData(listaAPI)
            var bundle = Bundle()
            bundle.putParcelableArrayList("Orden",listaPupusas)

            val intent = Intent(this,OrdenDetalleActivity::class.java)
            intent.putExtras(bundle)
            startActivity(intent)
            Log.d("lISTA PUPA", "$listaPupusas")


        }



    }

    override fun onClickOrder(orden: HistorialOrden, ordenPOST: HistorialOrdenPOST) {

    }


    override fun returnOrden(orden: Orden) {
        //this.orden=orden
    }


    val orden=Orden()
    lateinit var listaPupusas:ArrayList<Pupusa>
    lateinit var listaAPI:ArrayList<Relleno>
    lateinit var listaAPIprocessed:ArrayList<OrdenPupusas>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        listaPupusas = ArrayList()
        val ordenes = Orden.randomOrders()

        val fragment = OrdenFragment.newInstance(orden)
        val builder = supportFragmentManager
            .beginTransaction()
            .add(R.id.listContainer, fragment, FRAGMENT_TAG)
           // .addToBackStack(FRAGMENT_TAG)
        builder.commitAllowingStateLoss()

      /*  sendOrder.setOnClickListener {
            parseData(listaAPI)
            var bundle = Bundle()
            bundle.putParcelableArrayList("Orden",listaPupusas)

            val intent = Intent(this,OrdenDetalleActivity::class.java)
            intent.putExtras(bundle)
            startActivity(intent)
            Log.d("MAIN ACT", " hash arroz ${orden.arroz.toString()} hash maiz${orden.maiz.toString()}")


        }*/

    }


    fun parseData(apiArray:ArrayList<Relleno>){
        listaPupusas.clear()
        var id=0

        for (i in 0 until orden.rellenos.size){

            for (x in 0 until apiArray.size){

                if(orden.rellenos.get(i).equals(apiArray.get(x).nombre)){
                    id=apiArray.get(x).id

                }

            }
            var pupusa1 = Pupusa(id,orden.rellenos[i],orden.maiz[i]!!,"Maiz")
            var pupusa2 = Pupusa(id,orden.rellenos[i],orden.arroz[i]!!,"Arroz")
            if(pupusa1.cantidad!=0){
                listaPupusas.add(pupusa1)
            }
            if(pupusa2.cantidad!=0){
                listaPupusas.add(pupusa2)
            }
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
                   /* val a = arrayListOf<Int>(1,2,3)
                    putExtra("ddd",a)*/
                    val rellenos= arrayListOf<String>()
                    rellenos.addAll(orden.rellenos)
                    putExtra("rellenos",rellenos)
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
        const val FRAGMENT_TAG4= "ORDEN HISTORIAL DETALLE"
    }
}
