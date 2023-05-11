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
                        "html:target/default-cucumber-reports.html",
                        "json:target/json-reports/cucumber.json",
                        "junit:target/xml-report/cucumber.xml"
                },
              //  monochrome = true, //console okunakli hale getirir, renksiz yapar
                features = "src/test/resources/features/",
                 glue = {"techproed/stepDefinitions", "techproed/hooks"},//Bu parametre ile kodlarımızı yazdığımız stepDefinition
                                                     //class'ının packege'ını belirtiriz
                 tags = "@BlueRentalCarDataTableMap",
                 dryRun = false                               )
/*
features ===> features'ların olduğu packega'ın yolunu ver(ContentRoot)
glue ====> stepDefinition'ların olduğu packega'ın yolunu ver(Source Root)
tags ====> çalıştırmak istediğin grubu yaz
dryRun = true ====> eksik step definition bulup gösterir. calismaz. konsolda eksik stepleri gosterir.
 */

public class Runner {
}
