package co.edu.eam.miprimeraapp.data

import co.edu.eam.miprimeraapp.modelo.Usuario

object Usuarios {

    private var usuarios:ArrayList<Usuario> = ArrayList()

    init{
        usuarios.add( Usuario("112", "Carlos", "carlos@email.com", "1234") )
        usuarios.add( Usuario("234", "Lucas", "lucas@email.com", "4545") )
        usuarios.add( Usuario("565", "Ana", "ana@email.com", "3434") )
    }

    fun getLista():ArrayList<Usuario>{
        return usuarios
    }

    fun registro(usuario: Usuario){
        usuarios.add(usuario)
    }

    fun validarSesion(email:String, password:String):Usuario?{
        val usuario = usuarios.find { u -> u.correo == email && u.password == password }
        return usuario
    }

}