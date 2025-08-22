package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    // Define the WebDriver instance
    private WebDriver driver;

    // Constructor to initialize the WebDriver and PageFactory
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Define the web elements using @FindBy annotation
    @FindBy(id = "login-account-name")
    private WebElement txtEmail;

    @FindBy(id = "login-account-password")
    private WebElement txtPassword;

    @FindBy(id = "login-button")
    private WebElement btnLogin;

    @FindBy(xpath = "//*[@class='widget-button btn btn-primary btn-small login-button btn-icon-text']")
    private WebElement getBtnLogin;

    public void clickGetLogin() {
        getBtnLogin.click();
    }

    // Method to set the username
    public void setUserName(String uname) {
        txtEmail.clear();
        txtEmail.sendKeys(uname);
    }

    // Method to set the password
    public void setPassword(String pwd) {
        txtPassword.clear();
        txtPassword.sendKeys(pwd);
    }

    // Method to click the login button
    public void clickLogin() {
        btnLogin.click();
    }

}
