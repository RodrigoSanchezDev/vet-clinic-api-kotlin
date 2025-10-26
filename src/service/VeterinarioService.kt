package service

import model.Veterinario
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

/**
 * Servicio para gestión de veterinarios y disponibilidad
 *
 * @author Rodrigo Sánchez
 * @contact rodrigo@sanchezdev.com
 */

class VeterinarioService {

    private val veterinarios = listOf(
        Veterinario("María González", "Medicina General", disponible = true),
        Veterinario("Carlos Rojas", "Cirugía", disponible = true),
        Veterinario("Ana Martínez", "Dermatología", disponible = true)
    )

    fun mostrarVeterinariosDisponibles() {
        println("\nVeterinarios disponibles:")
        veterinarios.forEachIndexed { index, vet ->
            println("${index + 1}. Dr(a). ${vet.nombre} - ${vet.especialidad}")
        }
    }

    fun obtenerVeterinario(opcion: Int): Veterinario {
        return when (opcion) {
            1 -> veterinarios[0]
            2 -> veterinarios[1]
            3 -> veterinarios[2]
            else -> veterinarios[0]
        }
    }

    fun verificarDisponibilidad(
        veterinario: Veterinario,
        fechaHoraSolicitada: String
    ): Boolean {
        println("\n╔═══════════════════════════════════════╗")
        println("║    VERIFICACIÓN DE DISPONIBILIDAD     ║")
        println("╚═══════════════════════════════════════╝")

        println("Veterinario: ${veterinario.nombre}")
        println("Especialidad: ${veterinario.especialidad}")
        println("Fecha y hora solicitada: $fechaHoraSolicitada")

        val resultado = if (veterinario.disponible) {
            println("\nVeterinario disponible")
            println("Consulta registrada en la agenda del Dr(a). ${veterinario.nombre}")
            true
        } else {
            println("\nVeterinario NO disponible")
            println("Sugerencia: Por favor seleccione una nueva fecha y hora")
            println("   Horarios sugeridos:")
            println("   - Mañana a las 10:00 hrs")
            println("   - Mañana a las 15:30 hrs")
            println("   - Pasado mañana a las 09:00 hrs")
            false
        }

        return resultado
    }

    fun obtenerFechaHoraSugerida(): String {
        return LocalDateTime.now()
            .plusDays(1)
            .format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"))
    }
}

