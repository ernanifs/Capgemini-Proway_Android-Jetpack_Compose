package br.com.treinamento.modulojetpackcompose.projetoCrudColaboradoes.componentes

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import br.com.treinamento.modulojetpackcompose.projetoCrudColaboradoes.modelos.Colaborador

@Composable
fun ListagemColaborador(
    colaboradores: List<Colaborador>,
    acaoRemocao: (Colaborador) -> Unit,
    acaoEdicao: (Colaborador) -> Unit
) {

    // Estrutura
    LazyColumn(
        modifier = Modifier.padding(all = 15.dp),
    ) {
        // Laço de repetição
        items(colaboradores) { colaborador ->
            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Column() {
                    Text(colaborador.nome)
                    Text(colaborador.email)
                    Text(colaborador.nivel.descricao)
                }

                BotaoColaborador(texto = "Editar", corFundo = Color(0xFF4457eb)) {
                    acaoEdicao(colaborador)
                }
                BotaoColaborador(texto = "Remover", corFundo = Color(0xFFd44b3b)) {
                    acaoRemocao(colaborador)
                }
            }
        }
    }

}