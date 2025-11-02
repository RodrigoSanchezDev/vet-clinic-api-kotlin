package util

/**
 * Utilidades para validación de entradas del usuario
 * Incluye manejo robusto de excepciones y valores nulos
 *
 * @author Rodrigo Sánchez
 * @contact rodrigo@sanchezdev.com
 */

/**
 * Solicita texto con manejo seguro de nulos
 * Usa operador ?: para valor por defecto
 */
fun solicitarTexto(mensaje: String, valorPorDefecto: String = ""): String {
    while (true) {
        print(mensaje)
        val entrada = readLine()

        // Operador Elvis ?: para manejar null
        if (entrada.isNullOrBlank()) {
            if (valorPorDefecto.isNotEmpty()) {
                println("Valor por defecto aplicado: $valorPorDefecto")
                return valorPorDefecto
            } else {
                println("❌ El valor no puede estar vacío. Intente nuevamente.")
            }
        } else {
            return entrada.trim()
        }
    }
}

/**
 * Solicita texto opcional (puede ser null)
 * Usa operador Elvis ?: para asignar valor por defecto si es nulo
 */
fun solicitarTextoOpcional(mensaje: String, mensajePorDefecto: String = "Sin información"): String {
    print(mensaje)
    val entrada = readLine()

    // Operador Elvis ?: - Si entrada es null o blank, retorna mensajePorDefecto
    return entrada?.takeIf { it.isNotBlank() }?.trim() ?: mensajePorDefecto
}

/**
 * Solicita entero con try-catch robusto
 */
fun solicitarEntero(mensaje: String, valorPorDefecto: Int? = null): Int {
    while (true) {
        print(mensaje)
        val entrada = readLine()

        try {
            // Operador safe call ?. y Elvis ?:
            return entrada?.toIntOrNull() ?: run {
                if (valorPorDefecto != null) {
                    println("Valor por defecto aplicado: $valorPorDefecto")
                    valorPorDefecto
                } else {
                    println("❌ ERROR: Ingrese un número entero válido")
                    continue
                }
            }
        } catch (e: NumberFormatException) {
            if (valorPorDefecto != null) {
                println("⚠️  Entrada inválida. Valor por defecto aplicado: $valorPorDefecto")
                return valorPorDefecto
            } else {
                println("❌ ERROR: '$entrada' no es un número válido. Intente nuevamente.")
            }
        }
    }
}

/**
 * Solicita entero con manejo robusto de excepciones
 * Muestra mensajes claros al usuario
 */
fun solicitarEnteroSeguro(mensaje: String, valorPorDefecto: Int? = null, rango: IntRange? = null): Int {
    while (true) {
        print(mensaje)
        val entrada = readLine()

        try {
            val numero = entrada?.toIntOrNull()

            if (numero == null) {
                // Usar operador Elvis ?: para valor por defecto
                return valorPorDefecto ?: run {
                    println("❌ ERROR: Debe ingresar un número entero")
                    println("   Valor ingresado: '${entrada ?: "(vacío)"}'")
                    continue
                }
            }

            // Validar rango si se especifica
            if (rango != null && numero !in rango) {
                println("❌ ERROR: El número debe estar entre ${rango.first} y ${rango.last}")
                println("   Valor ingresado: $numero")
                continue
            }

            return numero

        } catch (e: NumberFormatException) {
            println("❌ ERROR: Formato numérico inválido")
            println("   Campo: Número entero")
            println("   Valor ingresado: '$entrada'")
            println("   Ejemplo válido: 25")

            // Usar let solo si valorPorDefecto no es null
            valorPorDefecto?.let {
                println("   Usando valor por defecto: $it")
                return it
            }
        }
    }
}

/**
 * Solicita decimal con try-catch y operadores seguros
 */
fun solicitarDecimal(mensaje: String, valorPorDefecto: Double? = null): Double {
    while (true) {
        print(mensaje)
        val entrada = readLine()

        try {
            // Operador safe call ?. con toDoubleOrNull()
            return entrada?.toDoubleOrNull() ?: run {
                if (valorPorDefecto != null) {
                    println("Valor por defecto aplicado: $valorPorDefecto")
                    valorPorDefecto
                } else {
                    println("❌ ERROR: Ingrese un número decimal válido")
                    continue
                }
            }
        } catch (e: NumberFormatException) {
            println("❌ ERROR: Formato decimal inválido")
            println("   Valor ingresado: '$entrada'")
            println("   Ejemplo válido: 15.5")

            // Usar let para ejecutar solo si no es null
            valorPorDefecto?.let {
                println("   Usando valor por defecto: $it")
                return it
            }
        }
    }
}

/**
 * Solicita decimal con validación de rango
 */
fun solicitarDecimalSeguro(
    mensaje: String,
    valorPorDefecto: Double? = null,
    minimo: Double? = null,
    maximo: Double? = null
): Double {
    while (true) {
        print(mensaje)
        val entrada = readLine()

        try {
            val numero = entrada?.toDoubleOrNull()

            if (numero == null) {
                // Operador Elvis ?: para retornar valor por defecto o continuar
                return valorPorDefecto ?: run {
                    println("❌ ERROR: Debe ingresar un número decimal")
                    continue
                }
            }

            // Validar rango mínimo usando let
            minimo?.let {
                if (numero < it) {
                    println("❌ ERROR: El valor debe ser mayor o igual a $it")
                    return@solicitarDecimalSeguro solicitarDecimalSeguro(mensaje, valorPorDefecto, minimo, maximo)
                }
            }

            // Validar rango máximo usando let
            maximo?.let {
                if (numero > it) {
                    println("❌ ERROR: El valor debe ser menor o igual a $it")
                    return@solicitarDecimalSeguro solicitarDecimalSeguro(mensaje, valorPorDefecto, minimo, maximo)
                }
            }

            return numero

        } catch (e: NumberFormatException) {
            println("❌ ERROR: Formato decimal inválido")
            println("   Valor ingresado: '${entrada ?: "(vacío)"}'")

            // Retornar valor por defecto si existe, sino continuar
            return valorPorDefecto ?: continue
        }
    }
}

/**
 * Valida formato de email (debe contener @ y dominio con punto)
 */
fun validarEmail(email: String?): Boolean {
    // Operador safe call ?. para evitar NullPointerException
    if (email.isNullOrBlank()) return false
    val partes = email.split("@")
    if (partes.size != 2) return false
    if (partes[0].isEmpty() || partes[1].isEmpty()) return false
    return partes[1].contains(".")
}

/**
 * Valida y corrige email con operador Elvis ?:
 * Retorna valor predeterminado si es inválido
 */
fun validarYCorregirEmail(email: String?): String {
    // Operador Elvis ?: para manejar null
    val emailSeguro = email?.trim() ?: ""

    return if (validarEmail(emailSeguro)) {
        emailSeguro
    } else {
        println("⚠️  Email inválido. Usando valor predeterminado: correo@invalido.com")
        "correo@invalido.com"
    }
}

/**
 * Valida email y usa let para ejecutar solo si es válido
 */
fun validarEmailConAccion(email: String?, accion: (String) -> Unit): Boolean {
    // Operador let - solo ejecuta si email no es null y es válido
    return email?.takeIf { validarEmail(it) }?.let { emailValido ->
        accion(emailValido)
        true
    } ?: false
}

fun validarTelefono(telefono: String): Boolean {
    return telefono.replace("+", "").replace(" ", "").all { it.isDigit() }
}

