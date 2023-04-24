@sprint6
Feature: Cobro con tarjeta bloqueada
  Yo como usuario tendero
  Requiero que cuando la lectura de tarjeta desde el dispositivo mPOS este en proceso, la aplicación tenga la capacidad
  de detectar el error de Lectura que se produce en el dispositivo mPOS cuando no se ingresa una tarjeta y
  para que pueda mostrarse la pantalla de error correspondiente en la aplicación.

  Background: El usuario se encuentra en home de la aplicacion
    Given Elvis Perform the introductory tutorial
    And Elvis login with his credentials


  Scenario: Cobro via chip - Tarjeta bloqueada
    When Elvis realiza el cobro con monto "1010" y concepto "bebidas"
    Then Elvis deberia poder ver la pantalla de tarjeta bloqueada

#  @TarjetaBloqueada
  Scenario: Cobro via chip - Tarjeta bloqueada, redireccionar al home
    When Elvis realiza el cobro con monto "1010" y concepto "bebidas"
    And Elvis selecciona la opcion Cancelar en la pantalla de tarjeta bloqueada
    Then Elvis deberia poder ver el home de la app

  @tarjetaBloqueada
  Scenario: Cobro via chip - Tarjeta bloqueada, redireccionar a la pantalla Monto por cobrar
    When Elvis realiza el cobro con monto "1010" y concepto "bebidas"
    And Elvis selecciona la opcion Volver a intentar en la pantalla de tarjeta bloqueada
    Then Elvis deberia poder ver la pantalla de Monto por cobrar
