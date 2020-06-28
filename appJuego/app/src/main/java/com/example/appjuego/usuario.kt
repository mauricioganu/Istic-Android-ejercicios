package com.example.appjuego

import android.content.ContentValues
import android.content.Context
import android.widget.Toast


class usuario(var nombre: String, var apellido: String, var mail: String, var clave: String) {
    var id:Int=0

    companion object{


        fun retornarArrayUsuarios(contexto: Context): MutableList<String> {
            val listado: MutableList<String> = ArrayList()
            val admin = Admin_baseDeDatos(contexto, "SqLite2020", null, 4)
            val bd = admin.writableDatabase
            val fila = bd.rawQuery("select id,nombre,apellido,mail,clave from usuarios", null)
            if (fila.moveToFirst()) {

                do {
                    val id: String = fila.getString(0)
                    val nombre: String = fila.getString(1)
                    val apellido: String = fila.getString(2)
                    val mail: String = fila.getString(3)
                    val clave: String = fila.getString(4)

                    listado.add(id+" "+nombre+""+apellido+" "+mail+" "+clave)
                } while (fila.moveToNext())

            } else{
                Toast.makeText(contexto, "No hay usuarios",  Toast.LENGTH_SHORT).show()
            }
            bd.close()
            return listado
        }
    }


    public fun GuardarEnSqLite(contexto:Context): Long {
        var retorno:Long= 0L
        try {
            val admin = Admin_baseDeDatos(contexto,"SqLite2020", null, 4)
            val bd = admin.writableDatabase
            val registro = ContentValues()
            registro.put("nombre",this.nombre)
            registro.put("apellido",this.apellido)
            registro.put("mail",this.mail)
            registro.put("clave",this.clave)
            retorno=bd.insert("usuarios", null, registro)
            bd.close()
            Toast.makeText(contexto, "se creo el ID: $retorno", Toast.LENGTH_SHORT).show()
        }catch (e:Throwable)
        {
            Toast.makeText(contexto, "Error: ${e.message}", Toast.LENGTH_SHORT).show()
        }
        return retorno
    }
    public fun ActualizarEnSqLite(contexto:Context): Long {
        var retorno:Long= 0L
        try {
            val admin = Admin_baseDeDatos(contexto,"SqLite2020", null, 4)
            val bd = admin.writableDatabase
            val registro = ContentValues()
            registro.put("nombre",this.nombre)
            registro.put("apellido",this.apellido)
            registro.put("mail",this.mail)
            registro.put("clave",this.clave)
            retorno=bd.insert("usuarios", null, registro)
            bd.close()
            Toast.makeText(contexto, "se creo el ID: $retorno", Toast.LENGTH_SHORT).show()
        }catch (e:Throwable)
        {
            Toast.makeText(contexto, "Error: ${e.message}", Toast.LENGTH_SHORT).show()
        }
        return retorno
    }
}

/*

no hay articulo no such column:(code1 SQLITE_ERROR1
 */