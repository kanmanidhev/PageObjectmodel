package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {

	//PAGE FACTORY OR OBJECT REPOSITORY
	@FindBy(name = "username")
	WebElement username;
	
	
	@FindBy(name = "password")
	WebElement password;
	
	
	
	@FindBy(xpath ="//input[@type='submit']")
	WebElement loginBtn;
	
	@FindBy(xpath ="//font[contains(text(),'Sign Up')]")
	WebElement SignUpBtn;
	
	@FindBy(xpath ="//img[contains(@class,'img-responsive')]")
	static
	WebElement crmLogo;
	
	
	//initializing page objects
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	public static String validateLoginPagetitle() {
		return driver.getTitle();
	}
	
	
	public static boolean ValidateCRMImage() {
		return crmLogo.isDisplayed();
	}
	
	
	public HomePage login(String un,String pwd) {
		username.sendKeys(un);
		password.sendKeys(pwd);
		
		
		try
        {
            

            //Step 1
            new Actions(driver).moveToElement(loginBtn).perform();  

            //Step 2
            loginBtn.click();
        }
        catch (org.openqa.selenium.WebDriverException ex)
        {
            //Step 3
        	loginBtn.click();
        }
		
		return new HomePage();
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
