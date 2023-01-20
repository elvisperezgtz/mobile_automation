@sprint7 @regresion @pantallaPerfil @perfil
Feature: Pantalla perfil
  yo como usuario tendero
  quiero


  Background: El usuario se encuentra en la opcion de datos bancarios
    Given Elvis realiza el tutorial introductorio
    And Elvis inicia sesion con su numero telefonico
    When Elvis ingresa a la opcion Perfil

    Scenario: Verificar funcionalidad del boton Perfil
      Then Elvis deberia ver la pantalla de perfil con todos sus componentes

