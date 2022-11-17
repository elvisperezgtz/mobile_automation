@sprint7

Feature: FAQ's en seccion "Ayuda" de pantalla "Perfil"

  Yo como usuario tenedero
  Requiero que la aplicacion muestre la seccion de preguntas frecuentes del sitio web del producto a partir del boton de “Ayuda”de la pantalla “Administracion de Perfil”,
  Para que el usuario de la app tenga acceso a la informacion necesaria para resolver dudas relativas al producto.

  Background: El usuario se encuentra en la pantalla de
    Given Elvis realiza el tutorial introductorio
    And Elvis inicia sesion con el usuario "5521996723" y la contrasenia "Femsa123"
    When Elvis ingresa a la pantalla de administracion de perfil

  @faq  @smoke
  Scenario: Validar que la opcion Ayuda nos redireccione a la pantalla FAQ's
    When Elvis ingresa a la opcion Ayuda
    Then Elvis deberia ver la pantalla de FAQ's

