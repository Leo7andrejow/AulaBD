package org.example.crud

import java.sql.Connection
import java.sql.DriverManager

class EntidadeJDBC (
    val usuario : String,
    val url : String,
    val senha: String
) {
    fun conectarComBanco() : Connection?{
    try {
        val coneccao: Connection = DriverManager.getConnection(//cada banco tem seu driver
            this.url, this.usuario, this.senha
        )
        println("Conectou!")
        return coneccao
        } catch (erro: Exception){
            println(erro.printStackTrace())
        }
        return null
    }
}