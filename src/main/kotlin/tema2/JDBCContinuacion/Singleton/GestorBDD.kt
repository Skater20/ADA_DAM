package tema2.JDBCContinuacion.Singleton

import java.sql.Connection
import java.sql.DriverManager

class GestorBDD private constructor(){

    companion object {
        @Volatile
        private var instance: GestorBDD? = null
        fun getInstance(): GestorBDD {
            if(instance==null){
                instance = GestorBDD()
            }
            return instance!!
        }
    }

    private val url: String = "jdbc:mysql://localhost/"
    private val bd: String = "bddeprueba"
    private val user: String = "root"
    private val pass: String = ""

    //La conexion también debe ser privada
    @Volatile
    private var conn: Connection? = null

    fun conectarBDD(){
        if(conn==null){
            println("[Conexion realizada]")
            conn = DriverManager.getConnection(url+bd, user, pass)
        } else {
            println("[Conexion ya existente]")
        }
    }

    fun desconexion(){
        if(conn!=null){
            conn!!.close()
            println("[Desconexión Realizada]")
        } else {
            println("[No existe conexion a Base de Datos]")
        }
    }
}