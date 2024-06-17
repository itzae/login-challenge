# Login Challenge App
Esta aplicación de Android implementa un fake login utilizando Kotlin. Este proyecto es un proceso de inicio de sesión básico en una aplicación Android utilizando Kotlin y componentes de Android como ViewModel, StateFlow  y Jetpack Compose para la interfaz de usuario.

## Características
- Fake login con verificación básica de usuario y contraseña.
- Verificación de formato de correo
- Utiliza Clean Architecture para una separación clara de responsabilidades.
- Pruebas unitarias para el ViewModel.
- Pruebas unitarias para el usecase
- Pruebas instrumentadas

## Capturas de Pantalla


https://github.com/itzae/login-challenge/assets/27383308/1c33fb43-8c30-43e8-aba3-05eef2953608


## Tecnologías Utilizadas
- Kotlin
- Android Jetpack (ViewModel, StateFlow, Compose)
- Navigation compose
- Hilt
  
## Requisitos
- Android Studio 4.2 o superior
- Dispositivo o emulador con Android 5.0 (API nivel 21) o superior

## Ejecución
1.- Clonar el repositorio:

``` bash
git clone https://github.com/tu_usuario/fake-login-app.git
```

Abrir el proyecto en Android Studio:

2.- Abre Android Studio.
- Selecciona File -> Open y navega hasta el directorio donde clonaste el repositorio.
- Selecciona la carpeta del proyecto (login-challenge) y haz clic en OK.

3.- Ejecutar en un dispositivo o emulador:

- Conecta un dispositivo Android o inicia un emulador desde Android Studio.
- Haz clic en el botón Run (icono de reproducción) en Android Studio.
- Selecciona tu dispositivo/emulador y espera a que la aplicación se instale y ejecute.

## Interacción con la aplicación:

- Ingresa el nombre de usuario **test@gmail.com** y contraseña  **PasswordTest123** en la pantalla de login.
- Haz clic en el botón "Ingresar" para simular el proceso de inicio de sesión.
- Observa los diferentes estados (éxito, error o formato invalido de correo) según las credenciales ingresadas.
- Al tener éxito y dar tap en **Continuar** te llevará a la pantalla de home.

## Estructura del Proyecto
El proyecto sigue una estructura básica de Clean Architecture, con los siguientes paquetes principales:

data: Contiene las capas de acceso a datos, como repositorios o fuentes de datos. (En este caso no se utilizó alguna fuente de datos)
domain: Define los casos de uso (use cases) que manejan la lógica de negocio.
presentation: Contiene la lógica de presentación, incluyendo ViewModels y la interfaz de usuario con Jetpack Compose.

## Pruebas
Pruebas Unitarias: Se incluyen pruebas unitarias para el ViewModel utilizando turbine y stateflow para simular el flujo de datos y verificar el comportamiento esperado.

Autor
<a href="https://github.com/itzae">Itzae</a>
