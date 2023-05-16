package techproed.stepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import techproed.pages.BlueRentalCarPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ExcelUtils;
import techproed.utilities.ReusableMethods;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertTrue;

public class BlueRentalCarStepDefinitions {
    BlueRentalCarPage blueRentalCarPage = new BlueRentalCarPage();

    @Given("kullanici blue rental car sayfasina gider")
    public void kullanici_blue_rental_car_sayfasina_gider() {

        Driver.getDriver().get(ConfigReader.getProperty("blueRentACarUrl"));
           }

    @When("login olur")
    public void login_olur(DataTable dataTable) {
        blueRentalCarPage.loginButonu.click();
        blueRentalCarPage.emailBox.sendKeys(dataTable.row(1).get(0));
        blueRentalCarPage.passwordBox.sendKeys(dataTable.row(1).get(1));
        blueRentalCarPage.loginConfirm.click();

        //cikis yapiyoruz
        blueRentalCarPage.dropDown.click();
        blueRentalCarPage.logOut.click();
        blueRentalCarPage.ok.click();

        //2.data girisi
        blueRentalCarPage.loginButonu.click();
        blueRentalCarPage.emailBox.sendKeys(dataTable.row(2).get(0));
        blueRentalCarPage.passwordBox.sendKeys(dataTable.row(2).get(1));
        blueRentalCarPage.loginConfirm.click();
    }


    @When("login olur map")
    public void loginOlurMap(DataTable dataTable) {
        dataTable.asMaps().get(0).get("emailadress");
        dataTable.asMaps().get(0).get("password");

        //Datayı birinci satırı Key olarak kabul eden List<Map> data türüne çavirdik.
        List<Map<String, String>> bilgiler = dataTable.asMaps();//[{emailadress=jack@gmail.com, password=12345}, {emailadress=sam.walker@bluerentalcars.com, password=c!fas_art}]
        System.out.println("bilgiler = " + bilgiler);


        for (Map<String, String> w : bilgiler) {//Her bir Map'i alarak "Key değerlerini kullanarak "Value" değerlerini çağırdık ve testimizde kullandık.
            blueRentalCarPage.loginButonu.click();
            blueRentalCarPage.emailBox.sendKeys(w.get("emailadress"));
            blueRentalCarPage.passwordBox.sendKeys(w.get("password"));
            blueRentalCarPage.loginConfirm.click();

            //cikis yapiyoruz
            blueRentalCarPage.dropDown.click();
            blueRentalCarPage.logOut.click();
            blueRentalCarPage.ok.click();

        }


    }

    @Then("Verilen_kullanicilar_ile_login_olunur")
    public void verilen_kullanicilar_ile_login_olunur(DataTable data) {
        blueRentalCarPage=new BlueRentalCarPage();



        System.out.println(data.asMaps());//map'lerden olusan bir list olusturur.
        //[{email=sam.walker@bluerentalcars.com, password=c!fas_art}, {email=kate.brown@bluerentalcars.com, password=tad1$Fas}]
        /*
        feature file'daki olusturmus oldugumuz tabloyu map olarak listeler.
       basligi key olarak alir, altindaki verileri value olarak alir
       */

        for (Map<String, String> element:data.asMaps()) {
            blueRentalCarPage.loginButonu.click();
            blueRentalCarPage.emailBox.sendKeys(element.get("email"), Keys.TAB, element.get("password"), Keys.ENTER);
            ReusableMethods.bekle(3);
            blueRentalCarPage.dropDown.click();
            blueRentalCarPage.logOut.click();
            ReusableMethods.bekle(3);
            blueRentalCarPage.ok.click();

        }

    }

    @And("kullanici_exceldeki_{string}sayfasindaki_kullanici_bilgileri_ile_login_olur")
    public void kullanici_exceldeki_Sayfasindaki_kullanici_bilgileri_ile_login_olur(String sayfaAdi) {

        ExcelUtils excelUtils=new ExcelUtils("src/test/resources/mysmoketestdata.xlsx", sayfaAdi);
        for (int i = 1; i <=excelUtils.rowCount(); i++) {
            String email=excelUtils.getCellData(i,0);
            String password=excelUtils.getCellData(i,1);
            blueRentalCarPage.loginButonu.click();
            ReusableMethods.bekle(2);
            blueRentalCarPage.emailBox.sendKeys(email, Keys.TAB, password, Keys.ENTER);
            blueRentalCarPage.dropDown.click();
            ReusableMethods.bekle(2);
            blueRentalCarPage.profile.click();
            ReusableMethods.bekle(2);
            Assert.assertEquals(blueRentalCarPage.verifyEmail.getText(),email);
            ReusableMethods.bekle(2);
            blueRentalCarPage.dropDown.click();
            blueRentalCarPage.logOut.click();
            blueRentalCarPage.ok.click();

        }
        Driver.closeDriver();
    }

    @Given("kullanici_blueRentACarUrl_sayfasina_gider_exceldeki_verilerle_login_olur")
    public void kullanici_bluerentacarurl_sayfasina_gider_exceldeki_verilerle_login_olur() {
        System.out.println("BlueRentalPage Sayfasına Gidildi Exceldeki Veriler ile login olundu");
    }
}
