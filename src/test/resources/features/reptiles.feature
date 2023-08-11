Feature: Listar Reptiles
  Yo como usuario de la pagina web JPetStore
  Quiero conocer la lista de reptiles disponibles en la tienda
  Para conocer el precio de cada uno de ellos

  Scenario: Listar reptiles disponibles
    Given el usuario ingresa a la pagina de inicio de JPetStore
    When selecciona la opcion reptiles del menu principal
    And elige la opcion Rattlesnake y luego Iguana
    Then el usuario visualizara la lista de reptiles disponibles

