package org.cleartrip.pageobjects;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.cleartrip.utils.SearchData;
import org.cleartrip.utils.Waiting;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

/*
 * @author Hemanth.Sridhar
 */
public class ClearTripFlightPageObjects {
   
	public ClearTripFlightPageObjects(WebDriver driver){
		PageFactory.initElements(driver, this);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}
	
	@FindBy(xpath="//input[@id='FromTag']")
	private WebElement fromTextBox;
	
	@FindBy(xpath="//input[@id='ToTag']")
	private WebElement toTextBox;
	
	@FindBy(xpath="//input[@id='DepartDate']")
	private WebElement departDate;
	
	@FindBy(xpath="//div[@class='monthBlock first']/descendant::a[text()='19']")
	private WebElement departFromDate;
	
	@FindBy(xpath="//select[@id='Adults']")
	private WebElement AdultsDropDown;
	
	@FindBy(xpath="//select[@id='Childrens']")
	private WebElement ChildrenDropDown;
	
	@FindBy(xpath="//select[@id='Infants']")
	private WebElement InfantsDropDown;
	
	@FindBy(xpath="//input[@id='SearchBtn']")
	private WebElement searchButtonFlight;
	
	@FindBy(xpath="//li[@class='listItem showTabs ']/descendant::button[1]")
	private WebElement bookClick;
	
	@FindBy(xpath="//input[@id='insurance_box']")
	private WebElement insuranceCheckBox;
	
	@FindBy(xpath="//input[@value='Continue booking']")
	private WebElement continueBookingButton;
	
	@FindBy(xpath="//input[@id='username']")
	private WebElement enterUserName;
	
	@FindBy(xpath="//input[@value='Continue']")
	private WebElement continueButton;
	
	@FindBy(xpath="//select[@id='AdultTitle1']")
	private WebElement salutation;
	
	@FindBy(xpath="//input[@id='AdultFname1']")
	private WebElement firstName;
	
	@FindBy(xpath="//input[@id='AdultLname1']")
	private WebElement lastName;
	
	@FindBy(xpath="//input[@id='mobileNumber']")
	private WebElement mobileNumber;
	
	@FindBy(xpath="//input[@id='paymentSubmit']")
	private WebElement paymentButton;
	
	@FindBy(id="homeErrorMessage")
	private WebElement homeErrorMessageFlight;
	
	public void bookFlightTicket() throws IOException{
		fromCity();
		toCity();
		departDateClick();
		adultsDropDown();
		childrenDropDown();
		infantDropDown();
		searchButtonClick();
		clickBook();
		clickInsuranceCheckBox();
		clickContinueBooking();
		enterUsername();
		enterTravellersDetails();
		assertPaymentButton();	
	}
	
	public void checkErrorMsgInFlightPage() throws IOException {
		clearFromCityAndToCity();
		searchButtonClick();
		assertErrorMsg();
	}


	public void fromCity() throws IOException
	{
	fromTextBox.click();
	fromTextBox.sendKeys(SearchData.propertiesReader("resources/PropertyFiles/SearchData.properties", "flightFromText"));
	}
	

	public void toCity() throws IOException
	{
	toTextBox.click();
	toTextBox.sendKeys(SearchData.propertiesReader("resources/PropertyFiles/SearchData.properties", "flightToText"));
	}
	
	public void departDateClick()
	{
		departDate.click();	
		departFromDate.click();		
	}
	
	public void adultsDropDown() throws IOException{
		Select select = new Select(AdultsDropDown);
		select.selectByVisibleText(SearchData.propertiesReader("resources/PropertyFiles/SearchData.properties", "numberOfAdults"));	
	}
	
	public void childrenDropDown() throws IOException{
		Select select = new Select(ChildrenDropDown);
		select.selectByVisibleText(SearchData.propertiesReader("resources/PropertyFiles/SearchData.properties", "numberOfChildren"));	
			}
	
	public void infantDropDown() throws IOException{
		Select select = new Select(ChildrenDropDown);
		select.selectByVisibleText(SearchData.propertiesReader("resources/PropertyFiles/SearchData.properties", "numberOfInfants"));	
			}
	
	public void searchButtonClick(){
		searchButtonFlight.click();
	}
	
	public void clickBook(){
		bookClick.click();
	}
	
	public void clickInsuranceCheckBox(){
		insuranceCheckBox.click();
	}
	
	public void clickContinueBooking(){
		Waiting.explicitWaitVisibilityOfElement(continueBookingButton, 10);
		continueBookingButton.click();
	}
	
	public void enterUsername() throws IOException
	{
		enterUserName.click();
		enterUserName.sendKeys(SearchData.propertiesReader("resources/PropertyFiles/SearchData.properties", "enterUsername"));
		continueButton.click();
	}
	
	public void enterTravellersDetails() throws IOException
	{
		Waiting.explicitWaitVisibilityOfElement(salutation, 10);
		Select select = new Select(salutation);
		select.selectByVisibleText(SearchData.propertiesReader("resources/PropertyFiles/SearchData.properties", "salutation"));
		Waiting.explicitWaitVisibilityOfElement(firstName, 5);
		firstName.click();		
		firstName.sendKeys((SearchData.propertiesReader("resources/PropertyFiles/SearchData.properties", "firstName")));
		Waiting.explicitWaitVisibilityOfElement(lastName, 5);
		lastName.click();
		lastName.sendKeys((SearchData.propertiesReader("resources/PropertyFiles/SearchData.properties", "LastName"))); 
		Waiting.explicitWaitVisibilityOfElement(mobileNumber, 3);
		mobileNumber.click();
		mobileNumber.sendKeys((SearchData.propertiesReader("resources/PropertyFiles/SearchData.properties", "mobileNumber")));
	}
	
	public void assertPaymentButton(){
		Assert.assertTrue(paymentButton.isEnabled());
	}
	
	public void clearFromCityAndToCity() {
		fromTextBox.click();
		fromTextBox.clear();
		toTextBox.click();
		toTextBox.clear();
		
	}
	
	public void assertErrorMsg()
	{
		Waiting.explicitWaitVisibilityOfElement(homeErrorMessageFlight, 3);
		Assert.assertTrue(homeErrorMessageFlight.isDisplayed());
	}
}
