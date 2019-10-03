package sv.edu.bitlab.tarea6.entity

data class OrdenPupusas(var relleno_id: String,var tipo:String, var total: Int,var created_at:String)
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


