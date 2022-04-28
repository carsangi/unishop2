package co.edu.eam.miprimeraapp.actividades

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.view.isGone
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import co.edu.eam.miprimeraapp.adapter.ProductoAdapter
import co.edu.eam.miprimeraapp.data.Carrito
import co.edu.eam.miprimeraapp.data.Productos
import co.edu.eam.miprimeraapp.databinding.ActivityCarritoBinding
import co.edu.eam.miprimeraapp.modelo.Producto

class CarritoActivity : AppCompatActivity() {

    lateinit var binding:ActivityCarritoBinding
    var listaProductos:ArrayList<Producto> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCarritoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        listaProductos = Carrito.obtener()

        Log.v("CARRITO", listaProductos.toString())

        val adapter = ProductoAdapter(listaProductos)
        binding.listaCarrito.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.listaCarrito.adapter = adapter

    }
}