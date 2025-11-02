<div align="center">

# 🏥 Sistema de Gestión de Clínica Veterinaria

![Kotlin](https://img.shields.io/badge/Kotlin-0095D5?style=for-the-badge&logo=kotlin&logoColor=white)
![IntelliJ IDEA](https://img.shields.io/badge/IntelliJ_IDEA-000000.svg?style=for-the-badge&logo=intellij-idea&logoColor=white)
![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Git](https://img.shields.io/badge/GIT-E44C30?style=for-the-badge&logo=git&logoColor=white)
![macOS](https://img.shields.io/badge/macOS-000000?style=for-the-badge&logo=apple&logoColor=white)

### Sistema de consola desarrollado en Kotlin para gestionar una clínica veterinaria en Chile 🇨🇱

Aplicación de línea de comandos que permite registrar mascotas, dueños, consultas, calcular costos en pesos chilenos (CLP), aplicar descuentos y gestionar la agenda de veterinarios.

[Características](#-características) •
[Instalación](#-instalación-y-ejecución) •
[Estructura](#-estructura-del-proyecto) •
[Tecnologías](#-tecnologías-utilizadas) •
[Autor](#-autor)

</div>

---

## 📋 Tabla de Contenidos

- [✨ Características](#-características)
- [🛠️ Tecnologías Utilizadas](#️-tecnologías-utilizadas)
- [🚀 Instalación y Ejecución](#-instalación-y-ejecución)
  - [Opción 1: IntelliJ IDEA (Recomendado)](#opción-1-intellij-idea-recomendado)
  - [Opción 2: Terminal](#opción-2-terminal)
- [📁 Estructura del Proyecto](#-estructura-del-proyecto)
- [🏗️ Arquitectura](#️-arquitectura)
- [💡 Conceptos de Kotlin Implementados](#-conceptos-de-kotlin-implementados)
- [✅ Validaciones](#-validaciones)
- [🔧 Solución de Problemas](#-solución-de-problemas)
- [👤 Autor](#-autor)
- [📄 Licencia](#-licencia)

---

## ✨ Características

### 🆕 Nuevas Funcionalidades (2025)

#### 🏗️ Programación Orientada a Objetos (POO)

##### 🛡️ Manejo Robusto de Excepciones y Nulos

- ✅ **Try-Catch para entradas inválidas**
  - Captura `NumberFormatException` en campos numéricos
  - Mensajes claros al usuario cuando se detecta error
  - Valores por defecto seguros
  
- ✅ **Excepciones de I/O**
  - Try-catch específico para operaciones de entrada/salida
  - Manejo de errores al cargar/guardar datos
  - Logging detallado de errores

- ✅ **Operadores seguros para nulos**
  - `?.` (Safe call): Evita NullPointerException
  - `?:` (Elvis): Asigna valor por defecto si es null
  - `let`: Ejecuta código solo si valor no es null
  - `takeIf`: Retorna valor solo si cumple condición

- ✅ **Campos opcionales (nullables)**
  - `comentariosAdicionales: String?` en Consulta
  - Valor por defecto "Sin comentarios" si es null
  - Validación segura de email antes de enviar
  - SMS solo si teléfono no está vacío

- ✅ **Manejador centralizado de excepciones**
  - Clase `ManejadorExcepciones` para errores consistentes
  - Mensajes informativos y sugerencias al usuario
  - Logging estructurado de errores

##### 📦 Clases y Objetos
- ✅ **Clase Mascota refactorizada**
  - Atributos: nombre, especie, edad, peso, raza, color, sexo
  - Método `mostrarInformacion()`: Retorna información ordenada de la mascota
  - Método `obtenerCategoriaEdad()`: Clasifica por edad (Cachorro/Adulto/Senior)
  - Método `obtenerCategoriaPeso()`: Clasifica por peso según especie
  - Métodos utilitarios: `cumplirAnios()`, `actualizarPeso()`, `necesitaDieta()`

- ✅ **Clase Consulta refactorizada**
  - Método `calcularCostoFinalConDescuento(numeroMascotas)`: Calcula costo con descuento
  - Método `cambiarEstado(nuevoEstado)`: Cambia estado y registra historial
  - Método `generarResumen()`: Genera resumen formateado de la consulta
  - Métodos adicionales: `aplicarDescuentoPersonalizado()`, `aplicarRecargoUrgencia()`, `marcarComoPagada()`, `cancelar()`
  - Atributos calculados: historial de estados, descuento aplicado, costo original

##### 🧬 Herencia y Polimorfismo
- ✅ **Clase base Usuario** (`Usuario.kt`)
  - Atributos comunes: nombre, teléfono, email
  - Método base `mostrarInformacion()`: Puede ser sobreescrito (Polimorfismo)
  - Métodos utilitarios: `validarEmail()`, `obtenerNombreFormateado()`
  - Sobrescritura de `toString()`, `equals()`, `hashCode()`

- ✅ **Clase Veterinario hereda de Usuario**
  - Extiende Usuario con: especialidad, disponible, licenciaProfesional
  - **Polimorfismo**: Sobrescribe `mostrarInformacion()` con formato específico
  - Métodos propios: `cambiarDisponibilidad()`, `obtenerTituloProfesional()`, `puedeAtenderEmergencia()`
  - Companion object con `generarLicencia()`

- ✅ **Clase Dueño hereda de Usuario**
  - Extiende Usuario con: dirección, rut, lista de mascotas
  - **Polimorfismo**: Sobrescribe `mostrarInformacion()` con datos del dueño
  - Métodos propios: `agregarMascota()`, `obtenerMascotas()`, `contarMascotas()`, `tieneMascotas()`
  - Gestión de colección interna de mascotas

#### 🧩 Modularidad y Funciones Reutilizables
- 🔧 **Cálculo de próxima vacunación**: Función que calcula automáticamente la fecha según especie
- 💊 **Determinación de dosis**: Calcula dosis de medicamento según peso y edad
- 📅 **Gestión de fechas**: Funciones modulares para formateo y cálculo de días
- 🔄 **Funciones puras**: Reutilizables sin efectos secundarios

#### 📚 Colecciones Avanzadas
- 🔍 **Filter**: Filtra veterinarios disponibles y libres en horarios específicos
- 🎯 **Find**: Busca veterinarios por especialidad o nombre
- 🗺️ **Map**: Agenda de veterinarios (clave: nombre, valor: lista de citas)
- 📊 **Operaciones**: `sumOf`, `filter`, `find`, `forEach`, `forEachIndexed`

#### 💉 Sistema de Vacunas Inteligente
- 🔄 **Flujos de control con `when`**: Determina automáticamente el plan de vacunación según especie y edad
- 🐕 **Perros**: Vacuna anual (1-7 años), semestral (>7 años)
- 🐱 **Gatos**: Vacuna anual (1-10 años), semestral (>10 años)
- 🐰 **Conejos**: Vacuna semestral (<2 años), anual (>2 años)
- ⚠️ Alertas de vacunación urgente para mascotas jóvenes

#### 📊 Sistema de Arreglos y Reportes
- 📋 **Almacenamiento en arreglos**: Consultas almacenadas en `mutableListOf<ConsultaCompleta>`
- 🔁 **Ciclos for**: Recorrido de todas las consultas para generar informes
- 📈 **Estadísticas en tiempo real**: Total de consultas, ingresos y promedios
- 🎯 **Filtros por estado**: Separación de consultas (Pendiente/Programada/Realizada)
- 📑 **Informes detallados**: Listados completos con datos de dueño, mascota y veterinario

#### ✉️ Validación Avanzada de Email
- ✅ Validación de formato: Debe contener `@` y dominio con punto
- 🔄 Valor predeterminado automático: `correo@invalido.com` para emails inválidos
- 🛡️ Protección contra entradas mal formadas

#### 📝 Plantillas de Strings Mejoradas
- 💬 Interpolación con `$variable` en todos los mensajes
- 🔧 Expresiones con `${expresión}` para cálculos dinámicos
- 💰 Formateo de moneda: `formatearMoneda()` para valores CLP

### 📊 Gestión de Datos

- 🐾 Registro de mascotas con nombre, especie, edad y peso
- 👤 Registro de dueños con nombre, teléfono y email validado
- 📝 Registro de consultas con ID único, descripción, costo y estado
- 👨‍⚕️ Gestión de veterinarios con especialidades
- 💉 Plan de vacunación personalizado por mascota

### 💰 Cálculos y Descuentos

- 💵 Cálculo dinámico de costos según tipo de servicio:
  - **Consulta General**: CLP $25,000
  - **Vacunación**: CLP $15,000
  - **Cirugía Menor**: CLP $80,000
  - **Cirugía Mayor**: CLP $250,000
  - **Emergencia**: CLP $50,000
  - **Control**: CLP $18,000
  - **Desparasitación**: CLP $12,000
- ⏱️ Costo adicional por tiempo: CLP $500 cada 10 minutos después de 30 min
- 🎁 Descuento automático del 15% al atender múltiples mascotas

### 📋 Verificación y Reportes

- ✅ Verificación de disponibilidad de veterinarios
- 📅 Sugerencias de horarios alternativos
- 📊 Resumen completo de consultas con formato profesional
- 📈 Estadísticas globales del sistema
- 🔍 Filtrado de consultas por estado
- 📑 Informes detallados con ciclos for

### 💻 Interfaz de Usuario

- 🖥️ **Aplicación de consola/terminal** con interfaz de línea de comandos
- 📝 Menú principal interactivo con 9 opciones:
  1. Registrar nueva consulta (con cálculo de medicamentos)
  2. Ver informe de todas las consultas
  3. Ver consultas pendientes
  4. Ver consultas programadas
  5. Ver estadísticas del sistema
  6. Ver agenda de veterinarios (Map)
  7. Ver estadísticas de veterinarios
  8. Buscar veterinario por especialidad (find)
  9. Salir
- 🎨 Formato visual profesional con bordes y separadores
- ⌨️ Entrada de datos mediante prompts guiados
- 🔄 Bucle while para navegación continua

---

## 🛠️ Tecnologías Utilizadas

| Tecnología | Uso |
|------------|-----|
| ![Kotlin](https://img.shields.io/badge/Kotlin-0095D5?style=flat-square&logo=kotlin&logoColor=white) | Lenguaje de programación principal |
| ![Java](https://img.shields.io/badge/Java-ED8B00?style=flat-square&logo=openjdk&logoColor=white) | JVM Runtime |
| ![IntelliJ IDEA](https://img.shields.io/badge/IntelliJ_IDEA-000000?style=flat-square&logo=intellij-idea&logoColor=white) | IDE de desarrollo |
| ![Git](https://img.shields.io/badge/Git-F05032?style=flat-square&logo=git&logoColor=white) | Control de versiones |

---

## 🚀 Instalación y Ejecución

### Opción 1: IntelliJ IDEA (Recomendado)

1. **Abrir el proyecto en IntelliJ IDEA**
   - `File` → `Open` → Seleccionar la carpeta del proyecto

2. **Verificar plugin de Kotlin**
   - `Preferences` → `Plugins` → Buscar "Kotlin"
   - Instalar si no está presente

3. **Configurar Project SDK**
   - `File` → `Project Structure` → `Project`
   - Seleccionar Java SDK (recomendado: Java 17 o superior)

4. **Marcar directorio fuente**
   - Click derecho en `src` → `Mark Directory as` → `Sources Root`

5. **Ejecutar la aplicación**
   - Abrir `src/Main.kt`
   - Click en el icono ▶️ (Run) junto a la función `main()`

### Opción 2: Terminal

```bash
# 1. Instalar Kotlin (macOS con Homebrew)
brew install kotlin

# 2. Compilar el proyecto
kotlinc -cp src src/Main.kt src/model/*.kt src/service/*.kt src/util/*.kt -include-runtime -d VetClinica.jar

# 3. Ejecutar la aplicación
java -jar VetClinica.jar
```

---

## 📁 Estructura del Proyecto

```
src/
├── 📂 model/                  # Clases de datos (Data Classes)
│   ├── Usuario.kt            # 🆕 Clase base con herencia (POO)
│   ├── Mascota.kt            # 🔄 Refactorizada con métodos POO
│   ├── Dueno.kt              # 🔄 Hereda de Usuario (Polimorfismo)
│   ├── Consulta.kt           # 🔄 Métodos POO: calcular, cambiar estado, generar resumen
│   ├── Veterinario.kt        # 🔄 Hereda de Usuario (Polimorfismo)
│   └── ConsultaCompleta.kt   # 🆕 Composición de objetos POO
├── 📂 service/                # Lógica de negocio
│   ├── MascotaService.kt     # Gestión de mascotas
│   ├── DuenoService.kt       # Gestión de dueños (con validación de email)
│   ├── ConsultaService.kt    # 🔄 Gestión de consultas, arreglos y estadísticas
│   ├── VeterinarioService.kt # 🔄 Gestión con filter, find y Map de agenda
│   ├── VacunaService.kt      # 🆕 Sistema de vacunas con flujos when
│   └── MedicamentoService.kt # 🆕 Funciones modulares: dosis y vacunación
├── 📂 util/                   # Utilidades y helpers
│   ├── Validaciones.kt       # 🔄 Validación robusta con ?. y ?:
│   ├── Formateo.kt           # Formateo de datos
│   └── ManejadorExcepciones.kt # 🆕 Manejador centralizado de excepciones
└── 📄 Main.kt                 # 🔄 Punto de entrada con menú interactivo
```

**Leyenda:**
- 🆕 = Archivo nuevo
- 🔄 = Archivo modificado con nuevas funcionalidades

---

## 🏗️ Arquitectura

El proyecto sigue una **arquitectura en capas**:

- **📦 Model**: Clases de datos que representan las entidades del dominio
- **⚙️ Service**: Lógica de negocio y operaciones sobre las entidades
- **🔧 Util**: Funciones auxiliares de validación y formateo
- **🎯 Main**: Controlador principal que coordina el flujo de la aplicación

---

## 💡 Conceptos de Kotlin Implementados

### 🎯 Conceptos Fundamentales
- ✅ Variables inmutables (`val`) y mutables (`var`)
- ✅ Data classes para modelado de entidades
- ✅ Inferencia de tipos
- ✅ Null safety con operadores `?` y `?:`
- ✅ String templates para interpolación (`$variable` y `${expresión}`)
- ✅ Funciones con parámetros por defecto
- ✅ Operadores aritméticos y de comparación

### 🆕 Nuevas Implementaciones Avanzadas

#### 🔄 Flujos de Control
- ✅ **When como expresión**: Retorna valores directamente
  ```kotlin
  val vacuna = when (mascota.especie.lowercase()) {
      "perro" -> when { ... }
      "gato" -> when { ... }
      else -> "Consultar"
  }
  ```
- ✅ **When anidado**: Decisiones complejas por especie y edad
- ✅ **If-else como expresión**: Retorno de valores condicionales
- ✅ **Bucles while**: Navegación de menús y validaciones optimizadas

#### 📊 Colecciones y Estructuras de Datos
- ✅ **MutableList**: `mutableListOf<ConsultaCompleta>()`
- ✅ **Ciclos for con índices**: `for (i in lista.indices)`
- ✅ **Ciclos for-each**: `for (elemento in lista)`
- ✅ **withIndex()**: `for ((index, elemento) in lista.withIndex())`
- ✅ **Filtrado manual**: Ciclos for con condiciones

#### 🔧 Funciones y Validaciones
- ✅ **Validación de strings**: Split, contains, isEmpty
- ✅ **Try-catch**: Manejo de NumberFormatException
- ✅ **Valores predeterminados**: Parámetros opcionales
- ✅ **Funciones puras**: Sin efectos secundarios

#### 📝 Strings y Formateo
- ✅ **Plantillas de strings**: Interpolación con `$` y `${}`
- ✅ **String.format()**: Formateo de números con comas
- ✅ **Lowercase()**: Normalización de texto
- ✅ **Trim()**: Limpieza de espacios

---

## ✅ Validaciones

### 🔧 Validaciones Optimizadas
- 🔍 Entrada de texto con manejo de valores vacíos
- 🔢 Conversión segura de tipos numéricos (Int, Double)
- 🛡️ Valores predeterminados para entradas inválidas
- ⚠️ Manejo de excepciones NumberFormatException
- ✔️ Validación de disponibilidad de recursos
- 🔄 **Optimización**: Bucles `while` en lugar de recursividad (evita stack overflow)

### 🆕 Validaciones Avanzadas de Email
- ✉️ **Formato válido**: Debe contener `@` y dominio con punto
- 🔍 **Validación estricta**:
  - ❌ `email-sin-arroba` → `correo@invalido.com`
  - ❌ `test@` → `correo@invalido.com`
  - ❌ `@dominio.com` → `correo@invalido.com`
  - ✅ `juan@ejemplo.cl` → ✅ Email válido
- 🛡️ **Protección automática**: Valor predeterminado para emails mal formados

---

## 📖 Ejemplos de Uso

### 🛡️ Manejo de Excepciones - Try-Catch

```kotlin
// Try-catch para entradas inválidas
fun calcularCostoFinalConDescuento(numeroMascotas: Int): Double {
    return try {
        if (numeroMascotas < 1) {
            throw IllegalArgumentException("El número de mascotas debe ser mayor a 0")
        }
        // ... cálculo del descuento
    } catch (e: IllegalArgumentException) {
        println("❌ ERROR: ${e.message}")
        println("   Usando 1 mascota por defecto")
        costoConsulta  // Valor por defecto
    } catch (e: Exception) {
        println("❌ ERROR inesperado: ${e.message}")
        costoConsulta
    }
}
```

### 🛡️ Operadores Seguros - ?. y ?:

```kotlin
// Operador Elvis ?: para valor por defecto
val comentarios = comentariosAdicionales ?: "Sin comentarios"

// Safe call ?. con takeIf
val emailValido = email?.takeIf { it.contains("@") }

// Operador Elvis con null
val numero = entrada?.toIntOrNull() ?: run {
    println("❌ ERROR: Entrada inválida")
    valorPorDefecto
}
```

### 🛡️ Operador let - Ejecución Condicional

```kotlin
// Enviar email SOLO si es válido (usa let)
dueno.email.takeIf { validarEmail(it) }?.let { emailValido ->
    println("✅ Enviando recordatorio a $emailValido")
    enviarEmail(emailValido)
} ?: println("⚠️  Email inválido, no se enviará recordatorio")

// Enviar SMS SOLO si teléfono existe (usa let)
dueno.telefono.takeIf { it.isNotBlank() }?.let { telefono ->
    println("✅ Enviando SMS a $telefono")
    enviarSMS(telefono)
} ?: println("⚠️  Teléfono vacío, no se enviará SMS")
```

### 🛡️ Campos Opcionales (Nullable)

```kotlin
// Campo opcional en Consulta
class Consulta(
    ...
    val comentariosAdicionales: String? = null  // Puede ser null
)

// Obtener comentarios con operador Elvis
fun obtenerComentarios(): String {
    return comentariosAdicionales ?: "Sin comentarios"
}

// Mostrar en resumen solo si existe (usa let)
val comentariosInfo = comentariosAdicionales?.let {
    "\n   Comentarios:  $it"
} ?: ""  // String vacío si es null
```

### 🛡️ Validaciones Robustas

```kotlin
// Solicitar entero con try-catch y mensajes claros
fun solicitarEnteroSeguro(mensaje: String, rango: IntRange? = null): Int {
    while (true) {
        try {
            val numero = readLine()?.toIntOrNull()
            
            if (numero == null) {
                println("❌ ERROR: Debe ingresar un número entero")
                continue
            }
            
            // Validar rango si se especifica
            if (rango != null && numero !in rango) {
                println("❌ ERROR: Número debe estar entre ${rango.first} y ${rango.last}")
                continue
            }
            
            return numero
        } catch (e: NumberFormatException) {
            println("❌ ERROR: Formato numérico inválido")
            println("   Ejemplo válido: 25")
        }
    }
}
```

### 🏗️ POO - Clase Mascota con métodos

```kotlin
// Crear mascota con constructor mejorado
val mascota = Mascota(
    nombre = "Max",
    especie = "Perro",
    edad = 3,
    peso = 15.5,
    raza = "Golden Retriever",
    color = "Dorado"
)

// Usar método mostrarInformacion() (POO)
println(mascota.mostrarInformacion())
// Salida:
// ╔═══════════════════════════════════════╗
// ║   INFORMACIÓN DE LA MASCOTA           ║
// ╚═══════════════════════════════════════╝
// Nombre:    Max
// Especie:   Perro
// Raza:      Golden Retriever
// Edad:      3 año(s) (Adulto)
// Peso:      15.5 kg (Mediano)
// Color:     Dorado

// Métodos utilitarios
mascota.cumplirAnios()                    // Incrementa edad
mascota.actualizarPeso(16.0)              // Actualiza peso
val categoria = mascota.obtenerCategoriaEdad()  // "(Adulto)"
```

### 🏗️ POO - Clase Consulta con métodos

```kotlin
// Crear consulta
val consulta = Consulta(
    idConsulta = 1234,
    descripcion = "Control anual",
    costoConsulta = 25000.0,
    tipoServicio = "Consulta General"
)

// Método calcularCostoFinalConDescuento() (POO)
consulta.calcularCostoFinalConDescuento(numeroMascotas = 2)
// Salida:
// Descuento aplicado: 15% por atención de múltiples mascotas
//    Descuento:      CLP $3,750
//    Costo original: CLP $25,000
//    Costo final:    CLP $21,250

// Método cambiarEstado() (POO)
consulta.cambiarEstado("Programada")
// Salida: ✅ Estado actualizado: Pendiente → Programada

// Método generarResumen() (POO)
println(consulta.generarResumen())
// Salida:
// ┌─────────────────────────────────────────┐
// │ RESUMEN DE CONSULTA                     │
// └─────────────────────────────────────────┘
// ID:           #1234
// Tipo:         Consulta General
// Descripción:  Control anual
// Estado:       Programada
// Costo:        CLP $21,250
//    Descuento:    CLP $3,750
```

### 🧬 Herencia y Polimorfismo - Usuario base

```kotlin
// Clase base Usuario
open class Usuario(
    val nombre: String,
    val telefono: String,
    val email: String
) {
    open fun mostrarInformacion(): String {
        return "Nombre: $nombre\nTeléfono: $telefono\nEmail: $email"
    }
}

// Veterinario hereda de Usuario y SOBRESCRIBE mostrarInformacion()
class Veterinario(...) : Usuario(nombre, telefono, email) {
    override fun mostrarInformacion(): String {
        return "Dr(a). $nombre\nEspecialidad: $especialidad\n..."
    }
}

// Dueño hereda de Usuario y SOBRESCRIBE mostrarInformacion()
class Dueno(...) : Usuario(nombre, telefono, email) {
    override fun mostrarInformacion(): String {
        return "$nombre\nMascotas: ${mascotas.size}\n..."
    }
}
```

### 🧬 Polimorfismo en acción

```kotlin
// Lista polimórfica de Usuario
val usuarios: List<Usuario> = listOf(
    Veterinario("María González", "+56911111111", "maria@vet.cl", "Cirugía"),
    Dueno("Juan Pérez", "+56922222222", "juan@email.cl")
)

// Cada uno ejecuta SU PROPIA versión de mostrarInformacion()
usuarios.forEach { usuario ->
    println(usuario.mostrarInformacion())  // Polimorfismo!
}
// Salida:
// Dr(a). María González
// Especialidad: Cirugía
// ...
//
// Juan Pérez
// Mascotas: 0
// ...
```

### 🔧 Funciones Modulares - Cálculo de Próxima Vacunación

```kotlin
val medicamentoService = MedicamentoService()

// Función reutilizable que calcula próxima vacunación
val proximaFecha = medicamentoService.calcularProximaVacunacion(
    ultimaVacunacion = "01/01/2025",
    especie = "Perro"
)
// Resultado: 01/01/2026 (12 meses después)

// Formatear fecha
val fechaFormateada = medicamentoService.formatearFecha(proximaFecha)
// Resultado: "01/01/2026"

// Calcular días restantes
val diasRestantes = medicamentoService.calcularDiasHastaVacunacion(proximaFecha)
// Resultado: 61 días
```

### 💊 Funciones Modulares - Determinación de Dosis

```kotlin
// Función que retorna dosis según peso y edad
val dosis = medicamentoService.determinarDosisRecomendada(
    peso = 15.5,
    edad = 3
)

println("Dosis: ${dosis.dosis} ${dosis.unidad}")       // 155.0 mg
println("Frecuencia: ${dosis.frecuencia}")              // Cada 8 horas
println("Observaciones: ${dosis.observaciones}")        // Dosis estándar...
```

### 🔍 Colecciones Avanzadas - FILTER

```kotlin
// Filtrar veterinarios disponibles
val disponibles = veterinarioService.obtenerVeterinariosDisponibles()
// Resultado: Lista de veterinarios con disponible = true

// Filtrar veterinarios libres en horario específico
val libres = veterinarioService.obtenerVeterinariosLibresEnHorario("01/11/2025 10:00")
// Resultado: Lista de veterinarios sin cita en ese horario
```

### 🎯 Colecciones Avanzadas - FIND

```kotlin
// Buscar veterinario por especialidad
val cirujano = veterinarioService.buscarVeterinarioPorEspecialidad("Cirugía")

if (cirujano != null) {
    println("Encontrado: Dr(a). ${cirujano.nombre}")
    // Salida: "Encontrado: Dr(a). Carlos Rojas"
}
```

### 🗺️ Colecciones Avanzadas - MAP (Agenda)

```kotlin
// Map: nombre del veterinario -> lista de citas
val agenda = veterinarioService.obtenerAgendaVeterinario("María González")
// Resultado: ["01/11/2025 10:00", "01/11/2025 14:00"]

// Registrar nueva cita en la agenda
val registrado = veterinarioService.registrarCitaEnAgenda(
    "María González", 
    "02/11/2025 09:00"
)
// Resultado: true (cita registrada)

// Contar total de citas usando sumOf
val totalCitas = veterinarioService.contarTotalCitas()
// Resultado: 4 (suma de todas las citas en el Map)
```

### 💉 Sistema de Vacunas

```kotlin
// Determina automáticamente el plan de vacunación
val mascota = Mascota("Max", "Perro", 3, 15.5)
val vacunaService = VacunaService()

vacunaService.mostrarPlanVacunacion(mascota)
// Salida:
// Frecuencia: Anual
// Vacuna: Anual - Refuerzo + Rabia
```

### 📊 Arreglos y Ciclos FOR

```kotlin
// Generar informe de todas las consultas
consultaService.generarInformeConsultas()

// Salida:
// ┌─────────────── CONSULTA #1 ───────────────┐
// │ Dueño: Juan Pérez
// │ Mascota: Max (Perro)
// │ Motivo: Control general
// │ Costo: CLP $25,000
// └────────────────────────────────────────────┘
```

### 🔍 Filtros por Estado

```kotlin
// Ver solo consultas programadas
consultaService.mostrarConsultasProgramadas()

// Ver solo consultas pendientes
consultaService.mostrarConsultasPendientes()
```

### 📈 Estadísticas del Sistema

```kotlin
consultaService.generarEstadisticas()

// Salida:
// Total de consultas: 10
// Pendientes: 2
// Programadas: 5
// Realizadas: 3
// Ingreso Total: CLP $250,000
// Promedio por consulta: CLP $25,000
```

### ✉️ Validación de Email

```kotlin
// Email válido
val email1 = validarYCorregirEmail("juan@ejemplo.cl")
// Resultado: juan@ejemplo.cl

// Email inválido
val email2 = validarYCorregirEmail("email-sin-arroba")
// Salida: ⚠️ Email inválido. Usando: correo@invalido.com
// Resultado: correo@invalido.com
```

---

## 🧪 Scripts de Prueba

El proyecto incluye scripts de shell para probar todas las funcionalidades:

### `test_validaciones.sh`
Prueba las validaciones optimizadas (bucles while sin recursividad):
```bash
./test_validaciones.sh
```

### `test_completo.sh`
Prueba el flujo básico del sistema:
```bash
./test_completo.sh
```

### `demo_funcionalidades.sh`
Demostración completa de todas las nuevas características:
```bash
./demo_funcionalidades.sh
```

**Resultados esperados:**
- ✅ Sistema de vacunas con when
- ✅ Validación de email con valores predeterminados
- ✅ Arreglos y ciclos for
- ✅ Filtros por estado
- ✅ Estadísticas del sistema

---

---

## 🔧 Solución de Problemas

### ❌ Error: "Kotlin not found" / Comando `kotlinc` no existe
**Solución**: Instalar Kotlin con Homebrew
```bash
brew install kotlin
```

### ❌ Error: "Main function not found"
**Solución**: 
1. Verificar que `Main.kt` contenga `fun main()`
2. Verificar que `src` esté marcado como "Sources Root"
3. Configurar la clase principal en Run Configuration

### ❌ Problemas con importaciones/resolución de símbolos
**Solución**:
1. `File` → `Invalidate Caches / Restart`
2. Asegurar que el Project SDK esté configurado
3. Verificar que `src` esté marcado como "Sources Root"

### 💡 Plugins Recomendados para IntelliJ IDEA

| Plugin | Descripción |
|--------|-------------|
| **Kotlin** | Soporte oficial de Kotlin (obligatorio) |
| **Ktlint** | Análisis de código y estilo |
| **SonarLint** | Calidad de código en tiempo real |
| **Git ToolBox** | Mejoras para Git integration |
| **Rainbow Brackets** | Visualización mejorada de corchetes |

---

## 📝 Historial de Cambios

### 🆕 Versión 5.0 - Noviembre 2025 (Actual) - Robustez y Manejo de Excepciones

#### 🛡️ Manejo Robusto de Excepciones
- ✅ **Try-Catch para entradas inválidas**
  - `calcularCostoFinalConDescuento()` valida número de mascotas
  - `crearConsultaSegura()` valida descripción y costo
  - `solicitarEnteroSeguro()` con validación de rango
  - Mensajes de error claros e informativos

- ✅ **Excepciones de I/O**
  - Try-catch en `enviarRecordatorioEmail()`
  - Try-catch en `enviarRecordatorioSMS()`
  - Manejo robusto de errores de conexión

- ✅ **Manejador Centralizado** (`ManejadorExcepciones.kt`)
  - `manejarErrorNumerico()`: Errores de formato
  - `manejarErrorIO()`: Errores de entrada/salida
  - `manejarErrorGeneral()`: Errores inesperados
  - `ejecutarSeguro()`: Wrapper genérico para try-catch

#### 🔒 Manejo de Valores Nulos
- ✅ **Operadores Seguros**
  - `?.` (Safe call) en todas las validaciones
  - `?:` (Elvis) para valores por defecto
  - `takeIf` para filtrado condicional
  - `let` para ejecución solo si no es null

- ✅ **Campos Opcionales (Nullable)**
  - `comentariosAdicionales: String?` en Consulta
  - `obtenerComentarios()` retorna "Sin comentarios" si es null
  - Validación de email antes de enviar recordatorio
  - Validación de teléfono antes de enviar SMS

- ✅ **Validaciones Mejoradas**
  - `validarEmail(email: String?)` acepta null
  - `validarYCorregirEmail(email: String?)` con Elvis
  - `validarEmailConAccion()` usa let
  - `solicitarTextoOpcional()` para campos opcionales

#### 📧 Envío Seguro de Recordatorios
- ✅ **Email solo si es válido**
  - Uso de `let` para ejecutar solo si email válido
  - Mensaje de advertencia si email es inválido
  - No falla si email es null

- ✅ **SMS solo si existe teléfono**
  - Uso de `takeIf` para validar teléfono no vacío
  - Uso de `let` para enviar solo si es válido
  - Mensaje de advertencia si teléfono vacío

#### Archivos Nuevos
- `src/util/ManejadorExcepciones.kt` - Manejador centralizado

#### Archivos Modificados
- `src/model/Consulta.kt` - Campo opcional `comentariosAdicionales`
- `src/util/Validaciones.kt` - Operadores seguros y let
- `src/service/DuenoService.kt` - Envío seguro con let
- `src/service/ConsultaService.kt` - Try-catch y validaciones
- `README.md` - Documentación completa

### 🆕 Versión 4.0 - Noviembre 2025 - Refactorización POO

#### 🏗️ Programación Orientada a Objetos
- ✅ **Clase base Usuario** (`Usuario.kt`)
  - Herencia para Veterinario y Dueño
  - Atributos comunes: nombre, teléfono, email
  - Método base `mostrarInformacion()` para polimorfismo
  - Métodos: `validarEmail()`, `obtenerNombreFormateado()`

- ✅ **Clase Mascota refactorizada**
  - Método `mostrarInformacion()`: Retorna información ordenada
  - Método `obtenerCategoriaEdad()`: Cachorro/Adulto/Senior
  - Método `obtenerCategoriaPeso()`: Pequeño/Mediano/Grande
  - Métodos: `cumplirAnios()`, `actualizarPeso()`, `necesitaDieta()`

- ✅ **Clase Consulta refactorizada**
  - Método `calcularCostoFinalConDescuento(numeroMascotas)`
  - Método `cambiarEstado(nuevoEstado)` con historial
  - Método `generarResumen()`: Formato profesional
  - Métodos: `aplicarDescuentoPersonalizado()`, `marcarComoPagada()`, `cancelar()`

- ✅ **Herencia y Polimorfismo**
  - `Veterinario` hereda de `Usuario`
  - `Dueno` hereda de `Usuario`
  - Sobrescritura de `mostrarInformacion()` (Polimorfismo)
  - Companion objects y métodos estáticos

#### 🎨 Mejoras de Arquitectura
- ✅ Encapsulación de datos con propiedades privadas
- ✅ Sobrescritura de `toString()`, `equals()`, `hashCode()`
- ✅ Uso de propiedades calculadas (`val esAdulto`, `val esSenior`)
- ✅ Métodos de utilidad específicos por clase

#### Archivos Nuevos
- `src/model/Usuario.kt` - Clase base para herencia

#### Archivos Refactorizados
- `src/model/Mascota.kt` - De data class a clase con métodos POO
- `src/model/Consulta.kt` - De data class a clase con lógica de negocio
- `src/model/Veterinario.kt` - Hereda de Usuario con polimorfismo
- `src/model/Dueno.kt` - Hereda de Usuario con polimorfismo
- `src/service/MascotaService.kt` - Usa método `mostrarInformacion()`
- `src/service/DuenoService.kt` - Usa métodos heredados de Usuario
- `src/Main.kt` - Usa métodos POO de Consulta

### 🆕 Versión 3.0 - Noviembre 2025

#### 🧩 Modularidad y Funciones Reutilizables
- ✅ **MedicamentoService** (`MedicamentoService.kt`)
  - Función `calcularProximaVacunacion()`: Calcula fecha según especie
  - Función `determinarDosisRecomendada()`: Dosis según peso y edad
  - Función `formatearFecha()`: Formateo de fechas LocalDate
  - Función `calcularDiasHastaVacunacion()`: Días restantes
  - Data class `DosisRecomendada`: Encapsula información de dosis

#### 📚 Colecciones Avanzadas
- ✅ **Filter avanzado**
  - `obtenerVeterinariosDisponibles()`: Filtra por disponibilidad
  - `obtenerVeterinariosLibresEnHorario()`: Filtra por horario específico
  
- ✅ **Find para búsquedas**
  - `buscarVeterinarioPorEspecialidad()`: Encuentra primer match
  - `buscarVeterinarioPorNombre()`: Búsqueda por nombre
  
- ✅ **Map para agenda**
  - `mutableMapOf<String, MutableList<String>>`: Agenda por veterinario
  - `registrarCitaEnAgenda()`: Añade citas al Map
  - `obtenerAgendaVeterinario()`: Consulta citas de un veterinario
  - `contarTotalCitas()`: Suma usando `sumOf`

#### 🎨 Mejoras de UI
- ✅ Menú expandido a 9 opciones
- ✅ Opción para calcular medicamento y vacunación
- ✅ Visualización de agenda completa
- ✅ Estadísticas de veterinarios
- ✅ Búsqueda interactiva por especialidad

#### Archivos Nuevos
- `src/service/MedicamentoService.kt`

#### Archivos Modificados
- `src/Main.kt` - Nuevas opciones de menú y funciones modulares
- `src/service/VeterinarioService.kt` - Filter, find y Map de agenda
- `README.md` - Documentación completa de nuevas funcionalidades

### 🆕 Versión 2.0 - Noviembre 2025

#### Nuevas Funcionalidades
- ✅ **Sistema de Vacunas Inteligente** (`VacunaService.kt`)
  - Flujos de control con `when` como expresión
  - Recomendaciones automáticas por especie y edad
  - Alertas de vacunación urgente

- ✅ **Sistema de Arreglos y Reportes** (`ConsultaService.kt`)
  - Almacenamiento en `mutableListOf<ConsultaCompleta>`
  - Ciclos `for` para recorrer consultas
  - Generación de informes detallados
  - Estadísticas en tiempo real

- ✅ **Filtros Avanzados**
  - Filtrado por estado (Pendiente/Programada/Realizada)
  - Agrupación de consultas
  - Listados específicos

- ✅ **Validación de Email Mejorada**
  - Formato estricto (@ y dominio con punto)
  - Valor predeterminado automático
  - Protección contra entradas inválidas

- ✅ **Plantillas de Strings**
  - Uso extensivo de `$variable` y `${expresión}`
  - Formateo profesional de moneda
  - Interpolación en mensajes complejos

#### Optimizaciones
- 🔄 **Validaciones sin recursividad**: Bucles `while` para evitar stack overflow
- 🎨 **Menú interactivo mejorado**: 6 opciones principales
- 📊 **Modelo de datos extendido**: `ConsultaCompleta` con toda la información

#### Archivos Nuevos
- `src/service/VacunaService.kt`
- `src/model/ConsultaCompleta.kt`
- `test_validaciones.sh`
- `test_completo.sh`
- `demo_funcionalidades.sh`
- `IMPLEMENTACION.md`

#### Archivos Modificados
- `src/Main.kt` - Menú interactivo
- `src/service/ConsultaService.kt` - Arreglos y filtros
- `src/service/DuenoService.kt` - Validación de email
- `src/util/Validaciones.kt` - Optimización sin recursividad

### 📦 Versión 1.0 - Octubre 2025
- ✅ Sistema básico de gestión veterinaria
- ✅ Registro de mascotas, dueños y consultas
- ✅ Cálculo de costos y descuentos
- ✅ Gestión de veterinarios y disponibilidad
- ✅ Interfaz de consola

---

<div align="center">

**Rodrigo Sánchez**

[![Email](https://img.shields.io/badge/Email-rodrigo%40sanchezdev.com-D14836?style=for-the-badge&logo=gmail&logoColor=white)](mailto:rodrigo@sanchezdev.com)
[![Website](https://img.shields.io/badge/Website-sanchezdev.com-00C7B7?style=for-the-badge&logo=google-chrome&logoColor=white)](https://sanchezdev.com)
[![GitHub](https://img.shields.io/badge/GitHub-Follow-181717?style=for-the-badge&logo=github&logoColor=white)](https://github.com/rodrigosanchez)

</div>

---

## 📄 Licencia

Este proyecto es de código abierto bajo la licencia MIT.

```
MIT License - © 2025 Rodrigo Sánchez
```

---

<div align="center">

**⭐ Si te gustó este proyecto, dale una estrella en GitHub ⭐**

Hecho con ❤️ y ☕ por [Rodrigo Sánchez](https://sanchezdev.com)

</div>


