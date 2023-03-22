@sprint7 @regresion @editarDatosBancarios @perfil
Feature: Visualizar Pantalla "Edicion datos bancarios"
  yo como usuario tendero
  Requiero que posterior a la validacion de indetidad exitosa, la aplicacion me permita editar y actualizar los datos bancarios capturados en el proceso de onboarding de la aplicacion,
  Para que el usuario pueda hacer los ajustes de su informacion segun lo requiera.


  Background: El usuario se encuentra en la opcion de datos bancarios
    Given Elvis Perform the introductory tutorial
    And Elvis inicia sesion con su numero telefonico
    When Elvis ingresa a la opcion datos bancarios

  Scenario: Verificar rediccionamiento a la pantalla Editar datos bancarios al ingresar una contrasenia valida
    When Elvis quiere editar sus datos bancarios
    And Elvis confirma la contrasenia "Femsa123"
    Then Elvis deberia poder ver que los campos CLABE y Titular se pueden editar

  Scenario: Verificar mensaje de error al ingresar una contrasenia no valida
    When Elvis quiere editar sus datos bancarios
    And Elvis confirma la contrasenia "Femsa1234"
    Then Elvis debaria ver el mensaje Contraseña incorrecta

  Scenario: Verificar que el boton Salir sin guardar del modal "Deseas salir?" redireccione a la pantalla de clabe interbancaria con los campos bloqueados
    When Elvis quiere editar sus datos bancarios
    And Elvis confirma la contrasenia "Femsa123"
    And Elvis cancela la actualizacion de los datos bancarios
    Then Elvis deberia ver la pantalla de datos bancarios con los campos deshabilitados

  Scenario: Verificar que el boton seguir editando del modal "Deseas salir?" redireccione a la pantalla de clabe interbancaria con los campos en modo edicion
    When Elvis quiere editar sus datos bancarios
    And Elvis confirma la contrasenia "Femsa123"
    And Elvis cancela la actualizacion de datos pero continua editando
    Then Elvis deberia poder ver que los campos CLABE y Titular se pueden editar

  Scenario: Verificar que el boton Cancelar del modal "tus datos son correctos?" redireccione a la pantalla de edicion de clabe interbancaria en modo edicion
    When Elvis quiere editar sus datos bancarios
    And Elvis confirma la contrasenia "Femsa123"
    And Elvis intenta guardar los datos actualizados y cancela el guardado de datos
    Then Elvis deberia poder ver que los campos CLABE y Titular se pueden editar

  Scenario: Cambio de datos interbancarios con exito
    When Elvis edita sus datos bancarios con clabe "123456789123456788" y titular "Juan Gomez Jimenez"
    Then Elvis deberia poder ver el mensaje de guardado con exito
    And Elvis deberia poder ver los datos actualizados correctamente

  #Todo terminar estos escenarios
#  Scenario: Validacion de longitud campo Nombre del titular
#
#  Scenario: Validacion de Longitud campo Cuenta clabe
