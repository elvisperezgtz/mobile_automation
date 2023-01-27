@sprint7 @regresion @perfil
@editarDatosNegocio
Feature: Visualizar Pantalla "Edicion de datos de negocio"

  yo como usuario tendero
  Requiero que posterior a la validacion de indetidad exitosa, la aplicacion me permita editar y actualizar los datos de negocio capturados en el proceso de onboarding de la aplicacion,
  de tal forma que el usuario pueda hacer los ajustes de su informacion segun lo requiera.

  Background: El usuario se encuentra en la opcion de datos personales
    Given Elvis realiza el tutorial introductorio
    And Elvis inicia sesion con su numero telefonico
    When Elvis ingresa a la opcion datos de negocio

  Scenario: Edicion de datos de negocio
    When Elvis edita los datos de negocio
      | Nombre      | Actividad  | CodigoPostal |
      | Bug Hunters | ASOCIACIÓN | 50004        |
    Then ELvis deberia poder ver el mensaje de guardado con exito
    And Elvis deberia ver los datos actualizados correctamente
      | Nombre      | Actividad  | CodigoPostal |
      | Bug Hunters | ASOCIACIÓN | 50004        |

  Scenario: Validar que el boton Editar solicite la validacion de contrasenia
    When Elvis intenta editar los datos del negocio
    Then Elvis deberia ver la solicitud de confirmacion de su contrasenia

    #Todo
  Scenario: Editar datos personales | fallido

  Scenario: validar obligatoriedad del campo Nombre de tu negocio
    When Elvis borra el contenido del campo Nombre de tu negocio e intenta guardar
    Then Elvis deberia ver la alerta "Este campo es obligatorio"


  Scenario: validar obligatoriedad del campo Codigo postal
    When Elvis borra el contenido del campo Codigo postal e intenta guardar
    Then Elvis deberia ver la alerta "Este campo es obligatorio"

  @codigoPostal
  Scenario: validar que el campo Codigo postal no admita codigos postales no validos
    When Elvis modifica el codigo postal por "50001"
    Then Elvis deberia ver el mensaje "El Código Postal es incorrecto"





