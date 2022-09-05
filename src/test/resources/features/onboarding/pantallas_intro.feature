@Sprint_1
Feature: Pantallas introductorias
  Como Usuario Tendero
  Quiero visualizar las pantallas con la informacion introductoria del producto
  Para que me permita redireccionar mi navegacion al registro de cuenta o inicio
  de sesion cada que no tenga una sesion iniciada.


#    Background: El usuario tiene acceso a la app

  @pantallasIntro
  Scenario: Navegacion por las pantallas introductorias por medio de gestos
    Given Elvis tiene acceso a la App de Mpos
    When Elvis realiza el tutorial introductorio
    Then Elvis deberia poder visualizar el home de app
