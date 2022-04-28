package co.edu.eam.miprimeraapp.actividades

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import co.edu.eam.miprimeraapp.R
import co.edu.eam.miprimeraapp.adapter.ViewPagerAdapter
import co.edu.eam.miprimeraapp.data.Carrito
import co.edu.eam.miprimeraapp.data.Productos
import co.edu.eam.miprimeraapp.databinding.ActivityDetalleProductoBinding
import co.edu.eam.miprimeraapp.modelo.Producto
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.tabs.TabLayoutMediator

class DetalleProductoActivity : AppCompatActivity() {

    lateinit var binding:ActivityDetalleProductoBinding
    var productoCodigo:String? = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetalleProductoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        productoCodigo = intent.extras?.getString("producto-id")

        if(productoCodigo!=null) {
            binding.viewPager.adapter = ViewPagerAdapter(this, productoCodigo!!)
            TabLayoutMediator(binding.tabsDetalle, binding.viewPager) { tab, pos ->
                when (pos) {
                    0 -> tab.text = "Detalle producto"
                    1 -> tab.text = "Comentarios"
                }
            }.attach()
        }

        binding.btnAgregarCarrito.setOnClickListener {
            Snackbar.make(binding.root, "Producto agregado al carrito!", Snackbar.LENGTH_LONG).show()
            if(productoCodigo!=null){
                Carrito.agregar( Productos.obtener(productoCodigo!!)!! )
            }
        }

    }
}