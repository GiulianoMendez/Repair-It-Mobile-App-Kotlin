package com.example.repairit

import Classes.Usuario
import Interfaces.UsuarioDAO
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var appDB:appDataBase
    private lateinit var usuarioTmp:Usuario
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        appDB = appDataBase.getDatabase(this)

        val txtUsername:EditText = findViewById(R.id.txtUsername)
        val txtPassword:EditText = findViewById(R.id.txtPassword)

        val btnGo: Button = findViewById(R.id.btnGo)

        btnGo.setOnClickListener(){
            val usernm: String = txtUsername.text.toString()
            val pass: String = txtPassword.text.toString()

            if (usernm.isEmpty() || pass.isEmpty()){
                Toast.makeText(this, "All Fields Required", Toast.LENGTH_SHORT).show()}
            else {

                GlobalScope.launch(Dispatchers.IO) {
                    usuarioTmp = appDB.usuarioDAO().getUser(usernm,pass)
                }
                //if (usuarioTmp.username == usernm && usuarioTmp.password == pass){}
                val intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)

            }
        }

    }
}