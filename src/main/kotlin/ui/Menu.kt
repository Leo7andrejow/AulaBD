package org.example.ui

fun menu (){
    println("1 - Cadastar caixa D'Agua")
    println("2 - Editar caixa D'Agua")
    println("3 - Listar caixa D'Agua")
    println("4 - Excluir caixa D'Agua")

    var opcao = readln().toInt()

    when(opcao){
        1-> println("Cadastrando caixa...")
        2-> println("Editando caixa...")
        3-> println("Listar caixa...")
        4-> println("excluir caixa...")
        else-> println("Opção indisponivel!")
    }

}