package techproed.stepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import io.cucumber.java.lv.Kad;
import org.openqa.selenium.Keys;
import techproed.pages.GooglePage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class GoogleStepDefinition {
    GooglePage googlePage = new GooglePage();

    @Given("kullanici_google_anasayfaya_gider")
    public void kullanici_google_anasayfaya_gider() {
        // Write code here that turns the phrase above into concrete actions
        Driver.getDriver().get(ConfigReader.getProperty("googleUrl"));
    }

    @When("kullanici googleda {string} aratir")
    public void kullanici_googleda_aratir(String aranacakKelime) {
        // Write code here that turns the phrase above into concrete actions

        googlePage.aramaKutusu.sendKeys(aranacakKelime, Keys.ENTER);
    }

    @And("sayfayi kapatir")
    public void sayfayi_kapatir() {
        // Write code here that turns the phrase above into concrete actions
        Driver.closeDriver();
    }


    @Then("title'in {string} icerdigini dogrular")
    public void title_in_icerdigini_dogrular(String titleDegeri) {

        assertTrue(Driver.getDriver().getTitle().contains(titleDegeri));

    }

    @When("kullanici verilen bilgileri aratir")
    public void kullanici_verilen_bilgileri_aratir(DataTable dataTable) {
        List<String> bilgiler = dataTable.asList();
        for (int i = 1; i < bilgiler.size(); i++) {
            googlePage.aramaKutusu.sendKeys(bilgiler.get(i), Keys.ENTER);
            googlePage.aramaKutusu.clear();
        }
    }
}
