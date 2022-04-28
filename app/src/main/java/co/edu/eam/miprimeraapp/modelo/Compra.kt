package co.edu.eam.miprimeraapp.modelo

import java.util.*
import kotlin.collections.ArrayList

class Compra(var productosID:ArrayList<String>, var usuarioID:String, var precio:ArrayList<Float>, var cantidad:ArrayList<Int>, var fecha:Date) {

    override fun toString(): String {
        return "Compra(productosID=$productosID, usuarioID='$usuarioID', precio=$precio, cantidad=$cantidad, fecha=$fecha)"
    }
}