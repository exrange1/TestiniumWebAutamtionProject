Feature: beymen

  Scenario: beymen automation testing
    When  open the site and verify that
    And  SendKeys to searchBar  from excel and delete
    And  SendKeys to searchBar  from excel
    And  Press enter from keyboard and click on random product
    And  Write to product and price infos to txt file
    And  Add product to cart and compare the prices
    And  Increase the quantity and verify
    Then Delete product from cart and verify