Feature: Login


  Background: El usuario se encuentra en home de la aplicacion
    Given Elvis realiza el tutorial introductorio

  Scenario: Iniciar sesión acceso correcto con teléfono
    When Elvis inicia sesion con el usuario <"usuario"> y la contrasenia <"contrasenia">
    Then Elvis deberia poder ver el mensaje de "Iniciando sesión"

  @login
  Scenario Outline: Iniciar Sesión con Email no valido
    When Elvis inicia sesion con el usuario <"usuario"> y la contrasenia <"contrasenia">
    Then Elvis deberia poder ver el mensaje error "mensaje"
    Examples:
      | <usuario>     | <contrasenia> | <mensaje>                 | <testCase>                 |
      | admin@add.com | Femsa2022     | XCUIElementTypeStaticText | con Email no valido        |
      | badUser       | badPassword   | XCUIElementTypeStaticText | con telefono no valido     |
      | badUser       | badPassword   | XCUIElementTypeStaticText | con contrasenia incorrecta |


  Scenario Outline: Iniciar Sesión <"testCase">
    When Elvis inicia sesion con el usuario <"usuario"> y la contrasenia <"contrasenia">
    Then Elvis deberia poder ver el boton Iniciar sesion deshabilitado
    Examples:
      | <usuario> | <contrasenia> | <testCase>                                               |
      |           | badPassword   | con campo telefono vacio                                 |
      | badUser   |               | con campo contrasenia vacio                              |
      |           |               | con campos requeridos vacios                             |
      | abc       | Femsa2022     | con campo usuario con menos de los caracteres requeridos |



