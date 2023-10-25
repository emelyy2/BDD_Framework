package Locators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewSavingsAccountLocator {

    final WebDriver Driver;

    public NewSavingsAccountLocator(WebDriver driver){
        this.Driver = driver;
        PageFactory.initElements(driver, this);

    }

    @FindBy(xpath = "//button[text()='Open New Account']")
    public WebElement newAccountButton;

    @FindBy(xpath = "(//a[text()='Saving'])[2]")
    public WebElement saveAccountButton;

    @FindBy(xpath = "//h2[text()='New Business Account']")
    public WebElement newBusinessAccountTitle;

    @FindBy(id = "firstName")
    public WebElement firstName;

    @FindBy(id = "lastName")
    public WebElement lastName;

    @FindBy(id = "email")
    public WebElement email;

    @FindBy(id = "business-name")
    public WebElement businessName;

    @FindBy(id = "business-type")
    public WebElement businessType;

    @FindBy(id = "business-address")
    public WebElement businessAddress;

    @FindBy(id = "tax-id")
    public WebElement taxId;

    @FindBy(xpath = "//select[@id='state']")
    public WebElement stateBusiness;

    @FindBy(xpath = "//button[text()='Submit']")
    public WebElement submitButton;
}
