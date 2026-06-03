# LendlyApp

## Integrantes:
- Matías Varas
- Santiago De Barbieri
- Gonzalo Agustin Gonzalez

## 1 - Nombre y Descripción
**LendlyApp** es una aplicación móvil financiera diseñada para facilitar la gestión de préstamos, compras y servicios bancarios digitales. La aplicación ofrece una experiencia de usuario moderna y segura, permitiendo a los usuarios administrar su flujo de caja, solicitar financiamiento y realizar un seguimiento detallado de sus transacciones financieras desde una interfaz intuitiva.

## 2 - Características Principales / Funcionalidades
*   **Autenticación Segura:** Sistema completo de registro e inicio de sesión con verificación por SMS y validación de identidad.
*   **Gestión de Préstamos:** Funcionalidad para solicitar, visualizar y administrar préstamos activos.
*   **Dashboard Financiero:** Pantalla principal con resumen de saldo, acceso rápido a "Cash In" y movimientos recientes.
*   **Tienda (Shop):** Integración de un marketplace o sección de compras dentro de la app.
*   **Historial de Transacciones:** Registro detallado de todas las actividades financieras realizadas.
*   **Notificaciones:** Sistema de alertas para mantener al usuario informado sobre sus movimientos y estados de cuenta.
*   **Onboarding Dinámico:** Guía introductoria para nuevos usuarios.

## 3 - Tecnologías
El proyecto está desarrollado siguiendo las últimas recomendaciones de Google para el desarrollo en Android:

*   **Lenguaje:** [Kotlin](https://kotlinlang.org/)
*   **UI:** [Jetpack Compose](https://developer.android.com/jetpack/compose) (Arquitectura declarativa)
*   **Navegación:** Compose Navigation
*   **Inyección de Dependencias:** Hilt (Dagger)
*   **Networking:** Retrofit & Gson
*   **Arquitectura:** MVVM (Model-View-ViewModel) con un enfoque en Clean Architecture por módulos de características.

## 4 - Estructura del Proyecto
La estructura del código sigue un patrón organizado por funcionalidades (features) para mejorar la escalabilidad:

```text
app/src/main/java/com/example/parciallendlyapp/
├── components/      # Componentes de UI reutilizables (Botones, Chips, etc.)
├── data/            # Implementación de acceso a datos (API, repositorios y modelos de datos)
│   ├── network/
│   └── repository/
├── di/              # Módulos de Inyección de Dependencias (Hilt)
├── domain/          # Utilidades comunes para la lógica de negocio
├── feature/         # Módulos principales divididos por funcionalidad:
│   ├── auth/        # Login, Registro, Verificación SMS
│   ├── home/        # Dashboard principal y Cash In
│   ├── loans/       # Gestión de préstamos
│   ├── shop/        # Sección de tienda/compras
│   ├── history/     # Historial de movimientos
│   └── ...          # Otras funcionalidades (notifications, onboarding, splash)
├── navigation/      # Configuración de rutas y grafos de navegación
├── ui/              # Definiciones de temas, colores y tipografías (Material 3)
└── MainActivity.kt  # Punto de entrada de la aplicación
```
