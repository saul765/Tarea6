package sv.edu.bitlab.tarea6.entity

class Orden2 {

     var maiz= hashMapOf<String,Int>()
     var arroz= hashMapOf<String,Int>()
     var rellenos = ArrayList<String>()


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
}