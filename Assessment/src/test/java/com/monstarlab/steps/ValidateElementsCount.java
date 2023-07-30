package com.monstarlab.steps;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

public class ValidateElementsCount
{
	int NoOfElements;
	public WebElement carouselsElemetList;
	Utility utils = new Utility();
	private static final Logger logger = LogManager.getLogger(ValidateElementsCount.class);
	public WebDriverWait wait = new WebDriverWait(utils.driver,30);
	
//Scroll down till Respective Carousel for which parameter has Passed through Feature file
	@When("Scroll down to Carousel {string}")	
	public void scrollDownToCarousel(String CarouselNumber) {	
		
		try { 	
//Get current carousel by calling the utility function
			carouselsElemetList = utils.getCarousel(CarouselNumber);
			
//Scroll Down until Carousel is Visible
			utils.js.executeScript("arguments[0].scrollIntoView();", carouselsElemetList);
			
//Wait until Carousel fully loaded into a page
			utils.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			//wait.until(ExpectedConditions.visibilityOf(utils.carouselsElemetList)); //Explicit Wait
		}
		catch(Exception e) {e.printStackTrace();		}
	}

	@Then("Count the no of Elements of Carousel")
	public void countTheNoOfElementsOfCarousel() {			
		 try {
//Count the No of Elements or Li tags from the given Carousel
			 NoOfElements = carouselsElemetList.findElements(By.tagName("article")).size();
		}
		catch(Exception e) {e.printStackTrace();		}
	}

	@Then("Validate Expected elements {int} exist in Carousel {string}")
	public void validateCountOfCarouselElements(int count, String CarouselNumber) {
		 try {			 
//Log information that which carousel has how many elements
			 System.out.print("OUTPUT: Carousel "+CarouselNumber+ " has "+ NoOfElements+ " Elements\n");
 
//Test will Pass If No of elements is equal to Value got through feature file(15)
//Test will Fail if Values does not matches
			 Assert.assertEquals(count, NoOfElements);			
			 
		} // We can use Soft Assertion if there and multiple asset statements to continue the execution
		catch(Exception e) {e.printStackTrace();		}
	}	    
} 
