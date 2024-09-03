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

  @crearUsuarioMasivo
  Scenario Outline: Crear usuarios masivo
    When creo el usuario con username "<username>", firstname "<firstname>", lastname "<lastname>", email "<email>", password "<password>", phone "<phone>", userStatus "<userStatus>"
    Then el código de respuesta es 200
    And el type es "unknown"

    Examples:
      | username | firstname | lastname | email             | password | phone      | userStatus |
      | user1    | Juan      | Perez    | juan@dominio.com  | 1234567  | 999999991  | 0          |
      | user2    | Maria     | Lopez    | maria@dominio.com | 1234567  | 999999992  | 0          |
      | user3    | Carlos    | Jimenez  | carlos@dominio.com| 1234567  | 999999993  | 0          |
      | user4    | Ana       | Torres   | ana@dominio.com   | 1234567  | 999999994  | 0          |
      | user5    | Luis      | Martinez | luis@dominio.com  | 1234567  | 999999995  | 0          |


  @actualizarUsuarioMasivo
  Scenario Outline: Actualizar usuarios masivo
    Given consulto el usuario con nombre "<oldUsername>"
    When actualizo el usuario "<oldUsername>" con nuevo username "<newUsername>", firstname "<firstname>", lastname "<lastname>", email "<email>", password "<password>", phone "<phone>", userStatus "<userStatus>"
    Then el código de respuesta es 200

    Examples:
      | oldUsername | newUsername | firstname | lastname | email               | password | phone      | userStatus |
      | user1       | newUser1    | Juan      | Perez    | newjuan@dominio.com | 7654321  | 999999996  | 1          |
      | user2       | newUser2    | Maria     | Lopez    | newmaria@dominio.com| 7654322  | 999999997  | 1          |
      | user3       | newUser3    | Carlos    | Jimenez  | newcarlos@dominio.com| 7654323 | 999999998  | 1          |
      | user4       | newUser4    | Ana       | Torres   | newana@dominio.com  | 7654324  | 999999999  | 1          |
      | user5       | newUser5    | Luis      | Martinez | newluis@dominio.com | 7654325  | 999999000  | 1          |

