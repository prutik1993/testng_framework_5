package scripts;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.TechGlobalFrontendTestingHomePage;
import pages.TechGlobalIFramesPage;

public class TechGlobalIFramesTest extends TechGlobalBase{
    /*
    Go to https://techglobal-training.netlify.app/
    Click on “Practices” dropdown in the header
    Select the “Frontend Testing” option
    Click on the “IFrames” card
    Validate the “Please fill out your information below” text
     */
    @BeforeMethod
    public void setPage(){
        techGlobalFrontendTestingHomePage = new TechGlobalFrontendTestingHomePage();
        techGlobalIFramesPage = new TechGlobalIFramesPage();
        techGlobalFrontendTestingHomePage.getFrontendTestingPage();
        techGlobalFrontendTestingHomePage.clickOnCard("IFrames");
    }
    @Test(priority = 1, description = "Validating input header test")
    public void validateInputText(){

        driver.switchTo().frame(techGlobalIFramesPage.IFrameId);
        Assert.assertTrue(techGlobalIFramesPage.inputHeader.isDisplayed());
        Assert.assertEquals(techGlobalIFramesPage.inputHeader.getText(),
                "Please fill out your information below");
    }
    /*
    Click on “Practices” dropdown in the header
    Select the “Frontend Testing” option
    Click on the “IFrames” card
    Enter “John” to first name input box
    Enter “Doe” to last name input box
    Click on “SUBMIT” button
    Validate the result equals “You entered: John Doe”
     */
    @Test(priority = 2, description = "Validating the result of inputs")
    public void validateInputs(){
        driver.switchTo().frame(techGlobalIFramesPage.IFrameId);
        Assert.assertTrue(techGlobalIFramesPage.firstName.isDisplayed());
        Assert.assertTrue(techGlobalIFramesPage.lastName.isDisplayed());
        techGlobalIFramesPage.firstName.sendKeys("John");
        techGlobalIFramesPage.lastName.sendKeys("Doe");
        Assert.assertTrue(techGlobalIFramesPage.submitButton.isDisplayed());
        Assert.assertTrue(techGlobalIFramesPage.submitButton.isEnabled());
        techGlobalIFramesPage.submitButton.click();
        driver.switchTo().parentFrame();
        Assert.assertTrue(techGlobalIFramesPage.resultText.isDisplayed());
        Assert.assertEquals(techGlobalIFramesPage.resultText.getText(),"You entered: John Doe");
    }
}
