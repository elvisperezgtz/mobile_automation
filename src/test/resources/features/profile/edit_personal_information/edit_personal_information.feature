
Feature: Edit personal information
  As a shopkeeper user
  I require that after the successful entity validation, the application allows me to edit and update the bank data captured in the onboarding process of the application,
  so that the user can make adjustments to their information as required.

  Background: The user is in the edit personal information option.
    Given Elvis Perform the introductory tutorial
    And he is logged in to the app by "phone number" with his "valid credentials"
    When he enters in the personal data option

  @fix
  Scenario: Verify Edit button redirection
    Then Elvis should see his personal data registered


  Scenario: Verify functionality of the Edit button

  Scenario: Verify Back button redirection

  Scenario: Validate email format of the Email field

  Scenario: Validate length of Last name field with 1 character

  Scenario: Validate that the Name field accepts accented characters

  Scenario: Validate that emails already registered are not accepted

  Scenario: Verify that when you press the Continue button the data is saved correctly.


  Scenario: Verify CANCEL button functionality

  Scenario: Verify functionality of Continue Button with incorrect password

  Scenario: Verify functionality of Continue Button with valid password


  Scenario: Verify functionality of the Save button

  Scenario: Verify functionality of the EXIT WITHOUT SAVING button


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


