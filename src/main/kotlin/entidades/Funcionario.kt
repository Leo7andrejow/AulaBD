package org.example.entidades

import org.example.enumeradores.Raca
import org.example.enumeradores.Setor
import java.math.BigDecimal

class Funcionario (
    nome : String,
    cpf : Long,
    idade : Int,
    val cargo : String,
    val cargaHorario : Int,
    val salario : BigDecimal,
    raca : Raca,
    val estudante : Boolean,
    val tamanhoRoupa : String,
    val setor: Setor

) : Pessoa(
    nome = nome,
    cpf = cpf,
    idade = idade,
    raca = raca
) {
    //Comportamento do profissional
    fun instalarCaixaDAgua(funcionario: Funcionario) {
        if (funcionario.setor.equals(Setor.MONTAGEM)) {
            println("Profissional habilitado")
        } else {
            println("Profissional desqualificado")
        }
    }

    override fun receberConta(conta: Conta, aReceber: BigDecimal) {
        conta.saldo = conta.saldo.subtract(aReceber)
    }
}