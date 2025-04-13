package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import webBase.FinacPlusWebBase;

public class Steps_Login extends FinacPlusWebBase {

    @Given("The User navigates to {string}")
    public void theUserNavigatesTo(String url) {
        navigateToURL(url);
    }

    @When("The User enters valid username {string} and password {string}")
    public void theUserEntersValidUsernameAndPassword(String username, String password) {
        WebElement usernameField = driver.findElement(By.id("userName"));
        WebElement passwordField = driver.findElement(By.id("password"));

        scrollIntoElementTillVisible(usernameField);
        wait.until(ExpectedConditions.visibilityOf(usernameField));
        usernameField.sendKeys(username);

        scrollIntoElementTillVisible(passwordField);
        wait.until(ExpectedConditions.visibilityOf(passwordField));
        passwordField.sendKeys(password);
    }

    @And("The user clicks on Login button")
    public void theUserClicksOnLoginButton() {
        WebElement loginButton = driver.findElement(By.xpath("//button[@id='login']"));
        wait.until(ExpectedConditions.elementToBeClickable(loginButton));
        loginButton.click();
    }

    @Then("the {string} should be visible")
    public void theShouldBeVisible(String userNameDetails) {
        WebElement userNameLabelLocator = driver.findElement(By.xpath("//*[text()='User Name : ']"));
        WebElement userNameValueLocator = driver.findElement(By.id("userName-value"));

        Assert.assertEquals(userNameLabelLocator.getText(), userNameDetails.substring(0, 11));
        Assert.assertEquals(userNameValueLocator.getText(), userNameDetails.substring(12));
    }

    @And("the Log Out button should be visible")
    public void theLogOutButtonShouldBeVisible() {
        WebElement logOutButtonLocator = driver.findElement(By.xpath("//button[text()='Log out']"));
        Assert.assertTrue(logOutButtonLocator.isDisplayed() && logOutButtonLocator.isEnabled());
    }

    @Then("the error message {string} should be displayed")
    public void theErrorMessageShouldBeDisplayed(String errorMessage) {
        WebElement errorMessageLocator = driver.findElement(By.xpath("//*[text()='Invalid username or password!']"));
        Assert.assertEquals(errorMessageLocator.getText(), errorMessage);
    }

    @Given("the user goes to the URL {string} and successfully logins with username {string} and password {string}")
    public void theUserGoesToTheURLAndSuccessfullyLoginsWithUsernameAndPassword(String url, String username, String password) {
        theUserNavigatesTo(url);
        theUserEntersValidUsernameAndPassword(username, password);
        theUserClicksOnLoginButton();
    }
}