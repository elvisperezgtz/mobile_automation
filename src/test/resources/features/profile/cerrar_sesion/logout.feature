@logout @regression @profile

Feature: Logout

  As a Spin pro user
  I want a logout option
  To close session


  Background: the user is on the Profile screen
    Given Elvis Perform the introductory tutorial
    And he is logged in to the app by "phone number" with his "valid credentials"
    And he enters in the Profile screen

  @logout
  Scenario: Logout
    When he logout from the app
    Then he should see the login screen

  Scenario: Verificar redireccion del boton Atras despues de cerrar sesion
    When Elvis cierra la sesion de la app e intenta volver atras
    Then Elvis deberia ver la pantalla Registrate en tres pasos

  Scenario: Verificar que el boton Cerrar sesion muestre el modal Quieres cerrar tu sesion
    And Elvis quiere cerrar la sesion activa
    Then Elvis deberia ver el modal Quieres cerrar tu sesion





