package sv.edu.bitlab.tarea6.ordenDetalleFragment

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import sv.edu.bitlab.tarea6.R
import sv.edu.bitlab.tarea6.entity.*

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



    private lateinit var listaPupusa: ArrayList<Pupusa>
    private var listener: OnFragmentInteractionListener? = null
    private var listView: RecyclerView? = null
    private var inflater: LayoutInflater? = null

     var  arroz:ArrayList<OrdenPupusas> = ArrayList()
     var maiz:ArrayList<OrdenPupusas> = ArrayList()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        this.inflater=inflater
        return inflater.inflate(R.layout.fragment_detalle_orden_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        listView = view.findViewById(R.id.ordersDetalleListView)
        listView!!.layoutManager = LinearLayoutManager(this.context!!)

       listView!!.adapter = OrdenDetalleAdapter(listaPupusa, this)


        listener?.onClickOrder(makeOrder(),makeOrder2())
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

  fun makeOrder():HistorialOrden{
      val id=13
      val status="recibida"
      val arrozFinal:ArrayList<OrdenPupusas> = ArrayList()
      arrozFinal.add(OrdenPupusas("1","maiz",5,"3-10-2019"))
      val maizFinal:ArrayList<OrdenPupusas> = ArrayList()
      maizFinal.add(OrdenPupusas("2","arroz",6,"3-10-2019"))
      val precioUnidad=0.5F
      val total= getTotal()

      val historialOrden=HistorialOrden(id,status,arrozFinal,maizFinal,precioUnidad,total)

      return historialOrden
  }
 fun makeOrder2():HistorialOrdenPOST{

     val id=13
     val status="recibida"
     val arrozFinal:ArrayList<OrdenPupusasPOST> = ArrayList()
     val maizFinal:ArrayList<OrdenPupusasPOST> = ArrayList()
     for (item in 0 until listaPupusa.size){
        if (listaPupusa.get(item).tipo_masa.equals("Arroz")){
            arrozFinal.add(OrdenPupusasPOST(1,"arroz",listaPupusa.get(item).id,listaPupusa.get(item).cantidad,"2019-10-3","2019-10-3",13))
        }

         if (listaPupusa.get(item).tipo_masa.equals("Maiz")){
             maizFinal.add(OrdenPupusasPOST(2,"maiz",listaPupusa.get(item).id,listaPupusa.get(item).cantidad,"2019-10-3","2019-10-3",13))

         }


     }

     val precioUnidad=0.5F
     val total= getTotal()

     val historialOrdenPOST=HistorialOrdenPOST(id,status,arrozFinal,maizFinal,precioUnidad,total)

     return historialOrdenPOST
 }

    fun getTotal():Float{
        var total=0.0F

        for (x in listaPupusa){

            total=total+x.cantidad*0.5F
            Log.d("total","${x.cantidad}")
        }

        return total
    }

    fun fillArrays(arrozFinal:ArrayList<OrdenPupusas>,maizFinal: ArrayList<OrdenPupusas>){

        for (item in listaPupusa){

            if (item.tipo_masa.equals("Maiz")){



            }else{


            }



        }
    }

    interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        fun onFragmentInteraction(uri: Uri)
        fun onClickOrder(orden:HistorialOrden,ordenPOST: HistorialOrdenPOST)
    }

    companion object {
        @JvmStatic
        fun newInstance(lista: ArrayList<Pupusa>) :OrdenDetalle{
            val fragment = OrdenDetalle()
            fragment.listaPupusa = lista
            return fragment
        }
    }
}
