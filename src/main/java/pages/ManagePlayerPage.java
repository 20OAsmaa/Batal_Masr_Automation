package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ManagePlayerPage {
    WebDriver driver;

    public ManagePlayerPage(WebDriver driver) {
        this.driver = driver;
    }
    private final By addPlayerButton = By.cssSelector(".btn.btn-dark");
    public AddPlayerPage clickOnAddPlayer(){
        driver.findElement(addPlayerButton).click();
        return new AddPlayerPage(driver);
    }
}
