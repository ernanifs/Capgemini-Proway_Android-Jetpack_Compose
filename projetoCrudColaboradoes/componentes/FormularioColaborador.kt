package br.com.treinamento.modulojetpackcompose.projetoCrudColaboradoes.componentes

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.unit.dp
import br.com.treinamento.modulojetpackcompose.projetoCrudColaboradoes.modelos.Colaborador
import br.com.treinamento.modulojetpackcompose.projetoCrudColaboradoes.modelos.NivelColaborador

@Composable
fun FormularioColaborador(
    colaboradorEmEdicao: Colaborador?,
    acaoCadastro: (Colaborador) -> Unit,
    acaoAtualizacao: (Colaborador) -> Unit,
    acaoCancelarEdicao: () -> Unit
) {

    // Variáveis
    var nome   by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var nivelSelecionado by remember { mutableStateOf(NivelColaborador.ADMINISTRATIVO) }
    val focusManager = LocalFocusManager.current
    val emEdicao = colaboradorEmEdicao != null

    LaunchedEffect(colaboradorEmEdicao?.id) {
        if (colaboradorEmEdicao == null) {
            nome = ""
            email = ""
            nivelSelecionado = NivelColaborador.ADMINISTRATIVO
        } else {
            nome = colaboradorEmEdicao.nome
            email = colaboradorEmEdicao.email
            nivelSelecionado = colaboradorEmEdicao.nivel
        }
    }

    // Estrutura (layout)
    Column(
        modifier = Modifier.padding(all = 15.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        // Nome
        OutlinedTextField(
            value = nome,
            onValueChange = { nome = it },
            label = { Text("Nome") },
            modifier = Modifier.fillMaxWidth()
        )

        // Email
        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("E-mail") },
            modifier = Modifier.fillMaxWidth()
        )

        var expandido by remember { mutableStateOf(false) }

        Box(modifier = Modifier.fillMaxWidth()) {
            OutlinedTextField(
                value = nivelSelecionado.descricao,
                onValueChange = {},
                readOnly = true,
                label = { Text("Nivel") },
                trailingIcon = {
                    IconButton(onClick = { expandido = !expandido }) {
                        Icon(
                            imageVector = Icons.Default.ArrowDropDown,
                            contentDescription = "Abrir niveis"
                        )
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { expandido = true }
            )

            DropdownMenu(
                expanded = expandido,
                onDismissRequest = { expandido = false },
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                NivelColaborador.entries.forEach { nivel ->
                    DropdownMenuItem(
                        text = { Text(nivel.descricao) },
                        onClick = {
                            nivelSelecionado = nivel
                            expandido = false
                        }
                    )
                }
            }
        }


        // Botão (sem trailing lambda)
        //Botao(
        //    texto = "Cadastrar",
        //    corFundo = Color(0xFF4457eb),
        //    acao = {
        //        acaoCadastro(Pessoa(nome, cidade))
        //    }
        //)

        // Botao (com trailing lambda)
        BotaoColaborador(
            texto = if (emEdicao) "Salvar alteracoes" else "Cadastrar",
            corFundo = Color(0xFF4457eb)
        ) {
            if (emEdicao) {
                acaoAtualizacao(
                    colaboradorEmEdicao!!.copy(
                        nome = nome,
                        email = email,
                        nivel = nivelSelecionado
                    )
                )
            } else {
                acaoCadastro(
                    Colaborador(
                        nome = nome,
                        email = email,
                        nivel = nivelSelecionado
                    )
                )
            }

            nome = ""
            email = ""
            nivelSelecionado = NivelColaborador.ADMINISTRATIVO

            focusManager.clearFocus()
        }

        if (emEdicao) {
            BotaoColaborador(
                texto = "Cancelar edicao",
                corFundo = Color(0xFF8f8f8f)
            ) {
                acaoCancelarEdicao()
                focusManager.clearFocus()
            }
        }

    }

}
