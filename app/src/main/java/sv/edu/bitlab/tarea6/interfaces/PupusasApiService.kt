package sv.edu.bitlab.retrofit.interfaces

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import sv.edu.bitlab.tarea6.entity.*

interface PupusasApiService {

    @GET("rellenos")
    fun getRellenos(): Call<List<Relleno>>

    @GET("ordens")
    fun getOrdenes():Call<List<HistorialOrden>>

    @POST("ordens")
    fun submitOrden(@Body params: HistorialOrden):Call<HistorialOrden>

    @POST("ordens")
    fun submitOrden(@Body params: HistorialOrdenPOST):Call<HistorialOrdenPOST>
}