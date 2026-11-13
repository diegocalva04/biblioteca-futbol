# Validación del proyecto

## Compilación y pruebas

El 13 de noviembre de 2026 se ejecutó `gradlew testDebugUnitTest assembleDebug`. Gradle finalizó correctamente con `BUILD SUCCESSFUL`. La prueba `getBooksSearchesFootballAndLoadsEachVolumeSequentially` verificó la búsqueda con el término `football`, las consultas individuales en orden y la conversión de la miniatura de HTTP a HTTPS.

## Ejecución gráfica

El APK se instaló en el emulador `Reply_Tablet_API_35` y se abrió `MainActivity`. La captura `evidencias/ejecucion-emulador-error.png` muestra el estado de error de carga. En esta ejecución, el emulador no tuvo conectividad de red.

## Servicio Google Books

Una solicitud de comprobación al endpoint oficial respondió HTTP 429 `RESOURCE_EXHAUSTED`. La respuesta indicó cuota diaria configurada en cero para el proyecto asociado a la solicitud. Por ello, no se pudo validar la descarga en vivo de portadas ni presentar resultados bibliográficos como verificados. La aplicación mantiene el flujo de búsqueda y solicitud de detalles requerido por el codelab.
