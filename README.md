# Biblioteca Fútbol

Aplicación Android de consulta bibliográfica sobre fútbol. Realiza una búsqueda en Google Books, consulta los detalles de cada volumen por identificador y presenta los títulos y las miniaturas disponibles en una cuadrícula adaptable.

## Tecnologías

- Kotlin y Jetpack Compose
- Retrofit y Gson para las solicitudes REST y la lectura JSON
- Corrutinas para las operaciones de red
- Repositorio e inyección manual de dependencias
- ViewModel para los estados de carga, éxito y error
- Coil `AsyncImage` para las portadas
- JUnit y un servicio falso para la prueba local del repositorio

## Funcionamiento

Al iniciar, la aplicación busca libros con el término estable `soccer`. El repositorio obtiene la lista de identificadores y solicita los detalles individuales secuencialmente. La pantalla muestra el título y, si existe, la miniatura. Los enlaces de portada `http` se normalizan a `https`; los libros sin imagen no detienen la cuadrícula. La interfaz presenta estados de carga y error cuando la respuesta no puede obtenerse.

## Estructura principal

- `network/`: modelos de respuesta y endpoints Retrofit de Google Books.
- `data/`: modelo de dominio, repositorio y contenedor de dependencias.
- `ui/`: ViewModel, estados y pantalla Compose.
- `app/src/test/`: servicio falso y prueba unitaria del repositorio.
- `docs/evidencias/`: captura auténtica del estado de ejecución validado.

## Compilar y ejecutar

Se requiere Android Studio con Android SDK 36 y un JDK compatible con Gradle 8.13. Abre la carpeta `BibliotecaFutbol` en Android Studio y espera la sincronización de Gradle. Desde PowerShell, también se puede ejecutar:

```powershell
.\gradlew.bat testDebugUnitTest assembleDebug
```

El APK de depuración queda en `app\build\outputs\apk\debug\app-debug.apk`. La aplicación requiere conectividad a Internet para consultar Google Books.

## Validación registrada

La compilación del APK y la prueba unitaria `testDebugUnitTest` finalizaron correctamente. El APK se instaló y se abrió en un emulador Android. En la sesión documentada, el emulador no tuvo ruta de red y Google Books respondió HTTP 429 `RESOURCE_EXHAUSTED` en la consulta realizada desde el equipo, indicando cuota diaria cero para el proyecto asociado. Por ello, la captura incluida documenta el estado de error y no se afirma que se hayan cargado títulos o portadas desde el servicio real. La validación en vivo depende de disponer de conectividad y cuota de API habilitada.

## Repositorio

Código fuente e historial de cambios: <https://github.com/diegocalva04/biblioteca-futbol>
