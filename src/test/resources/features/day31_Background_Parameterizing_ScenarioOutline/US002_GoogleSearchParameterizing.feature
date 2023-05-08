@GoogleSearch
Feature: Google_Search

  Background: kullanici_google_anasayfaya_gider
    Given kullanici_google_anasayfaya_gider

  Scenario: TC01_Java__Search
    When kullanici googleda "Java" aratir
    Then title'in "Java" icerdigini dogrular
    And sayfayi kapatir

  Scenario: TC02_SQL__Search
    When kullanici googleda "SQL" aratir
    Then title'in "SQL" icerdigini dogrular
    And sayfayi kapatir

  Scenario: TC03_JDBC__Search
    When kullanici googleda "JDBC" aratir
    Then title'in "JDBC" icerdigini dogrular
    And sayfayi kapatir

  Scenario: TC04_Selenium__Search
    When kullanici googleda "Selenium" aratir
    Then title'in "Selenium" icerdigini dogrular
    And sayfayi kapatir

  Scenario: TC05_Lambda__Search
    When kullanici googleda "Lambda" aratir
    Then title'in "Lambda" icerdigini dogrular
    And sayfayi kapatir