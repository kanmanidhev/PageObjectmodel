//author kanmani
package com.crm.qa.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase {
	

	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	ContactsPage contactsPage;
	
	String sheetName ="contacts";
	
	
	public ContactsPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		testUtil = new TestUtil();
		loginPage = new LoginPage();
		contactsPage = new ContactsPage();
		homePage =loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		testUtil.switchToFrame();
		homePage.clickonContactsPage();
	}
	
	
	
	@Test(priority=1)
	public void verifyContactsPageLabelTest() {
		Assert.assertTrue(contactsPage.verifyContactsLabel(),"Contact Label is missin on the page");
	}
	
	@Test(priority=2)
	public void selectSingleContactsTest() {
		contactsPage.selectContacts("kanmani dhev");
	}
	
	@Test(priority=3)
	public void selectMutlipleContactsTest() {
		contactsPage.selectContacts("kanmani dhev");
		contactsPage.selectContacts("rishi dhev");
	}
	
	@DataProvider
	public Object[][] getCRMTestData() {
		Object data[][] = 	testUtil.getTestData(sheetName);
		return data;
		
	}
	
	@Test(priority=4,dataProvider ="getCRMTestData" )
	public void validateCreateNewContactTest(String title,String firstName,String lastName,String company) {
		
			homePage.clickOnNewContactLink();
		
		//contactsPage.createNewContact("Mr.", "Ish", "Dhev", "Google");
			contactsPage.createNewContact(title,firstName,lastName,company);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	
	
	
	
	
	
	
	

}