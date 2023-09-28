package techproed.stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import techproed.pages.TechproPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ReusableMethods;

public class TechproStepDefinition {
    TechproPage techproPage;
    @Given("kullanici_techpro_sayfasina_gider")
    public void kullanici_techpro_sayfasina_gider() {
        Driver.getDriver().get(ConfigReader.getProperty("techproed_Url"));
    }

    @And("arama_kutusunda_QA_aratir")
    public void arama_kutusunda_qa_aratir() {
        techproPage=new TechproPage();
        techproPage.searchBox.sendKeys("QA", Keys.ENTER);

    }

    @And("sayfa_basliginin_qa_icerdigini_test_eder")
    public void sayfa_basliginin_qa_icerdigini_test_eder() {
        Assert.assertTrue(Driver.getDriver().getTitle().contains("QA"));
    }

    @Then("cikan_reklam_kapatilir")
    public void cikan_reklam_kapatilir() {
        techproPage=new TechproPage();
        techproPage.reklam.click();
    }

    @Given("kullanici_{string}_sayfasina_gider")
    public void kullanici__sayfasina_gider(String arg0) {
        switch (arg0) {
            case "blueRentACarUrl":
                Driver.getDriver().get(ConfigReader.getProperty("blueRentACarUrl"));
                break;
            case "techproed_Url":
                Driver.getDriver().get(ConfigReader.getProperty("techproed_Url"));
                break;
            case "amazon_Url":
                Driver.getDriver().get(ConfigReader.getProperty("amazon_Url"));
                break;
            case "testCenterUrl":
                Driver.getDriver().get(ConfigReader.getProperty("testCenterUrl"));
                break;
            case "dataTableUrl":
                Driver.getDriver().get(ConfigReader.getProperty("dataTableUrl"));
                break;
            case "googleUrl":
                Driver.getDriver().get(ConfigReader.getProperty("googleUrl"));
                break;
            default:
                break;
        }
    }

    @And("kullanici {int} saniye bekler")
    public void kullaniciSaniyeBekler(int arg0) {
        ReusableMethods.bekle(2);
    }

    @And("searchBoxda_{string}_aratir")
    public void searchboxda__aratir(String arg0) {
        techproPage=new TechproPage();
        techproPage.searchBox.sendKeys("python", Keys.ENTER);
    }

    @And("sayfa_basliginin_{string}_icerdigini_test_eder")
    public void sayfa_basliginin__icerdigini_test_eder(String arg0) {
        Assert.assertTrue(Driver.getDriver().getTitle().contains("QA"));
    }

    @When("kullanici_tum_sayfanin_resmini_alir")
    public void kullanici_tum_sayfanin_resmini_alir() {
        ReusableMethods.tumSayfaScreenShoot();
    }


    @And("searchBoxda_{string}_arattirir")
    public void searchboxda__arattirir(String arg0) {
        techproPage=new TechproPage();
        techproPage.searchBox.sendKeys("qa", Keys.ENTER);
    }
}
