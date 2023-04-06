package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminLoginOBJ {

	WebDriver driver;
	
	public AdminLoginOBJ(WebDriver ldriver) {
		driver=ldriver;
		PageFactory.initElements(ldriver, this);
		
	}
	/*
	 * locator for LoginPage 
	 */

	

	@FindBy(xpath = "//input[@formcontrolname='userName']")
	@CacheLookup
	WebElement usm;

	@FindBy(xpath ="//input[@formcontrolname='password']")
	@CacheLookup
	WebElement pwd;

	@FindBy(xpath ="//button [@class='btn btn-log']")
	@CacheLookup
	WebElement logIn;
	
	/*
	 *  Method For LogIN page
	 */





	public void UName(String name) {
		usm.sendKeys(name);
	}

	public void pWord(String password) {
		pwd.sendKeys(password);
	}

	public void login() {
		logIn.click();
	}
}
