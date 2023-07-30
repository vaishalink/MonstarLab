package com.monstarlab.pagefactory;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
//Locate all the Carousels WebElement on the Page
	
	@FindBy(xpath = "//*[@id=\"main-content\"]/div/div[2]/div[1]/div/div/div/div/div/div[2]/div/section/div/ul")
	WebElement carousel_1_ElementList;
	
	@FindBy(xpath = "//*[@id=\"main-content\"]/div/div[2]/div[5]/div/div/div/div/div/div[2]/div/section/div/ul")
	WebElement carousel_2_ElementList;

	@FindBy(xpath = "//*[@id=\"main-content\"]/div/div[2]/div[6]/div/div/div/div/div/div[2]/div/section/div/ul")
	WebElement carousel_3_ElementList;

	@FindBy(xpath = "//*[@id=\"main-content\"]/div/div[2]/div[7]/div/div/div/div/div/div[2]/div/section/div/ul")
	WebElement carousel_4_ElementList;
	
	@FindBy(xpath = "//*[@id=\"main-content\"]/div/div[2]/div[8]/div/div/div/div/div/div[2]/div/section/div/ul")
	WebElement carousel_5_ElementList;


//Initialize PageFactory Web Elements	
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);		
	}
	
	//Getters to return the WebElements
	public WebElement getCarousel_1_ElementList() {
		return carousel_1_ElementList;	
	}
	public WebElement getCarousel_2_ElementList() {
		return carousel_2_ElementList;	
	}
	public WebElement getCarousel_3_ElementList() {
		return carousel_3_ElementList;	
	}
	public WebElement getCarousel_4_ElementList() {
		return carousel_4_ElementList;	
	}
	public WebElement getCarousel_5_ElementList() {
		return carousel_5_ElementList;	
	}

}
