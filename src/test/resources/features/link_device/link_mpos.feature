@regresion
Feature: Autorizar privilegios Bluetooth

  Yo como Usuario Tendero
  Quiero visualizar una Ventana Emergente que verifique si la aplicacion tiene privilegios
  de uso de la funcionalidad de Bluetooth
  Para que pueda hacer la vinculacion del dispositivo MPOS con el dispositivo Movil.

  Background: Elvis tiene un numero registrado y contrasenia
    Given Elvis ha registrado su telefono
    And Elvis ingreso el codigo de validacion enviado a su celular
    And Elvis establecio "Mpos1234" como contrasenia de su cuenta
    When Elvis registra los datos personales

#  @vinculacion
  Scenario: Autorizar privilegios Bluetooth
    When Elvis realiza la vinculacion del dispositivo MPOS
    Then Elvis deberia poder que inicio la busqueda de dispositivos

  @vinculacion @desactivarBT

  Scenario: Autorizar privilegios bluetooth cuando el bluetooth esta apagado
    When Elvis desactiva el bluetooth de su telefono
    When Elvis realiza la vinculacion del dispositivo Mpos aceptando activar el Bluetooth
    Then Elvis deberia poder que inicio la busqueda de dispositivos

  @onboarding
  Scenario: Proceso de Onboarding exitoso
    When Elvis realiza la vinculacion del dispositivo MPOS
    And Elvis ingresa los datos de su cuenta Clabe
    Then  Elvis deberia ver el titulo "Felicidades"