package com.monstarlab.steps;

import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

public class ValidateUniqueness {
	
	Utility utils = new Utility();
	public List<String> productIds = new ArrayList<String>();
	public WebElement carouselsElemetList;
	private static final Logger logger = LogManager.getLogger(ValidateUniqueness.class);
	
//Read the current Carousel 
	@When("Read the all Elements of Carousel {string}")
	public void readElementsOfCarousel(String CarouselNumber) {
		 try {
//Get current carousel by calling the utility function
			 carouselsElemetList = utils.getCarousel(CarouselNumber);
		}
		catch(Exception e) {e.printStackTrace();		}
	}
	
	@Then("Validate uniqueness of elements of Carousel {string}")
	public void validateUniquenessOfCarouselElements(String CarouselNumber) {
		 try {
//Get and store  Element List of all the elements exist in that Carousel
			 utils.CarouselsElemets = carouselsElemetList.findElements(By.tagName("article"));

//Collect Unique product ID for each element from the stored Element List
			 for(int i=0; i<utils.CarouselsElemets.size(); i++) {				 
				 productIds.add(utils.CarouselsElemets.get(i).getAttribute("data-scroll-id"));
			 }       
			 
//Log the Info that No of Distinct Elements are Present in which Carousel
			System.out.print("OUTPUT: "+productIds.stream().distinct().count()+" Unique elements are present in Carousel "+CarouselNumber +"\n\n");
			 
//Test Case will Pass only if all the Elements form the List are Distinct
//Test Case will Fail if Size of ElementList and DistinctElementLisr are different
// We can use Soft Assertion if there and multiple asset statements to continue the execution
			 Assert.assertEquals(productIds.size(), productIds.stream().distinct().count());			 
		} 
		catch(Exception e) {e.printStackTrace();		}
	}
}  

