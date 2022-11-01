@sprint7
Feature: Detalle de datos bancarios
  yo como usuario tendero
  quiero de una pantalla que me permita visualizar los datos bancarios registrados en el proceso de onboarding de la aplicacion
  Para que me permita acceder a la edicion de los mismos a traves de un boton que ejecute la funcionalidad de “Validacion de identidad”.

  Background: El usuario se encuentra en la opcion de datos bancarios
    Given Elvis realiza el tutorial introductorio
    And Elvis inicia sesion con el usuario "5521996723" y la contrasenia "Femsa123"
    When Elvis ingresa a la opcion datos bancarios


  Scenario: Validar pantalla de datos bancarios
    Then Elvis deberia ver los datos registrados Nombre del titular "Juan Gomez" y cuenta clabe "123456789123456789"

#  @datosBancarios
  Scenario: Validar solicitud de Validacion de identidad
    When Elvis quiere editar sus datos bancarios
    Then Elvis deberia poder ver la pantalla de confirmacion de contrasenia

#  @datosBancarios
  Scenario: Verificar que el boton cancelar de la pantalla Confirma tu contrasenia redireccione a la pantalla de clabe interbancaria
    When Elvis quiere editar sus datos bancarios
    And Elvis cancela la Confirmacion de la contrasenia
    Then Elvis deberia ver los datos registrados Nombre del titular "Juan OSe Gomez" y cuenta clabe "123456789123456789"

#  1 clic en editar
#  2 confirmar contrasenia
    #  a ingresar password
    #  b click guardar
    #  c Click en confirmar

  @datosBancarios
  Scenario: Verificar rediccionamiento a la pantalla Editar datos bancarios al ingresar una contrasenia valida
    When Elvis quiere editar sus datos bancarios
    And Elvis confirma la contrasenia "Femsa123"
    Then Elvis deberia poder ver que los campos CLABE y Titular se pueden editar

  Scenario: Verificar mensaje de error al ingresar una contrasenia valida

  Scenario: Validacion de longitud campo Nombre del titular

  Scenario: Validacion de Longitud campo Cuenta clabe



  Scenario: Verificar que el boton Salir sin guardar del modal "Deseas salir?" redireccione a la pantalla de clabe interbancaria

  Scenario: Verificar que el boton seguir editando del modal "Deseas salir?" redireccione a la pantalla de clabe interbancaria

  Scenario: Verificar que el boton cancelar del modal "tus datos son correctos?" redireccione a la pantalla de edicion de clabe interbancaria





