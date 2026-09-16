package com.tricentiswebshop.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Tricentis_RegisterPage {
	
	 WebDriver driver;

	    @FindBy(id = "gender-male")
	    WebElement male;

	    @FindBy(id = "gender-female")
	    WebElement female;

	    @FindBy(id = "FirstName")
	    WebElement firstName;

	    @FindBy(id = "LastName")
	    WebElement lastName;

	    @FindBy(id = "Email")
	    WebElement email;

	    @FindBy(id = "Password")
	    WebElement password;

	    @FindBy(id = "ConfirmPassword")
	    WebElement confirmPassword;

	    @FindBy(id = "register-button")
	    WebElement registerButton;
	    
	    @FindBy(css = "input.register-continue-button")
	    WebElement continueButton;

		@FindBy(xpath = "//a[@class='ico-logout']")
		WebElement logout;

	    public Tricentis_RegisterPage(WebDriver driver) {
	        this.driver = driver;
	        PageFactory.initElements(driver, this);
	    }


	    public void selectMale() {
	        male.click();
	    }

	    public void selectFemale() {
	        female.click();
	    }

	    public void enterFirstName(String firstNameValue) {
	        firstName.clear();
	        firstName.sendKeys(firstNameValue);
	    }

	    public void enterLastName(String lastNameValue) {
	        lastName.clear();
	        lastName.sendKeys(lastNameValue);
	    }

	    public void enterEmail(String emailValue) {
	        email.clear();
	        email.sendKeys(emailValue);
	    }

	    public void enterPassword(String passwordValue) {
	        password.clear();
	        password.sendKeys(passwordValue);
	    }

	    public void enterConfirmPassword(String confirmPasswordValue) {
	        confirmPassword.clear();
	        confirmPassword.sendKeys(confirmPasswordValue);
	    }

	    public void clickRegister() {
	        registerButton.click();
	    }
	    public boolean isFirstNameDisplayed() {
	        return firstName.isDisplayed();
	    }

	    public boolean isLastNameDisplayed() {
	        return lastName.isDisplayed();
	    }

	    public boolean isEmailDisplayed() {
	        return email.isDisplayed();
	    }

	    public boolean isPasswordDisplayed() {
	        return password.isDisplayed();
	    }

	    public boolean isConfirmPasswordDisplayed() {
	        return confirmPassword.isDisplayed();
	    }

	    public boolean isRegisterButtonDisplayed() {
	        return registerButton.isDisplayed();
	    }
	    public void clickContinue() {
	        continueButton.click();
	    }
		public void clickLogout() {
		    logout.click();
		}
}
