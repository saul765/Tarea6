package sv.edu.bitlab.tarea6.entity

import android.os.Parcel
import android.os.Parcelable
import java.io.Serializable
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class Orden() : Parcelable{
  var precioUnidad = 0.5f
  var maiz = hashMapOf(
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
  )
  private var fecha:Calendar = Calendar.getInstance()

  override fun writeToParcel(dest: Parcel?, flags: Int) {
    dest!!.writeFloat(this.precioUnidad)
    dest.writeInt(maiz[QUESO]!!)
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
    dest.writeInt(arroz[FRIJOL_QUESO]!!)

    dest.writeString(this.getFecha())
  }

  constructor(parcel: Parcel) : this() {
    precioUnidad = parcel.readFloat()

    maiz[QUESO] = parcel.readInt()
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
    arroz[FRIJOL_QUESO] = parcel.readInt()
    setFecha(parcel.readString()!!)
  }

  override fun describeContents(): Int {
    return 0
  }

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