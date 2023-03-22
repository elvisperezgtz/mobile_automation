@sprint5
Feature: Transaccion Exitosa via chip
  Yo como Usuario Tendero
  Requiero visualizar la pantalla “Transaccion Exitosa” posterior a haber recibido una respuesta desde el servicio de integracion (API-Sale)
  Para que se indique al usuario el resultado de un cobro exitoso y se muestren en pantalla los datos basicos de la transaccion.

  Background: El usuario se encuentra en home de la aplicacion
    Given Elvis Perform the introductory tutorial
    And Elvis login with his credentials

  @transaccionExitosa
  Scenario: Cobro via chip - Sin privilegios concedidos
    When Elvis realiza el cobro con monto "1010" y concepto "bebidas"
    Then Elvis deberia poder ver que el cobro se realizo con exito

  #Todo Completar el escenario

#  Scenario: Cobro via chip - redireccion a la pantalla Home
#    When Elvis realiza el cobro con monto "1010" y concepto "bebidas"
#    And Elvis finaliza la transaccion en la pantalla de "Transaccion exitosa"
#    Then Elvis deberia poder ver el home de la app