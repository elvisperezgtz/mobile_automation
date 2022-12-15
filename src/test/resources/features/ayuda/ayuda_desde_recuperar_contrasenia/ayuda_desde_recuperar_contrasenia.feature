@ayuda @sprint8 @regresion  @ayudaRecuperarContrasenia
Feature: Ayuda desde pantalla de recuperar contrasenia
  Como usuario tendero
  Quiero
  Para

  Background: El usuario se encuentra en la pantalla de login
    Given Elvis ingresa a la pantalla de inicio de sesion

  Scenario: Redireccion del boton Ayuda desde la pantalla "Recuperar contraseña"
    When Elvis ingresa a la ayuda de la pantalla recuperar contrasenia
    Then Elvis deberia ver que se muestre la ayuda

