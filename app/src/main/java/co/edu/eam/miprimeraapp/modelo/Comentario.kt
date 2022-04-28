package co.edu.eam.miprimeraapp.modelo

import java.util.*

class Comentario(var mensaje:String, var fecha:Date, var productoID:String, var usuarioID: String, var calificacion:Int) {
    override fun toString(): String {
        return "Comentario(mensaje='$mensaje', fecha=$fecha, producto=$productoID, usuario=$usuarioID)"
    }
}