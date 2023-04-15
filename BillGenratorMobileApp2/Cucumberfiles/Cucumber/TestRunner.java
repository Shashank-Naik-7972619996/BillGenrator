package Cucumber;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/CucumberFeatureFiles", glue="StepDefination",stepNotifications=true)
public class TestRunner {
}
