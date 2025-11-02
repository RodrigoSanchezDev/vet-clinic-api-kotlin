import service.MascotaService
import service.DuenoService
import service.ConsultaService
import service.VeterinarioService
import service.VacunaService
import service.MedicamentoService
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
    val vacunaService = VacunaService()
    val medicamentoService = MedicamentoService()

    var continuar = true

    while (continuar) {
        mostrarMenuPrincipal()
        val opcion = solicitarEntero("\nSeleccione una opción: ", 1)

        when (opcion) {
            1 -> registrarNuevaConsulta(
                mascotaService,
                duenoService,
                consultaService,
                veterinarioService,
                vacunaService,
                medicamentoService
            )
            2 -> consultaService.generarInformeConsultas()
            3 -> consultaService.mostrarConsultasPendientes()
            4 -> consultaService.mostrarConsultasProgramadas()
            5 -> consultaService.generarEstadisticas()
            6 -> veterinarioService.mostrarAgendaCompleta()
            7 -> veterinarioService.mostrarEstadisticasVeterinarios()
            8 -> buscarVeterinarioPorEspecialidad(veterinarioService)
            9 -> {
                println("\n╔═══════════════════════════════════════════════════════════════╗")
                println("║  Gracias por usar el Sistema de Gestión Veterinaria          ║")
                println("╚═══════════════════════════════════════════════════════════════╝\n")
                continuar = false
            }
            else -> println("\n⚠️  Opción inválida. Intente nuevamente.")
        }
    }
}

fun mostrarMenuPrincipal() {
    println("\n╔═══════════════════════════════════════╗")
    println("║         MENÚ PRINCIPAL                ║")
    println("╚═══════════════════════════════════════╝")
    println("1. Registrar nueva consulta")
    println("2. Ver informe de todas las consultas")
    println("3. Ver consultas pendientes")
    println("4. Ver consultas programadas")
    println("5. Ver estadísticas del sistema")
    println("6. Ver agenda de veterinarios")
    println("7. Ver estadísticas de veterinarios")
    println("8. Buscar veterinario por especialidad")
    println("9. Salir")
}

fun registrarNuevaConsulta(
    mascotaService: MascotaService,
    duenoService: DuenoService,
    consultaService: ConsultaService,
    veterinarioService: VeterinarioService,
    vacunaService: VacunaService,
    medicamentoService: MedicamentoService
) {
    // Registrar mascota y dueño
    val mascota = mascotaService.registrarMascota()
    val dueno = duenoService.registrarDueno()

    // Mostrar plan de vacunación (FLUJO DE CONTROL CON WHEN)
    vacunaService.mostrarPlanVacunacion(mascota)

    if (vacunaService.necesitaVacunaUrgente(mascota)) {
        println("\n⚠️  ATENCIÓN: Esta mascota necesita vacunación urgente")
    }

    // NUEVA FUNCIONALIDAD: Información de medicamento y próxima vacunación
    println("\n¿Desea calcular dosis de medicamento y próxima vacunación? (s/n)")
    val calcularMedicamento = solicitarTexto("Respuesta: ", "n")

    if (calcularMedicamento.lowercase() == "s") {
        val ultimaVacunacion = solicitarTexto(
            "Fecha de última vacunación (dd/MM/yyyy): ",
            "01/01/2025"
        )
        medicamentoService.mostrarInformacionMedicamento(mascota, ultimaVacunacion)
    }

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

    // Crear consulta con costo inicial
    val consulta = consultaService.crearConsulta(idConsulta, descripcion, costoInicial, "Pendiente", tipoServicio)

    // Usar método POO de Consulta para calcular descuento
    consulta.calcularCostoFinalConDescuento(numeroMascotas)

    // Asignar veterinario usando COLECCIONES AVANZADAS
    println("\n╔═══════════════════════════════════════╗")
    println("║    ASIGNACIÓN DE VETERINARIO          ║")
    println("╚═══════════════════════════════════════╝")

    // Verificar disponibilidad en horario específico
    val fechaHora = solicitarTexto(
        "\nFecha y hora deseada (ej: 01/11/2025 10:00): ",
        veterinarioService.obtenerFechaHoraSugerida()
    )

    // USAR FILTER: Mostrar veterinarios libres en ese horario
    veterinarioService.mostrarVeterinariosLibresEnHorario(fechaHora)

    veterinarioService.mostrarVeterinariosDisponibles()
    val opcionVet = solicitarEntero("\nSeleccione un veterinario (1-${veterinarioService.getTotalVeterinariosDisponibles()}): ", 1)
    val veterinario = veterinarioService.obtenerVeterinario(opcionVet)

    // Verificar disponibilidad y registrar en AGENDA (MAP)
    val consultaRegistrada = veterinarioService.verificarDisponibilidad(veterinario, fechaHora)

    // Usar método POO de Consulta para cambiar estado
    if (consultaRegistrada) {
        consulta.cambiarEstado("Programada")
    } else {
        consulta.cambiarEstado("Pendiente")
    }

    // REGISTRAR EN ARREGLO DE CONSULTAS
    consultaService.registrarConsultaCompleta(consulta, dueno, mascota, veterinario, fechaHora)

    // Generar resumen (con plantillas de strings)
    consultaService.generarResumen(dueno, mascota, consulta, veterinario, mascotaService, duenoService)

    // Enviar recordatorios
    consultaService.enviarRecordatorios(dueno)

    println("\n✅ Total de consultas en el sistema: ${consultaService.getTotalConsultas()}")
    println("✅ Total de citas agendadas: ${veterinarioService.contarTotalCitas()}")
}

/**
 * Función modular para buscar veterinario por especialidad
 * Usa FIND de colecciones avanzadas
 */
fun buscarVeterinarioPorEspecialidad(veterinarioService: VeterinarioService) {
    println("\n╔═══════════════════════════════════════════════════════════════╗")
    println("║         BUSCAR VETERINARIO POR ESPECIALIDAD                   ║")
    println("╚═══════════════════════════════════════════════════════════════╝")
    println("Especialidades disponibles:")
    println("  - Medicina General")
    println("  - Cirugía")
    println("  - Dermatología")
    println("  - Emergencias")

    val especialidad = solicitarTexto("\nIngrese la especialidad buscada: ", "Medicina General")

    // Usar FIND para buscar
    val veterinario = veterinarioService.buscarVeterinarioPorEspecialidad(especialidad)

    if (veterinario != null) {
        println("\n✅ Veterinario encontrado:")
        println("   Nombre: Dr(a). ${veterinario.nombre}")
        println("   Especialidad: ${veterinario.especialidad}")
        println("   Estado: ${if (veterinario.disponible) "Disponible" else "No disponible"}")

        val agenda = veterinarioService.obtenerAgendaVeterinario(veterinario.nombre)
        println("   Citas agendadas: ${agenda.size}")
        if (agenda.isNotEmpty()) {
            println("   Próximas citas:")
            agenda.take(3).forEach { cita ->
                println("     - $cita")
            }
        }
    } else {
        println("\n⚠️  No se encontró veterinario disponible con esa especialidad")
    }
}
