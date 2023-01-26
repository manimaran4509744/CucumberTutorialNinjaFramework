package org.testRunnerPkg;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = { "src/test/resources/FeatureFiles" },tags=("@Home or @Cart or @Forgot"), dryRun = false, glue = {"org.stepDefinitionPkg",
		"org.hooks" }, plugin = { "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
				"timeline:test-output/", "html:test-output/CucumberReport/cucumber.html",
				"rerun:test-output/Rerun.txt" })
public class TestRunnerClass {
	
	

}
