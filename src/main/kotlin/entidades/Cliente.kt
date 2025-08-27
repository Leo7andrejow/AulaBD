package org.example.entidades

import org.example.enumeradores.Raca
import org.example.enumeradores.Sexo


class Cliente (
    nome : String,
    cpf : Long,
    idade : Int,
    val sexo : Sexo,
    raca : Raca,
    val metodoPagamento : String,
    val endereco : String,
) : Pessoa(
    nome = nome,
    cpf = cpf,
    idade = idade,
    raca = raca
) {

}