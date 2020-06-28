package com.example.appjuego

import android.content.ContentValues
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_registro.*
import kotlinx.android.synthetic.main.activity_registro.lblPass
import kotlinx.android.synthetic.main.activity_listado_usuarios.*

class registro : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro)
        val lblNombre : TextView =findViewById<Button>(R.id.lblNombre)
        val lblApellido :TextView =findViewById<TextView>(R.id.lblApellido)
        val lblMail :TextView =findViewById<TextView>(R.id.lblMail)
        val lblPass :TextView =findViewById<TextView>(R.id.lblPass)
       // val lblConfirmar :TextView =findViewById<TextView>(R.id.lblConfirmar)
        val btn_resgitro :Button =findViewById<Button>(R.id.btn_registro)

        btn_resgitro.setOnClickListener {
            if( this.altaDeUsuario()>0 ){
               // this.listarUsuarios()
                lblNombre.setText("")
                lblApellido.setText("")
                lblMail.setText("")
                lblPass.setText("")
            }
            if (lblNombre.text.toString().isEmpty() or lblApellido.text.toString().isEmpty() or lblMail.text.toString().isEmpty() or lblPass.text.toString().isEmpty())
            {

                Toast.makeText(this, "Campos vacios ", Toast.LENGTH_LONG).show()
            }
            else
            {


                val intent: Intent =Intent(this,okRegistro ::class.java)
                startActivity(intent)
                finish()


            }
        }

}


    private fun altaDeUsuario(): Long {
        var retorno:Long= 0L
        //Toast.makeText(this, "btnAltaUsuario", Toast.LENGTH_SHORT).show()
        if(this.lblNombre.getText().isNotEmpty()&&this.lblApellido.getText().isNotEmpty()&&this.lblMail.getText().isNotEmpty()&&this.lblPass.getText().isNotEmpty() )
        {

            var nombre=this.lblNombre.getText().toString()
            var apellido=this.lblApellido.getText().toString()
            var mail=this.lblMail.getText().toString()
            var clave=this.lblPass.getText().toString()
            val miUsuario=  usuario(nombre,apellido,mail,clave)
            retorno=miUsuario.GuardarEnSqLite(this)



            try {
                val admin = Admin_baseDeDatos(this,"SqLite2020", null, 4)
                val bd = admin.writableDatabase
                val registro = ContentValues()
                registro.put("nombre",nombre)
                registro.put("apellido",apellido)
                registro.put("mail",mail)
                registro.put("clave",clave)
                val newId=bd.insert("usuarios", null, registro)
                retorno= newId
                bd.close()
                Toast.makeText(this, "se creo el ID: $newId", Toast.LENGTH_SHORT).show()
            }catch (e:Throwable)
            {
                Toast.makeText(this, "Error: ${e.message}", Toast.LENGTH_SHORT).show()
            }


        }else
        {
            Toast.makeText(this, "Los campos no deben estar vacios", Toast.LENGTH_SHORT).show()
        }
        return retorno
    }/*fin altaDeUsuario*/

   /* private fun listarUsuarios()
    {
        this.txtListar.setText("")
        val listado=usuario.retornarArrayUsuarios(this)
        this.txtListar.append(listado.toString())
/*
        try {
            val admin = Admin_baseDeDatos(this, "SqLite2020", null, 2)
            val bd = admin.writableDatabase
            val fila = bd.rawQuery("select id,nombre,clave from usuarios", null)
            if (fila.moveToFirst()) {
                do {
                    val id: String = fila.getString(0)
                    val nombre: String = fila.getString(1)
                    val clave: String = fila.getString(2)
                    this.txtListar.append(id +" "+nombre+" "+clave+" \n")
                } while (fila.moveToNext())
            } else{
                Toast.makeText(this, "No hay Usuarios para listar",  Toast.LENGTH_SHORT).show()
            }
            bd.close()
        }catch (e:Throwable)
        {
            Toast.makeText(this, "No hay Usuarios ${e.message}",  Toast.LENGTH_SHORT).show()
            this.txtListar.append(e.message)
        }

 */*/



    }
