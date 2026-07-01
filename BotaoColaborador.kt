package br.com.treinamento.modulojetpackcompose.projetoCrudColaboradoes.componentes

import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@Composable
fun BotaoColaborador(texto: String, corFundo: Color, acao: () -> Unit) {
    Button(
        onClick = acao,
        colors = ButtonDefaults.buttonColors(containerColor = corFundo)
    ) { Text(texto) }
}