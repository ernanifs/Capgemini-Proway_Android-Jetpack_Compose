package br.com.treinamento.modulojetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import br.com.treinamento.modulojetpackcompose.componentes.Componente04_LazyColumn
import br.com.treinamento.modulojetpackcompose.projeto1.ProjetoCrudColaboradores
import br.com.treinamento.modulojetpackcompose.ui.theme.ModuloJetpackComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ModuloJetpackComposeTheme {
                //Componente01_Box()
                //Componente02_Column()
                //Componente03_Row()
                //Componente04_LazyColumn(nomes = listOf("Ralf", "Jéssica", "Carla"))
                //Componente05_TextField_Button()
                //Componente06_Switch()
                //Componente07_Slider()
                //Componente08_Icon()
                //Componente09_Image()
                //Componente10_AlertDialog()
                //Componente11_OutlinedTextField()
                //Projeto1()
                //Projeto2()
                //Projeto4CrudColaboradores()
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ModuloJetpackComposeTheme {
        //Componente04_LazyColumn(nomes = listOf("Ralf", "Jéssica", "Carla"))
        //Componente01_Box()
        //Componente02_Column()
        //Componente03_Row()
        //Componente04_LazyColumn(nomes = listOf("Ralf", "Jéssica", "Carla"))
        //Componente05_TextField_Button()
        //Componente06_Switch()
        //Componente07_Slider()
        //Componente08_Icon()
        //Componente09_Image()
        //Componente10_AlertDialog()
        //Componente11_OutlinedTextField()
        //Projeto1()
        //Projeto2()
        //Projeto3()
        //Projeto4CrudColaboradores()
        //ProjetoCrudColaboradores()
        ProjetoCrudColaboradores(expandido = false, onEvent = {})
    }
}