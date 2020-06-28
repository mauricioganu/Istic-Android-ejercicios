
package com.example.appjuego

//import android.support.v7.app.AppCompatActivity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_listado_usuarios.*



class Listado_usuarios : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listado_usuarios)
        listarUsuarios()

        lsvListado.setOnItemClickListener{ parent, view, position, id ->

            val texto=parent.getItemAtPosition(position) as String
            val datos=texto.split(",")//22,miNombre,miClave
            val id=datos[0]//datos[0]=id datos[1]=nombre datos[2]=clave
           // Toast.makeText(this, "Selecciono :$id", Toast.LENGTH_SHORT).show()
          //  val intento1 = Intent(this,Editar_usuario::class.java)
          //  intento1.putExtra("id", "$id")
            //startActivity(intento1)
        }
    }
    private fun listarUsuarios()
    {
        val listado=ArrayList<String>()
        try {
            val admin = Admin_baseDeDatos(this, "SqLite2020", null, 4)
            val bd = admin.writableDatabase
            val fila = bd.rawQuery("select id,nombre,apellido,mail,clave from usuarios", null)
            if (fila.moveToFirst()) {
                do {
                    val id: String = fila.getString(0)
                    val nombre: String = fila.getString(1)
                    val apellido: String = fila.getString(2)
                    val mail: String = fila.getString(3)
                    val clave: String = fila.getString(4)
                    listado.add(id +","+nombre+","+apellido+mail+","+","+clave+" \n")
                } while (fila.moveToNext())
            } else{
                Toast.makeText(this, "No hay Usuarios para listar",  Toast.LENGTH_SHORT).show()
            }
            bd.close()
            val adapter = ArrayAdapter(this,android.R.layout.simple_list_item_1,listado)
            this.lsvListado.adapter=adapter
        }catch (e:Throwable)
        {
            Toast.makeText(this, "No hay artículo ${e.message}",  Toast.LENGTH_SHORT).show()
            e.message?.let { listado.add(it) }
        }

    }
   // override fun onStart() {
    //    super.onStart()
      //  this.listarUsuarios()
    //}
}

