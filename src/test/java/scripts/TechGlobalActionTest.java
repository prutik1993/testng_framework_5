package scripts;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.TechGlobalActionPage;
import pages.TechGlobalFrontendTestingHomePage;
import utilities.Waiter;

import java.time.Duration;

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

        actions.dragAndDrop(techGlobalActionPage.dragMeBox,techGlobalActionPage.dropHereBox).perform();
        //actions.moveToElement(techGlobalActionPage.dragMeBox).clickAndHold().
        // moveToElement(techGlobalActionPage.dropHereBox).release().perform();

        Waiter.waitForVisibilityOfElements(techGlobalActionPage.dragDropMeResult,5);

        Assert.assertEquals(techGlobalActionPage.dragDropMeResult.getText(),"An element dropped here!");
    }

    /**
     * TEST3
     * Go to https://techglobal-training.netlify.app/
     * Click on the "Practices" dropdown in the header
     * Select the "Frontend Testing" option from the dropdown menu
     * Click on the "Actions" card
     * Go to input box, and remove existing text inside
     * Enter “Hello” to search input box
     * Validate value attribute is “Hello”
     */
    @Test(priority = 3,description = "Keyboard actions")
    public void keyboardActions(){
    actions.keyDown(Keys.SHIFT).
            sendKeys(techGlobalActionPage.inputBox,"h")
            .keyUp(Keys.SHIFT)
            .pause(Duration.ofSeconds(2))
            .sendKeys("ello")
            .pause(Duration.ofSeconds(2))
            .perform();
    Assert.assertEquals(techGlobalActionPage.inputBox.getAttribute("value"),"Hello");
    }
    /**
     * TEST4
     * Go to https://techglobal-training.netlify.app/
     * Click on the "Practices" dropdown in the header
     * Select the "Frontend Testing" option from the dropdown menu
     * Click on the "Actions" card
     * Go to input box, and remove existing text inside
     * Enter “techglobal” to input box with uppercases
     * Validate the value attribute for search input box is “TECHGLOBAL”
     * Then, copy the text and paste again
     * Validate the value attribute for search input box is “TECHGLOBALTECHGLOBAL”
     */
    @Test(priority = 4,description = "Validate keyboard actions and copy and paste actions")
    public void validateKeyboardActionAndCopyPaste(){
        actions.keyDown(Keys.SHIFT)
                .sendKeys(techGlobalActionPage.inputBox,"techglobal").perform();
        Assert.assertEquals(techGlobalActionPage.inputBox.getAttribute("value"),"TECHGLOBAL");
        actions.moveToElement(techGlobalActionPage.inputBox)
                .doubleClick()
                .keyDown(Keys.COMMAND).sendKeys("c")
                .sendKeys("v")
                .sendKeys("v").keyUp(Keys.COMMAND).perform();

        /**
         * actions.keyDown(Keys.SHIFT)
         *                 .sendKeys(techGlobalActionsPage.inputBox, "techglobal")
         *                 .keyUp(Keys.SHIFT)
         *                 .pause(Duration.ofSeconds(2))
         *                 .keyDown(Keys.COMMAND)
         *                 .sendKeys("a")
         *                 .pause(Duration.ofSeconds(2))
         *                 .sendKeys("c")
         *                 .keyUp(Keys.COMMAND)
         *                 .sendKeys(Keys.ARROW_RIGHT)
         *                 .keyDown(Keys.COMMAND)
         *                 .sendKeys("v")
         *                 .pause(Duration.ofSeconds(2))
         *                 .perform();
         */

        Assert.assertEquals(techGlobalActionPage.inputBox.getAttribute("value"),"TECHGLOBALTECHGLOBAL");

    } @Test(priority = 4,description = "Validate keyboard actions and copy and paste actions")
    public void practiceForMe(){
        actions.moveToElement(techGlobalActionPage.inputBox)
                .sendKeys("hello")
                .doubleClick()
                .keyDown(Keys.COMMAND).sendKeys("c")
                .sendKeys("v")
                .sendKeys("v")
                .keyUp(Keys.COMMAND)
                .perform();
    }




}
