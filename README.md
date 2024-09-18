# Ejercicio de Automatización E2E con Serenity BDD

Este ejercicio realiza pruebas funcionales automatizadas (E2E) de un flujo de compra en la
página [https://www.demoblaze.com/](https://www.demoblaze.com/) utilizando Serenity BDD con Screenplay en Java y Maven.

## Prerequisitos

Antes de ejecutar las pruebas, asegúrate de tener configurado lo siguiente en tu máquina local:

|                                                                               **IntelliJ**                                                                                |                                                              **Java**                                                               |                                                 **Maven**                                                 |
|:-------------------------------------------------------------------------------------------------------------------------------------------------------------------------:|:-----------------------------------------------------------------------------------------------------------------------------------:|:---------------------------------------------------------------------------------------------------------:|
| [<img width="50" height="50" src="https://cdn.iconscout.com/icon/free/png-128/intellij-idea-569199.png">](https://www.jetbrains.com/es-es/idea/download/#section=windows) | [<img height="60" src="https://www.oracle.com/a/ocom/img/cb71-java-logo.png">](https://www.oracle.com/java/technologies/downloads/) | [<img height="50" src="data:image/png;base64,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">](https://maven.apache.org/) |

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
