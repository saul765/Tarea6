package sv.edu.bitlab.tarea6.ordenHistorial

import android.app.ProgressDialog
import android.content.Context
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.list_row_historial.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import sv.edu.bitlab.tarea6.R
import sv.edu.bitlab.tarea6.entity.HistorialOrden
import sv.edu.bitlab.tarea6.entity.Orden
import sv.edu.bitlab.tarea6.entity.Relleno
import sv.edu.bitlab.tarea6.mainActivity.OrdenFragment
import sv.edu.bitlab.tarea6.mainActivity.recyclerView.MyOrdenRecyclerViewAdapter
import sv.edu.bitlab.tarea6.ordenHistorial.recyclerView.MyordenHistorialRecyclerViewAdapter
import sv.edu.bitlab.tarea6.ordenHistorial.recyclerView.OrdenHistorialViewHolder
import sv.edu.bitlab.tarea6.startservice.ApiService
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.format.DateTimeFormatter

/**
 * A fragment representing a list of Items.
 * Activities containing this fragment MUST implement the
 * [OrdenHistorialFragment.OnListFragmentInteractionListener] interface.
 */
class OrdenHistorialFragment : Fragment(),OrdenHistorialViewHolder.OrdenHistorialItemListener {


    @RequiresApi(Build.VERSION_CODES.O)
    override fun onViewDetalleOrden(id: TextView, fecha: TextView, total: TextView,status:TextView, position: Int) {
        id.text="Order ID: ${historial.get(position).id}"
        Log.d("POSITITON","THE POSITION IS $position")
        if (historial.get(position).maiz.size!=0) {

            val apidate = historial.get(position).maiz.get(0).created_at
            Log.d("DATE","$apidate")
            val date = LocalDate.parse(apidate.dropLast(14))
            val formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy")
            val formattedDate = date.format(formatter)
            fecha.text="Date: $formattedDate "
        }else{

            fecha.text="Date: "
        }


        status.text="Status: ${historial.get(position).status}"

        total.text="Total: $${historial.get(position).total} USD"
    }

    override fun onItemClickDetalle(btn_detalle: Button, position: Int) {

        listener!!.changetoFragmentOrden(historial,position)
        Log.d("Button","la position es $position")
    }





    override fun onTextInput(input: String, position: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    private var listener: OrdenHistorialFragment.OnListFragmentInteractionListener? = null

    private var listView: RecyclerView? = null
    private var inflater: LayoutInflater? = null
    private var progressBar:ProgressDialog?=null
    val historial=ArrayList<HistorialOrden>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        this.inflater = inflater
        val view = inflater.inflate(R.layout.fragment_ordenhistorial_list, container, false)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        listView=view.findViewById(R.id.fragment_historial_list)
        listView!!.layoutManager = LinearLayoutManager(this.context!!)
        listView!!.adapter = MyordenHistorialRecyclerViewAdapter(historial,this)




        if (historial.isEmpty()) {

            progressBar= ProgressDialog(context)
            progressBar!!.setTitle("Fetching data")
            progressBar!!.setMessage("Getting Data from Server Please wait")

            progressBar!!.show()
            ApiService.create().getOrdenes().enqueue(object : Callback<List<HistorialOrden>> {
                override fun onResponse(
                    call: Call<List<HistorialOrden>>,
                    response: Response<List<HistorialOrden>>
                ) {
                    progressBar!!.hide()
                    var history_array = response.body()
                    Log.d("HistoryOrder", "${history_array}")
                    val adapter = listView!!.adapter as MyordenHistorialRecyclerViewAdapter
                    historial.addAll(history_array!!)
                    //  adapter.historial=ArrayList<HistorialOrden>(history_array!!)
                    adapter.notifyDataSetChanged()


                }

                override fun onFailure(call: Call<List<HistorialOrden>>, t: Throwable) {
                    Log.d("ERROR", "NO SE PUEDE MOSTRAR EL JSON")
                    progressBar!!.hide()
                    AlertDialog.Builder(view.context)
                        .setTitle("ERROR")
                        .setMessage("Error con el servidor lo sentimos")
                        .setNeutralButton("ok", null)
                        .create()
                        .show()
                }

            })
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnListFragmentInteractionListener) {
            listener = context
        } else {
            throw RuntimeException(context.toString() + " must implement OnListFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     *
     *
     * See the Android Training lesson
     * [Communicating with Other Fragments](http://developer.android.com/training/basics/fragments/communicating.html)
     * for more information.
     */
    interface OnListFragmentInteractionListener {
        // TODO: Update argument type and name
        fun onListFragmentInteraction(uri: Uri)
        fun changetoFragmentOrden(historialOrden: ArrayList<HistorialOrden>,position: Int)
    }

    companion object {



        // TODO: Customize parameter initialization
        @JvmStatic
        fun newInstance() : OrdenHistorialFragment {
            val params = Bundle()

            val fragment = OrdenHistorialFragment()
            fragment.arguments = params
            return fragment
        }
    }
}
