@Test
Feature: MonsratLab Assessment

Scenario: Validate Carousels of HomePage
    Given Webpage is up and running
    When Navigate to HomePage
  
Scenario Outline: Validate No of Elements of Courousels    	
  	When Scroll down to Carousel "<carousel>"
 	Then Count the no of Elements of Carousel
 	Then Validate Expected elements <Size> exist in Carousel "<carousel>"
 	 	
	Examples:
 	|carousel       | Size		|
 	| carousel_1    | 15		|
  	| carousel_2    | 15		|
	| carousel_3    | 15		|
	| carousel_4    | 15		|
	| carousel_5    | 15		|

	
Scenario Outline: Validate Uniqueness of Elements of Courousels   
 	When Read the all Elements of Carousel "<carousel>"
 	Then Validate uniqueness of elements of Carousel "<carousel>"
 	
	Examples:
 	|carousel       | Size		|
 	| carousel_1    | 15		|
  	| carousel_2    | 15		|
	| carousel_3    | 15		|
	| carousel_4    | 15		|
	| carousel_5    | 15		|

Scenario: Closure of Test
    Given Close the Webpage
    
