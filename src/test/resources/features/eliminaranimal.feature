Feature: Elimnar animal de carrito de compras
  Yo como usuario de la tienda de mascotas JPetStore
  Quiero administrar mi carrito de compras
  Para eliminar los animales del carrito que decida finalmente no comprar

  Scenario: Eliminacion animal exitosa
    Given el usuario inicia sesion exitosamente en la tienda virtual
    And tiene agregado un animal al carrito de compras
    When decide elimnar el animal del carrito de compras
    Then deberia observar un mensaje cofirmando que el carrito de compras esta vacio