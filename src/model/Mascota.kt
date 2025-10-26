package model

/**
 * Representa una mascota registrada en el sistema
 */
data class Mascota(
    val nombre: String,
    val especie: String,
    val edad: Int,
    val peso: Double
)

