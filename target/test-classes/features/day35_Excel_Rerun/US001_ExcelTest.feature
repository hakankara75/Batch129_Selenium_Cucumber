Feature: BlueRentralCar_Excel_Login

  Scenario: TC01_Positive_Login_Testi
    Given kullanici_"blueRentACarUrl"_sayfasina_gider
    And kullanici_exceldeki_"customer_info"sayfasindaki_kullanici_bilgileri_ile_login_olur
  @excel
  Scenario: TC02_Positive_Login_Testi
    Given kullanici_"blueRentACarUrl"_sayfasina_gider
    And kullanici_exceldeki_"admin_info"sayfasindaki_kullanici_bilgileri_ile_login_olur