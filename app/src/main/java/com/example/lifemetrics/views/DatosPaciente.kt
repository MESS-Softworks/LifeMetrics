package com.example.lifemetrics.views

import androidx.compose.foundation.rememberScrollState
import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lifemetrics.R

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun DatosPacienteView() {

    var nombre by remember { mutableStateOf("") }
    var edad by remember { mutableStateOf("") }
    var sexo by remember { mutableStateOf("") }
    var talla by remember { mutableStateOf("") }
    var peso by remember { mutableStateOf("") }
    var medicamento by remember { mutableStateOf("") }
    var veces by remember { mutableStateOf("") }
    var horas by remember { mutableStateOf("") }


    var expandedSexo by remember { mutableStateOf(false) }
    val optionsSexo = listOf("Hombre", "Mujer", "Otro")

    var expandedTalla by remember { mutableStateOf(false) }
    val optionsTalla = listOf("Extra chica", "Chica", "Mediana", "Grande", "Extra grande")

    // Funciones para validar cada campo
    fun validateNombre(value: String): String {
        val regex = Regex("^[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]*$")
        return if (value.matches(regex)) value else nombre
    }
    /*fun validateNombre(value: String): String {
        val allowedChars = setOf('ñ', 'Ñ', 'á', 'é', 'í', 'ó', 'ú', 'Á', 'É', 'Í', 'Ó', 'Ú')
        return if (value.all { it.isLetter() || it.isWhitespace() || it in allowedChars }) value else nombre
    }*/

    fun validateEdad(value: String): String {
        return if (value.all { it.isDigit() }) value else edad
    }

    fun validateVeces(value: String): String {
        return if (value.all { it.isDigit() }) value else veces
    }

    fun validatePeso(value: String): String {
        // Expresión regular para aceptar números enteros o decimales (con un punto)
        return if (value.isEmpty() || value.matches(Regex("^[0-9]*\\.?[0-9]*$"))) {
            value // Si es válido, regresa el valor
        } else {
            peso // Si no es válido, mantiene el valor anterior
        }
    }

    fun validateHoras(value: String): String {
        return if (value.all { it.isDigit() }) value else horas
    }

    Scaffold {
        Box(modifier = Modifier.fillMaxSize()) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .verticalScroll(rememberScrollState()),  // Hacemos que la columna sea desplazable
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = R.drawable.registro),
                    contentDescription = "registro",
                    modifier = Modifier.size(250.dp)  // Ajusta el tamaño de la imagen
                )
                Text(
                    text = "Ingresa los datos del paciente",
                    style = MaterialTheme.typography.titleLarge.copy(
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF49688d),
                        fontSize = 24.sp
                    ),
                    modifier = Modifier.padding(top = 16.dp, bottom = 16.dp)
                )
                Spacer(modifier = Modifier.height(16.dp))
                OutlinedTextField(
                    value = nombre,
                    onValueChange = { nombre = validateNombre(it) },
                    label = { Text("Nombre") },
                    modifier = Modifier.align(Alignment.CenterHorizontally),
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = Color(0xFF49688d),
                        unfocusedBorderColor = Color(0xFF8aa2d4),
                        focusedLabelColor = Color(0xFF49688d),
                        unfocusedLabelColor = Color(0xFF8aa2d4),
                    )
                )
                Spacer(modifier = Modifier.height(16.dp))
                OutlinedTextField(
                    value = edad,
                    onValueChange = { edad = validateEdad(it) },
                    label = { Text("Edad") },
                    modifier = Modifier.align(Alignment.CenterHorizontally),
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = Color(0xFF49688d),
                        unfocusedBorderColor = Color(0xFF8aa2d4),
                        focusedLabelColor = Color(0xFF49688d),
                        unfocusedLabelColor = Color(0xFF8aa2d4),
                    )
                )

                Spacer(modifier = Modifier.height(16.dp))
                Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
                    OutlinedTextField(
                        value = sexo,
                        onValueChange = { },
                        label = { Text("Sexo") },
                        modifier = Modifier //.align(Alignment.CenterHorizontally)
                            .clickable { expandedSexo = true },
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            focusedBorderColor = Color(0xFF49688d),
                            unfocusedBorderColor = Color(0xFF8aa2d4),
                            focusedLabelColor = Color(0xFF49688d),
                            unfocusedLabelColor = Color(0xFF8aa2d4), ),
                        readOnly = true
                    )
                    DropdownMenu(
                        expanded = expandedSexo,
                        onDismissRequest = { expandedSexo = false }
                    ) {
                        optionsSexo.forEach { label ->
                            DropdownMenuItem(
                                text = { Text(label) },
                                onClick = {
                                    sexo = label
                                    expandedSexo = false
                                }
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))
                Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
                    OutlinedTextField(
                        value = talla,
                        onValueChange = { },
                        label = { Text("Talla") },
                        modifier = Modifier //.align(Alignment.CenterHorizontally)
                            .clickable { expandedTalla = true },
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            focusedBorderColor = Color(0xFF49688d),
                            unfocusedBorderColor = Color(0xFF8aa2d4),
                            focusedLabelColor = Color(0xFF49688d),
                            unfocusedLabelColor = Color(0xFF8aa2d4), ),
                        readOnly = true
                    )
                    DropdownMenu(
                        expanded = expandedTalla,
                        onDismissRequest = { expandedTalla = false }
                    ) {
                        optionsTalla.forEach { label ->
                            DropdownMenuItem(
                                text = { Text(label) },
                                onClick = {
                                    talla = label
                                    expandedTalla = false
                                }
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))
                OutlinedTextField(
                    value = peso,
                    onValueChange = { newValue ->
                        peso = validatePeso(newValue) },
                    label = { Text("Peso") },
                    modifier = Modifier.align(Alignment.CenterHorizontally),
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = Color(0xFF49688d),
                        unfocusedBorderColor = Color(0xFF8aa2d4),
                        focusedLabelColor = Color(0xFF49688d),
                        unfocusedLabelColor = Color(0xFF8aa2d4),
                    )
                )

                Spacer(modifier = Modifier.height(16.dp))
                OutlinedTextField(
                    value = medicamento,
                    onValueChange = { medicamento = it },
                    label = { Text("Medicamento que ingiere") },
                    modifier = Modifier.align(Alignment.CenterHorizontally),
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = Color(0xFF49688d),
                        unfocusedBorderColor = Color(0xFF8aa2d4),
                        focusedLabelColor = Color(0xFF49688d),
                        unfocusedLabelColor = Color(0xFF8aa2d4),
                    )
                )
                Spacer(modifier = Modifier.height(16.dp))
                OutlinedTextField(
                    value = veces,
                    onValueChange = { veces = validateVeces(it) },
                    label = { Text("Veces al día que se ingiere") },
                    modifier = Modifier.align(Alignment.CenterHorizontally),
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = Color(0xFF49688d),
                        unfocusedBorderColor = Color(0xFF8aa2d4),
                        focusedLabelColor = Color(0xFF49688d),
                        unfocusedLabelColor = Color(0xFF8aa2d4),
                    )
                )
                Spacer(modifier = Modifier.height(16.dp))
                OutlinedTextField(
                    value = horas,
                    onValueChange = { horas = validateHoras(it) },
                    label = { Text("¿Cuántas horas?") },
                    modifier = Modifier.align(Alignment.CenterHorizontally),
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = Color(0xFF49688d),
                        unfocusedBorderColor = Color(0xFF8aa2d4),
                        focusedLabelColor = Color(0xFF49688d),
                        unfocusedLabelColor = Color(0xFF8aa2d4),
                    )
                )
                Spacer(modifier = Modifier.height(32.dp))
                Button(
                    onClick = { /* Acción para registrar */ },
                    modifier = Modifier.align(Alignment.CenterHorizontally),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF8aa2d4)
                    )
                ) {
                    Text(
                        text = "Registrar",
                        fontWeight = FontWeight.Bold,
                        fontSize = 24.sp
                    )
                }
                Spacer(modifier = Modifier.height(100.dp))  // Asegúrate de dejar espacio suficiente antes de la imagen
            }
            Image(
                painter = painterResource(id = R.drawable.piepagcontroldia),
                contentDescription = "piepag",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(90.dp)
                    .align(Alignment.BottomCenter)
            )
        }
    }
}

