package org.example.crud

import org.example.entidades.CaixaDAgua
import org.example.enumeradores.Color
import org.example.enumeradores.Material
import java.sql.Connection
import java.sql.ResultSet
import kotlin.system.exitProcess

val conectar = EntidadeJDBC(
    url = "jdbc:postgresql://localhost:5433/teste02",
    usuario = "postgres",
    senha = "root"
)

fun criarTabelaCaixa (){

    val sql = "CREATE TABLE IF NOT EXISTS CaixaDAgua " +
            " (id serial NOT NULL PRIMARY KEY, " +
            "capacidade float, " +
            "cor varchar(255), " +
            "peso float, " +
            "preco varchar(255), " +
            "altura float, " +
            "profundidade float, " +
            "largura float, " +
            "tamanho varchar(255), " +
            "material varchar(255), " +
            "conectores int)"



    val banco = conectar.conectarComBanco()
    val enviarParaBanco = banco!!.createStatement().execute(sql)

    println(enviarParaBanco)

    banco.close()
}


fun cadasatrarCaixa (id : Int){
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
    val c = CaixaDAgua(
        material = material,
        capacidade = litros,
        cor = cor,
        peso = opcaoPeso,
        preco = opcaoPreco,
        altura = opcaoAltura,
        profundidade = opcaoProfundidade,
        largura = opcaoLargura,
        tamanho = opcaoTamanho,
        conectores = opcaoconectores

    )
    val banco = conectar.conectarComBanco()!!
    if (id == 0){
        val salvar = banco.prepareStatement(
            "INSERT INTO CaixaDAgua" +
                    " (material, capacidade, cor, peso, preco, altura, " +
                    "profundidade, largura, tamanho, conectores)" +
                    " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)"
        )
        salvar.setString(1, c.material.name)
        salvar.setDouble(2, c.capacidade!!)
        salvar.setString(3, c.cor.name)
        salvar.setInt(4, c.peso)
        salvar.setInt(5, c.preco)
        salvar.setInt(6, c.altura)
        salvar.setInt(7, c.profundidade)
        salvar.setDouble(8, c.largura)
        salvar.setString(9, c.tamanho)
        salvar.setInt(10, c.conectores)
        salvar.executeUpdate()
        salvar.close()
    }else{
        val sql = "UPDATE CaixaDAgua SET " +
                " material = ?, " +
                " capacidade = ?, " +
                " cor = ?, " +
                " peso = ?, " +
                " preco = ?, " +
                " altura = ?, " +
                " largura = ?, " +
                " profundidade = ?, " +
                " tamanho = ?, " +
                " conectores = ? " +
                " WHERE id = ?"
        val editar = banco.prepareStatement(sql)
        editar.setInt(11, id)
        editar.setString(1, c.material.name)
        editar.setDouble(2, c.capacidade!!)
        editar.setString(3, c.cor.name)
        editar.setInt(4, c.peso)
        editar.setInt(5, c.preco)
        editar.setInt(6, c.altura)
        editar.setInt(7, c.profundidade)
        editar.setDouble(8, c.largura)
        editar.setString(9, c.tamanho)
        editar.setInt(10, c.conectores)
        editar.executeUpdate()
        editar.close()
    }
    banco.close()

}
fun editarCaixa () {

    println("Digite o ID que deseja editar")
    var id= readln().toInt()
    val banco = conectar.conectarComBanco()
    val sqlBusca = "SELECT * FROM CaixaDAgua WHERE id = ?"
    val resultados = banco!!.prepareStatement(sqlBusca)
    resultados.setInt(1, id)
    val retorno = resultados.executeQuery()

    while (retorno.next()){
        println("----------------------------------------------")
        println("id: ${retorno.getString("id")}")
        id = retorno.getString("id").toInt()
        println("material: ${retorno.getString("material")}")
        println("cor: ${retorno.getString("cor")}")
        println("peso: ${retorno.getString("peso")}")
        println("largura: ${retorno.getString("largura")}")
        println("conectores: ${retorno.getString("conectores")}")
        println("capacidade: ${retorno.getString("capacidade")}")
        println("altura: ${retorno.getString("altura")}")
        println("profundidade: ${retorno.getString("profundidade")}")
        println("tamanho: ${retorno.getString("tamanho")}")
        println("preço: ${retorno.getString("preco")}")
    }

    println("Faça suas alterações: ")
    cadasatrarCaixa(id)
    retorno.close()
    resultados.close()
    banco.close()
}
fun listarCaixa(){
    val banco = conectar.conectarComBanco()
    val sql = "SELECT * FROM CaixaDAgua"
    val resultados : ResultSet= banco!!.createStatement().executeQuery(sql)

    while (resultados.next()){
        println("----------------------------------------------")
        println("id: ${resultados.getString("id")}")
        println("material: ${resultados.getString("material")}")
        println("cor: ${resultados.getString("cor")}")
        println("peso: ${resultados.getString("peso")}")
        println("largura: ${resultados.getString("largura")}")
        println("conectores: ${resultados.getString("conectores")}")
        println("capacidade: ${resultados.getString("capacidade")}")
        println("altura: ${resultados.getString("altura")}")
        println("profundidade: ${resultados.getString("profundidade")}")
        println("tamanho: ${resultados.getString("tamanho")}")
        println("preço: ${resultados.getString("preco")}")
    }
    resultados.close()
    banco.close()

}
fun excluirCaixa(){
    println("Digite o ID que deseja excluir")
    val id= readln().toInt()

    val banco = conectar.conectarComBanco()
    val sqlBusca = "SELECT * FROM CaixaDAgua WHERE id = ?"
    val resultados = banco!!.prepareStatement(sqlBusca)
    resultados.setInt(1, id)
    val retorno = resultados.executeQuery()

    while (retorno.next()){
    println("----------------------------------------------")
    println("id: ${retorno.getString("id")}")
    println("material: ${retorno.getString("material")}")
    println("cor: ${retorno.getString("cor")}")
    println("peso: ${retorno.getString("peso")}")
    println("largura: ${retorno.getString("largura")}")
    println("conectores: ${retorno.getString("conectores")}")
    println("capacidade: ${retorno.getString("capacidade")}")
    println("altura: ${retorno.getString("altura")}")
    println("profundidade: ${retorno.getString("profundidade")}")
    println("tamanho: ${retorno.getString("tamanho")}")
    println("preço: ${retorno.getString("preco")}")
    }

    println("Tem certeza que deseja excluir esse registro?")
    val resposta = readln().lowercase()
    when(resposta){
        "sim"->{
            val deletar = banco.prepareStatement("DELETE FROM CaixaDAgua WHERE id = ?")
                deletar.setInt(1, id)
            deletar.executeUpdate()
        }
        else -> {
            println("Operação cancelada!")
        }
    }
    resultados.close()
    banco.close()

}