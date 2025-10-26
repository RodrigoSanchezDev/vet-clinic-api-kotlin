package model

/**
 * Representa un veterinario del sistema
 */
data class Veterinario(
    val nombre: String,
    val especialidad: String,
    var disponible: Boolean = true
)

