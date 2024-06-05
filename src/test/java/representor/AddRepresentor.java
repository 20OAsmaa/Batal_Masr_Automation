package representor;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.AddRepresentorAccountPage;
import pages.AdminHomePage;
import pages.ManageRepresentorPage;

import static org.testng.Assert.assertTrue;

public class AddRepresentor extends BaseTests {

    @Test
    public void testAddNewRepresentor() throws InterruptedException {
        AdminHomePage adminHomePage = loginPage.SignInFeature("admin@gmail.com","12345678");
        ManageRepresentorPage manageRepresentorPage = adminHomePage.clickOnManageRepresentorLink();
        AddRepresentorAccountPage addRepresentorAccountPage = manageRepresentorPage.clickOnAddAgentButton();
        addRepresentorAccountPage.
                createRepresentor(
                        "test",
                        "admin"+getRandomFiveDigitNumber()+"@gmail.com",
                        "12345678",
                        "kora");
        assertTrue(manageRepresentorPage.toasterMessageIsDisplayed());
    }
}
