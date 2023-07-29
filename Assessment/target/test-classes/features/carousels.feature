@Test
Feature: Testing

Scenario: Initiate Carousels of HomePage
    Given Webpage is up and running
    When Navigate to HomePage
  
Scenario Outline: Validate No of Elements of Courousels    	
  	When Scroll down to Carousel <Number>
 	Then Count the no of Elements of Carousel <Number>
 	Then Validate Expected elements <Size> exist in Carousel <Number>
 	 	
	Examples:
 	|Number| Size	|
 	| 1    | 15		|
  	| 2    | 15		|
	| 3    | 15		|
	| 4    | 15		|
	| 5    | 15		|

	
Scenario Outline: Validate Uniqueness of Elements of Courousels   
 	When Read the all Elements of Carousel <Number>
 	Then Validate uniqueness of elements of Carousel <Number>
 	
	Examples:
 	|Number| Size	|
 	| 1    | 15		|
  	| 2    | 15		|
	| 3    | 15		|
	| 4    | 15		|
	| 5    | 15		|	

Scenario: Closure of Test
    Given Close the Webpage
    
