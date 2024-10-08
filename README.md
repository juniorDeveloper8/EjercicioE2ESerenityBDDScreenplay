# Ejercicio de Automatización E2E con Serenity BDD

Este ejercicio realiza pruebas funcionales automatizadas (E2E) de un flujo de compra en la
página [https://www.demoblaze.com/](https://www.demoblaze.com/) utilizando Serenity BDD con Screenplay en Java y Maven.

## Prerequisitos

Antes de ejecutar las pruebas, asegúrate de tener configurado lo siguiente en tu máquina local:

|                                                                               **IntelliJ**                                                                                |                                                              **Java**                                                               |                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                      **Maven**                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                      |
|:-------------------------------------------------------------------------------------------------------------------------------------------------------------------------:|:-----------------------------------------------------------------------------------------------------------------------------------:|:---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------:|
| [<img width="50" height="50" src="https://cdn.iconscout.com/icon/free/png-128/intellij-idea-569199.png">](https://www.jetbrains.com/es-es/idea/download/#section=windows) | [<img height="60" src="https://www.oracle.com/a/ocom/img/cb71-java-logo.png">](https://www.oracle.com/java/technologies/downloads/) | [<img height="50" src="https://logowik.com/content/uploads/images/maven-apache3537.jpg">](https://maven.apache.org/) |

> **NOTA**:
>

- **Sistema Operativo:** Windows 11
- **IDE:** IntelliJ IDEA versión Community 2024
- **Maven:** versión 3.9.8 (debe estar en la variable de entorno)
- **JDK:** versión 17 (debe estar en la variable de entorno)
- **Serenity BDD:** versión 3.9.8 (especificada en el archivo `pom.xml`)
- **ChromeDriver:** Asegúrate de tener el driver de Chrome compatible con la versión del navegador que estás usando. El
  archivo `chromedriver.exe` se encuentra en `src/test/resources/webdriver/chromedriver.exe`.

## Comandos de instalación

- Clona el repositorio y navega a la carpeta del proyecto:

```markdown
git clone https://github.com/juniorDeveloper8/EjercicioE2ESerenityBDDScreenplay.git
```

### (SOLO SI ES NECESARIO)

- Instala las dependencias del proyecto:
  ```markdown
  mvn install
  ```

- Compilar el proyecto y limpiar:**
    ```markdown
      mvn clean compile
  ```

## Instrucciones para Ejecutar las Pruebas

1. **Ejecuta las pruebas:**
    - Para ejecutar las pruebas, dirigirse a la carpeta runner y ejecutar RunnerTest.java que se encuentra en
      ```bash
      \src\test\java\com\nttdata\runners\RunnerTest.java
      ```

    2. **Genera el reporte:**
        - Para obtener el reporte detallado de las pruebas, ejecuta el siguiente comando Maven en la terminal:
          ```bash
          mvn serenity:aggregate
          ```
        - Los reportes se generarán en la carpeta `target/site/serenity` buscar el archivo `index.html`.

        - reporte ya genenrado en la carpeta `\adjuntos\site\serenity\index.html`

# Nota

## Configuración del Proyecto

### En el archivo de serenity.conf tomar en cuenta las siguientes indicaciones

- En webDrive esta configurado para q funciones con el navegador brave

```
 webdriver {
    driver = chrome
    autodownload = false
    capabilities {
        "goog:chromeOptions" {
        #usar el binario si no tiene instalado chorme
            binary = "C:\\Program Files\\BraveSoftware\\Brave-Browser\\Application\\brave.exe"
            args = [
                "--remote-allow-origins=*", "--xheadless"
            ]
        }
    }

}
```

- Si usan otro navegador como Chrome, entonces deben comentar el binario o eliminarlo. Les dejo el código:

```
webdriver {
    driver = chrome
    autodownload = false
    capabilities {
        "goog:chromeOptions" {
            args = [
                "--remote-allow-origins=*", "--xheadless"
            ]
        }
    }

}
```

1. **Configurar el entorno:**
    - El archivo `serenity.conf` debe estar configurado correctamente. Asegúrate de que las siguientes configuraciones
      estén presentes:
      ```hocon
      environments {
          default {
              webdriver.base.url = "https://www.demoblaze.com/"
          }
          dev {
              webdriver.base.url = "https://www.demoblaze.com/"
          }
          uat {
              webdriver.base.url = "https://www.demoblaze.com/"
          }
      }
 
      webdriver {
          driver = chrome
          autodownload = false
          capabilities {
              "goog:chromeOptions" {
                  binary = "C:\\Program Files\\BraveSoftware\\Brave-Browser\\Application\\brave.exe"
                  args = [
                      "--remote-allow-origins=*", "--xheadless"
                  ]
              }
          }
      }
 
      drivers {
          windows {
              webdriver.chrome.driver = "src/test/resources/webdriver/chromedriver.exe"
          }
      }
      ```

## Detalles del Flujo de Compra Automatizado

El flujo de compra automatizado incluye los siguientes pasos:

1. **Agregar dos productos al carrito:**
    - La prueba agrega dos productos diferentes al carrito de compras.

2. **Visualizar el carrito:**
    - Una vez que los productos están en el carrito, la prueba visualiza el contenido del carrito.

3. **Completar el formulario de compra:**
    - Se completa el formulario de compra con detalles ficticios.

4. **Finalizar la compra:**
    - La prueba finaliza la compra y verifica que la transacción se haya completado correctamente.
