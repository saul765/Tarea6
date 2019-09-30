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
    /*var maiz = hashMapOf(
        QUESO to 0,
        FRIJOLES to 0,
        REVUELTAS to 0,
        AJO to 0 ,
        CHICHARRON to 0 ,
        FRIJOL_QUESO to 0
    )
    var arroz = hashMapOf(
        QUESO to 0,
        FRIJOLES to 0,
        REVUELTAS to 0,
        AJO to 0 ,
        CHICHARRON to 0 ,
        FRIJOL_QUESO to 0
    )*/

    var rellenos = mutableListOf<String>(
        "QUESO","FRIJOLES", "REVUELTAS","AJO", "CHICHARRON", "FRIJOL QUESO","CAMARON","LOROCO"
    )

    private var fecha:Calendar = Calendar.getInstance()

    override fun writeToParcel(dest: Parcel?, flags: Int) {
        dest!!.writeFloat(this.precioUnidad)

        for(item in 0 until rellenos.size){

            dest!!.writeInt(maiz[item]!!)
            dest!!.writeInt(arroz[item]!!)
            dest!!.writeString(rellenos[item]!!)


        }
        Log.d("RELLENOS PARCEL","$rellenos" )


        /*  dest.writeInt(maiz[QUESO]!!)
          dest.writeInt(maiz[FRIJOLES]!!)
          dest.writeInt(maiz[REVUELTAS]!!)
          dest.writeInt(maiz[AJO]!!)
          dest.writeInt(maiz[CHICHARRON]!!)
          dest.writeInt(maiz[FRIJOL_QUESO]!!)

          dest.writeInt(arroz[QUESO]!!)
          dest.writeInt(arroz[FRIJOLES]!!)
          dest.writeInt(arroz[REVUELTAS]!!)
          dest.writeInt(arroz[AJO]!!)
          dest.writeInt(arroz[CHICHARRON]!!)
          dest.writeInt(arroz[FRIJOL_QUESO]!!)*/
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
        /*maiz[QUESO] = parcel.readInt()
        maiz[FRIJOLES] = parcel.readInt()
        maiz[REVUELTAS] = parcel.readInt()
        maiz[AJO] = parcel.readInt()
        maiz[CHICHARRON] = parcel.readInt()
        maiz[FRIJOL_QUESO] = parcel.readInt()

        arroz[QUESO] = parcel.readInt()
        arroz[FRIJOLES] = parcel.readInt()
        arroz[REVUELTAS] = parcel.readInt()
        arroz[AJO] = parcel.readInt()
        arroz[CHICHARRON] = parcel.readInt()
        arroz[FRIJOL_QUESO] = parcel.readInt()*/

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

    /*fun reParcel(newItems:Int){

        for(item in 0 until rellenos.size){
            Parcel.obtain().writeInt(maiz[item]!!)
            Parcel.obtain().writeInt(arroz[item]!!)


        }
        for(item in 0 until rellenos.size){
            maiz[item]= Parcel.obtain().readInt()
            arroz[item]= Parcel.obtain().readInt()


        }

    }*/


    fun getTotal(): Float {
        val totalMaiz = maiz.map { entry ->
            entry.value
        }.reduce { total, counter -> total+counter }

        val totalArroz = arroz.map { entry ->
            entry.value
        }.reduce { total, counter -> total+counter }

        return (totalArroz * precioUnidad) + (totalMaiz * precioUnidad)
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

        const val MAIZ = "MAIZ"
        const val ARROZ = "ARROZ"
        const val FORMATO_FECHA = "dd-MM-yyyy" //09-09-2019

        const val QUESO = 0
        const val FRIJOLES = 1
        const val REVUELTAS = 2
        const val AJO = 3
        const val CHICHARRON = 4
        const val FRIJOL_QUESO = 5

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