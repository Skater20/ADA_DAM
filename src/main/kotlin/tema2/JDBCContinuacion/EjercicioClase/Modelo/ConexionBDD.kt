package tema2.JDBCContinuacion.EjercicioClase.Modelo

import SQLSentences
import Sentencias
import java.sql.*

class ConexionBDD private constructor() {
    /*
    Para implementar el patron creacional Singleton, en kotlin tenemos dos aproximaciones.
    "Las más sencillas"

    La primera, la más parecida a la aproximación en Java, sería declarar el constructor
    por defecto de la clase como privado y dentro de la clase declarar un companion object
    que se encargara de inicializar la clase

    La otra aproximación, consistiría aprovecharnos que Kotlin tiene una manera de aplicar
    este patrón creacional de forma nativa.
    Para ello, simplemente deberíamos declarar la clase... como un objeto. Sólo eso.
    De esta manera, este objeto se crea una única vez, y todos los intentos
    de creación de un objeto nuevo, serían en realidad llamadas al mismo objeto una
    y otra vez.


    https://dev4phones.wordpress.com/2020/05/01/como-crear-una-clase-singleton-en-kotlin-para-android/
     */
    //1a Aproximación
    companion object{
        @Volatile
        private var instance: ConexionBDD? = null

        fun getInstance() : ConexionBDD{
            if(instance == null){
                println("[Instancia de clase no existente, se procede a crearla]")
                instance = ConexionBDD()
            } else {
                println("[Instancia ya existente]")
            }
            return instance!!
        }
    }

    //Declaración de variables globales PRIVADAS
    private val url: String = "jdbc:mysql://localhost/"
    private val bd: String = "bddeprueba"
    private val user: String = "root"
    private val pass: String = ""

    //La conexion también debe ser privada
    private var conn: Connection? = null

    //Un método para realizar la conexión a la BDD
    fun conectarBDD() {
        //Si la conexión no está hecha, se hace.
        if (conn == null) {
            Class.forName("com.mysql.cj.jdbc.Driver")
            conn = DriverManager.getConnection(url + bd, user, pass)
            println("[Conexion realizada correctamente]")
        } else {
            println("[Conexion ya existente]")
        }
    }

    //Un método para desconectar
    fun desconexion() {
        //Si existe una conexión, procedemos a cerrarla
        if (!conn?.isClosed!!) {
            conn!!.close()
            println("[Desconectado de la Base de Datos]")
        } else {
            println("[Conexion inexistente]")
        }
    }

    //Un método para mostrar todos los resultados de la tabla
    fun selectAll() {
        if (conn != null) {
            val st: Statement = conn!!.createStatement()
            val rs1: ResultSet = st.executeQuery(Sentencias.selectAll)
            while (rs1.next()) {
                println(rs1.getString(1))
                println(rs1.getString(2))
                println(rs1.getString(3))
                println(rs1.getString(4))
            }
        } else {
            println("[Base de Datos no conectada]")
        }

    }

    //Un método para mostrar todos los resultados de la tabla
    fun checkUser(dni: String): Boolean {
        if (conn != null) {
            val ps: PreparedStatement = conn!!.prepareStatement(SQLSentences.selectUser)
            ps.setString(1, dni)
            val rs1: ResultSet = ps.executeQuery()
            while (rs1.next()) {
                return (rs1.getString(1).isNotBlank())
            }
        } else {
            println("[Base de Datos no conectada]")
        }
        return false
    }


}