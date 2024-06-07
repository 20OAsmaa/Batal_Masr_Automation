package representor;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.AddPlayerPage;
import pages.AddRepresentorAccountPage;
import pages.AdminHomePage;
import pages.ManageRepresentorPage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class Demo extends BaseTests {
    int getRandomVariableForRepresentor = getRandomFiveDigitNumber();
    int getRandomVariableForPlayer = getRandomFiveDigitNumber();
    String representorEmail ;
    String playerEmail ;
    String imagePath = "E:\\GP_Automation\\GP\\src\\main\\resources\\1.jpg";

    @Test(priority = 1)
    public void testAddNewRepresentor() throws InterruptedException {
        representorEmail = "admin"+ getRandomVariableForRepresentor +"@gmail.com";
        AdminHomePage adminHomePage = loginPage.SignInFeature("admin@gmail.com","12345678");
        ManageRepresentorPage manageRepresentorPage = adminHomePage.clickOnManageRepresentorLink();
        AddRepresentorAccountPage addRepresentorAccountPage = manageRepresentorPage.clickOnAddAgentButton();
        addRepresentorAccountPage.
                createRepresentor(
                        "test",
                        "admin"+ getRandomVariableForRepresentor +"@gmail.com",
                        "12345678",
                        "testtest");
        assertTrue(manageRepresentorPage.toasterMessageIsDisplayed());
    }
    @Test(priority = 2)
    public void testAddPlayer() throws InterruptedException {
        playerEmail = "admin"+ getRandomVariableForPlayer +"@gmail.com";
        manageRepresentorPage.clickOnLogoutButton();
        loginPage.SignInFeature(representorEmail,"12345678");
        AddPlayerPage addPlayerPage = managePlayerPage.clickOnAddPlayer();
        addPlayerPage.addPlayer("test", "male","178","78", "Nady Bnha",playerEmail,
                "12345678",imagePath);
    }
    @Test(priority = 3)
    public void testViewPlayer() throws InterruptedException {

        manageRepresentorPage.clickOnLogoutButton();
        loginPage.SignInFeature(playerEmail,"12345678");
        assertEquals(playerHomePage.getPlayerClub(),"Nady Bnha");
        assertTrue(playerHomePage.getPlayerHeight().contains("178"));
        assertEquals(playerHomePage.getPlayerAge(),"22");

    }
}
