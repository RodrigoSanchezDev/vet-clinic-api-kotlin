package util

/**
 * Utilidades para formateo de datos
 *
 * @author Rodrigo Sánchez
 * @contact rodrigo@sanchezdev.com
 */

fun formatearMoneda(monto: Double): String {
    return "CLP $${String.format("%,.0f", monto)}"
}

fun formatearTelefono(telefono: String): String {
    return if (telefono.startsWith("+56")) {
        telefono
    } else {
        "+56$telefono"
    }
}

