Ejercicio de Automatización E2E con Serenity BDD

Este ejercicio realiza pruebas funcionales automatizadas (E2E) de un flujo de compra en la página https://www.demoblaze.com/ utilizando Serenity BDD con Screenplay en Java y Maven.

Prerequisitos

Antes de ejecutar las pruebas, asegúrate de tener configurado lo siguiente en tu máquina local:

- Sistema Operativo: Windows 10, macOS, o Linux.
- IDE: IntelliJ IDEA o Eclipse.
- Java JDK: versión 17 (debe estar en la variable de entorno JAVA_HOME).
- Maven: versión  3.9.8 o superior (debe estar en la variable de entorno MAVEN_HOME).
- Serenity BDD: versión 3.9.8 (especificada en el archivo pom.xml).
- ChromeDriver: Asegúrate de tener el driver de Chrome compatible con la versión del navegador que estás usando. El archivo chromedriver.exe se encuentra en src/test/resources/webdriver/chromedriver.exe.

Configuración del Proyecto

1. Configurar el entorno:
   - El archivo serenity.conf debe estar configurado correctamente. Asegúrate de que las siguientes configuraciones estén presentes:

     environments {
         default{
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
2. Configurar el entorno:
   - El archivo serenity.properties debe estar configurado correctamente. Asegúrate de que las siguientes configuraciones estén presentes:

     serenity.project.name= QaEjercicioE2E
     serenity.take.screenshots= AFTER_EACH_STEP

     # Customizando el reporte
     report.customfields.ApplicationVersion = 1.2.3
     report.customfields.environment = DEV
     report.customfields.user = cesaralcantara
     report.customfields.squad = Open Banking
     report.customfields.order = ApplicationVersion, environment, user, squad

     # Configuración del driver
     serenity.browser.maximized = true
     ```

3. Instalar dependencias:
   - Clona el repositorio y navega a la carpeta del proyecto:
     git clone https://github.com/tu_usuario/tu_repositorio.git
     cd tu_repositorio

--* (SOLO SI ES NESESARIO) *--

   - Instala las dependencias del proyecto:
     mvn install

4. Compilar el proyecto:
   - Compila el proyecto:
     mvn clean compile

Instrucciones para Ejecutar las Pruebas

1. Ejecuta las pruebas:
   - Para ejecutar las pruebas de E2E, utiliza el siguiente comando Maven:
     mvn clean verify

2. Genera el reporte:
   - Para obtener el reporte detallado de las pruebas, ejecuta el siguiente comando Maven:
     mvn serenity:aggregate
   - Los reportes se generarán en la carpeta target/site/serenity.

3. Visualiza los reportes:
   - Abre el archivo index.html ubicado en target/site/serenity en un navegador web para revisar los resultados detallados de las pruebas.

Detalles del Flujo de Compra Automatizado

El flujo de compra automatizado incluye los siguientes pasos:

1. Agregar dos productos al carrito:
   - La prueba agrega dos productos diferentes al carrito de compras.

2. Visualizar el carrito:
   - Una vez que los productos están en el carrito, la prueba visualiza el contenido del carrito.

3. Completar el formulario de compra:
   - Se completa el formulario de compra con detalles ficticios.

4. Finalizar la compra:
   - La prueba finaliza la compra y verifica que la transacción se haya completado correctamente.

Información Adicional

- Configuración Adicional: Para detalles sobre la configuración de Serenity BDD y Maven, consulta la documentación oficial de Serenity BDD y Maven.

Para más información sobre cómo personalizar o configurar el entorno de prueba, consulta la documentación de Serenity BDD y Maven en sus respectivos sitios web.
