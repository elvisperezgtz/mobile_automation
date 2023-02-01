@sprint7 @regresion  @faq @perfil

Feature: FAQ's en seccion "Ayuda" de pantalla "Perfil"

  Yo como usuario tenedero
  Requiero que la aplicacion muestre la seccion de preguntas frecuentes del sitio web del producto a partir del boton de “Ayuda”de la pantalla “Administracion de Perfil”,
  Para que el usuario de la app tenga acceso a la informacion necesaria para resolver dudas relativas al producto.

  Background: El usuario se encuentra en la pantalla de
    Given Elvis realiza el tutorial introductorio
    And Elvis inicia sesion con su numero telefonico
    When Elvis ingresa a la pantalla de administracion de perfil

  @smoke
  Scenario: Validar que la opcion Ayuda nos redireccione a la pantalla FAQ's
    When Elvis ingresa a la opcion Ayuda
    Then Elvis deberia ver la pantalla de FAQ's

