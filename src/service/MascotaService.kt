package service

import model.Mascota
import util.solicitarTexto
import util.solicitarEntero
import util.solicitarDecimal

/**
 * Servicio para gestión de mascotas
 *
 * @author Rodrigo Sánchez
 * @contact rodrigo@sanchezdev.com
 */

class MascotaService {

    fun registrarMascota(): Mascota {
        println("\n╔═══════════════════════════════════════╗")
        println("║    REGISTRO DE NUEVA MASCOTA          ║")
        println("╚═══════════════════════════════════════╝")

        val nombre = solicitarTexto("Nombre de la mascota: ")
        val especie = solicitarTexto("Especie (Perro/Gato/Conejo/etc.): ", "Perro")
        val edad = solicitarEntero("Edad (en años): ", 0)
        val peso = solicitarDecimal("Peso (en kg): ", 0.0)

        val mascota = Mascota(nombre, especie, edad, peso)

        println("\nMascota registrada:")
        println("   Nombre: ${mascota.nombre}")
        println("   Especie: ${mascota.especie}")
        println("   Edad: ${mascota.edad} año(s)")
        println("   Peso: ${mascota.peso} kg")

        return mascota
    }

    fun mostrarDetallesMascota(mascota: Mascota) {
        // Usar método POO de la clase Mascota
        println(mascota.mostrarInformacion())
    }
}
