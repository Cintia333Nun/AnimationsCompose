package com.example.animationscompose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Tab
import androidx.compose.material3.TabPosition
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex

/**
 *  Se compone una columna con el menu superior  que ocupe el ancho disponible.
 *  Se personaliza TabRow:
 *      Para que contenga un indicator redondeado y morado.
 *      Se hace referencia a la pestaña actual.
 *      Se personalizan los colores del menu
 *      Se agrega padding y aaltura predeterminada
 *      Se agrega forma redondeada
 *  Se personaliza Tab:
 *      Contenga el titulo
 *      Mostrar la pestaña seleccionada
 *      Se cancelan los gestos de la pestaña
 *      Se agrega una forma redondeada, se agrega un padding de 3
 *      Se sobreescribe el onCLickListener
 * */
@Composable
fun TabLayout() {
    var tabIndex by remember { mutableIntStateOf(0) }
    val tabs = listOf("Splash", "Buttons")
    val indicator = @Composable { tabPositions: List<TabPosition> ->
        RoundedIndicator(
            Modifier.tabIndicatorOffset(tabPositions[tabIndex])
        )
    }

    Column(
        modifier = Modifier.fillMaxWidth(),
    ) {
        TabRow(
            selectedTabIndex = tabIndex,
            indicator = indicator,
            contentColor = colorResource(id = R.color.white),
            containerColor = colorResource(id = R.color.layout_background),
            divider = {},
            modifier = Modifier
                .padding(8.dp)
                .height(45.dp)
                .clip(
                    shape = RoundedCornerShape(20.dp)
                )
        ) {
            tabs.forEachIndexed{index, title ->
                Tab(
                    text = { Text(title, fontWeight = FontWeight.Bold) },
                    selected = tabIndex== index,
                    interactionSource = DisabledInteractionSource(),
                    modifier = Modifier
                        .clip(shape = RoundedCornerShape(20.dp))
                        .padding(bottom = 3.dp)
                        .zIndex(2f),
                    onClick = { tabIndex = index }
                )
            }
        }
    }
}

/**
 * Corresponde al indicador redondeado personalizado de la pestaña.
 * */
@Composable
fun RoundedIndicator(modifier: Modifier = Modifier) {
    Column(
        modifier
            .fillMaxSize()
            .padding(5.dp)
            .background(
                colorResource(id = R.color.purple_500),
                RoundedCornerShape(20.dp),
            ),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
    }
}