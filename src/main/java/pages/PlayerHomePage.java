package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;



public class PlayerHomePage {

    WebDriver driver;

    public PlayerHomePage(WebDriver driver) {
        this.driver = driver;
    }
    private final By clubName = By.xpath("(//span[@class='ms-2'])[2]");
    private final By heightName = By.xpath("(//span[@class='ms-2'])[3]");
    private final By ageName = By.xpath("(//span[@class='ms-2'])[4]");


    public String getPlayerClub(){
          return driver.findElement(clubName).getText();

    }
    public String getPlayerHeight(){
        return driver.findElement(heightName).getText();
    }
    public String getPlayerAge(){
        return driver.findElement(ageName).getText();
    }
}
