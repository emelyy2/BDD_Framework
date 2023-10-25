package Locators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageLocators {

    final WebDriver driver;

    public LoginPageLocators(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "UserName")
    public WebElement username;

    @FindBy(id = "password")
    public WebElement password;

    @FindBy(id = "login-btn")
    public WebElement loginButton;

    public void EnterUsername(String username){
        this.username.sendKeys(username);
    }

    public void EnterPassword(String password){
        this.password.sendKeys(password);
    }

    public void ClickLoginButton(){
        this.loginButton.click();
    }


}
