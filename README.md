# En el archivo de serenity.conf tomar en cuenta las siguientes acciones

## En webDrive esta configurado para q funciones con el navegador brave
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
- más información en la carpeta adjuntos readme.txt