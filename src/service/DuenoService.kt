package service

import model.Dueno
import util.solicitarTexto

/**
 * Servicio para gestión de dueños de mascotas
 *
 * @author Rodrigo Sánchez
 * @contact rodrigo@sanchezdev.com
 */

class DuenoService {

    fun registrarDueno(): Dueno {
        println("\n╔═══════════════════════════════════════╗")
        println("║    REGISTRO DE DUEÑO                  ║")
        println("╚═══════════════════════════════════════╝")

        val nombreDueno = solicitarTexto("Nombre del dueño: ")
        val telefono = solicitarTexto("Teléfono (ej: +56912345678): ", "+56912345678")
        val email = solicitarTexto("Correo electrónico: ", "cliente@ejemplo.cl")

        val dueno = Dueno(nombreDueno, telefono, email)

        println("\nDueño registrado:")
        println("   Nombre: ${dueno.nombreDueno}")
        println("   Teléfono: ${dueno.telefono}")
        println("   Email: ${dueno.email}")

        return dueno
    }

    fun mostrarDetallesDueno(dueno: Dueno) {
        println("\n┌─────────────────────────────────────────┐")
        println("│ DATOS DEL DUEÑO                         │")
        println("└─────────────────────────────────────────┘")
        println("  Nombre:    ${dueno.nombreDueno}")
        println("  Teléfono:  ${dueno.telefono}")
        println("  Email:     ${dueno.email}")
    }
}

