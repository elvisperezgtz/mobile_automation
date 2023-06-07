@regression @profile
Feature: Authorize device

  As a Spin pro user
  I want a module to authorize device
  to be able to use my mPOS device

  Background: The user is in the Profile screen
    Given Elvis Perform the introductory tutorial
    And he logs in by "phone number"
    When he enters in the Profile screen

    @authorizeDevice
  Scenario: Authorize device with permissions granted previously
    And he authorize his device
    Then he should see the message Device ready

#    Validar funcionalidad del boton Conectar
#    Verficar funcionalidad del boton No permitir
#    Verifica modal No tienes conexion a internet
#    Verificar funcionalidad del boton Autorizar dispositivo
#    Verificar funcionalidad del boton Ayuda
#    Verificar funcionalidad del boton cerrar
#    Verificar funcionalidad del boton Denegar
#    Verificar funcionalidad del boton Hacerlo mas tarde
#    Verificar funcionalidad del boton Hacerlo mas tarde
#    Verificar funcionalidad del boton Permitir
#    Verificar funcionalidad del boton Permitir con permisos de ubicacion rechazados anteriormentee
#    Verificar funcionalidad del boton vincular cuando no se tiene el dispositivo marcado para Intercambio de llaves
#    Verificar funcionalidad del boton vincular cuando se tiene el dispositivo marcado para Intercambio de llaves
#    Verificar funcionalidad del boton Vincular mas tarde
#    Verificar funcionalidad del boton Volver a intentar
#    Verificar funcionalidad del boton Volver a intentar
#    Verificar modal No se encontro dispositivo