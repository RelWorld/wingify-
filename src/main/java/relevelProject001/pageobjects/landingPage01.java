package relevelProject001.pageobjects;



import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevelProject.qa.utilis.abstractComponents01;

public class landingPage01 extends abstractComponents01 {
	WebDriver driver;

	public landingPage01(WebDriver driver) {
		super(driver);
		// initialization
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(css = "#username ")
	public WebElement username; // username

	@FindBy(css = "#password")
	public WebElement Password; // password

	@FindBy(css = "#log-in")
	public WebElement login; // loginbutton

	@FindBy(className = "form-check-input")
	public WebElement checkbox; // checkbox

	@FindBy(xpath = "(//div[@class='buttons-w']//img)[1]") // twitter
	public WebElement twitter;


	@FindBy(xpath = "(//div[@class='buttons-w']//img)[2]") // facebook
	public WebElement facebook;


	@FindBy(xpath = "(//div[@class='buttons-w']//img)[3]") // linkedin
	public WebElement linkedIn;

	@FindBy(xpath = "//div[@class='alert alert-warning']")
	public WebElement errorMessage; // error msg

	public HomePage login() {
		login.click();
		HomePage homePage = new HomePage(driver);
		return homePage;
	}

	public void typeUserName(String name) {
		username.sendKeys(name);
	}

	public void typePassword(String password) {
		Password.sendKeys(password);
	}

	public void clickLogInButton() {
		login.click();
	}

	public void pressEnterButtonOnPassword() {
		Password.sendKeys(Keys.chord(Keys.CONTROL, Keys.ENTER));
	}

	public void CheckBoxCheck() {
		checkbox.click();
	}


	public void twitterLogin() {
		twitter.click();
	}

	public void facebookLogin() {
		facebook.click();
	}

	public void linkedinLogin() {
		linkedIn.click();
	}

	public String getErrorMessage() {
		waitForWebElementToAppear(errorMessage);
		return errorMessage.getText();
	}

	public Boolean checkBoxEnale() {
        Boolean enable =checkbox.isEnabled();
		return enable;
	}
}

