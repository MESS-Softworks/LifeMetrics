package com.example.navigateprojects.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lifemetrics.components.BotonIcono

@Composable
fun DosTarjetas(titulo1: String, numero1: String, titulo2: String, numero2: String) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        MainCard (
            titulo = titulo1,
            numero = numero1,
            modifier = Modifier
                .padding(30.dp)
                .weight(1f)
        )

        SpaceW(10.dp)

        MainCard (
            titulo = titulo2,
            numero = numero2,
            modifier = Modifier
                .padding(30.dp)
                .weight(1f)
        )

    }
}

@Composable
fun MainCard (titulo: String, numero: String, modifier: Modifier = Modifier) {
    Card (
        modifier = modifier,
        colors = CardDefaults.cardColors(containerColor = Color.LightGray)
    ) {
        Column (
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(16.dp)
        ){
            Text(text = titulo, color = Color.Black, fontSize = 20.sp)
            Text(text = "$$numero", color = Color.Black, fontSize = 20.sp)
        }
    }
}

@Composable
fun PersonCard( name: String ) {
    Card (
        modifier = Modifier
            .fillMaxWidth()
            .padding ( horizontal = 10.dp, vertical = 6.dp ),
        colors = CardDefaults.cardColors ( containerColor = Color ( 0xFFB0C1D9 ) )
    ) {
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .height ( 72.dp )
                .padding ( 16.dp ),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text (
                text = name,
                fontSize = 21.sp,
                fontWeight = FontWeight.Bold,
                color = Color ( 0xFF49688D )
            )

            Row {
                // Botón para registrar consumo
                BotonIcono ( Icons.Default.Edit )
                Spacer ( modifier = Modifier.width ( 5.dp ) )

                // Botón para acceder al historial
                BotonIcono ( icono = Icons.Default.DateRange )
                Spacer ( modifier = Modifier.width ( 5.dp ) )

                // Botón para eliminar el usuario
                BotonIcono ( icono = Icons.Default.Delete )
            }
        }
    }
}