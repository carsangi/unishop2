package co.edu.eam.miprimeraapp.actividades

import android.graphics.Canvas
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.util.TypedValue
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import co.edu.eam.miprimeraapp.R
import co.edu.eam.miprimeraapp.adapter.ProductoAdapter
import co.edu.eam.miprimeraapp.data.Productos
import co.edu.eam.miprimeraapp.databinding.ActivityListaProductosBinding
import co.edu.eam.miprimeraapp.fragmentos.ListaProductosFragment
import co.edu.eam.miprimeraapp.modelo.Producto
import com.google.android.material.snackbar.Snackbar
import it.xabaras.android.recyclerview.swipedecorator.RecyclerViewSwipeDecorator

class ListaProductosActivity : AppCompatActivity() {

    lateinit var binding: ActivityListaProductosBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityListaProductosBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val codigoCategoria = intent.extras?.getInt("categoria-id")
        val nombreCategoria = intent.extras?.getString("categoria-nombre")
        //Toast.makeText(this, "La categoría seleccionada es: $codigoCategoria, $nombreCategoria", Toast.LENGTH_LONG).show()

        if(codigoCategoria!=null) {
            val fragment = ListaProductosFragment.newInstance(codigoCategoria = codigoCategoria)

            supportFragmentManager.beginTransaction()
                .replace(binding.listaProductos.id, fragment)
                .commit()
        }

    }
}