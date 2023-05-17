package techproed.runners;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
/*
Runner class; testNG deki .xml file larda belirttiğimiz class'ları,packageları veya methodları nasıl
çalıştırıyorsak, Cucumber frameworkundede Runner class'ındaki tags parametresi ile belirttiğimiz
senaryoyu çalıştırabiliriz
 */
//Cucumber ile JUnit'in entegre olmasını sağlayan test çalıştırıcı notasyonudur
@RunWith(Cucumber.class)
//Seneryoların nerede ve nasıl çalışacağı, hangi raporu kullanacağıyla alakalı seçenekleri ayarlarız
@CucumberOptions(  //plugin kismi raporlar icin
        plugin = {
                "pretty", //console renkli yazdirmak icin
                "html:src/test/resources/features/htmlReport/cucumberHooks1.html",
                "json:target/json-reports/cucumber1.json",
                "junit:src/test/resources/features/htmlReport/cucumber1.xml",
                "rerun:TestOutput/failed_scenario.txt",//rerun hata veren testleri kaydedip yeniden otomatik kosmak icin
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},//spark report icin
        //  monochrome = true, //console okunakli hale getirir, renksiz yapar
        features = "src/test/resources/features",
        glue = {"techproed/stepDefinitions"},//Bu parametre ile kodlarımızı yazdığımız stepDefinition
        //class'ının packege'ını belirtiriz
        tags = "@techpro1",
        dryRun = false                               )
public class ozHakikiRunner {
}
