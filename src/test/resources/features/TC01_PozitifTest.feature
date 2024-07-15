Feature:  General Store
  Scenario: TC01 | Pozitif Test
    When Ulke menusunden "Austria" secilir
    And Isim kutusuna "Safinaz" girilir
    And Cinsiyet seceneklerinden "Female" secilir
    And Lets Shop butonuna tiklanir
    Then Sayfa basliginin "Products" oldugu dogrulanir