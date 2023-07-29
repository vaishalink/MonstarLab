package com.monstarlab.steps;

import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

public class ValidateUniqueness {
	
	Utility utils = new Utility();
	public List<String> productIds = new ArrayList<String>();
	private static final Logger logger = LogManager.getLogger(ValidateUniqueness.class);
	
//Read the Carousel for which parameter has Passed through Feature file
	@When("Read the all Elements of Carousel {int}")
	public void readElementsOfCarousel(int CarouselNumber) {
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
		}
		catch(Exception e) {
			e.printStackTrace();
		}    
	}

	
	@Then("Validate uniqueness of elements of Carousel {int}")
	public void validateUniquenessOfCarouselElements(int CarouselNumber) {
		 try {
//Get and store  Element List of all the elements exist in that Carousel
			 utils.CarouselsElemets = utils.carouselsElemetList.findElements(By.tagName("article"));

//Collect Unique product ID for each element from the stored Element List
			 for(int i=0; i<utils.CarouselsElemets.size(); i++) {				 
				 productIds.add(utils.CarouselsElemets.get(i).getAttribute("data-scroll-id"));
			 }       
			 
//Log the Info that No of Distinct Elements are Present in which Carousel
			 logger.info(productIds.stream().distinct().count()+" Unique elements are present in Carousel "+CarouselNumber);
			 
//Test Case will Pass only if all the Elements form the List are Distinct
//Test Case will Fail if Size od ElementList and DistinctElementLisr are different
			 Assert.assertEquals(productIds.size(), productIds.stream().distinct().count());				 
		}
		catch(Exception e) {
			e.printStackTrace();
		}		
	}
}  // We can use Soft Assertion if there and multiple asset statements to cntinue the execution

