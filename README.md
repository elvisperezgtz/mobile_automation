# Digital Femsa mobile automation project
Proyecto de automatizacion de pruebas automatizadas sobre dispositivos mobiles para la aplicacion nativa (iOS y Android) creadas por el equipo de `Subadquirencia`.

Este proyecto de automatizacion tiene como objetivo la ejecucion automatizada de las pruebas funcionales de la aplicacion, dandole contunidad al ciclo de pruebas en CI/CD.

## Contexto del negocio
El proyecto de B2B es una estrategia que tiene Digital Femsa que busca materializar su propuesta de valor contemplando los siguientes puntos.

### Bancarizar los changarros

Ser la mejor solución de pagos electronicos online y offline.

Para lograrlo es necesario habilitar la funcionalidad de sub-adquirencia online y offline, que se describe a continuación.

### Sub-adquirencia online.
Son todas las operaciones con la tarjeta no presente, las aplicaciones que entran en esta clasificación son:

* e-commerce.

* Integración via API

* Integración via plugin

* Spei

### Sub-adquirencia offline.
Son las operaciones con tarjeta presente, es decir con el cliente en frente, los escenarios cubiertos son los siguientes.

* Pago con dispositivo

* Pago con numero de referencia

Las grandes etapas dentro de lo que se puede ver como el flujo de información desde que se dan a conocer hasta que se esta operando, se puede ver en la siguiente imagen.

## Stack tecnologico
* Java 17
* Appium
* SerenityBDD
* Cucumber


### Estructura del proyecto
El proyecto esta construido con Gradle,  y sigue el siguiente estandar de estructura de paquetes:
```Gherkin
src
  + main
  + test
    + java                        Test runners and supporting code
    + resources
      + features                  Feature files
     + search                  Feature file subdirectories 
             search_by_keyword.feature
```


## Como ejecutar los tests
Para correr las pruebas, puedes ejecutar la clase `CucumberTestSuite` , o por lineas de comando `gradle test`.

Para la ejecucion en local es necesario tener la version de Appium server corriendo y ejecutar el siguiente comando:
Para Android:
```json
$ gradle :test --tests "femsa.CucumberTestSuite" -Dappium.hub=http://127.0.0.1:4723 -Dwebdriver.driver=appium -Dappium.platformName=android -Dappium.automationName=uiautomator2 -Dappium.deviceName=R58M622ZADM -Dappium.platformVersion=11  -Dappium.appActivity=com.oxxo.mpos.presentation.mainnav.MainActivityNav -Dappium.app=/Users/elvisperez/Documents/repo/femsa/qa/automation/qa-automation-mobile/src/test/resources/apps/dev/android/b2b.apk -Dcucumber.filter.tags="@smoke"

```
| Variable | Descripcion |
| ------ | ------ |
| -Dappium.deviceName |  Nombre del dispositivo sobre el que se realizaran las pruebas|
| -Dappium.platformVersion | Version del sistema operativo del dispositivo movil |
| -Dappium.app | Direccion donde se aloja la version de la app |
| -Dcucumber.filter.tags | Tag de las pruebas que se desean correr, ejemplo, si deseas correr el smoke test puedes usar el tag `@smoke` |

O Para iOS
```json
$ gradle :test --tests "femsa.CucumberTestSuite" -Dappium.hub=http://127.0.0.1:4723 -Dwebdriver.driver=appium -Dappium.platformName=iOS -Dappium.automationName=XCUITest -Dappium.deviceName=iPhoneElvis -Dappium.platformVersion=11 -Dappium.udid=00008030-00094D463E33C02E -Dappium.bundleid=com.femsadigital.b2b -Dappium.app=/Users/elvisperez/Documents/repo/femsa/qa/automation/qa-automation-mobile/src/test/resources/apps/dev/ios/b2b.ipa -Dcucumber.filter.tags="@smoke"
```
| Variable | Descripcion |
| ------ | ------ |
| -Dappium.deviceName |  Nombre del dispositivo sobre el que se realizaran las pruebas|
| -Dappium.platformVersion | Version del sistema operativo del dispositivo movil |
| -Dappium.app | Direccion donde se aloja la version de la app |
| -Dappium.udid | ID del dispositivo iOS |
| -Dcucumber.filter.tags | Tag de las pruebas que se desean correr, ejemplo, si deseas correr el smoke test puedes usar el tag `@smoke` |

## Resultados de las pruebas
Los resultados de la ejecucion se podra ver en el siguiente directorio `target/site/serenity` gradle construira una version HTML como reporte de pruebas y lo podemos ver en el archivo `index.html`.

## Ejecucion en diveces farm
```json
$ gradle clean :test --tests "femsa.CucumberTestSuite" -Dappium.hub=https://eperezg:fbcc1f54-d8a0-412d-b7b1-295b8007778a@ondemand.us-west-1.saucelabs.com:443/wd/hub -Dwebdriver.driver=appium -Dappium.platformName=android -Dappium.automationName=uiautomator2 -Dappium.deviceName=Samsung_Galaxy_S9_free -Dappium.platformVersion=10  -Dappium.appActivity=com.oxxo.mpos.presentation.mainnav.MainActivityNav -Dappium.app=storage:filename=app-development-debug.apk -Dcucumber.filter.tags="@smoke"
```
| Variable | Descripcion |
| ------ | ------ |
| -Dappium.deviceName |  Nombre del dispositivo sobre el que se realizaran las pruebas|
| -Dappium.hub |  Url del servicio expuesto de appium de la granja de dispositivos|
| -Dappium.platformVersion | Version del sistema operativo del dispositivo movil |
| -Dappium.app | Direccion donde se aloja la version de la app en el divice farm |
| -Dcucumber.filter.tags | Tag de las pruebas que se desean correr, ejemplo, si deseas correr el smoke test puedes usar el tag `@smoke` |