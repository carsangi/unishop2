package co.edu.eam.miprimeraapp.actividades

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import co.edu.eam.miprimeraapp.data.Productos
import co.edu.eam.miprimeraapp.databinding.ActivityResultadoBusquedaBinding
import co.edu.eam.miprimeraapp.fragmentos.ListaProductosFragment

class ResultadoBusquedaActivity : AppCompatActivity() {

    lateinit var binding:ActivityResultadoBusquedaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityResultadoBusquedaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val texto = intent.extras?.getString("criterio")

        if(texto!=null){

            supportFragmentManager.beginTransaction()
                .replace(binding.resultadoBusqueda.id, ListaProductosFragment.newInstance(busqueda = texto))
                .commit()
        }

    }
}