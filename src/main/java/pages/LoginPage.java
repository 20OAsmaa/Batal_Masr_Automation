package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    WebDriver driver;

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    private final By emailField = By.id("email");

    private final By passwordField = By.id("password");

    private final By signInButton = By.cssSelector("[type='submit']");


    private void insertEmail(String email){
        driver.findElement(emailField).sendKeys(email);
    }
    private void insertPassword(String password){
        driver.findElement(passwordField).sendKeys(password);
    }

    private void clickOnSignInButton(){
        driver.findElement(signInButton).click();
    }
    public AdminHomePage SignInFeature(String email, String password) throws InterruptedException {
        insertEmail(email);
        insertPassword(password);
        clickOnSignInButton();
        Thread.sleep(1500);
        return new AdminHomePage(driver);
    }
}
