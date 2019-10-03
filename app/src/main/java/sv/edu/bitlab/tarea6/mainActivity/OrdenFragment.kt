package sv.edu.bitlab.tarea6.mainActivity

import android.app.ProgressDialog
import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.fragment_orden.*
import kotlinx.android.synthetic.main.fragment_orden.view.*
import kotlinx.android.synthetic.main.fragment_orden_detalle.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import sv.edu.bitlab.tarea6.R

import sv.edu.bitlab.tarea6.entity.Orden
import sv.edu.bitlab.tarea6.entity.Orden2
import sv.edu.bitlab.tarea6.entity.Relleno
import sv.edu.bitlab.tarea6.mainActivity.recyclerView.MyOrdenRecyclerViewAdapter
import sv.edu.bitlab.tarea6.mainActivity.recyclerView.OrdenItemViewHolder
import sv.edu.bitlab.tarea6.startservice.ApiService

/**
 * A fragment representing a list of Items.
 * Activities containing this fragment MUST implement the
 * [OrdenFragment.OnListFragmentInteractionListener] interface.
 */
private const val ORDERS_LIST = "ORDERS_LIST"
private const val ORDER= "ORDER"
class OrdenFragment : Fragment() ,OrdenItemViewHolder.OrdenItemListener{
    override fun onOrdenarDenuevoClick(orden: Orden) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onItemClick(position: Int) {
        Log.d("HISTORY_FRGAMENT", "Click en item $position")
    }

    override fun onTextInput(input: String, position: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    // TODO: Customize parameters


    private lateinit var order:Orden
    private var listener: OrdenFragmentInteractionListener? = null
    private var listView: RecyclerView? = null
    private var inflater: LayoutInflater? = null
    private var loadingContainer:View?=null
    private var orden2=Orden2()
    private var progressBar:ProgressDialog?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


//        orderLists = arguments!!.getParcelableArrayList<Orden>(ORDERS_LIST)!!
        order=arguments!!.getParcelable<Orden>(ORDER)!!

        arguments?.let {
            //orderLists = arguments!!.getParcelableArrayList<Orden>(ORDERS_LIST)!!
            order=arguments!!.getParcelable<Orden>(ORDER)!!
        }


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        this.inflater = inflater

        return inflater.inflate(R.layout.fragment_orden_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        listView = view.findViewById(R.id.ordersListView)

        listView!!.layoutManager = LinearLayoutManager(this.context!!)
        listView!!.adapter = MyOrdenRecyclerViewAdapter(order, orden2,this)


        val order2= Orden2()
       val orden1=Orden()
        progressBar= ProgressDialog(context)
        progressBar!!.setTitle("Fetching data")
        progressBar!!.setMessage("Getting Data from Server Please wait")

        progressBar!!.show()
        //activity!!.loading_container.visibility=View.VISIBLE
        ApiService.create().getRellenos().enqueue(object : Callback<List<Relleno>> {
            override fun onResponse(
                call: Call<List<Relleno>>,
                response: Response<List<Relleno>>
            ) {
               progressBar!!.hide()
               // activity!!.loading_container.visibility=View.GONE
                var array= response.body()
                parseData(array!!,order2,order)
              val adapter = listView!!.adapter as MyOrdenRecyclerViewAdapter
               // adapter.orden2=order2
               // adapter.orden=orden1

/*
                Log.d("MUTABLE LIST ORDENN 1","${adapter.orden.rellenos}")
                Log.d("MUTABLE PARCE","${order.rellenos}")*/
                adapter.notifyDataSetChanged()



            }

            override fun onFailure(call: Call<List<Relleno>>, t: Throwable) {
                Log.d("ERROR","NO SE PUEDE MOSTRAR EL JSON")
                progressBar!!.hide()
                //activity!!.loadingContainer.visibility = View.GONE
                AlertDialog.Builder(view.context)
                    .setTitle("ERROR")
                    .setMessage("Error con el servidor lo sentimos")
                    .setNeutralButton("ok", null)
                    .create()
                    .show()
            }

        })


    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OrdenFragmentInteractionListener) {
            listener = context
        } else {
            throw RuntimeException(context.toString() + " must implement OrdenFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }


    interface OrdenFragmentInteractionListener {
        // TODO: Update argument type and name
        fun onFragmentInteraction(uri: Uri)
        fun returnOrden(orden:Orden)
    }

    fun onButtonPressed(uri: Uri) {
        listener?.onFragmentInteraction(uri)
    }

    fun parseData(list: List<Relleno>,orden2: Orden2,orden: Orden){
        var counter=orden.arroz.size


        for (item in list){

            orden2.setHashPupusas(item.nombre)
            orden.setHashPupusas(item.nombre,counter)
            counter++

        }


       // Log.d("HASHMAPS","${orden2.maiz} ${orden2.arroz}")
       // Log.d("HASHMAPS orden 1","${orden.maiz} ${orden.arroz}")
        //Log.d("MUTABLE LIST","${orden.rellenos}")


    }

    companion object {


        // TODO: Customize parameter initialization
        @JvmStatic
        fun newInstance(orden: Orden) : OrdenFragment {

            val params = Bundle()

            params.putParcelable(ORDER,orden)
            val fragment = OrdenFragment()
            fragment.arguments = params
            return fragment
        }
    }
}
