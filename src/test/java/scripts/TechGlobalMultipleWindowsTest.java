package scripts;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.TechGlobalFrontendTestingHomePage;
import pages.TechGlobalMultipleWindowsPage;
import utilities.Waiter;

public class TechGlobalMultipleWindowsTest extends TechGlobalBase{

    @BeforeMethod
    public void setPage(){
        techGlobalFrontendTestingHomePage = new TechGlobalFrontendTestingHomePage();
        techGlobalMultipleWindowsPage = new TechGlobalMultipleWindowsPage();

        techGlobalFrontendTestingHomePage.getFrontendTestingPage();
        techGlobalFrontendTestingHomePage.clickOnCard("Multiple Windows");
    }

    @Test(priority = 1, description = "Validate the Apple link")
    public void validateTheAppleLink(){
        Waiter.pause(2);
        // 1 window/tab
        String mainWindow = driver.getWindowHandle();
        techGlobalMultipleWindowsPage.links.get(0).click();

        // 2 windows/tabs
        for (String windowId : driver.getWindowHandles()) {
            if(!windowId.equals(mainWindow)){
                driver.switchTo().window(windowId);
                break;
            }
        }
        Assert.assertEquals(driver.getTitle(),"Apple");
        driver.close();

        // go back to TechGlobal page and validate that title is TechGlobal
        driver.switchTo().window(mainWindow);
        Assert.assertTrue(driver.getCurrentUrl().contains("techglobal"));



    }
}
