package br.com.treinamento.modulojetpackcompose.projetoCrudColaboradoes.modelos

import java.util.UUID

data class Colaborador(
    val id: String = UUID.randomUUID().toString(),
    val nome: String,
    val email: String,
    val nivel: NivelColaborador
)
