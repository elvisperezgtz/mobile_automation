@login @regresion

Feature: Login
#Todo Agregar el sprint

  Background: El usuario se encuentra en home de la aplicacion
    Given Elvis realiza el tutorial introductorio

  Scenario: Iniciar sesión acceso correcto con teléfono
    When Elvis inicia sesion con el usuario "5521996723" y la contrasenia "Femsa123"
    Then Elvis deberia poder ver el mensaje "Iniciando sesión"

  Scenario Outline: Iniciar Sesión con <testCase>
    When Elvis inicia sesion con el usuario <usuario> y la contrasenia <contrasenia>
    Then Elvis deberia poder ver el mensaje de error <mensaje>
    Examples:
      | usuario         | contrasenia   | mensaje             | testCase                   |
      | "admin@add.com" | "Femsa2022"   | "Datos incorrectos" | Email no valido            |
      | "5521996723"    | "badPassword" | "Datos incorrectos" | con contrasenia incorrecta |

  Scenario Outline: Iniciar Sesión: validacion de <testCase>
    When Elvis inicia sesion con el usuario <usuario> y la contrasenia <contrasenia>
    Then Elvis deberia poder ver el boton Iniciar sesion deshabilitado
    Examples:
      | usuario   | contrasenia   | testCase                                             |
      | ""        | "badPassword" | campo telefono vacio                                 |
      | "badUser" | ""            | campo contrasenia vacio                              |
      | ""        | ""            | campos requeridos vacios                             |
      | "abc"     | "Femsa2022"   | campo usuario con menos de los caracteres requeridos |
#
#    Scenario: Validar longitud del campo Contraseña
#      When Elvis ingresa una contraseña de 33 caracteres
#      Then Elvis deberia ver que el campo Contraseña solo permitio escribir 32 caracteres
