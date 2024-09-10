@AllTest

Feature: agregar productos

  @AddProduct
  Scenario: agrego productos al carrito
    Given el Usuario esta en la pagina de demoblaze
    When escojo productos para el carro
    And verifica la compra de los articulos
    Then llena el formulario de copra con los siguientes datos:
