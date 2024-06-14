package com.example.animationscompose

import androidx.compose.foundation.interaction.Interaction
import androidx.compose.foundation.interaction.MutableInteractionSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow

/**
 *  MutableInteractionSource: Esta interfaz se utiliza en Jetpack Compose para manejar interacciones,
 *  como clics, gestos de desplazamiento.
 * */
class DisabledInteractionSource : MutableInteractionSource {
    /**
     *  Se anula la propiedad deinteracciones y se asigna un flujo vacio.
     * */
    override val interactions: Flow<Interaction> = emptyFlow()
    /**
     *  Este metodo emite un flujo cuando se tiene una interaccion como un click o un click largo, etc..
     *  en este caso se sobreescribe para no realizar nada en caso de ser seleccionado.
     * */
    override suspend fun emit(interaction: Interaction) {}
    /**
     *  Devuelve true si tiene exito al emitir una interaccion en este caso se sobreescribe para mantenerse en true
     * */
    override fun tryEmit(interaction: Interaction) = true
}