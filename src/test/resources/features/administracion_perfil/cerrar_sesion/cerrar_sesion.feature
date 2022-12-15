@sprint7 @regresion
@cerrarSesion
Feature: Cerrar Sesion
  Yo como usuario tendero
  Requiero que en la pantalla “Administracion de Perfil” este disponible un boton
  Para que permita el cierre de la sesion activa del usuario en caso de que asi se requiera.

  Background: el usuario se encuentra en la administracion de perfil
    Given Elvis realiza el tutorial introductorio
    And Elvis inicia sesion con el usuario "5521996723" y la contrasenia "Femsa123"
    And  Elvis ingresa a la opcion de Administracion de Perfil

  @smoke
  Scenario: Cierre de sesion
    When Elvis cierra la sesion de la app
    Then Elvis deberia ver la pantalla de inicio de sesion





