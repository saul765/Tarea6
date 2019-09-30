package sv.edu.bitlab.tarea6.entity

import android.os.Parcel
import android.os.Parcelable

class Orden2() :Parcelable{



    override fun writeToParcel(p0: Parcel?, p1: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun describeContents(): Int {
        return 0
    }

    var maiz= hashMapOf<String,Int>()
     var arroz= hashMapOf<String,Int>()
     var rellenos = ArrayList<String>()

    constructor(parcel: Parcel) : this() {

    }


    fun setHashMaiz(key:String){

        this.maiz.put(key,0)
    }
    fun setHashArroz(key:String){

        this.arroz.put(key,0)
    }

    fun setHashPupusas(key: String){

        setHashMaiz(key)
        setHashArroz(key)
        rellenos.add(key)
    }

    companion object CREATOR : Parcelable.Creator<Orden2> {
        override fun createFromParcel(parcel: Parcel): Orden2 {
            return Orden2(parcel)
        }

        override fun newArray(size: Int): Array<Orden2?> {
            return arrayOfNulls(size)
        }
    }
}