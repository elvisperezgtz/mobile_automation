@sprint7 @regresion @editarDetalleDatosBancarios @perfil
Feature: Detalle de datos bancarios
  yo como usuario tendero
  quiero de una pantalla que me permita visualizar los datos bancarios registrados en el proceso de onboarding de la aplicacion
  Para que me permita acceder a la edicion de los mismos a traves de un boton que ejecute la funcionalidad de “Validacion de identidad”.

  Background: El usuario se encuentra en la opcion de datos bancarios
    Given Elvis realiza el tutorial introductorio
    And Elvis inicia sesion con su numero telefonico
    When Elvis ingresa a la opcion datos bancarios

  Scenario: Validar pantalla de datos bancarios
    Then Elvis deberia ver los datos registrados Nombre del titular "Juan Gomez Jimenez" y cuenta clabe "123456789123456788"

  Scenario: Validar solicitud de Validacion de identidad
    When Elvis quiere editar sus datos bancarios
    Then Elvis deberia poder ver la pantalla de confirmacion de contrasenia

  Scenario: Verificar que el boton cancelar de la pantalla Confirma tu contrasenia redireccione a la pantalla de clabe interbancaria
    When Elvis quiere editar sus datos bancarios
    And Elvis cancela la Confirmacion de la contrasenia
    Then Elvis deberia ver los datos registrados Nombre del titular "Juan Gomez Jimenez" y cuenta clabe "123456789123456788"



