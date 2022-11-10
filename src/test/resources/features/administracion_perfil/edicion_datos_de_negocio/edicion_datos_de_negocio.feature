@sprint7
#@editarDatosNegocio
Feature: Visualizar Pantalla "Edicion de datos de negocio"

  yo como usuario tendero
  Requiero que posterior a la validacion de indetidad exitosa, la aplicacion me permita editar y actualizar los datos de negocio capturados en el proceso de onboarding de la aplicacion,
  de tal forma que el usuario pueda hacer los ajustes de su informacion segun lo requiera.

  Background: El usuario se encuentra en la opcion de datos personales
    Given Elvis realiza el tutorial introductorio
    And Elvis inicia sesion con el usuario "5521996723" y la contrasenia "Femsa123"
    When Elvis ingresa a la opcion datos de negocio

#  @editarDatosNegocio
  Scenario: Edicion de datos de negocio
    When Elvis edita los datos de negocio
      | Nombre      | Actividad  | CodigoPostal |
      | Bug Hunters | ASOCIACIÓN | 50004        |
    Then ELvis deberia poder ver el mensaje de guardado con exito
    And Elvis deberia ver los datos actualizados correctamente
      | Nombre      | Actividad  | CodigoPostal |
      | Bug Hunters | ASOCIACIÓN | 50004        |

  @editarDatosNegocio
  Scenario: Validar que el boton Editar solicite la validacion de contrasenia
    When Elvis intenta editar los datos del negocio
    Then Elvis deberia ver la solicitud de confirmacion de su contrasenia

