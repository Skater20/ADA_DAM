package tema2.JDBCContinuacion.EjercicioClase.Vista

//Esta clase correspondería a los archivos .xml de un proyecto Android
//Como por ejemplo el MainActivity.xml
class AppVista {

    fun mainMenu(): String{
        println("Bienvenido a la aplicación. Seleccione una opción")
        println("1. Login")
        println("0. Salir")
        val opc: String = readln();
        return opc;
    }

    fun login(): String{
        println("user: (dni del usuario)")
        var opc: String = readln()
        return opc.trim().lowercase()
    }

    fun exit(){
        println("Hasta pronto")
    }

    fun loginError(msg: String) {
        println("****ERROR****")
        println(msg)
        println("*************")
    }

    fun loginSuccess(msg: String) {
        println("*************")
        println(msg)
        println("*************")
    }

}