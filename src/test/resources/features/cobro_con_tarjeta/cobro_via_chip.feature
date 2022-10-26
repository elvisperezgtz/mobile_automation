
Feature: Cobro via chip


#  B2CS-1532 - Android || Visualizar la pantalla "Tarjeta Bloqueada" - con tarjeta de vales
#  B2CS-1532 - Android || Visualizar la pantalla "Tarjeta Bloqueada" validar que el boton cancelar redireccione al Home
#  B2CS-1532 - Android || Visualizar la pantalla "Tarjeta Bloqueada" - Validar que el boton reintentar nos redireccione a la pantalla "Monto por cobrar"
  Background: El usuario se encuentra en home de la aplicacion
    Given Elvis realiza el tutorial introductorio
    And Elvis inicia sesion con el usuario "5521996723" y la contrasenia "Femsa123"
  @cobroViaChip
  Scenario: Cobro via chip - Sin privilegios concedidos
    When Elvis realiza el cobro con monto "1010" y concepto "bebidas"
    Then Elvis deberia poder ver que el cobro se realizo con exito

    @TarjetaBloqueada
  Scenario: Cobro via chip - Tarjeta bloqueada
    When Elvis realiza el cobro con monto "1010" y concepto "bebidas"
    Then Elvis deberia poder ver la pantalla de tarjeta bloqueada

  @TarjetaBloqueada
  Scenario: Cobro via chip - Tarjeta bloqueada, redireccionar al home
    When Elvis realiza el cobro con monto "1010" y concepto "bebidas"
    And Elvis selecciona la opcion Cancelar en la pantalla de tarjeta bloqueada
    Then Elvis deberia poder ver el home de la app

  @TarjetaBloqueada
  Scenario: Cobro via chip - Tarjeta bloqueada, redireccionar a la pantalla Monto por cobrar
    When Elvis realiza el cobro con monto "1010" y concepto "bebidas"
    And Elvis selecciona la opcion Volver a intentar en la pantalla de tarjeta bloqueada
    Then Elvis deberia poder ver la pantalla de Monto por cobrar
