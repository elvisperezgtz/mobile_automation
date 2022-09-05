Feature: Visualizar pantalla de captura de datos Personales & Negocio
  Como Usuario
  Quiero visualizar un pantalla que me permita ingresar mis datos personales y de negocio
  Para que la informacion pueda ser registrada en el sistema como parte del proceso de
  onboarding y aplicar las validaciones de formato correspondientes a cada campo.


  Background: Elvis tiene un numero registrado y contrasenia
    Given Elvis ha registrado el telefono "5568721918"
    And Elvis ingreso el codigo de validacion enviado a su celular
    And Elvis establecio "Mpos1234" como contrasenia de su cuenta

  @datosPersonales
  Scenario: Capturar datos personales- happy path
    When Elvis registra los datos personales
    Then Elvis deberia poder ver el titulo "¿Ya cuentas con tu dispositivo de cobro?"
    And  Elvis deberia ver los botones con el texto "Ya lo tengo" y "Aun no lo tengo"

  Scenario: Validar que el campo nombre admite acentos


  Scenario: Validar obligatoriedad del campo nombre

  Scenario: Validar obligatoriedad del campo Apellido

  Scenario: Validar obligatoriedad del campo email

  Scenario: Validar formato del campo email

  Scenario: Validar longitud del campo nombre del negocio

  Scenario: Validar longitud del campo nombre

  Scenario: Validar longitud del campo apellido

  Scenario: Validar longitud del campo email

  Scenario: Validar doble espacio del campo apellido

  Scenario: Validar doble espacio del campo nombre

  Scenario: Validar doble espacio del campo nombre negocio



