@sprint7 @regresion @perfil
@editarDatosNegocio
Feature: Visualizar Pantalla "Edicion de datos de negocio"

  yo como usuario tendero
  Requiero que posterior a la validacion de indetidad exitosa, la aplicacion me permita editar y actualizar los datos de negocio capturados en el proceso de onboarding de la aplicacion,
  de tal forma que el usuario pueda hacer los ajustes de su informacion segun lo requiera.

  Background: The user is in the edit business information option.
    Given Elvis Perform the introductory tutorial
    And he is logged in to the app by "phone number" with his "valid credentials"
    When he enters in the Business data option


  Scenario: Verify Edit button redirection
    Then he should see his Business information registered

  Scenario: Verify functionality of the Edit button
    And he wants to edit his Business information
    Then he should see a Confirm Password modal

  Scenario: Verify Back button redirection
    And he wants to go back
    Then he should see the Profile screen


  Scenario: Verify functionality of Continue Button with incorrect password
    And he tries to confirm the password with a wrong password "BadPassword"
    Then he should see the error message "Contraseña incorrecta"


  Scenario: Verify functionality of Continue Button with valid password
    And he confirms his password
    Then he should see the business information form in edit mode

  @fixBusiness
  Scenario Outline: Validate the length of your Business Name field with <testCase>
    And he changes his Business name for "<businessName>"
    And he saves changes
    Then he should see the following message: You have updated your data
    Examples:
      | businessName                        | testCase      |
      | Merchantasdfglkjhgasdflkjhgasdfglkj | 35 characters |
      | m                                   | 1 character   |
      | Merchant123456789123456789123456789 | numbers       |


  Scenario Outline: Validate the mandatory of <tesCase>
    Examples:
      | Business name |
      | postal code   |
      | Activity      |

  Scenario Outline: Validate the length of your Postal code field with <testCase>
    And he changes his postal code for "<postalCode>"
    And he saves changes
    Then he should see the following message: You have updated your data
    Examples:
      | postalCode | testCase    |
      |            | empty       |
      | 1          | 1 character |


  Scenario: Validate that the Zip Code field does not admit zip codes that are not from Mexico.

  Scenario: Verify functionality of the EXIT WITHOUT SAVING button

  Scenario: Verify CANCEL button functionality

  Scenario: Verify that the information was updated

  Scenario: Validate that the title at home change when update the Business information

  Background: El usuario se encuentra en la opcion de datos personales
    Given Elvis Perform the introductory tutorial
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

  @negocio
  Scenario: Verificar que se actualice el nombre del negocio en el home
    When Elvis cambia el nombre del negocio por "Surtitodo"
    And Elvis ingresa al home de la aplicacion
    Then Elvis deberia ver el nombre del negocio "Surtitodo"





