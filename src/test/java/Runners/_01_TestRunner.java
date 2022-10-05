package Runners;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
        features = {"src/test/java/FeatureFiles/beymen.feature"}, // buraya feature files in path ı verilecek
        glue = {"StepDefinitions"},       //buraya step definitons klasörü verilecek
        plugin = { "html:target//cucumber-reports.html" }


)
public class _01_TestRunner extends AbstractTestNGCucumberTests {


}
