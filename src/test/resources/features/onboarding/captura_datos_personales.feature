@Sprint_2 @regresion
Feature: Visualizar pantalla de captura de datos Personales & Negocio
  Como Usuario
  Quiero visualizar un pantalla que me permita ingresar mis datos personales y de negocio
  Para que la informacion pueda ser registrada en el sistema como parte del proceso de
  onboarding y aplicar las validaciones de formato correspondientes a cada campo.

  Background: Elvis tiene un numero registrado y contrasenia
    Given Elvis ha registrado su telefono
    And Elvis ingreso el codigo de validacion enviado a su celular
    And Elvis establecio "Mpos1234" como contrasenia de su cuenta

#  @datosPersonales
  Scenario: Capturar datos personales- happy path
    When Elvis registra los datos personales
    Then Elvis deberia poder ver el titulo "¿Ya cuentas con tu dispositivo de cobro?"
    And  Elvis deberia ver los botones con el texto "Ya lo tengo" y "Aun no lo tengo"

#  @datosPersonales
  Scenario: Validar obligatoriedad del campo nombre
    When Elvis registra los datos personales
    Then Elvis deberia poder ver la alerta "Este campo es obligatorio"

#  @datosPersonales
  Scenario: Validar que el campo nombre no permite numeros
    When Elvis registra los datos personales
    Then Elvis deberia poder ver la alerta "Este campo es obligatorio"

#  @datosPersonales
  Scenario: Validar longitud del campo nombre
    When Elvis registra los datos personales
    Then Elvis deberia validar que la longitud del campo nombre sea menor igual a 256
    And Elvis deberia poder ver el titulo "¿Ya cuentas con tu dispositivo de cobro?"

  @datosPersonales
  Scenario: Validar que el campo nombre admite acentos
    When Elvis registra los datos personales
    Then Elvis deberia poder ver el titulo "¿Ya cuentas con tu dispositivo de cobro?"

  Scenario: Validar obligatoriedad del campo apellido
    When Elvis registra los datos personales
    Then Elvis deberia poder ver la alerta "Este campo es obligatorio"

  Scenario: Validar que el campo apellido no permite numeros

  Scenario: Validar doble espacio del campo apellido

  Scenario: Validar longitud del campo apellido

  Scenario: Validar que el campo apellido admite acentos

  Scenario: Validar obligatoriedad del campo email
    When Elvis registra los datos personales
    Then Elvis deberia poder ver la alerta "Este campo es obligatorio"

  Scenario: Validar formato del campo email

  Scenario: Validar longitud del campo email

  Scenario: Validar longitud min del campo nombre negocio

  Scenario: Validar longitud max del campo nombre negocio

  Scenario: Validar que el campo nombre negocio es alfanumerico

  Scenario: Validar que el campo nombre negocio no admite caracteres especiales

  Scenario: Validar doble espacio del campo nombre negocio

  Scenario: Validar obligatoriedad del campo actividad de negocio
    When Elvis registra los datos personales
    Then Elvis deberia poder ver la alerta "Este campo es obligatorio"

  Scenario: Validar obligatoriedad del campo codigo postal
    When Elvis registra los datos personales
    Then Elvis deberia poder ver la alerta "Este campo es obligatorio"

  Scenario: Validar longitud del campo codigo postal

  Scenario: Validar que el campo codigo postal es numerico



