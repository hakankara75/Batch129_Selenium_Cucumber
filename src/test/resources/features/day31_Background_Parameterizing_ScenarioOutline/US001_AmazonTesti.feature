Feature: US001_Amazon_Sayfasinda_Urun_Aratma

  #her scenario oncesi calisir. scenario sonrasi ayni kodlarin yazilmasini yani tekrari onler
  Background: kullanici_amazon_sayfasina_gider
    Given kullanici_amazon_sayfasina_gider

  Scenario: TC01_Amazon_sayfasinda_Selenium_Aratma
        When arama_kutusunda_Selenium_aratir
    Then sayfayi_kapatir

  Scenario: TC01_Amazon_sayfasinda_Selenium_Aratma
    When arama_kutusunda_java_aratir
    Then sayfayi_kapatir
