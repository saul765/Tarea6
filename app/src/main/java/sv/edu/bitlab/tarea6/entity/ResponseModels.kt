package sv.edu.bitlab.tarea6.entity

import android.os.Parcel
import android.os.Parcelable

data class OrdenPupusas(var relleno_id: String,var tipo:String, var total: Int,var created_at:String):Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readInt(),
        parcel.readString()!!
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(relleno_id)
        parcel.writeString(tipo)
        parcel.writeInt(total)
        parcel.writeString(created_at)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<OrdenPupusas> {
        override fun createFromParcel(parcel: Parcel): OrdenPupusas {
            return OrdenPupusas(parcel)
        }

        override fun newArray(size: Int): Array<OrdenPupusas?> {
            return arrayOfNulls(size)
        }
    }
}

data class OrdenPupusasPOST(var id:Int,var tipo: String,var relleno_id:Int,var total:Int,var created_at: String,var updated_at:String,var orden_id:Int)
data class HistorialOrden(var id: Int,
                 var status:String,
                 var arroz:List<OrdenPupusas>,
                 var maiz: List<OrdenPupusas>,
                 var precio_unidad: Float,
                 var total: Float)

data class HistorialOrdenPOST(var id: Int,
                              var status:String,
                              var arroz:List<OrdenPupusasPOST>,
                              var maiz: List<OrdenPupusasPOST>,
                              var precio_unidad: Float,
                              var total: Float)


