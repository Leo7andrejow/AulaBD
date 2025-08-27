package org.example.entidades

import java.math.BigDecimal

class Conta (
    val cooperado : String,
    val id : Long,
    var saldo : BigDecimal,
    val agencia : String,
    val status : Array<String>,
    val senha : Long,
)