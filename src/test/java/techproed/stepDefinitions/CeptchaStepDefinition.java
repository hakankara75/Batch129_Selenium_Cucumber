package techproed.stepDefinitions;

import io.cucumber.java.en.Given;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;

public class CeptchaStepDefinition {

    @Given("captcha")
    public void captcha() {

        WebDriver driver = new ChromeDriver();

// Set the reCAPTCHA site key and secret key
        driver.manage().addCookie(new Cookie("reCAPTCHA_SITE_KEY", "your_site_key"));
        driver.manage().addCookie(new Cookie("reCAPTCHA_SECRET_KEY", "your_secret_key"));

// Go to the website with the reCAPTCHA
        driver.get("https://www.example.com/");

// Click on the reCAPTCHA checkbox
        driver.findElement(By.id("reCAPTCHA-checkbox")).click();

// Submit the form
        driver.findElement(By.id("submit")).click();
    }

}
