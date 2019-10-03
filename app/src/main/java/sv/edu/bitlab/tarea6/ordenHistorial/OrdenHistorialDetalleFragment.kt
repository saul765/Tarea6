package sv.edu.bitlab.tarea6.ordenHistorial

import android.content.Context
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.RequiresApi
import kotlinx.android.synthetic.main.fragment_orden_historial_detalle.*
import kotlinx.android.synthetic.main.fragment_orden_historial_detalle.view.*
import kotlinx.android.synthetic.main.list_row_historial.*
import kotlinx.android.synthetic.main.list_row_historial.view.*

import sv.edu.bitlab.tarea6.R
import sv.edu.bitlab.tarea6.entity.HistorialOrden
import sv.edu.bitlab.tarea6.entity.Orden
import sv.edu.bitlab.tarea6.entity.Relleno

import sv.edu.bitlab.tarea6.mainActivity.OrdenFragment
import java.time.LocalDate
import java.time.format.DateTimeFormatter

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [OrdenHistorialDetalleFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [OrdenHistorialDetalleFragment.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class OrdenHistorialDetalleFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private var listener: OnFragmentInteractionListener? = null
    /*private lateinit var historial:ArrayList<HistorialOrden>
    private lateinit var rellenos:ArrayList<String>*/
    private lateinit var historial:HistorialOrden
    private lateinit var relleno_maiz: String
    private lateinit var relleno_arroz: String


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d("rellenosMAIZ","$relleno_maiz")
        Log.d("rellenosARROZ","$relleno_arroz")
        Log.d("rellenosHISTO","$historial")
        val view=inflater.inflate(R.layout.fragment_orden_historial_detalle, container, false)

        view.id_detalle.text="ORDER ID: ${historial.id}"
        view.status_detalle.text="STATUS: ${historial.status}"
        view.precio_detalle.text="PRECIO UNIDAD: $${historial.precio_unidad}"

        if (historial.arroz.size!=0){

            val apidate=historial.arroz?.get(0).created_at
            val date = LocalDate.parse(apidate?.dropLast(14))
            val formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy")
            val formattedDate = date?.format(formatter)

            view.fecha_detalle.text="FECHA: ${formattedDate}"

            val cantidad_arroz=historial.arroz.get(0).total
            view.arroz_detalle.text="x $cantidad_arroz $relleno_arroz Arroz"
        }

        if (historial.maiz.size!=0){
            val cantidad_maiz=historial.maiz.get(0).total
            view.maiz_detalle.text="x $cantidad_maiz $relleno_maiz Maiz"
        }




       view.total_detalle.text="TOTAL $${historial.total} USD"

        //status_detalle.text="STATUS ${historial.status}"
        return view
    }

    // TODO: Rename method, update argument and hook method into UI event
    fun onButtonPressed(uri: Uri) {
        listener?.onFragmentInteraction(uri)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnFragmentInteractionListener) {
            listener = context
        } else {
            throw RuntimeException(context.toString() + " must implement OnFragmentInteractionListener")
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
     * See the Android Training lesson [Communicating with Other Fragments]
     * (http://developer.android.com/training/basics/fragments/communicating.html)
     * for more information.
     */
    interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        fun onFragmentInteraction(uri: Uri)
    }

    companion object {


        // TODO: Customize parameter initialization
        @JvmStatic
        /*fun newInstance(historial:ArrayList<HistorialOrden>, rellenos:ArrayList<String>) : OrdenHistorialDetalleFragment {*/
        fun newInstance(historial:HistorialOrden, relleno_maiz:String,relleno_arroz: String) : OrdenHistorialDetalleFragment {
            val params = Bundle()

            val fragment = OrdenHistorialDetalleFragment()
            fragment.historial=historial
            fragment.relleno_maiz=relleno_maiz
            fragment.relleno_arroz=relleno_arroz
            return fragment
        }
    }
}
