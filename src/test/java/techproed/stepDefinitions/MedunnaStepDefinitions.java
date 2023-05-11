package techproed.stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.Select;
import techproed.pages.MedunnaPage;
import techproed.utilities.Driver;

import static org.junit.Assert.assertTrue;

public class MedunnaStepDefinitions {
    MedunnaPage medunnaPage=new MedunnaPage();
    @Given("{string} adresine git")
    public void adresine_git(String url) {
        Driver.getDriver().get(url);
    }
    @When("kullanici simgesini tikla")
    public void kullanici_simgesini_tikla() {
    medunnaPage.kullaniciSimgesi.click();
    }
    @When("sign in secenegini tikla")
    public void sign_in_secenegini_tikla() {
    medunnaPage.signInSecenegi.click();
    }
    @When("usarname kutusuna {string} gir")
    public void usarname_kutusuna_gir(String userName) {
    medunnaPage.userNameKutusu.sendKeys(userName);
    }
    @When("password kutusuna {string} gir")
    public void password_kutusuna_gir(String password) {
    medunnaPage.passwordKutusu.sendKeys(password);
    }
    @When("remember me radio butonunu tikla")
    public void remember_me_radio_butonunu_tikla() {
    medunnaPage.rememberMe.click();
    }
    @When("sign in butonunu tikla")
    public void sign_in_butonunu_tikla() {
    medunnaPage.signIn.click();
    }
    @When("items&titles sekmesini tikla")
    public void items_titles_sekmesini_tikla() {
    medunnaPage.itemsAndTitles.click();
    }
    @When("room secenegini tikla")
    public void room_secenegini_tikla() {
    medunnaPage.room.click();
    }
    @When("create a new room botonunu tikla")
    public void create_a_new_room_botonunu_tikla() {
    medunnaPage.createANewRoom.click();
    }
    @When("room number kutusuna {string} gir")
    public void room_number_kutusuna_gir(String string) {
    medunnaPage.roomNumber.sendKeys(string);
    }
    @When("room type drop downdan {string} sec")
    public void room_type_drop_downdan_sec(String roomType) {

        new Select(medunnaPage.roomType).selectByVisibleText(roomType);

    }
    @When("price kutusuna {string} gir")
    public void price_kutusuna_gir(String price) {
    medunnaPage.roomPrice.sendKeys(price);
    }
    @When("description kutusuna {string} gir")
    public void description_kutusuna_gir(String description) {
    medunnaPage.description.sendKeys(description);
    }
    @When("save butonunu tikla")
    public void save_butonunu_tikla() {
    medunnaPage.saveButton.click();
    }
    @Then("kaydedildi alertini dogrula")
    public void kaydedildi_alertini_dogrula() throws InterruptedException {
        Thread.sleep(2000);
    assertTrue(medunnaPage.kaydedildiAlert.getText().contains("A new Room is created"));
    }

}
