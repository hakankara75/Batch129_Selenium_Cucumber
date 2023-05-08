@GoogleSearchScenarioOutline
Feature: Google Search

  Background: kullanici_google_anasayfaya_gider
    Given kullanici_google_anasayfaya_gider

  Scenario Outline: Google_aramalari
    When kullanici googleda "<Aranacak Kelime>" aratir
    Then title'in "<Aranacak Kelime>" icerdigini dogrular
    And sayfayi_kapatir

    Examples:
      | Aranacak Kelime |
      | Java            |
      | SQL             |
      | JDBC            |
      | Selenium        |
      | Lambda          |
