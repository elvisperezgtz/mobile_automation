@sprint7
@documentosLegales @regresion
Feature: Visualizacion de documentos legales
  Yo como usuario tendero
  Requiero que a partir del elemento  “Documentos legales” del listado de la pantalla “Administracion de Perfil” se desprenda una pantalla adicional que muestre el listado de “Documentos” disponibles
  Para consultar desde la aplicacion, de tal forma que el usuario pueda consultar los terminos y condiciones que acepta al usar el producto.

  Background: el usuario se encuentra en la opcion de documentos legales
    Given Elvis realiza el tutorial introductorio
    And Elvis inicia sesion con el usuario "5521996723" y la contrasenia "Femsa123"
    And  Elvis ingresa a la opcion de Documentos legales

  Scenario: Visualizar listado de documentos legales
    Then Elvis deberia poder ver las opciones de Terminos y condiciones y Politica de Privacidad

  Scenario: Validar la opcion Terminos y condiciones muestre el documento correspondiente
    When Elvis ingresa al documento Terminos y condiciones
    Then Elvis deberia ver el documento de terminos y condiciones

  Scenario: Validar la opcion Aviso de privacidad muestre el documento correspondiente
    When Elvis ingresa al documento Aviso de privacidad
    Then Elvis deberia ver el documento de Aviso de privacidad