package com.monstarlab.steps;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.monstarlab.pagefactory.HomePage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class Utility {
	public static WebDriver driver;
	public HomePage home;
    public JavascriptExecutor js;
	public List<WebElement> CarouselsElemets;
	public WebElement carouselPath = null;
 
//Creating instance of HomePage
	public Utility() {
		home = new HomePage(driver);
		js= (JavascriptExecutor) driver;
	}

//Getting Carousel based on Input Passed through Feature file
	public WebElement getCarousel(String carousel) {
		try { 	
			if(carousel.equals("carousel_1"))
				carouselPath = home.getCarousel_1_ElementList();
			
			if(carousel.equals("carousel_2"))
				carouselPath = home.getCarousel_2_ElementList();
			
			if(carousel.equals("carousel_3"))
				carouselPath = home.getCarousel_3_ElementList();
			
			if(carousel.equals("carousel_4"))
				carouselPath = home.getCarousel_4_ElementList();

			if(carousel.equals("carousel_5"))
				carouselPath = home.getCarousel_5_ElementList();
		}
		catch(Exception e) {e.printStackTrace();		}
		return carouselPath;
	}
//Common Steps which can be run by Multiple feature files and Scenarios
//Initialise driver
	@When("Webpage is up and running")
	public void init() {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\selenium-java-3.141.59\\chromedriver.exe");
	    driver = new ChromeDriver();
	}
	
//Open URL
	@Given("Navigate to HomePage")
	public void Navigate_HomePage() {
		try {			 
			driver.get("https://mall.cz/");					 
		}
		catch(Exception e) {e.printStackTrace();		}		 
	}
	
//Close driver
	@Given("Close the Webpage")
	public void closeWebpage() {
		try {			 
			 driver.quit();					 
		}
		catch(Exception e) {e.printStackTrace();		}
	}
}
