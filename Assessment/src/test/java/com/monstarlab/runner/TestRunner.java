package com.monstarlab.runner;

import io.cucumber.junit.CucumberOptions;

@CucumberOptions(
		features = {"C:/Users/Vaishali Narkhede/eclipse-workspace/Assessment/src/test/resources/features/carousels.feature"},
		glue = {"monstarlab"},  //Folders that contains Step Definitions
		plugin = {"pretty","html:myOutput"},  //To display output in Nicer formant
		dryRun=true,    // Once added Scenario can check if All steps covered in coding 
		strict = true,		
		tags = {"@Test"}	//To Run different Test Suits	
		)

public class TestRunner {


}
