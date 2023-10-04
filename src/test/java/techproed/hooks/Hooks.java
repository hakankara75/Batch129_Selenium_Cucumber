package techproed.hooks;


import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import techproed.pages.BlueRentalCarPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ExcelUtils;
import techproed.utilities.ReusableMethods;

public class Hooks {

  /*
Her bir Scenario'dan önce yada sonra çalışmasını istediğimiz metotları @Before ve @After kullanarak bu classın içerisine koyuyoruz.
Burada daha çok raporlama için kodlar kullacağız.
Screenshot alinip rapora koyulur
asagida hata alinirsa screenshot yapilacagina dair metot var
 */


    @Before ("All") //@Before importu cucumber'dan olmali
    public void setup(){
        System.out.println("Before Methodu");

    }
    @Before ("@gr1")
    public void setup1(){
        System.out.println("Amazonda SQL aratildi");

    }
    @Before ("@gr2")
    public void setup2(){
        System.out.println("Amazonda Java aratildi");

    }
    @Before ("@gr3")
    public void setup3(){
        System.out.println("Amazonda Selenium aratildi");

    }

    @Before ("@Excel")
    public void setup4(){
       /*
    bu before hooks mantiginin anlasilmasi icin yapildi. normalde hook icinde boyle uzun kodlar olmaz.
    feature ya da runnerdan calistirsak da once before calisir sonra feature sonra after calisir.
     */
        System.out.println("Amazonda Selenium aratildi");
        Driver.getDriver().get(ConfigReader.getProperty("blueRentACarUrl"));
        BlueRentalCarPage blueRentalCarPage=new BlueRentalCarPage();
        ExcelUtils excelUtils=new ExcelUtils("src/test/resources/mysmoketestdata.xlsx", "customer_info");
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
    }

    @After  //@After importu cucumber'dan olmali
    public void teardown(Scenario scenario){// bu class yardimci olacak
        //Eger scenario failed olursa alinan ekran goruntusu rapora eklenecek.
        final byte[] failedScreenShot=((TakesScreenshot)Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
        if (scenario.isFailed()){
            TakesScreenshot ts= (TakesScreenshot) Driver.getDriver();
            scenario.attach(failedScreenShot,"image/png", "failed_scenario"+scenario.getName());

        }
        Driver.closeDriver();

    }

}
