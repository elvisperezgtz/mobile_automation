@sprint7 @regresion @editarDetalleDatosBancarios @perfil
Feature: Detalle de datos bancarios
  yo como usuario tendero
  quiero de una pantalla que me permita visualizar los datos bancarios registrados en el proceso de onboarding de la aplicacion
  Para que me permita acceder a la edicion de los mismos a traves de un boton que ejecute la funcionalidad de “Validacion de identidad”.

  Background: El usuario se encuentra en la opcion de datos bancarios
    Given Elvis realiza el tutorial introductorio
    And Elvis inicia sesion con su numero telefonico
    When Elvis ingresa a la opcion datos bancarios

    #Todo cambiar esto por un metodo con json
  Scenario: Validar pantalla de datos bancarios
    Then Elvis deberia ver los datos registrados Nombre del titular "Juan Gomez Jimenez" y cuenta clabe "123456789123456788"

  Scenario: Validar solicitud de Validacion de identidad
    When Elvis quiere editar sus datos bancarios
    Then Elvis deberia poder ver la pantalla de confirmacion de contrasenia

  Scenario: Verificar que el boton cancelar de la pantalla Confirma tu contrasenia redireccione a la pantalla de clabe interbancaria
    When Elvis quiere editar sus datos bancarios
    And Elvis cancela la Confirmacion de la contrasenia
    Then Elvis deberia ver los datos registrados Nombre del titular "Juan Gomez Jimenez" y cuenta clabe "123456789123456788"

  Scenario: Validar obligatoriedad del campo CLABE interbancaria
    When Elvis borra el contenido del campo CLABE Interbancaria
    Then Elvis deberia ver la alerta "Este campo es obligatorio"


  Scenario: Validar obligatoriedad del campo Nombre del titular
    When Elvis borra el contenido del campo Nombre del titular
    Then Elvis deberia ver la alerta "Este campo es obligatorio"


  Scenario: Longitud del campo CLABE Interbancaria
  When Elvis ingresa una cuenta CLABE de 17 digitos
    Then Elvis deberia ver la alerta de validacion de longitud con el texto "La CLABE debe tener 18 dígitos"

  @clabe
  Scenario: Editar datos personales
    When Elvis edita su CLABE "123456789123456789" y nombre de titular "Jesus Diaz"
    Then Elvis deberia ver el mensaje de confirmacion "Actualizaste tus datos"





