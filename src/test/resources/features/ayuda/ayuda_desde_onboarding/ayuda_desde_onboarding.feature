@ayuda @sprint8
Feature: Solicitar "Ayuda" desde el flujo "Onboarding"
  Como usuario tendero
  Quiero
  Para

  Background: El usuario se encuentra en la pantalla de Onboarding
    Given Elvis realiza el tutorial introductorio

  @ayudaOnboarding
  Scenario: Redireccion del boton Ayuda desde la pantalla "Ingresa tu numero"
    When Elvis ingresa a la ayuda de la pantalla Ingresa tu numero
    Then Elvis deberia ver que se muestre la ayuda