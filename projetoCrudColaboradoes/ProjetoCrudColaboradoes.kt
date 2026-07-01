package br.com.treinamento.modulojetpackcompose.projeto1

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import br.com.treinamento.modulojetpackcompose.projetoCrudColaboradoes.componentes.FormularioColaborador
import br.com.treinamento.modulojetpackcompose.projetoCrudColaboradoes.componentes.ListagemColaborador
import br.com.treinamento.modulojetpackcompose.projetoCrudColaboradoes.modelos.Colaborador

@Composable
fun ProjetoCrudColaboradores(expandido: Any, onEvent: () -> Unit) {

    // Coleção de colaboradores
    val colaboradores = remember { mutableStateListOf<Colaborador>() }
    var colaboradorEmEdicao by remember { mutableStateOf<Colaborador?>(null) }

    // Estrutura
    Column(
        modifier = Modifier
            .safeDrawingPadding()
            .fillMaxSize()
    ) {
        // Formulário
        FormularioColaborador(
            colaboradorEmEdicao = colaboradorEmEdicao,
            acaoCadastro = { novoColaborador ->
                colaboradores.add(novoColaborador)
            },
            acaoAtualizacao = { colaboradorAtualizado ->
                val indice = colaboradores.indexOfFirst { it.id == colaboradorAtualizado.id }
                if (indice != -1) {
                    colaboradores[indice] = colaboradorAtualizado
                }
                colaboradorEmEdicao = null
            },
            acaoCancelarEdicao = {
                colaboradorEmEdicao = null
            }
        )

        // Listagem
        ListagemColaborador(
            colaboradores = colaboradores,
            acaoRemocao = { colaboradorRemovido ->
                colaboradores.remove(colaboradorRemovido)
                if (colaboradorEmEdicao?.id == colaboradorRemovido.id) {
                    colaboradorEmEdicao = null
                }
            },
            acaoEdicao = { colaborador ->
                colaboradorEmEdicao = colaborador
            }
        )

    }

}