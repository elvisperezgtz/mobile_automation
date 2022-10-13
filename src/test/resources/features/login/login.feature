@login
Feature: Login


  Background: El usuario se encuentra en home de la aplicacion
    Given Elvis realiza el tutorial introductorio

  Scenario: Iniciar sesión acceso correcto con teléfono
    When Elvis inicia sesion con su numero telefonico
    Then Elvis deberia poder ver el mensaje de "Iniciando sesión"


