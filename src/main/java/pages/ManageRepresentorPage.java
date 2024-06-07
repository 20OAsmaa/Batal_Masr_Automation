package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ManageRepresentorPage {

    WebDriver driver;
    WebDriverWait wait;
    Actions actions;
    public ManageRepresentorPage(WebDriver driver) {
        this.driver =driver;
    }
    private void explicitWait(By locator, int time) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.and(
                ExpectedConditions.visibilityOf(driver.findElement(locator)),
                ExpectedConditions.visibilityOfElementLocated(locator),
                ExpectedConditions.elementToBeClickable(locator),
                ExpectedConditions.presenceOfElementLocated(locator)
        ));
    }

    private final By addRepresentorButton = By.xpath("//button[contains(text(),'ADD REPRESNTOR')]");

    private final By toasterMessage = By.id("toast-container");
    private final By logoutButton = By.cssSelector(".Btn");


    public AddRepresentorAccountPage clickOnAddAgentButton() {
        explicitWait(addRepresentorButton,5);
        driver.findElement(addRepresentorButton).click();
        return new AddRepresentorAccountPage(driver);
    }

    public boolean toasterMessageIsDisplayed() throws InterruptedException {
        Thread.sleep(2500);
        return driver.findElement(toasterMessage).isDisplayed();
    }
    public LoginPage clickOnLogoutButton() throws InterruptedException {
        actions = new Actions(driver);
        actions.moveToElement(driver.findElement(logoutButton)).click().build().perform();
        Thread.sleep(1500);
        return new LoginPage(driver);
    }
}
