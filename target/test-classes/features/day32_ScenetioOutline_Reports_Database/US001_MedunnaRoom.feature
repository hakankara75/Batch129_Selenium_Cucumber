@MedunnaRoom                 #5   #bunu kopyalayip runner class a tags kismina yapistirdim. eksik step def. cikmasi icin
Feature: Medunna Oda Oluşturma    #1

    Background: Admin olarak giris yap      #2  #giris islemi tekrar edilmesi gereken is oldugu icin backround yaptik burayi
    Given "https://medunna.com/" adresine git
    When kullanici simgesini tikla
    And sign in secenegini tikla
    And usarname kutusuna "mark_twain" gir
    And password kutusuna "Mark.123" gir
    And remember me radio butonunu tikla
    And sign in butonunu tikla

 Scenario Outline: Oda Olusturma    #3      #bu loop ozelligi verir. tum basamaklarda ayni islemleri tekrar eder
When items&titles sekmesini tikla
   And room secenegini tikla
   And create a new room botonunu tikla
   And room number kutusuna "<roomNumber>" gir
   And room type drop downdan "<Room Type>" sec
   And price kutusuna "<price>" gir
   And description kutusuna "<description>" gir
   And save butonunu tikla
   Then kaydedildi alertini dogrula
   And sayfayi_kapatir
   Examples:  #4
     | roomNumber | Room Type | price | description   |
     | 2015341    | DELUXE    | 10    | Balkonlu oda  |
     | 3415027    | SUITE     | 20    | Temiz oda     |
     | 4605751    | TWIN      | 11    | Manzarali oda |
     | 9204681    | DAYCARE   | 45    | Tertemiz oda  |

#6 console daki adimlari kopyalayip stepDefinitions da yeni acilacak class a yapistir