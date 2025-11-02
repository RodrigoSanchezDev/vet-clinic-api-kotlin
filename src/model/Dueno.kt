package model

/**
 * Clase Dueño - Hereda de Usuario
 * Implementa Polimorfismo con métodos sobrescritos
 *
 * @author Rodrigo Sánchez
 * @contact rodrigo@sanchezdev.com
 */
class Dueno(
    nombre: String,
    telefono: String,
    email: String,
    val direccion: String = "",
    val rut: String = ""
) : Usuario(nombre, telefono, email) {

    // Lista de mascotas del dueño
    private val mascotas = mutableListOf<Mascota>()

    /**
     * Polimorfismo: Sobrescribe método de Usuario
     */
    override fun mostrarInformacion(): String {
        return """
            ${obtenerNombreFormateado()}
            Teléfono:  $telefono
            Email:     $email
            ${if (direccion.isNotEmpty()) "Dirección: $direccion" else ""}
            ${if (rut.isNotEmpty()) "RUT:       $rut" else ""}
            Mascotas:  ${mascotas.size}
        """.trimIndent()
    }

    /**
     * Método para agregar mascota al dueño
     */
    fun agregarMascota(mascota: Mascota) {
        mascotas.add(mascota)
    }

    /**
     * Método para obtener todas las mascotas
     */
    fun obtenerMascotas(): List<Mascota> = mascotas.toList()

    /**
     * Método para contar mascotas
     */
    fun contarMascotas(): Int = mascotas.size

    /**
     * Método para verificar si tiene mascotas
     */
    fun tieneMascotas(): Boolean = mascotas.isNotEmpty()

    /**
     * Método para obtener nombres de mascotas
     */
    fun obtenerNombresMascotas(): String {
        return if (mascotas.isEmpty()) {
            "Sin mascotas registradas"
        } else {
            mascotas.joinToString(", ") { it.nombre }
        }
    }

    // Compatibilidad con código existente
    val nombreDueno: String get() = nombre

    override fun toString(): String {
        return "Dueno(nombre='$nombre', email='$email', mascotas=${mascotas.size})"
    }
}

