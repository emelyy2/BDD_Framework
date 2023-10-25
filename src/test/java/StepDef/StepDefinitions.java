package StepDef;

import Locators.LoginPageLocators;
import Locators.NewSavingsAccountLocator;
import Utils.Config;
import Utils.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class StepDefinitions {

    Driver driver = new Driver();
    LoginPageLocators loginPage = new LoginPageLocators(driver.getDriver());
    NewSavingsAccountLocator savingPage = new NewSavingsAccountLocator(driver.getDriver());
    Actions action;
    Select select;


    @Given("User navigates to TNB login page")
    public void user_navigates_to_tnb_login_page() {
        driver.getDriver().get(Config.getProperty("url"));

    }
    @When("User enters username as {string}")
    public void user_enters_username_as(String username) {
       loginPage.EnterUsername(username);
    }
    @When("User enters password as {string}")
    public void user_enters_password_as(String password) {
        loginPage.EnterPassword(password);
    }
    @When("User clicks Login Button")
    public void user_clicks_login_button() {
        loginPage.ClickLoginButton();
    }
    @Then("User should successfully login")
    public void user_should_successfully_login() throws InterruptedException {
        Assert.assertEquals(driver.getDriver().getTitle(), "Bank Home Page");
        driver.closeDriver();
    }


    @Given("User is on TNB Home Page")
    public void user_is_on_tnb_home_page() {
        driver.getDriver().get(Config.getProperty("url"));
        loginPage.EnterUsername(Config.getProperty("username"));
        loginPage.EnterPassword(Config.getProperty("password"));
        loginPage.ClickLoginButton();

    }
    @When("User hovers over Open New Account")
    public void user_hovers_over_open_new_account() {
        action = new Actions(driver.getDriver());
        action.moveToElement(savingPage.newAccountButton).perform();


    }
    @When("User clicks The New Saving Account")
    public void user_clicks_the_new_saving_account() {
        savingPage.saveAccountButton.click();
    }
    @Then("User should be redirected to New Business Account page in new window")
    public void user_should_be_redirected_to_new_business_account_page_in_new_window() {
        Set<String> setWindow = driver.getDriver().getWindowHandles();
        List<String> windows = new ArrayList<>(setWindow);

        driver.getDriver().switchTo().window(windows.get(1));

        Assert.assertTrue(savingPage.newBusinessAccountTitle.isDisplayed());

    }
    @When("User enters Firstname and Lastname")
    public void user_enters_firstname_and_lastname() {
        savingPage.firstName.sendKeys(Config.getProperty("first_name"));
        savingPage.lastName.sendKeys(Config.getProperty("last_name"));

    }
    @When("User enters Email and Business Name")
    public void user_enters_email_and_business_name() {
        savingPage.email.sendKeys(Config.getProperty("email"));
        savingPage.businessName.sendKeys(Config.getProperty("business_name"));
    }
    @When("User enters Business Type and Business Address")
    public void user_enters_business_type_and_business_address() {
        savingPage.businessType.sendKeys(Config.getProperty("business_type"));
        savingPage.businessAddress.sendKeys(Config.getProperty("business_address"));

    }
    @When("User enters Tax ID and Selected Business State")
    public void user_enters_tax_id_and_selected_business_state() {
        savingPage.taxId.sendKeys(Config.getProperty("Tax_ID"));
        select = new Select(savingPage.stateBusiness);
        select.selectByVisibleText(Config.getProperty("business_state"));
    }
    @When("User clicks Submit Button")
    public void user_clicks_submit_button() {
        savingPage.submitButton.click();
    }
    @Then("User should see success message on alert and accepts")
    public void user_should_see_success_message_on_alert_and_accepts() {
        Alert alert = driver.getDriver().switchTo().alert();
        String alertMessage = alert.getText();
        Assert.assertEquals(alertMessage, Config.getProperty("alertMessage"));
        alert.accept();
    }
    @Then("User should be redirected to Home Page")
    public void user_should_be_redirected_to_home_page() throws InterruptedException {

        Set<String> setWindow = driver.getDriver().getWindowHandles();
        List<String> windows = new ArrayList<>(setWindow);

        driver.getDriver().switchTo().window(windows.get(0));
        Assert.assertEquals(driver.getDriver().getTitle(), "Bank Home Page");
        driver.closeDriver();


    }
}
