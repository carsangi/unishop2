package co.edu.eam.miprimeraapp.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import co.edu.eam.miprimeraapp.R
import co.edu.eam.miprimeraapp.actividades.DetalleProductoActivity
import co.edu.eam.miprimeraapp.databinding.ItemProductoBinding
import co.edu.eam.miprimeraapp.modelo.Producto

class ProductoAdapter(var lista:ArrayList<Producto>): RecyclerView.Adapter<ProductoAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = ItemProductoBinding.inflate( LayoutInflater.from(parent.context), parent, false )
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindProducto(lista[position])
    }

    override fun getItemCount(): Int =  lista.size

    inner class ViewHolder(private var view:ItemProductoBinding):RecyclerView.ViewHolder(view.root){

        fun bindProducto(producto:Producto){
            view.tituloProducto.text = producto.nombre

            var precio = producto.precio

            if (producto.descuento > 0){
                view.descuentoProducto.text = "${producto.descuento*100} %"
                view.descuentoProducto.isVisible = true
                precio -= precio * producto.descuento
            }

            view.precioProducto.text = "$ ${precio.toString()}"
            view.root.setOnClickListener {
                val intent = Intent( itemView.context, DetalleProductoActivity::class.java )
                intent.putExtra("producto-id", producto.codigo)
                itemView.context.startActivity( intent )
            }
        }

    }
}