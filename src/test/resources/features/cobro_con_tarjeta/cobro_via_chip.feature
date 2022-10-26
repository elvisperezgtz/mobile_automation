@cobroViaChip
Feature: Cobro via chip


#  B2CS-1532 - Android || Visualizar la pantalla "Tarjeta Bloqueada" - con tarjeta de vales
#  B2CS-1532 - Android || Visualizar la pantalla "Tarjeta Bloqueada" validar que el boton cancelar redireccione al Home
#  B2CS-1532 - Android || Visualizar la pantalla "Tarjeta Bloqueada" - Validar que el boton reintentar nos redireccione a la pantalla "Monto por cobrar"
  Background: El usuario se encuentra en home de la aplicacion
    Given Elvis realiza el tutorial introductorio
    And Elvis inicia sesion con el usuario "5521996723" y la contrasenia "Femsa123"

  Scenario: Cobro via chip - Sin privilegios concedidos
    When Elvis realiza el cobro con monto "1010" y concepto "bebidas"
    Then Elvis deberia poder ver que el cobro se realizo con exito


