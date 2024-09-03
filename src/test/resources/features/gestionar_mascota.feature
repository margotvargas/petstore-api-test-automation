Feature: Gestionar mascotas en PetStore

  @crearMascota
  Scenario: Crear mascota
    When creo la mascota con id "501", name "Maxito", status "available"
    Then el código de respuesta para la mascota es 200
    And el nombre de la mascota es "Maxito"

  @consultarMascota
  Scenario: Consultar mascota
    Given consulto la mascota con id "501"
    Then el código de respuesta para la mascota es 200

  @actualizarMascota
  Scenario: Actualizar mascota
    Given consulto la mascota con id "501"
    When actualizo la mascota con id "501" con nuevo nombre "Rambo"
    Then el código de respuesta para la mascota es 200
    And el nombre de la mascota es "Rambo"

  @eliminarMascota
  Scenario: Eliminar mascota
    Given consulto la mascota con id "501"
    When elimino la mascota con id "501"
    Then el código de respuesta para la mascota es 200