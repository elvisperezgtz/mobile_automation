@sprint7 @regresion @editarDatosPersonales @perfil
Feature: Visualizar Pantalla "Edicion de datos personales"
  Yo como usuario tendero
  Requiero que posterior a la validacion de indetidad exitosa, la aplicacion me permita editar y actualizar los datos bancarios capturados en el proceso de onboarding de la aplicacion,
  de tal forma que el usuario pueda hacer los ajustes de su informacion segun lo requiera.

  Background: El usuario se encuentra en la opcion de datos personales
    Given Elvis Perform the introductory tutorial
    And Elvis inicia sesion con su numero telefonico
    When Elvis ingresa a la opcion datos personales

  Scenario: Visualizar datos personales
    Then Elvis deberia ver sus datos personales registrados
      | Nombre    | Apellidos     | Email       |
      | Juan Jose | Gomez Jimenez | jg@mail.com |

  Scenario: Visualizar confirmar contrasenia antes de editar datos personales
    When Elvis intenta editar sus datos personales
    Then Elvis deberia ver la solicitud de confirmacion de su contrasenia

  Scenario: Validar edicion de datos personales
    When Elvis edita sus datos personales
      | Nombre    | Apellidos | Email        |
      | Juan Jose | Gomez     | jg@gmail.com |
    Then Elvis deberia poder ver el mensaje de guardado con exito
    And Elvis deberia ver los cambios aplicados a sus datos personales
      | Nombre    | Apellidos | Email        |
      | Juan Jose | Gomez     | jg@gmail.com |

  Scenario: Validar composicion de la imagen del perfil
    Then Elvis deberia ver la imagen de perfil compuesta por la primera letra del nombre y del apellido


  Scenario: Validar obligatoriedad del campo Nombre
    When Elvis borra el contenido del campo Nombre e intenta guardar
    Then Elvis deberia ver la alerta "Este campo es obligatorio"


  Scenario: Validar obligatoriedad del campo Apellidos
    When Elvis borra el contenido del campo Apellidos e intenta guardar
    Then Elvis deberia ver la alerta "Este campo es obligatorio"

  Scenario: Validar obligatoriedad del campo Email
    When Elvis borra el contenido del campo Email e intenta guardar
    Then Elvis deberia ver la alerta "Este campo es obligatorio"


  Scenario: Validar que no se permita cambiar el correo por otro correo registrado previamente en el sistema
    When Elvis cambia el correo registrado por otro correo registrado previamente
    Then Elvis deberia ver la alerta "Este email ya tiene una cuenta"


  Scenario: Verificar validacion de formato de correo electronico
    When Elvis modifica el correo electronico "corre@sinformato"
    Then Elvis deberia ver la alerta con el texto "Formato de email incorrecto"

  @hookDatosPersonales
  Scenario: Verificar cambio de logo al modificar nombres y apellidos desde el perfil
    When Elvis modifica su nombre "Felix" y apellidos "Sabas"
    Then Elvis deberia ver el logo modificado con las iniciales "FS"

  @hookDatosPersonales
  Scenario: Verificar cambio del titulo en la pantalla perfil al realizar cambio de nombres y apellidos
    When Elvis modifica su nombre "Felix" y apellidos "Sabas"
    And Elvis regresa a la pantalla de perfil
    Then Elvis deberia ver el logo en la pantalla Perfil modificado con las iniciales "FS"
    And Elvis deberia ver el titulo "Felix Sabas" en la pantalla perfil

  Scenario: Verificar inicio de sesion con correo modificado


