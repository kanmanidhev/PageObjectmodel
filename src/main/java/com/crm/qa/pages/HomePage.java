package com.crm.qa.pages;

import com.crm.qa.base.TestBase;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class HomePage extends TestBase {
	
	@FindBy(xpath="//td[contains(text(),'User: Dhev Ananth')]")
	@CacheLookup
	WebElement userNameLabel;
	
	@FindBy(xpath = "//a[contains(text(),'Contacts')]")
	WebElement contactLink;
	
	
	@FindBy(xpath = "//a[contains(text(),'Deals')]")
	WebElement dealsLink;
	
	
	@FindBy(xpath = "//a[contains(text(),'Tasks')]")
	WebElement tasksLink;
	
	@FindBy(xpath = "//a[contains(text(),'New Contact')]")
	WebElement newContactLink;
	
	//initializing page objects
		public HomePage() {
			PageFactory.initElements(driver, this);
		}
		
		public String verifyHomePageTitle(){

			return driver.getTitle();
		}
		
		public boolean verifyCorrectUserName() {
			return userNameLabel.isDisplayed();
			
			
		}
		
		public ContactsPage clickonContactsPage() {
			contactLink.click();
			return new ContactsPage();
		}
		
		public DealsPage clickonDealsPage() {
			dealsLink.click();
			return new DealsPage();
		}
		
		public TasksPage clickonTaskssPage() {
			tasksLink.click();
			return new TasksPage();
			
		
		}
		
		public void clickOnNewContactLink() {
			Actions action = new Actions(driver);
			action.moveToElement(contactLink).build().perform();
			newContactLink.click();
			
		}
		

}
