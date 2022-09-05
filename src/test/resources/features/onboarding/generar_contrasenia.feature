Feature:Visualizar pantalla de generación de contraseña
  Como Usuario
  quiero visualizar una pantalla que me permita ingresar la contraseña
  que sera utulizada como parte del login asi como la validacion del formato de la misma.

  Background: El usuario ya verifico el telefono
    When Elvis realiza el registro en la App con el numero de telefono "5623342574"
    And Elvis ingresa el codigo de verifacion enviado a su celular

  Scenario: Generar contraseña satisfactoriamente
    When Elvis ingresa la contrasenia "Mpos1234" para su cuenta
    Then Elvis deberia ver que el boton Continuar se encuentra habilitado
    And Elvis deberia ver que no existen validaciones pendientes

  Scenario: Generar contraseña sin mayusculas
    When Elvis ingresa la contrasenia "mpos124" para su cuenta
    Then Elvis deberia ver que el boton Continuar se encuentra deshabilitado
    And Elvis deberia ver la alerta con la frase "Una mayuscula"

  Scenario: Generar contraseña sin numero
    When Elvis ingresa la contrasenia "Mposabcd" para su cuenta
    Then Elvis deberia ver que el boton Continuar se encuentra deshabilitado
    And Elvis deberia ver la alerta con la frase "Un numero"

  Scenario: Generar contraseña sin minuscula
    When Elvis ingresa la contrasenia "MPOS1234 " para su cuenta
    Then Elvis deberia ver que el boton Continuar se encuentra deshabilitado
    And Elvis deberia ver la alerta con la frase "Una minuscula"

  Scenario: Generar contraseña de 7 caracteres
    When Elvis ingresa la contrasenia "Mposabcd" para su cuenta
    Then Elvis deberia ver que el boton Continuar se encuentra deshabilitado
    And Elvis deberia ver la alerta con la frase "8 caracteres"

  Scenario: Generar contraseña con el campo contraseña vacio
    When Elvis ingresa la contrasenia "" para su cuenta
    Then Elvis deberia ver que el boton Continuar se encuentra deshabilitado
    And Elvis deberia ver que existen validaciones pendientes

  Scenario: Generar contraseña con el campo contraseña con caracteres especiales
    When Elvis ingresa la contrasenia "*/-+/*-+&" para su cuenta
    Then Elvis deberia ver que el boton Continuar se encuentra deshabilitado
    And Elvis deberia ver que existen validaciones pendientes




