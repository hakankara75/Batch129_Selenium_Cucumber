package techproed.stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import techproed.pages.DataTablePage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;

import static org.junit.Assert.assertTrue;

public class DataTableStepDefinitions {

 DataTablePage dataTablePage = new DataTablePage();

    @Given("user is on {string} page")
    public void user_is_on_page(String url) {
        Driver.getDriver().get(url);
    }
    @Given("user clicks on the New button")
    public void user_clicks_on_the_new_button() {

        dataTablePage.newButton.click();

    }
    @Given("user enters the first name {string}")
    public void user_enters_the_first_name(String firstName) {

        dataTablePage.firstName.sendKeys(firstName);

    }
    @Given("user enters the last name {string}")
    public void user_enters_the_last_name(String lastName) {

        dataTablePage.lastName.sendKeys(lastName);

    }
    @Given("user enters the position {string}")
    public void user_enters_the_position(String string) {

        dataTablePage.position.sendKeys(string);

    }
    @Given("user enters the office {string}")
    public void user_enters_the_office(String string) {

        dataTablePage.office.sendKeys(string);

    }
    @Given("user enters the extension {string}")
    public void user_enters_the_extension(String string) {

        dataTablePage.extension.sendKeys(string);

    }
    @Given("user enters the start date {string}")
    public void user_enters_the_start_date(String string) {

        dataTablePage.startDate.sendKeys(string);

    }
    @Given("user enters the salary {string}")
    public void user_enters_the_salary(String string) {

        dataTablePage.salary.sendKeys(string);

    }
    @Given("click on create button")
    public void click_on_create_button() {

        dataTablePage.createButton.click();

    }
    @Given("search for the first name {string}")
    public void search_for_the_first_name(String string) {

        dataTablePage.searchBox.sendKeys(string);

    }
    @Then("verify the name field contains the first name {string}")
    public void verify_the_name_field_contains_the_first_name(String firstName) {

        assertTrue(dataTablePage.isimSutunu.get(0).getText().contains(firstName));

    }
    @Then("close the application")
    public void close_the_application() {

        Driver.closeDriver();

    }
}