package sv.edu.bitlab.tarea6.entity

data class OrdenPupusas(var relleno_id: String,var tipo:String, var total: Int,var created_at:String)
data class HistorialOrden(var id: Int,
                 var status:String,
                 var arroz:List<OrdenPupusas>,
                 var maiz: List<OrdenPupusas>,
                 var precio_unidad: Float,
                 var total: Float)