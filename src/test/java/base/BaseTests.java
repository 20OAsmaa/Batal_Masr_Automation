package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.LoginPage;
import pages.ManagePlayerPage;
import pages.ManageRepresentorPage;
import pages.PlayerHomePage;
import utils.ScreenRecorderUtil;

import java.lang.reflect.Method;
import java.util.Random;

public class BaseTests {

    protected WebDriver driver;

    protected LoginPage loginPage;
    protected ManageRepresentorPage manageRepresentorPage;
    protected ManagePlayerPage managePlayerPage;
    protected PlayerHomePage playerHomePage;

    @BeforeClass
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        loginPage = new LoginPage(driver);
        manageRepresentorPage = new ManageRepresentorPage(driver);
        managePlayerPage = new ManagePlayerPage(driver);
        playerHomePage = new PlayerHomePage(driver);
    }
    @BeforeMethod
    public void goHome(Method method) throws Exception {
        ScreenRecorderUtil.startRecord(method.getName());
        driver.get("http://localhost:4200/login");
    }
    @AfterMethod
    public void afterMethod() throws Exception {
        ScreenRecorderUtil.stopRecord();
    }
    @AfterClass
    public void tearDown(){
        driver.quit();
    }


    protected int getRandomFiveDigitNumber() {
        int min = 10000; // Minimum 5-digit number (inclusive)
        int max = 99999; // Maximum 5-digit number (inclusive)

        // Create a Random object
        Random random = new Random();

        // Generate a random number between min and max (exclusive)
        int randomNumber = random.nextInt(max - min + 1) + min;

        return randomNumber;
    }
}
