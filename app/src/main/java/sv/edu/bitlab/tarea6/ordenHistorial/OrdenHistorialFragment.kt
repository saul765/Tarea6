package sv.edu.bitlab.tarea6.ordenHistorial

import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import sv.edu.bitlab.tarea6.R
import sv.edu.bitlab.tarea6.entity.Orden
import sv.edu.bitlab.tarea6.mainActivity.OrdenFragment
import sv.edu.bitlab.tarea6.mainActivity.recyclerView.MyOrdenRecyclerViewAdapter
import sv.edu.bitlab.tarea6.ordenHistorial.recyclerView.MyordenHistorialRecyclerViewAdapter
import sv.edu.bitlab.tarea6.ordenHistorial.recyclerView.OrdenHistorialViewHolder

/**
 * A fragment representing a list of Items.
 * Activities containing this fragment MUST implement the
 * [OrdenHistorialFragment.OnListFragmentInteractionListener] interface.
 */
class OrdenHistorialFragment : Fragment(),OrdenHistorialViewHolder.OrdenHistorialItemListener {
    override fun onOrdenarDenuevoClick(orden: Orden) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onItemClick(position: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onTextInput(input: String, position: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    private var listener: OrdenHistorialFragment.OnListFragmentInteractionListener? = null

    //private var listener: OrdenFragment.OrdenFragmentInteractionListener? = null
    private var listView: RecyclerView? = null
    private var inflater: LayoutInflater? = null

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
        listView!!.adapter = MyordenHistorialRecyclerViewAdapter(this)
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
