package tema2.JDBCContinuacion.Singleton

class Persona private constructor(var nombre: String, var edad: Int) {

    //Intentar que se pueda acceder a esta clase de manera estática
    companion object {
        //Un atributo que contenga la instanciación de clase
        private var instance: Persona? = null
        //Una función para instanciar la clase en sí
        fun getInstance(nombre: String, edad: Int): Persona{

            if(instance == null){
                instance = Persona(nombre, edad)
            }
            return instance!!
        }
    }



}