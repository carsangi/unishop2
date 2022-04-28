package co.edu.eam.miprimeraapp.actividades

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import co.edu.eam.miprimeraapp.R
import co.edu.eam.miprimeraapp.databinding.ActivityMainBinding
import co.edu.eam.miprimeraapp.fragmentos.*

class MainActivity : AppCompatActivity() {

    lateinit var resultLauncher:ActivityResultLauncher<Intent>
    lateinit var binding:ActivityMainBinding
    val MENU_HOME = "HOME"
    val MENU_OFERTAS = "OFERTAS"
    val MENU_FAVORITOS = "FAVORITOS"
    val MENU_COMPRAS = "COMPRAS"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        resultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
            Log.v("MainActivity", "Llegó información")
            if(it.data!=null){
                Log.v("MainActivity", "${it.data?.extras?.getString("FOTO")}")
            }
        }

        reemplazarFragmento(1, "HOME")

        binding.barraInferior.setOnItemSelectedListener { item ->
            when(item.itemId){
                R.id.menu_home -> reemplazarFragmento(1, MENU_HOME)
                R.id.menu_ofertas -> reemplazarFragmento(2, MENU_OFERTAS)
                R.id.menu_favs -> reemplazarFragmento(3, MENU_FAVORITOS)
                R.id.menu_compras -> reemplazarFragmento(4, MENU_COMPRAS)
            }
            true
        }

    }

    fun reemplazarFragmento(pos:Int, nombre:String){

        var fragmento:Fragment = when( pos ){
            1 -> InicioFragment()
            2 -> ListaProductosFragment.newInstance(esOferta = true)
            3 -> FavoritosFragment()
            else -> ComprasFragment()
        }

        supportFragmentManager.beginTransaction().replace( binding.contenido.id, fragmento )
            .addToBackStack(nombre)
            .commit()
    }

    override fun onBackPressed() {
        super.onBackPressed()
        val count = supportFragmentManager.backStackEntryCount
        val nombre = supportFragmentManager.getBackStackEntryAt(count-1).name

        when(nombre){
            MENU_HOME -> binding.barraInferior.menu.getItem(0).isChecked = true
            MENU_OFERTAS -> binding.barraInferior.menu.getItem(1).isChecked = true
            MENU_FAVORITOS -> binding.barraInferior.menu.getItem(2).isChecked = true
            else -> binding.barraInferior.menu.getItem(3).isChecked = true
        }

    }

}