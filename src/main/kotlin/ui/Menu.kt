package org.example.ui

import org.example.crud.cadasatrarCaixa
import org.example.crud.editarCaixa
import org.example.crud.excluirCaixa
import org.example.crud.listarCaixa

fun menu (){
    do {
        println("1 - Cadastar caixa D'Agua")
        println("2 - Editar caixa D'Agua")
        println("3 - Listar caixa D'Agua")
        println("4 - Excluir caixa D'Agua")
        println("0 - Sair")


        var opcao = readln().toInt()

        when(opcao){
            0 ->println("0 - Adeus amigo!")
            1-> cadasatrarCaixa (0)//sempre que cadastrar uma caixa nova, o id sera 0
            2-> editarCaixa()
            3-> listarCaixa()
            4-> excluirCaixa()
            else-> println("Opção indisponivel!")
        }
    } while (opcao != 0)
}