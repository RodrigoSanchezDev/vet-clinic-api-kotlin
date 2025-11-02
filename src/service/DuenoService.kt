package service

import model.Dueno
import util.solicitarTexto
import util.validarYCorregirEmail
import util.validarEmail

/**
 * Servicio para gestión de dueños de mascotas
 * Incluye manejo robusto de excepciones y nulos
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
        val emailIngresado = solicitarTexto("Correo electrónico: ", "cliente@ejemplo.cl")
        val email = validarYCorregirEmail(emailIngresado)

        val dueno = Dueno(nombreDueno, telefono, email)

        println("\nDueño registrado:")
        println("   Nombre: ${dueno.nombreDueno}")
        println("   Teléfono: ${dueno.telefono}")
        println("   Email: ${dueno.email}")

        return dueno
    }

    /**
     * Envía recordatorio solo si el email es válido
     * Usa let para ejecutar acción solo si no es null y es válido
     */
    fun enviarRecordatorioEmail(dueno: Dueno, mensaje: String): Boolean {
        // Operador let - solo ejecuta si email es válido
        return dueno.email.takeIf { validarEmail(it) }?.let { emailValido ->
            try {
                println("\n📧 Enviando recordatorio por email...")
                println("   Destinatario: $emailValido")
                println("   Mensaje: $mensaje")
                println("✅ Email enviado exitosamente")
                true
            } catch (e: Exception) {
                println("❌ ERROR al enviar email: ${e.message}")
                false
            }
        } ?: run {
            println("⚠️  No se puede enviar email. Email inválido: ${dueno.email}")
            false
        }
    }

    /**
     * Envía recordatorio por SMS con manejo de excepciones
     */
    fun enviarRecordatorioSMS(dueno: Dueno, mensaje: String): Boolean {
        return try {
            // Operador safe call ?. para validar teléfono
            dueno.telefono.takeIf { it.isNotBlank() }?.let { telefonoValido ->
                println("\n📱 Enviando recordatorio por SMS...")
                println("   Destinatario: $telefonoValido")
                println("   Mensaje: $mensaje")
                println("✅ SMS enviado exitosamente")
                true
            } ?: run {
                println("⚠️  No se puede enviar SMS. Teléfono vacío")
                false
            }
        } catch (e: Exception) {
            println("❌ ERROR al enviar SMS: ${e.message}")
            false
        }
    }

    fun mostrarDetallesDueno(dueno: Dueno) {
        println("\n┌─────────────────────────────────────────┐")
        println("│ DATOS DEL DUEÑO                         │")
        println("└─────────────────────────────────────────┘")
        // Usar método POO de la clase Usuario (heredado por Dueno)
        println(dueno.mostrarInformacion().prependIndent("  "))
    }
}

