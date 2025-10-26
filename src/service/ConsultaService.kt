package service

import model.Consulta
import model.Dueno
import model.Mascota
import model.Veterinario
import util.solicitarTexto
import util.solicitarEntero
import util.formatearMoneda

/**
 * Servicio para gestión de consultas veterinarias
 *
 * @author Rodrigo Sánchez
 * @contact rodrigo@sanchezdev.com
 */

class ConsultaService {

    private val tiposServicio = mapOf(
        1 to Pair("Consulta General", 25000.0),
        2 to Pair("Vacunación", 15000.0),
        3 to Pair("Cirugía Menor", 80000.0),
        4 to Pair("Cirugía Mayor", 250000.0),
        5 to Pair("Emergencia", 50000.0),
        6 to Pair("Control", 18000.0),
        7 to Pair("Desparasitación", 12000.0)
    )

    fun mostrarTiposServicio() {
        println("\nTipos de servicio disponibles:")
        tiposServicio.forEach { (key, value) ->
            println("$key. ${value.first}")
        }
    }

    fun calcularCostoConsulta(tipoServicio: String, tiempoMinutos: Int): Double {
        val costoBase = when (tipoServicio.lowercase()) {
            "consulta general" -> 25000.0
            "vacunación" -> 15000.0
            "cirugía menor" -> 80000.0
            "cirugía mayor" -> 250000.0
            "emergencia" -> 50000.0
            "control" -> 18000.0
            "desparasitación" -> 12000.0
            else -> 20000.0
        }

        val costoTiempo = if (tiempoMinutos > 30) {
            ((tiempoMinutos - 30) / 10) * 500.0
        } else {
            0.0
        }

        return costoBase + costoTiempo
    }

    fun aplicarDescuento(costo: Double, numeroMascotas: Int): Double {
        return if (numeroMascotas > 1) {
            val descuento = costo * 0.15
            val costoFinal = costo - descuento
            println("\nDescuento aplicado: 15% por atención de múltiples mascotas")
            println("   Descuento: ${formatearMoneda(descuento)}")
            println("   Costo original: ${formatearMoneda(costo)}")
            println("   Costo final: ${formatearMoneda(costoFinal)}")
            costoFinal
        } else {
            costo
        }
    }

    fun obtenerNombreServicio(opcion: Int): String {
        return tiposServicio[opcion]?.first ?: "Consulta General"
    }

    fun crearConsulta(
        idConsulta: Int,
        descripcion: String,
        costoFinal: Double,
        estado: String = "Pendiente"
    ): Consulta {
        return Consulta(
            idConsulta = idConsulta,
            descripcion = descripcion,
            costoConsulta = costoFinal,
            estado = estado
        )
    }

    fun generarIdConsulta(): Int {
        return (1000..9999).random()
    }

    fun generarResumen(
        dueno: Dueno,
        mascota: Mascota,
        consulta: Consulta,
        veterinario: Veterinario,
        mascotaService: MascotaService,
        duenoService: DuenoService
    ) {
        println("\n")
        println("╔═══════════════════════════════════════════════════════════════╗")
        println("║                  RESUMEN DE LA CONSULTA                       ║")
        println("╠═══════════════════════════════════════════════════════════════╣")
        println("║  CLÍNICA VETERINARIA - SANTIAGO, CHILE                        ║")
        println("╚═══════════════════════════════════════════════════════════════╝")

        duenoService.mostrarDetallesDueno(dueno)
        mascotaService.mostrarDetallesMascota(mascota)

        println("\n┌─────────────────────────────────────────┐")
        println("│ DETALLES DE LA CONSULTA                 │")
        println("└─────────────────────────────────────────┘")
        println("  ID Consulta: #${consulta.idConsulta}")
        println("  Motivo:      ${consulta.descripcion}")
        println("  Veterinario: Dr(a). ${veterinario.nombre}")
        println("  Especialidad: ${veterinario.especialidad}")
        println("  Costo:       ${formatearMoneda(consulta.costoConsulta)}")
        println("  Estado:      ${consulta.estado}")

        println("\n╔═══════════════════════════════════════════════════════════════╗")
        println("║  GRACIAS POR CONFIAR EN NOSOTROS                              ║")
        println("║  Recordatorio: Recibirá un email con los detalles            ║")
        println("╚═══════════════════════════════════════════════════════════════╝\n")
    }

    fun enviarRecordatorios(dueno: Dueno) {
        println("Se enviará un recordatorio a ${dueno.email} 24 horas antes de la cita.")
        println("También recibirá un SMS al número ${dueno.telefono}\n")
    }
}

