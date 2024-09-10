Feature: Gestionar mascotas en PetStore

  @crearMascota
  Scenario: Crear mascota
    When creo la mascota con id "501", name "Maxito", status "available"
    Then el código de respuesta para la mascota es 200
    And valido que el nombre de la mascota es "Maxito"

  @consultarMascota
  Scenario: Consultar mascota
    Given consulto la mascota con id "501"
    Then el código de respuesta para la mascota es 200

  @actualizarMascota
  Scenario: Actualizar mascota
    Given consulto la mascota con id "501"
    When actualizo la mascota con id "501" con nuevo nombre "Rambo"
    Then el código de respuesta para la mascota es 200
    And valido que el nombre de la mascota es "Rambo"

  @eliminarMascota
  Scenario: Eliminar mascota
    Given consulto la mascota con id "501"
    When elimino la mascota con id "501"
    Then el código de respuesta para la mascota es 200

  #CASOS MASIVOS
  @crearMascotaMasivo
  Scenario Outline: Crear mascotas
    When creo la mascota con id "<id>", name "<name>", status "<status>"
    Then el código de respuesta para la mascota es 200
    And valido que el nombre de la mascota es "<name>"

    Examples:
      | id  | name   | status    |
      | 601 | Scott  | available |
      | 602 | Bobbie | available |

  @consultarMascotaMasivoCreado
  Scenario Outline: Consultar mascotas post creados
    Given consulto la mascota con id "<id>"
    Then el código de respuesta para la mascota es 200

    Examples:
      | id  |
      | 601 |
      | 602 |

  @actualizarMascotaMasivo
  Scenario Outline: Actualizar mascotas
    Given consulto la mascota con id "<oldId>"
    When actualizo la mascota con id "<oldId>" con nuevo nombre "<newMascotaName>"
    Then el código de respuesta es 200
    And valido que el nombre de la mascota es "<newMascotaName>"

    Examples:
      | oldId | newMascotaName |
      | 601   | Scott Junior   |
      | 602   | Firulais       |

  @consultarMascotaMasivoActualizado
  Scenario Outline: Consultar mascota masivo post actualizados
    Given consulto la mascota con id "<id>"
    Then el código de respuesta para la mascota es 200

    Examples:
      | id  |
      | 601 |
      | 602 |

  @eliminarMascotaMasivo
  Scenario Outline: Eliminar mascotas
    Given consulto la mascota con id "<id>"
    When elimino la mascota con id "<id>"
    Then el código de respuesta para la mascota es 200

    Examples:
      | id  |
      | 601 |
      | 602 |

  @consultarMascotaMasivoEliminado
  Scenario Outline: Consultar mascotas post eliminados
    Given consulto la mascota eliminada con id "<id>"
    Then el código de respuesta es 404

    Examples:
      | id  |
      | 601 |
      | 602 |
