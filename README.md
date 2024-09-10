# API Test Automation for PetStore

Este proyecto realiza pruebas automatizadas para la API de PetStore. Utiliza Serenity BDD con Cucumber para crear pruebas automatizadas que cubren las funcionalidades de gestión de usuarios, órdenes y mascotas en la API de PetStore.

## Características

- **Gestión de Usuarios**: Crear, consultar, actualizar y eliminar usuarios.
- **Gestión de Órdenes**: Crear, consultar y eliminar órdenes.
- **Gestión de Mascotas**: Crear, consultar, actualizar y eliminar mascotas.
- **Pruebas masivas**: Se incluyen pruebas masivas para crear, actualizar, consultar y eliminar usuarios y mascotas.

## Requisitos

Antes de ejecutar el proyecto, asegúrate de tener lo siguiente instalado:

- [Java JDK 8+](https://www.oracle.com/java/technologies/javase-jdk8-downloads.html)
- [Maven](https://maven.apache.org/install.html)
- [IntelliJ IDEA](https://www.jetbrains.com/idea/download) o cualquier otro IDE compatible con Java y Maven

## Estructura del Proyecto

```bash
src
│
└───test
    ├───java
    │   └───petStore
    │       ├───runner      # Archivos de configuración del Runner para las pruebas de Cucumber
    │       ├───steps       # Definición de pasos para las pruebas de usuario, orden y mascotas
    │       └───stepsDefs   # Step definitions de Cucumber
    └───resources
        └───features        # Archivos .feature que describen los escenarios de prueba
```
## Archivos .feature
Cada archivo .feature contiene escenarios de prueba para las siguientes áreas:

1. Usuarios: Crear, consultar, actualizar y eliminar usuarios, incluyendo pruebas masivas.
2. Store: Crear, consultar y eliminar órdenes de la tienda.
3. Mascotas: Crear, consultar, actualizar y eliminar mascotas, incluyendo pruebas masivas.

Ejemplo de Escenario
```bash
Feature: Gestión de órdenes en PetStore

  @crearOrden
  Scenario Outline: Crear una nueva orden en PetStore
    Given que el API de PetStore está disponible
    When creo una orden con id "<id>", petId "<petId>", quantity "<quantity>", shipDate "<shipDate>", status "<status>", complete "<complete>"
    Then el código de respuesta para la tienda es 200
    And el estado de la orden es placed "<status>"

    Examples:
      | id  | petId | quantity | shipDate             | status | complete |
      | 90  | 4     | 5        | 2024-08-24T14:15:22Z | placed | true     |
      | 91  | 2     | 2        | 2024-08-23T14:15:22Z | placed | true     |
```

## Configuración y Ejecución

### 1. Clonar el repositorio

```bash
git clone https://github.com/margotvargas/petstore-api-test-automation.git
```
### 2. Importar el proyecto en IntelliJ IDEA

```bash
1. Abrir IntelliJ IDEA.
2. Seleccionar **Open** y elegir la carpeta del proyecto clonado.
3. Esperar a que el IDE configure el entorno automáticamente (descargar dependencias de Maven).
```
### 3. Ejecución de pruebas

#### A. Desde IntelliJ IDEA

```bash
1. Navegar a la clase `CucumberTestSuite` en el paquete `petStore.runner`.
2. Colocar los tag que quieres probar.
3. Hacer clic derecho en la clase y seleccionar **Run 'CucumberTestSuite'**.
```

#### B. Ejecutar pruebas específicas por etiquetas

Para ejecutar pruebas con un tag específico (ejemplo: `@crearMascota`), usar el siguiente comando en la terminal:
```bash
mvn clean verify -Dcucumber.options="--tags @crearMascota"
```

### 4. Generación de reportes
Después de ejecutar las pruebas, Serenity generará un reporte detallado en el directorio target/site/serenity. 
Abre el archivo index.html en un navegador para ver los resultados.


## Autor
Desarrollado por Margot Vargas como parte del programa Tech Girl Power en colaboración con NTT Data.