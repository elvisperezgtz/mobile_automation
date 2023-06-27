@profile @authorizeDevice
Feature: Authorize device

  As a Spin pro user
  I want a module to authorize device
  to be able to use my mPOS device

  Background: The user is in the Profile screen
    Given Elvis Perform the introductory tutorial
    And he logs in by "phone number"
    When he enters in the Profile screen

  Scenario: Authorize device with permissions granted previously
    And he authorize his device
    Then he should see the message Device ready

#    Verificar funcionalidad del boton Ayuda

  Scenario: Verify Help button functionality
    When he needs help in the Turn on your device screen
    Then he should see the screen: How to use my Spiro device

#    Verificar funcionalidad del boton cerrar desde ayudd

  Scenario:  Verify functionality of Close button on Help screen
    When he is on the help screen and want to go back
    Then he should see the Turn on your device screen

    #    Verificar funcionalidad del boton Autorizar dispositivo
  Scenario: Validate functionality of the Authorize Device button
    When he wants to go to Authorize device option
    Then he should see the Turn on your device screen

    #    Verificar funcionalidad del boton Vincular mas tarde

  Scenario:The Link later button on the Turn on your device screen should redirect to the Profile screen
    And he wants to Link his device later
    Then he should see the Profile screen

  Rule: When a required permission is not granted, it should return to the Profile screen.
#    Verficar funcionalidad del boton No permitir
    Scenario: Do not allow permissions
      When he deny permissions on his cellphone
      Then he should see the Turn on your device screen

  Rule: Bluetooth is required on to start the pairing process

    Scenario: Authorize device when the Bluetooth is turned off
      When he authorize his device with bluetooth turned off
#then he should see the message "Device Authorized"

  Rule: Internet connection is required on to start the pairing process

#    Verifica modal No tienes conexion a internet
    @hookEnableWifi
    Scenario: Check modal You have no internet connection
      When he tries to authorize his device without internet connection
      Then he should see the modal You do not have Internet connection

      #    Verificar funcionalidad del boton Hacerlo mas tarde

  Rule: When press the Link later button, it should return to the profile screen
    Scenario: Verify functionality of the button Link later
      And he wants to authorize his device later
      Then he should see the Profile screen

#    Verificar funcionalidad del boton vincular cuando no se tiene el dispositivo marcado para Intercambio de llaves
#    Verificar funcionalidad del boton vincular cuando se tiene el dispositivo marcado para Intercambio de llaves

