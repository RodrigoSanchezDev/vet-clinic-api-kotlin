package util

/**
 * Utilidades para validación de entradas del usuario
 *
 * @author Rodrigo Sánchez
 * @contact rodrigo@sanchezdev.com
 */

fun solicitarTexto(mensaje: String, valorPorDefecto: String = ""): String {
    print(mensaje)
    val entrada = readLine()
    return if (entrada.isNullOrBlank()) {
        if (valorPorDefecto.isNotEmpty()) {
            println("Valor por defecto aplicado: $valorPorDefecto")
            valorPorDefecto
        } else {
            println("El valor no puede estar vacío. Intente nuevamente.")
            solicitarTexto(mensaje, valorPorDefecto)
        }
    } else {
        entrada.trim()
    }
}

fun solicitarEntero(mensaje: String, valorPorDefecto: Int? = null): Int {
    print(mensaje)
    val entrada = readLine()

    return try {
        entrada?.toInt() ?: run {
            if (valorPorDefecto != null) {
                println("Valor por defecto aplicado: $valorPorDefecto")
                valorPorDefecto
            } else {
                println("Entrada inválida. Intente nuevamente.")
                solicitarEntero(mensaje, valorPorDefecto)
            }
        }
    } catch (e: NumberFormatException) {
        if (valorPorDefecto != null) {
            println("Entrada inválida. Valor por defecto aplicado: $valorPorDefecto")
            valorPorDefecto
        } else {
            println("Por favor ingrese un número válido.")
            solicitarEntero(mensaje, valorPorDefecto)
        }
    }
}

fun solicitarDecimal(mensaje: String, valorPorDefecto: Double? = null): Double {
    print(mensaje)
    val entrada = readLine()

    return try {
        entrada?.toDouble() ?: run {
            if (valorPorDefecto != null) {
                println("Valor por defecto aplicado: $valorPorDefecto")
                valorPorDefecto
            } else {
                println("Entrada inválida. Intente nuevamente.")
                solicitarDecimal(mensaje, valorPorDefecto)
            }
        }
    } catch (e: NumberFormatException) {
        if (valorPorDefecto != null) {
            println("Entrada inválida. Valor por defecto aplicado: $valorPorDefecto")
            valorPorDefecto
        } else {
            println("Por favor ingrese un número válido.")
            solicitarDecimal(mensaje, valorPorDefecto)
        }
    }
}

fun validarEmail(email: String): Boolean {
    return email.contains("@") && email.contains(".")
}

fun validarTelefono(telefono: String): Boolean {
    return telefono.replace("+", "").replace(" ", "").all { it.isDigit() }
}

