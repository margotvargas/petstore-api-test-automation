Feature: Gestion de usuario PetStore

  @crearUsuario
  Scenario: Crear usuario
    When creo el usuario con username "mvargas", firstname "Margot", lastname "Vargas"
    Then el código de respuesta es 200
    And el type es "unknown"

  @consultarUsuario
  Scenario: Consultar usuario
    Given consulto el usuario con nombre "mvargas"
    Then el código de respuesta es 200

  @actualizarUsuario
  Scenario: Actualizo el nombre de usuario
    Given consulto el usuario con nombre "mvargas"
    When actualizo el usuario "mvargas" con nuevo username "nuevoUsername"
    Then el código de respuesta es 200

  @eliminarUsuario
  Scenario: Eliminar usuario
    Given consulto el usuario con nombre "nuevoUsername"
    When elimino el usuario con nombre "nuevoUsername"
    Then el código de respuesta es 200

  #ESCENARIOS MASIVOS
  @crearUsuarioMasivo
  Scenario Outline: Crear usuarios masivo
    When creo el usuario con username "<username>", firstname "<firstname>", lastname "<lastname>", email "<email>", password "<password>", phone "<phone>", userStatus "<userStatus>"
    Then el código de respuesta es 200
    And el type es "unknown"

    Examples:
      | username | firstname | lastname | email              | password | phone     | userStatus |
      | user1    | Juan      | Perez    | juan@dominio.com   | 1234567  | 999999991 | 0          |
      | user2    | Maria     | Lopez    | maria@dominio.com  | 1234567  | 999999992 | 0          |

  @consultarUsuarioMasivoCreado
  Scenario Outline: Consultar usuarios masivo post creados
    Given consulto el usuario con nombre "<username>"
    Then el código de respuesta es 200

    Examples:
      | username |
      | user1    |
      | user2    |

  @actualizarUsuarioMasivo
  Scenario Outline: Actualizar usuarios masivo
    Given consulto el usuario con nombre "<oldUsername>"
    When actualizo el usuario "<oldUsername>" con nuevo username "<newUsername>", firstname "<firstname>", lastname "<lastname>", email "<email>", password "<password>", phone "<phone>", userStatus "<userStatus>"
    Then el código de respuesta es 200

    Examples:
      | oldUsername | newUsername | firstname | lastname | email                 | password | phone     | userStatus |
      | user1       | newUser1    | Juan      | Perez    | newjuan@dominio.com   | 7654321  | 999999996 | 1          |
      | user2       | newUser2    | Maria     | Lopez    | newmaria@dominio.com  | 7654322  | 999999997 | 1          |

  @consultarUsuarioMasivoActualizado
  Scenario Outline: Consultar usuarios masivo post actualizados
    Given consulto el usuario con nombre "<username>"
    Then el código de respuesta es 200

    Examples:
      | username |
      | newUser1 |
      | newUser2 |

  @eliminarUsuarioMasivo
  Scenario Outline: Eliminar usuarios masivo
    Given consulto el usuario con nombre "<username>"
    When elimino el usuario con nombre "<username>"
    Then el código de respuesta es 200

    Examples:
      | username |
      | newUser1 |
      | newUser2 |

  @consultarUsuarioMasivoEliminado
  Scenario Outline: Consultar usuarios masivo post eliminados
    Given consulto el usuario eliminado con nombre "<username>"
    Then el código de respuesta es 404

    Examples:
      | username |
      | newUser1 |
      | newUser2 |
