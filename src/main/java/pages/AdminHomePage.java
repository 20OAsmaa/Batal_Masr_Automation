package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AdminHomePage {

    WebDriver driver;
    WebDriverWait wait;

    private void explicitWait(By locator, int time) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.and(
                ExpectedConditions.visibilityOf(driver.findElement(locator)),
                ExpectedConditions.visibilityOfElementLocated(locator),
                ExpectedConditions.elementToBeClickable(locator),
                ExpectedConditions.presenceOfElementLocated(locator)
        ));
    }

    public AdminHomePage(WebDriver driver) {
        this.driver = driver;
    }
    private final By mangeRepresentorLink =By.xpath("//a[contains(text(),'Mange Representor')]");

    public ManageRepresentorPage clickOnManageRepresentorLink(){
        driver.findElement(mangeRepresentorLink).click();
        return new ManageRepresentorPage(driver);
    }
}
