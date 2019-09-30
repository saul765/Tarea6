package sv.edu.bitlab.tarea6.entity

import android.os.Parcel
import android.os.Parcelable
import android.support.v4.app.INotificationSideChannel
import android.util.Log
import kotlinx.serialization.Serializable


@Serializable
class OrderDetail {
    var precioUnidad = 0.5f
    var maiz= hashMapOf<Int,Int>()
    var arroz= hashMapOf<Int,Int>()
    var rellenos = mutableListOf<String>()



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
    companion object {
        private const val serialVersionUID = 1L
    }


}