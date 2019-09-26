package sv.edu.bitlab.retrofit.interfaces

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import sv.edu.bitlab.tarea6.entity.Orden
import sv.edu.bitlab.tarea6.entity.RellenoWrapper

interface PupusasApiService {

    @GET("rellenos")
    fun getRellenos(): Call<RellenoWrapper>

    @POST("orden")
    fun submitOrden(@Body params: Orden):Call<Orden>
}