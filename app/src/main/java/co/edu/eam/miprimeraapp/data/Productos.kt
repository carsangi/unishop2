package co.edu.eam.miprimeraapp.data

import android.util.Log
import co.edu.eam.miprimeraapp.modelo.Categoria
import co.edu.eam.miprimeraapp.modelo.Comentario
import co.edu.eam.miprimeraapp.modelo.Producto

object Productos {

    private var listaProductos:ArrayList<Producto> = ArrayList()

    init{

        var categorias:ArrayList<Int> = ArrayList()
        categorias.add(2)

        val p1 = Producto("123", 40000f, "Memoria USB 8 GB", "Une espectacular memoria usb marca gato", ArrayList(), categorias)
        p1.descuento = 0.5f
        listaProductos.add(p1)

        categorias = ArrayList()
        categorias.add(4)

        val p2 = Producto("126", 90000f, "Camiseta Levis", "Camiseta colección 2022", ArrayList(), categorias)
        listaProductos.add(p2)

        categorias = ArrayList()
        categorias.add(2)

        val p3 = Producto("125", 160000f, "Nintendo Switch", "Nintendo 2021", ArrayList(), categorias)
        listaProductos.add(p3)

        categorias = ArrayList()
        categorias.add(2)

        val p4 = Producto("124", 90000f, "Computador ASUS", "Computador con xyz características", ArrayList(), categorias)
        listaProductos.add(p4)

        categorias = ArrayList()
        categorias.add(5)

        val p5 = Producto("127", 160000f, "Licuadora Oster 5 tiempos", "Licuadora 2022", ArrayList(), categorias)
        listaProductos.add(p5)

    }

    fun getLista():ArrayList<Producto>{
        return listaProductos
    }

    fun agregar(producto: Producto){
        listaProductos.add(producto)
    }

    fun obtener(productoID:String):Producto?{
        return listaProductos.find{ p -> p.codigo == productoID }
    }

    fun eliminar(codigo:String){
        listaProductos.removeIf{ it.codigo == codigo }
    }

    fun buscar(nombre:String):ArrayList<Producto>{
        return listaProductos.filter { p -> p.nombre!!.lowercase().contains(nombre.lowercase()) }.toCollection(ArrayList())
    }

    fun listar(categoria: Int): ArrayList<Producto>{
        Log.v("LISTA", listaProductos.toString())
        return listaProductos.filter { p -> p.categorias.contains(categoria) }.toCollection(ArrayList())
    }

    fun editar(producto: Producto){

    }

    fun listarOfertas():ArrayList<Producto>{
        return listaProductos.filter { p -> p.descuento > 0 }.toCollection(ArrayList())
    }
}