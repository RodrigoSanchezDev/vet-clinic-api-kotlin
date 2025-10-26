package model

/**
 * Representa una consulta veterinaria
 */
data class Consulta(
    val idConsulta: Int,
    val descripcion: String,
    var costoConsulta: Double,
    var estado: String
)

