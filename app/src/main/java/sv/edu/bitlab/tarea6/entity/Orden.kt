package sv.edu.bitlab.tarea6.entity

import android.os.Parcel
import android.os.Parcelable
import android.util.Log
import java.io.Serializable
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

class Orden: Parcelable{


    constructor(){

        var counter= 0
        for (key in rellenos){

            this.maiz.put(counter,0)
            this.arroz.put(counter,0)
            counter++

        }

    }
    var precioUnidad = 0.5f
    var maiz= HashMap<Int,Int>()
    var arroz= HashMap<Int,Int>()

    var rellenos = mutableListOf<String>(
        /*"QUESO","FRIJOLES", "REVUELTAS","AJO", "CHICHARRON", "FRIJOL QUESO","CAMARON","LOROCO"*/
    )

    private var fecha:Calendar = Calendar.getInstance()

    override fun writeToParcel(dest: Parcel?, flags: Int) {
        dest!!.writeFloat(this.precioUnidad)

        for(item in 0 until rellenos.size){

            dest!!.writeInt(maiz[item]!!)
            dest!!.writeInt(arroz[item]!!)
            dest!!.writeString(rellenos[item]!!)

        }

        dest.writeString(this.getFecha())

    }

    constructor(parcel: Parcel) : this() {

        precioUnidad = parcel.readFloat()

        for(item in 0 until rellenos.size){
            maiz[item]= parcel.readInt()
            arroz[item]= parcel.readInt()
            rellenos[item]=parcel.readString()!!


        }
        // setFecha(parcel.readString()!!)


    }

    override fun describeContents(): Int {
        return 0
    }
    fun setHashMaiz(key:Int){

        this.maiz.put(key,0)
    }
    fun setHashArroz(key:Int){

        this.arroz.put(key,0)
    }

    fun setHashPupusas(relleno: String,key:Int){

        setHashMaiz(key)
        setHashArroz(key)
        rellenos.add(relleno)
    }



    fun getFecha(): String {
        val formatter = SimpleDateFormat(FORMATO_FECHA)
        return formatter.format(fecha.time)
    }

    fun setFecha(fecha: String) {
        val formatter = SimpleDateFormat(FORMATO_FECHA)
        this.fecha = Calendar.getInstance()
        this.fecha.time = formatter.parse(fecha)
    }



    companion object CREATOR : Parcelable.Creator<Orden> {


        const val FORMATO_FECHA = "dd-MM-yyyy" //09-09-2019


        override fun createFromParcel(parcel: Parcel): Orden {

            return Orden(parcel)
        }

        override fun newArray(size: Int): Array<Orden?> {
            return arrayOfNulls(size)
        }


        fun randomOrders() :ArrayList<Orden>{
            var lista = arrayListOf<Orden>()
            for(index in 0..10){
                lista.add(Orden())
            }
            return lista
        }
    }

}