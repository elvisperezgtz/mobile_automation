@sprint7 @regresion @perfil1
@cerrarSesion
Feature: Cerrar Sesion
  Yo como usuario tendero
  Requiero que en la pantalla “Administracion de Perfil” este disponible un boton
  Para que permita el cierre de la sesion activa del usuario en caso de que asi se requiera.

  Background: el usuario se encuentra en la administracion de perfil
    Given Elvis realiza el tutorial introductorio
    And Elvis inicia sesion con su numero telefonico
    And  Elvis ingresa a la opcion de Administracion de Perfil

  @smoke
  Scenario: Cierre de sesion
    When Elvis cierra la sesion de la app
    Then Elvis deberia ver la pantalla de inicio de sesion

  Scenario: Verificar redireccion del boton Atras despues de cerrar sesion
    When Elvis cierra la sesion de la app e intenta volver atras
    Then Elvis deberia ver la pantalla Registrate en tres pasos

  Scenario: Verificar que el boton Cerrar sesion muestre el modal Quieres cerrar tu sesion
    And Elvis quiere cerrar la sesion activa
    Then Elvis deberia ver el modal Quieres cerrar tu sesion





