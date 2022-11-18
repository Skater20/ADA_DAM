import tema2.JDBCContinuacion.Singleton.GestorBDD
import tema2.JDBCContinuacion.Singleton.Persona
import kotlin.concurrent.thread

fun main() {

    thread(start = true) {

        val conexion1: GestorBDD = GestorBDD.getInstance()

        conexion1.conectarBDD()

    }

    thread(start = true) {

        readln()
        val conexion2: GestorBDD = GestorBDD.getInstance()

        conexion2.conectarBDD()
    }






}