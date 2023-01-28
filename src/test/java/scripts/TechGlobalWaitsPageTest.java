package scripts;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.TechGlobalFrontendTestingHomePage;
import pages.TechGlobalWaitsPage;
import utilities.Waiter;

public class TechGlobalWaitsPageTest extends TechGlobalBase {

    @BeforeMethod
    public void setPage(){
        techGlobalFrontendTestingHomePage = new TechGlobalFrontendTestingHomePage();
        techGlobalWaitsPage = new TechGlobalWaitsPage();
        techGlobalFrontendTestingHomePage.getFrontendTestingPage();
        techGlobalFrontendTestingHomePage.clickOnCard(3);
    }

    @Test(priority = 1, description = "Validate red box visible")
    public void validateRedBox(){
        

        //techGlobalWaitsPage.redBoxButton.click();
        techGlobalWaitsPage.blueBoxButton.click();


        //Assert.assertTrue(techGlobalWaitsPage.redBox.isDisplayed());

        Waiter.waitForVisibilityOfElements(techGlobalWaitsPage.blueBox, 60);
        Assert.assertTrue(techGlobalWaitsPage.blueBox.isDisplayed());
    }

}
