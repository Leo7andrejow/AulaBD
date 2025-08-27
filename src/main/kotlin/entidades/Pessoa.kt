package org.example.entidades

import org.example.enumeradores.Raca
import java.math.BigDecimal

open class Pessoa (
    val nome : String,
    val cpf : Long,
    val idade : Int,
    val raca : Raca,
) {
    // comportamento
    open fun receberConta(conta: Conta, aReceber: BigDecimal) {
        conta.saldo = conta.saldo.add(aReceber)
    }
}