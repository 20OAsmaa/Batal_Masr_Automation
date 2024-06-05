package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class AddRepresentorAccountPage {
    WebDriver driver;
    Select select;

    public AddRepresentorAccountPage(WebDriver driver) {
        this.driver = driver;
    }
    private final By firstNameField  = By.id("firstname");

    private final By emailField = By.id("email");

    private final By passwordField = By.id("password");

    private final By createAccountButton = By.cssSelector("[type='submit']");
    private final By associationName = By.id("association");

    private void insertFirstName(String firstName){
        driver.findElement(firstNameField).sendKeys(firstName);
    }
    private void insertEmail(String email){
        driver.findElement(emailField).sendKeys(email);
    }
    private void insertPassword(String password){
        driver.findElement(passwordField).sendKeys(password);
    }
    private void clickOnCreateAccountButton(){
        driver.findElement(createAccountButton).click();
    }
    private void selectFromDropDownList(String visibleText){
        select = new Select(driver.findElement(associationName));
        select.selectByVisibleText(visibleText);
    }
    public void createRepresentor(String firstName, String email, String password, String visibleText) throws InterruptedException {
        insertFirstName(firstName);
        Thread.sleep(1000);
        insertEmail(email);
        Thread.sleep(1000);
        insertPassword(password);
        Thread.sleep(1000);
        selectFromDropDownList(visibleText);
        Thread.sleep(1000);
        clickOnCreateAccountButton();
    }


}
