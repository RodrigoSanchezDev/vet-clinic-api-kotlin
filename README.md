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


### 📊 Gestión de Datos

- 🐾 Registro de mascotas con nombre, especie, edad y peso
- 👤 Registro de dueños con nombre, teléfono y email
- 📝 Registro de consultas con ID único, descripción, costo y estado
- 👨‍⚕️ Gestión de veterinarios con especialidades

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

### 💻 Interfaz de Usuario

- 🖥️ **Aplicación de consola/terminal** con interfaz de línea de comandos
- 📝 Menús interactivos con opciones numéricas
- 🎨 Formato visual profesional con bordes y separadores
- ⌨️ Entrada de datos mediante prompts guiados

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
│   ├── Mascota.kt            # Entidad Mascota
│   ├── Dueno.kt              # Entidad Dueño
│   ├── Consulta.kt           # Entidad Consulta
│   └── Veterinario.kt        # Entidad Veterinario
├── 📂 service/                # Lógica de negocio
│   ├── MascotaService.kt     # Gestión de mascotas
│   ├── DuenoService.kt       # Gestión de dueños
│   ├── ConsultaService.kt    # Gestión de consultas y cálculos
│   └── VeterinarioService.kt # Gestión de veterinarios
├── 📂 util/                   # Utilidades y helpers
│   ├── Validaciones.kt       # Validación de entradas
│   └── Formateo.kt           # Formateo de datos
└── 📄 Main.kt                 # Punto de entrada de la aplicación
```

---

## 🏗️ Arquitectura

El proyecto sigue una **arquitectura en capas**:

- **📦 Model**: Clases de datos que representan las entidades del dominio
- **⚙️ Service**: Lógica de negocio y operaciones sobre las entidades
- **🔧 Util**: Funciones auxiliares de validación y formateo
- **🎯 Main**: Controlador principal que coordina el flujo de la aplicación

---

## 💡 Conceptos de Kotlin Implementados

- ✅ Variables inmutables (`val`) y mutables (`var`)
- ✅ Data classes para modelado de entidades
- ✅ Inferencia de tipos
- ✅ Null safety con operadores `?` y `?:`
- ✅ When expressions para selección múltiple
- ✅ If como expresión que retorna valores
- ✅ Try-catch para manejo de excepciones
- ✅ String templates para interpolación
- ✅ Funciones con parámetros por defecto
- ✅ Operadores aritméticos y de comparación

---

## ✅ Validaciones

- 🔍 Entrada de texto con manejo de valores vacíos
- 🔢 Conversión segura de tipos numéricos (Int, Double)
- 🛡️ Valores predeterminados para entradas inválidas
- ⚠️ Manejo de excepciones NumberFormatException
- ✔️ Validación de disponibilidad de recursos

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


## 👤 Autor

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


