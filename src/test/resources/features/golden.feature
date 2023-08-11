Feature: Compra en JPStore
  Yo como usuario de JPetStore
  Quiero navegar por su pagina web
  Para comprar el perro de mi eleccion

  Scenario: Compra Golden Retriever
    Given el usuario inicia sesion exitosamente en la pagina web
    When el usuario selecciona un Golden Retreiver para comprar
    Then deberia visualizar un mensaje de confirmacion de la compra realizada
