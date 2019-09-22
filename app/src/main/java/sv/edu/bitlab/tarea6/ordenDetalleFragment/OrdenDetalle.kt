package sv.edu.bitlab.tarea6.ordenDetalleFragment

import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import sv.edu.bitlab.tarea6.R
import sv.edu.bitlab.tarea6.entity.Orden

import sv.edu.bitlab.tarea6.mainActivity.OrdenFragment
import sv.edu.bitlab.tarea6.mainActivity.recyclerView.MyOrdenRecyclerViewAdapter
import sv.edu.bitlab.tarea6.ordenDetalleFragment.recyclerView.OrdenDetalleAdapter
import sv.edu.bitlab.tarea6.ordenDetalleFragment.recyclerView.OrdenDetalleViewHolder

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

private const val ORDER_DETALLE = "ORDER_DETALLE"

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [OrdenDetalle.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [OrdenDetalle.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class OrdenDetalle : Fragment(),OrdenDetalleViewHolder.OrdenItemListener {
    override fun onOrdenarDenuevoClick(orden: Orden) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onItemClick(position: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onTextInput(input: String, position: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    // TODO: Rename and change types of parameters


    private lateinit var order: Orden
    private var listener: OnFragmentInteractionListener? = null
    private var listView: RecyclerView? = null
    private var inflater: LayoutInflater? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        order=arguments!!.getParcelable<Orden>(ORDER_DETALLE)!!

        arguments?.let {

            order=arguments!!.getParcelable<Orden>(ORDER_DETALLE)!!
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
       // return inflater.inflate(R.layout.fragment_orden_detalle2, container, false)
        this.inflater=inflater
        return inflater.inflate(R.layout.fragment_detalle_orden_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        listView = view.findViewById(R.id.ordersDetalleListView)
        listView!!.layoutManager = LinearLayoutManager(this.context)

       listView!!.adapter = OrdenDetalleAdapter(order, this)
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
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment OrdenDetalle.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(orden: Orden) :OrdenDetalle{
            val params = Bundle()

            params.putParcelable(ORDER_DETALLE, orden)
            val fragment = OrdenDetalle()
            fragment.arguments = params
            return fragment
        }
    }
}
