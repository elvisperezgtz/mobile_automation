Feature: Visualizar pantalla de verificación de código vía SMS

  Como Usuario
  Quiero visualizar una pantalla que me permita ingresar el codigo de verificacion recibido via SMS
  Para verificar mi dispositivo movil como una forma de contacto valida mostrando el mensaje de exito o error
  correspondiente

  Background: el usuario tiene acceso a la app
    Given Elvis tiene acceso a la app Mpos por primera vez
    When Elvis realiza el tutorial introductorio

  @pantallas
  Scenario: Pantalla de verificacion, habilitar boton de reenvio al terminar la cuenta regresiva
    When Elvis realiza el registro en la App con el numero de telefono "3334567890"
    And Elvis ingresa un codigo de verificacion no valido
    And Elvis espera a que termine la cuenta regresiva
    Then Elvis deberia ver el boton "Reenviar SMS"

#  @pantallas
  Scenario: Pantalla de verificacion de codigo SMS con codigo no valido
    When Elvis realiza el registro en la App con el numero de telefono "3334567890"
    And Elvis ingresa un codigo de verificacion no valido
    Then Elvis deberia poder ver el mensaje de error con el texto "El código es incorrecto"

#  @pantallas
  Scenario: Pantalla de verificacion, cuenta regresiva para el reenvio del codigo de verificacion
    When Elvis realiza el registro en la App con el numero de telefono "3334567890"
    And Elvis ingresa un codigo de verificacion no valido
    Then Elvis deberia ver la cuenta regresiva para poder reenviar el codigo de validacion

#  @pantallas
  Scenario: Pantalla de verificacion, reenviar codigo de verificacion
    When Elvis realiza el registro en la App con el numero de telefono "3334567890"
    And Elvis ingresa un codigo de verificacion no valido
    And Elvis ingresa un nuevo codigo de verificacion valido
    Then Elvis deberia poder ver el mensaje con el texto "Celular validado"

  @pantallas
  Scenario: Pantalla de verificacion de codigo SMS con codigo valido
    When Elvis realiza el registro en la App con el numero de telefono "5623342574"
    And Elvis ingresa el codigo de verifacion enviado a su celular
    Then Elvis deberia poder ver el mensaje de confirmacion de Numero validado





