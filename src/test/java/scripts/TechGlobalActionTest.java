package scripts;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.TechGlobalActionPage;
import pages.TechGlobalFrontendTestingHomePage;
import utilities.Waiter;

public class TechGlobalActionTest extends TechGlobalBase{

    /**
     * TEST1
     * Go to https://techglobal-training.netlify.app/
     * Click on the "Practices" dropdown in the header
     * Select the "Frontend Testing" option from the dropdown menu
     * Click on the "Actions" card
     * Verify that the user is redirected to the Actions page
     * Verify that the first three web elements are present and labeled as "Click on me",
     * "Right-Click on me", and "Double-Click on me"
     * Perform a click action on the first web element labeled as "Click on me"
     * Verify that  message appears next of the element stating "You clicked on a button!"
     * Perform a right click action on the second web element labeled as "Right-Click on me""
     * Verify that  message appears next of the element stating "You right-clicked on a button!"
     * Perform a double click action on the third web element labeled as "Double-Click on me"
     * Verify that  message appears next of the element stating "You double-clicked on a button!"
     */

    @BeforeMethod
    public void setPage(){
        techGlobalFrontendTestingHomePage = new TechGlobalFrontendTestingHomePage();
        techGlobalActionPage = new TechGlobalActionPage();
        actions = new Actions(driver);
        techGlobalFrontendTestingHomePage.getFrontendTestingPage();
        techGlobalFrontendTestingHomePage.clickOnCard("Actions");
    }
    @Test(priority = 1, description = "Validate that messages appears after clickin on  3 first boxes")
    public void clickActions(){
        Assert.assertEquals(driver.getCurrentUrl(),"https://techglobal-training.netlify.app/frontend/actions");

        Assert.assertTrue(techGlobalActionPage.clickBox.isDisplayed());
        Assert.assertTrue(techGlobalActionPage.rightClickBox.isDisplayed());
        Assert.assertTrue(techGlobalActionPage.doubleClickBox.isDisplayed());

        Assert.assertEquals(techGlobalActionPage.clickBox.getText(),"Click on me");
        Assert.assertEquals(techGlobalActionPage.rightClickBox.getText(),"Right-Click on me");
        Assert.assertEquals(techGlobalActionPage.doubleClickBox.getText(),"Double-Click on me");

        actions.moveToElement(techGlobalActionPage.clickBox).click().perform();
        Assert.assertEquals(techGlobalActionPage.clickResult.getText(),"You clicked on a button!");

        actions.moveToElement(techGlobalActionPage.rightClickBox).contextClick().perform();
        Assert.assertEquals(techGlobalActionPage.rightClickResult.getText(),"You right-clicked on a button!");

        actions.moveToElement(techGlobalActionPage.doubleClickBox).doubleClick().perform();
        Assert.assertEquals(techGlobalActionPage.doubleClickResult.getText(),"You double-clicked on a button!");
    }
    /**
     * TEST2
     * Go to https://techglobal-training.netlify.app/
     * Click on the "Practices" dropdown in the header
     * Select the "Frontend Testing" option from the dropdown menu
     * Click on the "Actions" card
     * Verify that the last two web elements are present and labeled as "Drag Me", and "Drop Here",
     * Perform a Drag and Drop action on the "Drag Me" web element, and drop it to "Drop Here"
     * Verify that the first web element "Drag me" is successfully dropped into the second web element "Drop Here"
     * Verify that a message appears next to the  web element stating "An element dropped here!"
     */
    @Test(priority = 2,description = "Validate drag and drop")
    public void validateDragAndDrop(){
        Assert.assertTrue(techGlobalActionPage.dragMeBox.isDisplayed());
        Assert.assertTrue(techGlobalActionPage.dropHereBox.isDisplayed());

        Assert.assertEquals(techGlobalActionPage.dragMeBox.getText(),"Drag Me");
        Assert.assertEquals(techGlobalActionPage.dropHereBox.getText(),"Drop Here");

        actions.moveToElement(techGlobalActionPage.dragMeBox).clickAndHold().moveToElement(techGlobalActionPage.dropHereBox).release().perform();
        Waiter.pause(2);

        Assert.assertEquals(techGlobalActionPage.dragDropMeResult.getText(),"An element dropped here!");
    }

}
