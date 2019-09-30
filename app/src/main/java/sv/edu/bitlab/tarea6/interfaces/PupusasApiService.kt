package sv.edu.bitlab.retrofit.interfaces

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import sv.edu.bitlab.tarea6.entity.HistorialOrden
import sv.edu.bitlab.tarea6.entity.Orden
import sv.edu.bitlab.tarea6.entity.Relleno
import sv.edu.bitlab.tarea6.entity.RellenoWrapper

interface PupusasApiService {

    @GET("rellenos")
    fun getRellenos(): Call<List<Relleno>>

    @GET("ordens")
    fun getOrdenes():Call<List<HistorialOrden>>

    @POST("orden")
    fun submitOrden(@Body params: Orden):Call<Orden>
}