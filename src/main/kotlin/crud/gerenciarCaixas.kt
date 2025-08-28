package org.example.crud

import org.example.entidades.CaixaDAgua
import org.example.enumeradores.Color
import org.example.enumeradores.Material

fun cadasatrarCaixa (){
    /*
    val capacidade : Int,
    val cor : Color,
    val peso : Double,
    val preco : BigDecimal,
    val altura : Double,
    val profundidade : Double,
    val Largura : Double,
    val tamanho : String,
    val material : Material,
    val conectores : Int,

        PLASTICO,
    PVC,
    METAL,
    ARGAMASSA,
    VEDAROSCA,
    COLA,
    LIXA,
    SERRA,

    */
    println("Escolha a quantidade do qual a caixa é composta:")
    println("1 - Plástico")
    println("2 - PVC")
    println("3 - Metal")
    println("4 - Argamassa")
    println("5 - Vedarosca")
    println("6 - Cola")
    println("7 - Lixa")
    println("8 - Serra")
    val opcaoMaterial = readln().toInt()
    var material : Material
    when(opcaoMaterial) {
        1-> material = Material.PLASTICO
        2-> material = Material.PVC
        3-> material = Material.METAL
        4-> material = Material.ARGAMASSA
        5-> material = Material.VEDAROSCA
        6-> material = Material.COLA
        7-> material = Material.LIXA
        8-> material = Material.SERRA
        else -> material = Material.PLASTICO
    }

    println("Capacidade da caixa em litros:")
    val litros = readln().toDouble()

    println("Escolha a cor da caixa de Agua:")
    println("1 - Azul")
    println("2 - Roxo")
    println("3 - Verde")
    println("4 - Branco")
    println("5 - Preto0")
    println("6 - Amarelo")
    println("7 - Vermelho")
    println("8 - Azul")
    val opcaoCor = readln().toInt()
    var cor : Color
    when(opcaoMaterial) {
        1-> cor = Color.AZUL
        2-> cor = Color.ROXO
        3-> cor = Color.VERDE
        4-> cor = Color.BRANCO
        5-> cor = Color.PRETO0
        6-> cor = Color.AMARELO
        7-> cor = Color.VERMELHO
        else -> cor = Color.AZUL
    }


    println("Peso da caixa")
    val opcaoPeso = readln().toInt()

    println("Preco da caixa")
    val opcaoPreco = readln().toInt()

    println("altura da caixa")
    val opcaoAltura = readln().toInt()

    println("Profundidade da caixa")
    val opcaoProfundidade = readln().toInt()

    println("Largura da caixa de agua ?")
    val opcaoLargura = readln().toDouble()

    println("Tamanho da caixa de Agua ?")
    val opcaoTamanho = readln().toString()

    println("conectores da caixa ")
    val opcaoconectores = readln().toInt()



    // salvar as variaveis agora dentro da classe
    CaixaDAgua(
        material = material,
        capacidade = litros,
        cor = cor,
        peso = opcaoPeso,
        preco = opcaoPreco,
        altura = opcaoAltura,
        profundidade = opcaoProfundidade,
        Largura = opcaoLargura,
        tamanho = opcaoTamanho,
        conectores = opcaoconectores





    )


}
fun editarCaixa () {

}
fun listarCaixa(){

}
fun excluirCaixa(){

}