package com.example.agendacontactos_objetos

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.AddIcCall
import androidx.compose.material.icons.filled.AttachEmail
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Save
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.agendacontactos_objetos.Data.Contacto
import com.example.agendacontactos_objetos.Data.viewModelContacto
import com.example.agendacontactos_objetos.ui.theme.AgendaContactos_ObjetosTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AgendaContactos_ObjetosTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    preview()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun agendacontactos(viewModelContacto: viewModelContacto){
    val context = LocalContext.current

    var nombre by remember { mutableStateOf("") }
    var telefono by remember { mutableStateOf("") }
    
   Column(modifier= Modifier
       .fillMaxWidth()
       .padding(16.dp)) {

       OutlinedTextField(
           value = nombre,
           onValueChange = { nombre = it },
           label = { Text("Nombre") },
           modifier = Modifier.fillMaxWidth()
       )
       Spacer(modifier = Modifier.height(16.dp))
       OutlinedTextField(
           value = telefono,
           onValueChange = { telefono = it },
           label = { Text("Teléfono") },
           keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
           keyboardActions = KeyboardActions(onDone = {
             //  viewModel.agregarContacto( Contacto(nombre, telefono))
               nombre = ""
               telefono = ""
           }),
           modifier = Modifier.fillMaxWidth()
       )
       Spacer(modifier = Modifier.height(16.dp))
       Button(
           onClick = {
             //  viewModelContacto.contacto.(Contacto(nombre, telefono))
            //   viewModel.agregarContacto( Contacto(nombre, telefono))


               nombre = ""
               telefono = ""

           },
           modifier = Modifier.align(Alignment.End)
       ) {
           Text("Agregar")
       }
       Spacer(modifier = Modifier.height(16.dp))
       
       LazyColumn{
           items(viewModelContacto.list){
               contacto->
               contactocard(contacto)
           }
       }
       
   }
    
    
    
}




@Composable()
fun contactocard(contacto: Contacto) {


    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(8.dp),


        ) {


        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {

                Image(
                    painter = painterResource(id = contacto.foto), // Reemplaza "imagen_producto" con el ID de tu imagen
                    contentDescription = null, modifier = Modifier.height(26.dp) // Descripción opcional para accesibilidad

                )
            Spacer(modifier = Modifier.width(30.dp))
                Text(
                    text = "${contacto.nombre}", style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.primary
                )
                Spacer(modifier = Modifier.width(30.dp))
                Text(
                    text = "${contacto.telefono}", style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.primary
                )


            IconButton(onClick = {}) {
                Icon(Icons.Default.Delete, contentDescription = "Eliminar")
            }
            IconButton(onClick = {}) {
                Icon(Icons.Default.Edit, contentDescription = "Modificar")
            }


            }


        }

    }

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun fichacontacto(contacto: Contacto) {




    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .padding(top = 50.dp), horizontalAlignment =  Alignment.CenterHorizontally,
    ) {

        Image(
            painter = painterResource(id = contacto.foto),
            contentDescription = null,
            modifier = Modifier
                .size(100.dp)
                .align(Alignment.CenterHorizontally)
        )

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ){
            Icon(Icons.Default.AccountCircle, contentDescription = null)
            Spacer(modifier = Modifier.width(8.dp))
            OutlinedTextField(
                value = contacto.nombre,
                onValueChange = { contacto.nombre = it },
                label = { Text("Nombre") },
                modifier = Modifier.fillMaxWidth()
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ){
            Icon(Icons.Default.Call, contentDescription = null)
            Spacer(modifier = Modifier.width(8.dp))
            OutlinedTextField(
                value = contacto.telefono,
                onValueChange = { contacto.nombre = it },
                label = { Text("Telefono") },
                modifier = Modifier.fillMaxWidth()
            )
        }

        Spacer(modifier = Modifier.height(16.dp))


        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ){
            Icon(Icons.Default.Email, contentDescription = null)
            Spacer(modifier = Modifier.width(8.dp))
            OutlinedTextField(
                value = contacto.email,
                onValueChange = { contacto.email = it },
                label = { Text("Email") },
                modifier = Modifier.fillMaxWidth()
            )
        }



    }
}


    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @OptIn(ExperimentalMaterial3Api::class)
    @Preview
    @Composable
    fun preview() {
        val viewModelContacto: viewModelContacto = viewModel()

        val contacto: Contacto = Contacto("", "", "", R.drawable.neutra, 0)

        // agendacontactos(viewModelContacto)


        Scaffold(

            topBar = {
                TopAppBar(
                    title = { Text("Contacto") },
                    actions={
                        IconButton(onClick = {}) {
                            Icon(Icons.Default.Save, contentDescription = "Guardar",modifier = Modifier.size(32.dp))
                        }
                    }


                )

            }
        ) {
            fichacontacto(contacto)
        }




    }
