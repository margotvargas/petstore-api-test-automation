Feature: Gestión de órdenes en PetStore

  @crearOrden
  Scenario Outline: Crear una nueva orden en PetStore
    Given que el API de PetStore está disponible
    When creo una orden con id "<id>", petId "<petId>", quantity "<quantity>", shipDate "<shipDate>", status "<status>", complete "<complete>"
    Then el código de respuesta para la tienda es 200
    And el estado de la orden es placed "<status>"

    Examples:
      | id  | petId | quantity | shipDate             | status | complete |
      | 90 | 4     | 5        | 2024-08-24T14:15:22Z | placed | true     |
      | 91 | 2     | 2        | 2024-08-23T14:15:22Z | placed | true     |

  @consultarOrden
  Scenario Outline: Consultar una orden existente en PetStore
    When deseo validar que la orden con id "<id>" existe
    Then el código de respuesta para la tienda es 200
    And la orden tiene el id "<id>"
    And la cantidad de la orden es "<quantity>"

    Examples:
      | id  | quantity |
      | 100 | 5        |
      | 101 | 2        |

    #NOTA: En el segundo escenario se omitió el Given, ya que era muy redundante

  @eliminarOrden
  Scenario Outline: Eliminar una orden existente en PetStore
    Given deseo validar que la orden con id "<id>" existe
    When elimino la orden con id "<id>"
    Then el código de respuesta para la tienda es 200

    Examples:
      | id  |
      | 100 |
      | 101 |

  @consultarOrdenEliminada
  Scenario Outline: Consultar una orden inexistente en PetStore
    Given consulto la orden eliminada con id "<id>" no exista
    Then el código de respuesta para la tienda es 404

    Examples:
      | id  |
      | 100 |
      | 101 |
