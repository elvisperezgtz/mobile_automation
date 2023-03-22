@sprint7 @regresion @perfil
@modalConfirmarContrasenia
Feature: Visualizar modal "Confirmar contraseña"

  Yo como usuario tendero
  requiero que la aplicacion haga una validacion de identidad cada que se requiera editar informacion personal, bancaria o de negocio,
  de tal forma que el usuario tenga la seguridad que solo aquien conozca la contraseña podra visualizar o editar su informacion.

  Background: El usuario se encuentra en la opcion de datos personales
    Given Elvis Perform the introductory tutorial
    And Elvis inicia sesion con su numero telefonico
    When Elvis ingresa a la opcion datos personales

  Scenario: Validar redireccionamiento a la pantalla de datos personales al presionar el boton cancelar
    When Elvis intenta editar sus datos personales
    And Elvis presiona el boton cancelar
    Then Elvis deberia ver la pantalla de datos personales con los campos deshabilitados

  Scenario: Validar que al presionar el boton Continuar habilite los campos para editar los datos
    When Elvis intenta editar sus datos personales
    And Elvis ingresa una contrasenia "Femsa123"
    Then Elvis deberia ver los campos del formulario de datos personales habilitados para edicion

  Scenario: Validar contraseña no valida
    When Elvis intenta editar sus datos personales
    And Elvis ingresa una contrasenia "123Femsa"
    Then Elvis deberia ver el mensaje Contraseña incorrecta
    And Elvis deberia ver la pantalla de datos personales con los campos deshabilitados

    @longitudCampo
Scenario: Validar longitud del campo contraseña
  When Elvis intenta editar sus datos personales
  And Elvis ingresa una contrasenia con 33 caracteres
  Then Elvis deberia ver que el campo contraseña solo tiene 32 caracteres













