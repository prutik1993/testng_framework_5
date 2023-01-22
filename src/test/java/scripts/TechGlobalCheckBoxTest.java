package scripts;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.TechGlobalCheckBoxPage;
import pages.TechGlobalFrontendTestingHomePage;
import utilities.Waiter;

public class TechGlobalCheckBoxTest extends TechGlobalBase{

    @BeforeMethod
    public void setPage(){
        techGlobalFrontendTestingHomePage = new TechGlobalFrontendTestingHomePage();
        techGlobalCheckBoxPage = new TechGlobalCheckBoxPage();
    }
    /*
    Go to https://techglobal-training.netlify.app/
    Click on "Practices" dropdown in the header
    Select the "Frontend Testing" option
    Click on the "Checkboxes" card
    Validate "Apple" and "Microsoft" checkboxes are displayed, enabled and not selected
    Select both and validate they are both selected
    Deselect both and validate they are deselected
     */

    @Test(priority = 1, description = "Validate checkboxes")
    public void validateCheckboxes(){
        techGlobalFrontendTestingHomePage.getFrontendTestingPage();
        techGlobalFrontendTestingHomePage.clickOnCard(6);
        for (int i = 0; i < techGlobalCheckBoxPage.checkboxInput.size(); i++) {
            Assert.assertTrue(techGlobalCheckBoxPage.checkboxInput.get(i).isDisplayed());
            Assert.assertTrue(techGlobalCheckBoxPage.checkboxInput.get(i).isEnabled());
            Assert.assertFalse(techGlobalCheckBoxPage.checkboxInput.get(i).isSelected());
        }
        for (int i = 0; i < techGlobalCheckBoxPage.checkboxInput.size(); i++) {
            techGlobalCheckBoxPage.checkboxLabel.get(i).click();
            Waiter.pause(1);
            Assert.assertTrue(techGlobalCheckBoxPage.checkboxInput.get(i).isSelected());
        }
        for (int i = 0; i < techGlobalCheckBoxPage.checkboxInput.size(); i++) {
            techGlobalCheckBoxPage.checkboxLabel.get(i).click();
            Waiter.pause(1);
            Assert.assertFalse(techGlobalCheckBoxPage.checkboxInput.get(i).isSelected());
        }
    }
    /*
    Go to https://techglobal-training.netlify.app/
    Click on "Practices" dropdown in the header
    Select the "Frontend Testing" option
    Click on the "Checkboxes" card
    Validate "Tesla" and "SpaceX" checkboxes are displayed, enabled and not selected
    Select both and validate they are both selected
    Deselect both and validate they are deselected (edited)
     */

    @Test(priority = 1, description = "Validate checkboxes")
    public void validateCheckboxes2(){
        techGlobalFrontendTestingHomePage.getFrontendTestingPage();
        techGlobalFrontendTestingHomePage.clickOnCard(6);

        techGlobalCheckBoxPage.checkboxInput2.forEach(cb -> {
            Assert.assertTrue(cb.isDisplayed());
            Assert.assertTrue(cb.isEnabled());
            Assert.assertFalse(cb.isSelected());
        });
        /* for (int i = 0; i < techGlobalCheckBoxPage.checkboxInput2.size(); i++) {
            Assert.assertTrue(techGlobalCheckBoxPage.checkboxInput2.get(i).isDisplayed());
            Assert.assertTrue(techGlobalCheckBoxPage.checkboxInput2.get(i).isEnabled());
            Assert.assertFalse(techGlobalCheckBoxPage.checkboxInput2.get(i).isSelected());
        }
        */
        for (int i = 0; i < techGlobalCheckBoxPage.checkboxInput2.size(); i++) {
            techGlobalCheckBoxPage.checkboxLabel2.get(i).click();
            Waiter.pause(1);
            Assert.assertTrue(techGlobalCheckBoxPage.checkboxInput2.get(i).isSelected());
        }

        for (int i = 0; i < techGlobalCheckBoxPage.checkboxInput2.size(); i++) {
            techGlobalCheckBoxPage.checkboxLabel2.get(i).click();
            Waiter.pause(1);
            Assert.assertFalse(techGlobalCheckBoxPage.checkboxInput2.get(i).isSelected());
        }
    }

}
