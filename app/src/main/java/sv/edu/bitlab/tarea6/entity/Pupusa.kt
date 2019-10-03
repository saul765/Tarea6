package sv.edu.bitlab.tarea6.entity

import android.os.Parcel
import android.os.Parcelable

data class Pupusa(var id:Int,var relleno: String?, var cantidad:Int, var tipo_masa: String?):Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString(),
        parcel.readInt(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(relleno)
        parcel.writeInt(cantidad)
        parcel.writeString(tipo_masa)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Pupusa> {
        override fun createFromParcel(parcel: Parcel): Pupusa {
            return Pupusa(parcel)
        }

        override fun newArray(size: Int): Array<Pupusa?> {
            return arrayOfNulls(size)
        }
    }
}
