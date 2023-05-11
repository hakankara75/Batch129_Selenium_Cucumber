package techproed.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import techproed.utilities.Driver;

public class MedunnaPage {
    public MedunnaPage() {

        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy (id="account-menu")
    public WebElement kullaniciSimgesi;
    @FindBy (id="login-item")
    public WebElement signInSecenegi;
    @FindBy (id="username")
    public WebElement userNameKutusu;
    @FindBy (id="password")
    public WebElement passwordKutusu;
    @FindBy (id="rememberMe")
    public WebElement rememberMe;
    @FindBy (xpath="//button[@type='submit']")
    public WebElement signIn;
    @FindBy (id="entity-menu")
    public WebElement itemsAndTitles;
    @FindBy (linkText="Room")
    public WebElement room;
    @FindBy (id="jh-create-entity")
    public WebElement createANewRoom;
    @FindBy (id="room-roomNumber")
    public WebElement roomNumber;
    @FindBy (id="room-roomType")
    public WebElement roomType;
    @FindBy (id="room-price")
    public WebElement roomPrice;
    @FindBy (id="room-description")
    public WebElement description;
    @FindBy (id="save-entity")
    public WebElement saveButton;
    @FindBy (xpath="//div[@class='Toastify__toast-container Toastify__toast-container--top-left toastify-container']")
    public WebElement kaydedildiAlert;




}
