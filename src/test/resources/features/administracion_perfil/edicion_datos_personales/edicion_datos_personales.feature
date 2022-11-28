@sprint7 @regresion
Feature: Visualizar Pantalla "Edicion de datos personales"
  Yo como usuario tendero
  Requiero que posterior a la validacion de indetidad exitosa, la aplicacion me permita editar y actualizar los datos bancarios capturados en el proceso de onboarding de la aplicacion,
  de tal forma que el usuario pueda hacer los ajustes de su informacion segun lo requiera.

  Background: El usuario se encuentra en la opcion de datos personales
    Given Elvis realiza el tutorial introductorio
    And Elvis inicia sesion con el usuario "5521996723" y la contrasenia "Femsa123"
    When Elvis ingresa a la opcion datos personales

#@editarDatosPersonales
  Scenario: Visualizar datos personales
    Then Elvis deberia ver sus datos personales registrados
      | Nombre    | Apellidos | Email        |
      | Juan Jose | Gomez     | jg@gmail.com |

#  @editarDatosPersonales
  Scenario: Visualizar confirmar contrasenia antes de editar datos personales
    When Elvis intenta editar sus datos personales
    Then Elvis deberia ver la solicitud de confirmacion de su contrasenia

#  @editarDatosPersonales
  Scenario: Validar edicion de datos personales
    When Elvis edita sus datos personales
      | Nombre    | Apellidos | Email        |
      | Juan Jose | Gomez     | jg@gmail.com |
    Then Elvis deberia poder ver el mensaje de guardado con exito
    And Elvis deberia ver los cambios aplicados a sus datos personales
      | Nombre    | Apellidos | Email        |
      | Juan Jose | Gomez     | jg@gmail.com |

  @editarDatosPersonales
  Scenario: Validar composicion de la imagen del perfil
    Then Elvis deberia ver la imagen de perfil compuesta por la primera letra del nombre y del apellido




