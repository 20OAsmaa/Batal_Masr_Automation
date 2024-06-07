package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class AddPlayerPage {

    WebDriver driver;

    Select select;
    public AddPlayerPage(WebDriver driver) {
        this.driver=driver;
    }
    private final By fullName = By.cssSelector("[formcontrolname='name']");

    private final By birthDate = By.cssSelector("[formcontrolname='birthOfDate']");
    private final By gender = By.cssSelector("[formcontrolname='gender']");
    private final By height = By.cssSelector("[formcontrolname='height']");
    private final By weight = By.cssSelector("[formcontrolname='weight']");
    private final By club = By.cssSelector("[formcontrolname='club']");
    private final By emailField = By.cssSelector("[formcontrolname='email']");
    private final By passwordField = By.cssSelector("[formcontrolname='password']");
    private final By image = By.cssSelector("#fileUpload");
    private final By submitButton = By.cssSelector("[type='submit']");

    private void insertName(String name){
        driver.findElement(fullName).sendKeys(name);
    }
    private void selectBirthDate() {
        driver.findElement(birthDate).sendKeys("4202002");
    }
    private void selectGender(String genderType){
        select = new Select(driver.findElement(gender));
        select.selectByVisibleText(genderType);
    }
    private void insertHeight(String heightNumber) {
        driver.findElement(height).sendKeys(heightNumber);
    }
    private void insertWeight(String weightNumber) {
        driver.findElement(weight).sendKeys(weightNumber);
    }
    private void insertClub(String clubName) {
        driver.findElement(club).sendKeys(clubName);
    }
    private void insertEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
    }
    private void insertPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    private void uploadImage(String imagePath){
        driver.findElement(image).sendKeys(imagePath);
    }

    private void clickOnSubmitButton(){
        scrollToElementActions(driver,driver.findElement(submitButton));
        driver.findElement(submitButton).click();
    }
    public static void scrollToElementActions(WebDriver driver, WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
    }

    public void addPlayer(String name,String gender, String height, String weight, String club,
                          String email, String password, String imagePath) throws InterruptedException {
        insertName(name);
        Thread.sleep(1000);
        selectBirthDate();
        Thread.sleep(1000);
        selectGender(gender);
        Thread.sleep(1000);
        insertHeight(height);
        Thread.sleep(1000);
        insertWeight(weight);
        Thread.sleep(1000);
        insertClub(club);
        Thread.sleep(1000);
        insertEmail(email);
        Thread.sleep(1000);
        insertPassword(password);
        Thread.sleep(1000);
        uploadImage(imagePath);
        Thread.sleep(1000);
        clickOnSubmitButton();
        Thread.sleep(2000);


    }
}
