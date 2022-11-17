@ayuda @sprint8
Feature: Solicitar "Ayuda" desde el login
  Como usuario tendero
  Quiero
  Para

  Background: El usuario se encuentra en la pantalla de login
    Given Elvis ingresa a la pantalla de inicio de sesion

  @ayudaLogin
  Scenario:  Redireccion del boton Ayuda desde la pantalla de Login
    When Elvis ingresa a la ayuda de la pantalla de inicio de sesion
    Then Elvis deberia ver que se muestre la ayuda
