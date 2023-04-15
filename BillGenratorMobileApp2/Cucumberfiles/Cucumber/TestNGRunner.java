package Cucumber;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/java/CucumberFeatureFiles", glue = "StepDefination")
public class TestNGRunner extends AbstractTestNGCucumberTests {

}