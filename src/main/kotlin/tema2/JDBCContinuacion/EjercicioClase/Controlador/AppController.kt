import tema2.JDBCContinuacion.EjercicioClase.Modelo.ConexionBDD
import tema2.JDBCContinuacion.EjercicioClase.Vista.AppVista

class AppController(private val vista: AppVista) {

    fun onLogin(dni: String) {
        val modelo: ConexionBDD = ConexionBDD.getInstance()
        modelo.conectarBDD()
        val loginCode: Boolean = modelo.checkUser(dni)
        if(loginCode) vista.loginSuccess("Bienvenid@") else vista.loginError("Usuario no reconocido")
        modelo.desconexion()
    }

}