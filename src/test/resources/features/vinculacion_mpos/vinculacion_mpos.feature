Feature: Autorizar privilegios Bluetooth

  Yo como Usuario Tendero
  Quiero visualizar una Ventana Emergente que verifique si la aplicacion tiene privilegios
  de uso de la funcionalidad de Bluetooth
  Para que pueda hacer la vinculacion del dispositivo MPOS con el dispositivo Movil.

  Background: Elvis tiene un numero registrado y contrasenia
    Given Elvis ha registrado el telefono "5568721918"
    And Elvis ingreso el codigo de validacion enviado a su celular
    And Elvis establecio "Mpos1234" como contrasenia de su cuenta
    When Elvis registra los datos personales

#  @vinculacion
  Scenario: Autorizar privilegios Bluetooth
    When Elvis realiza la vinculacion del dispositivo MPOS
    Then Elvis deberia poder que inicio la busqueda de dispositivos

  @vinculacion @desactivarBT
  Scenario: Autorizar privilegios bluetooth cuando el bluetooth esta desactivado
    When Elvis realiza la vinculacion del dispositivo Mpos aceptando activar el Bluetooth
    Then Elvis deberia poder que inicio la busqueda de dispositivos

