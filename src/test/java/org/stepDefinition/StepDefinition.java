package org.stepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefinition extends BaseClass{
	@Given("To launch the chrome browser")
	public void to_launch_the_chrome_browser() {
		launchBrowser();
		windowMaximize();
	  
	}

	@When("To launch the facebook page")
	public void to_launch_the_facebook_page() {
		LaunchUrl("https://www.facebook.com/login/");
	    
	}

	@When("To pass the data to the username and password")
	public void to_pass_the_data_to_the_username_and_password() {
		WebElement user=driver.findElement(By.id("email"));
		user.sendKeys("pravin");
		WebElement pass=driver.findElement(By.id("pass"));
		user.sendKeys("123456");
	}

	@When("To click the login button")
	public void to_click_the_login_button() {
		WebElement btn=driver.findElement(By.id("loginbutton"));
		btn.click();
	 
	}

	@Then("To close the browser")
	public void to_close_the_browser() {
	 driver.close();
	}

	@Given("to launch the browser")
	public void to_launch_the_browser() {
		launchBrowser();
		windowMaximize();
	}

	@When("to launch the email")
	public void to_launch_the_email() {
		LaunchUrl("https://www.gmail.com/");
	}

	@When("to pass the data {string}")
	public void to_pass_the_data(String string) {
		WebElement user = driver.findElement(By.id("identifierId"));
		user.sendKeys(string);
	    
	}

	@Then("close the browser")
	public void close_the_browser() {
	   driver.close();
	}



}
