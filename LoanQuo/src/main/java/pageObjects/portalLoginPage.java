package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class portalLoginPage {
	
	public WebDriver driver;
	public portalLoginPage(WebDriver driver) 
	{
		this.driver=driver;
	}
	
	By CompanyNameWithYear = By.xpath("//p[@class='mb-0']");
	By LoginCompanyName1 = By.xpath("//div[@class='text-primary p-4']//p");
	By LoginCompanyName2 = By.xpath("//p[@class='text-muted']");
	By CompanyNameonCheckLabel = By.xpath("//label[@class='form-check-label']");
	By username = By.id("email");
	By password = By.id("password");
	By forgotPassword = By.xpath("//a[normalize-space()='Forgot password?']");
	By passwordEye = By.cssSelector("#password-addon");
	By agreeCheck = By.cssSelector("#agreeCheck");
	By agreementLink = By.cssSelector("a[href='/agreement']");
	By submitButton = By.cssSelector("#submitbtn");
	By signUpNow = By.cssSelector(".fw-medium.text-primary");
	By emailError = By.id("email-error");
	By passwordError = By.id("password-error");
	By agreeCheckError = By.id("agreeCheck-error");
	
	
	public WebElement CompanyNameWithYearAtLoginPage()
	{
		return driver.findElement(CompanyNameWithYear); 
	}
	public WebElement Username()
	{
		return driver.findElement(username);
	}
	public WebElement Password()
	{
		return driver.findElement(password); 
	}
	public WebElement ForgotPassword()
	{
		return driver.findElement(forgotPassword); 
	}
	public WebElement PasswordEye()
	{
		return driver.findElement(passwordEye); 
	}
	public WebElement AgreementCheck()
	{
		return driver.findElement(agreeCheck); 
	}
	public WebElement AgreementLink()
	{
		return driver.findElement(agreementLink); 
	}
	public portalDashboard ClickSubmitButton()
	{
		driver.findElement(submitButton).click();
		return new portalDashboard(driver);
	
	}
	public WebElement SignUpNowLink()
	{
		return driver.findElement(signUpNow); 
	}
	public WebElement emailError()
	{
		return driver.findElement(emailError); 
	}
	public WebElement passwordError()
	{
		return driver.findElement(passwordError); 
	}
	public WebElement agreeCheckError()
	{
		return driver.findElement(agreeCheckError); 
	}
	public WebElement LoginCompanyName1() {
		// TODO Auto-generated method stub
		return driver.findElement(LoginCompanyName1); 
	}
	public WebElement LoginCompanyName2() {
		// TODO Auto-generated method stub
		return driver.findElement(LoginCompanyName2); 
	}
	public WebElement CompanyNameOnCheckLabel() {
		// TODO Auto-generated method stub
		return driver.findElement(CompanyNameonCheckLabel); 
	}
	
}
