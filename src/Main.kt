import service.MascotaService
import service.DuenoService
import service.ConsultaService
import service.VeterinarioService
import util.solicitarTexto
import util.solicitarEntero

/**
 * Sistema de Gestión de Clínica Veterinaria
 * Punto de entrada principal de la aplicación
 *
 * @author Rodrigo Sánchez
 * @contact rodrigo@sanchezdev.com
 * @website sanchezdev.com
 */

fun main() {
    println("╔═══════════════════════════════════════════════════════════════╗")
    println("║                                                               ║")
    println("║       SISTEMA DE GESTIÓN DE CLÍNICA VETERINARIA               ║")
    println("║              Santiago, Chile                                  ║")
    println("║                                                               ║")
    println("╚═══════════════════════════════════════════════════════════════╝")

    // Inicializar servicios
    val mascotaService = MascotaService()
    val duenoService = DuenoService()
    val consultaService = ConsultaService()
    val veterinarioService = VeterinarioService()

    // Registrar mascota y dueño
    val mascota = mascotaService.registrarMascota()
    val dueno = duenoService.registrarDueno()

    // Registrar consulta
    println("\n╔═══════════════════════════════════════╗")
    println("║    REGISTRO DE CONSULTA               ║")
    println("╚═══════════════════════════════════════╝")

    val idConsulta = consultaService.generarIdConsulta()

    consultaService.mostrarTiposServicio()
    val opcionServicio = solicitarEntero("\nSeleccione el tipo de servicio (1-7): ", 1)
    val tipoServicio = consultaService.obtenerNombreServicio(opcionServicio)

    val descripcion = solicitarTexto("Descripción del motivo de la visita: ", tipoServicio)
    val tiempoEstimado = solicitarEntero("Tiempo estimado de atención (en minutos): ", 30)

    // Calcular costo y aplicar descuento
    val numeroMascotas = solicitarEntero("\n¿Cuántas mascotas serán atendidas en esta consulta? ", 1)
    val costoInicial = consultaService.calcularCostoConsulta(tipoServicio, tiempoEstimado)
    val costoFinal = consultaService.aplicarDescuento(costoInicial, numeroMascotas)

    val consulta = consultaService.crearConsulta(idConsulta, descripcion, costoFinal)

    // Asignar veterinario
    println("\n╔═══════════════════════════════════════╗")
    println("║    ASIGNACIÓN DE VETERINARIO          ║")
    println("╚═══════════════════════════════════════╝")

    veterinarioService.mostrarVeterinariosDisponibles()
    val opcionVet = solicitarEntero("\nSeleccione un veterinario (1-3): ", 1)
    val veterinario = veterinarioService.obtenerVeterinario(opcionVet)

    // Verificar disponibilidad
    val fechaHora = solicitarTexto(
        "\nFecha y hora deseada (ej: 27/10/2025 10:00): ",
        veterinarioService.obtenerFechaHoraSugerida()
    )

    val consultaRegistrada = veterinarioService.verificarDisponibilidad(veterinario, fechaHora)

    if (consultaRegistrada) {
        consulta.estado = "Programada"
    } else {
        consulta.estado = "Pendiente de Reprogramación"
    }

    // Generar resumen
    consultaService.generarResumen(dueno, mascota, consulta, veterinario, mascotaService, duenoService)

    // Enviar recordatorios
    consultaService.enviarRecordatorios(dueno)
}

