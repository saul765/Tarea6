package sv.edu.bitlab.tarea6.mainActivity

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
import sv.edu.bitlab.tarea6.R

import sv.edu.bitlab.tarea6.entity.Orden
import sv.edu.bitlab.tarea6.mainActivity.recyclerView.MyOrdenRecyclerViewAdapter
import sv.edu.bitlab.tarea6.mainActivity.recyclerView.OrdenItemViewHolder

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

    private var orderLists = arrayListOf<Orden>()
    private lateinit var order:Orden
    private var listener: OrdenFragmentInteractionListener? = null
    private var listView: RecyclerView? = null
    private var inflater: LayoutInflater? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        orderLists = arguments!!.getParcelableArrayList<Orden>(ORDERS_LIST)!!
        order=arguments!!.getParcelable<Orden>(ORDER)!!

        arguments?.let {
            orderLists = arguments!!.getParcelableArrayList<Orden>(ORDERS_LIST)!!
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
        listView!!.layoutManager = LinearLayoutManager(this.context)

        listView!!.adapter = MyOrdenRecyclerViewAdapter(order, this)
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
    interface OrdenFragmentInteractionListener {
        // TODO: Update argument type and name
        fun onFragmentInteraction(uri: Uri)
    }

    fun onButtonPressed(uri: Uri) {
        listener?.onFragmentInteraction(uri)
    }

    companion object {

        // TODO: Customize parameter argument names
        const val ARG_COLUMN_COUNT = "column-count"

        // TODO: Customize parameter initialization
        @JvmStatic
        fun newInstance(orderList: ArrayList<Orden>,orden: Orden) : OrdenFragment {
            val params = Bundle()
            params.putParcelableArrayList(ORDERS_LIST, orderList)
            params.putParcelable(ORDER,orden)
            val fragment = OrdenFragment()
            fragment.arguments = params
            return fragment
        }
    }
}
