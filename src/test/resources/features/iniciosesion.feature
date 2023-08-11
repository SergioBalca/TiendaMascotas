Feature: Inicio sesion
  Yo como cliente de JPetStore
  Quiero estar en capacidad de iniciar sesion en la pagina web
  Para comprar animales en la tieda virtual

  Scenario: Inicio sesion exitoso
    Given el usuario navega hasta el formulario de inicio de sesion
    When ingresa usuario y clave validos
    Then deberia ser dirigido a la pagina principal de la tienda
