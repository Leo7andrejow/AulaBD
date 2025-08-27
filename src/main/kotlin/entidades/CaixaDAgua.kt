package org.example.entidades

import org.example.enumeradores.Color
import org.example.enumeradores.Material
import java.math.BigDecimal

class CaixaDAgua (// contrustores da classe
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

    )