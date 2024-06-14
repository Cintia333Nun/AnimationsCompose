package com.example.animationscompose

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.TabPosition
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.platform.debugInspectorInfo

/**
 *  Esta función extiende Modifier para crear un modificador personalizado llamado tabIndicatorOffset.
 *  Este modificador se utiliza para animar la posición y el ancho del indicador de una pestaña
 * */
fun Modifier.tabIndicatorOffset(
    currentTabPosition: TabPosition
): Modifier = composed(
    /**
     * composed es una función de composición que permite crear un modificador personalizado.
     * inspectorInfo se utiliza para proporcionar información de depuración
     * */
    inspectorInfo = debugInspectorInfo {
        name = "tabIndicatorOffset"
        value = currentTabPosition
    }
) {
    /**
     *  Se utiliza para animar el ancho de la pestaña (currentTabWidth).
     *  La animación dura 250 milisegundos y utiliza una interpolación FastOutSlowInEasing.
     * */
    val currentTabWidth by animateDpAsState(
        targetValue = currentTabPosition.width,
        animationSpec = tween(durationMillis = 250, easing = FastOutSlowInEasing), label = ""
    )
    /**
     *  Se utiliza para animar el desplazamiento horizontal del indicador (indicatorOffset).
     *  También dura 250 milisegundos con la misma interpolación.
     * */
    val indicatorOffset by animateDpAsState(
        targetValue = currentTabPosition.left,
        animationSpec = tween(durationMillis = 250, easing = FastOutSlowInEasing), label = ""
    )
    /**
     *  fillMaxWidth(): El indicador ocupará todo el ancho disponible.
     *  wrapContentSize(Alignment.BottomStart): El contenido se alineará en la parte inferior izquierda.
     *  offset(x = indicatorOffset): Se desplaza horizontalmente según el valor de indicatorOffset.
     *  width(currentTabWidth): Establece el ancho del indicador según el valor de currentTabWidth.
     * */
    fillMaxWidth()
        .wrapContentSize(Alignment.BottomStart)
        .offset(x = indicatorOffset)
        .width(currentTabWidth)
}