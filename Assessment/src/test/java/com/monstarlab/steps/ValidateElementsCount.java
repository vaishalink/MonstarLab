package com.monstarlab.steps;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

public class ValidateElementsCount
{
	Utility utils = new Utility();
	private static final Logger logger = LogManager.getLogger(ValidateElementsCount.class);
	int NoOfElements;
	public WebDriverWait wait = new WebDriverWait(utils.driver,30);
	
//Scroll down till Respective Carousel for which parameter has Passed through Feature file
	@When("Scroll down to Carousel {int}")
	public void scrollDownToCarousel(int CarouselNumber) {	
		
		try { 	
			if(CarouselNumber == 1)
				utils.carouselsElemetList = utils.home.getCarousel_1_ElementList();
			
			if(CarouselNumber == 2)
				utils.carouselsElemetList = utils.home.getCarousel_2_ElementList();
			
			if(CarouselNumber == 3)
				utils.carouselsElemetList = utils.home.getCarousel_3_ElementList();
			
			if(CarouselNumber == 4)
				utils.carouselsElemetList = utils.home.getCarousel_4_ElementList();

			if(CarouselNumber == 5)
				utils.carouselsElemetList = utils.home.getCarousel_5_ElementList();
			
//Scroll Down until Carousel is Visible
			utils.js.executeScript("arguments[0].scrollIntoView();", utils.carouselsElemetList);
			
//Wait until Carousel fully loaded into a page
			utils.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			//wait.until(ExpectedConditions.visibilityOf(utils.carouselsElemetList)); //Explicit Wait
		}
		catch(Exception e) {
			e.printStackTrace();
		}	   
	}

	@Then("Count the no of Elements of Carousel {int}")
	public void countTheNoOfElementsOfCarousel(int CarouselNumber) {			
		 try {
//Count the No of Elements or Li tags from the given Carousel
			 NoOfElements = utils.carouselsElemetList.findElements(By.tagName("article")).size();
		}
		catch(Exception e) {
			e.printStackTrace();
		}	    
	}

@Then("Validate Expected elements {int} exist in Carousel {int}")
	public void validateCountOfCarouselElements(int count, int CarouselNumber) {
		 try {			 
//Log information that which carousel has how many elements
			 logger.info("OUTPUT: Carousel "+CarouselNumber+ " has "+ NoOfElements+ " Elements");
 
//Test will Pass If No of elements is equal to Value got through feature file(15)
//Test will Fail if Values does not matches
			 Assert.assertEquals(count, NoOfElements);					 
		}
		catch(Exception e) {
			e.printStackTrace();
		}		 
	}	    
} // We can use Soft Assertion if there and multiple asset statements to cntinue the execution
