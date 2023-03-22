@ayuda @sprint8 @regresion @ayudaOnboarding
Feature: Solicitar "Ayuda" desde el flujo "Onboarding"
  Como usuario tendero
  Quiero
  Para

  Background: El usuario se encuentra en la pantalla de Onboarding
    Given Elvis Perform the introductory tutorial

  Scenario: Redireccion del boton Ayuda desde la pantalla "Ingresa tu numero"
    When Elvis ingresa a la ayuda de la pantalla Ingresa tu numero
    Then Elvis deberia ver que se muestre la ayuda
