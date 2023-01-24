package scripts;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.TechGlobalDynamicTablesPage;
import pages.TechGlobalFrontendTestingHomePage;

public class TechGlobalDynamicTablesTest extends TechGlobalBase{

    /*
         REGULAR MODAL AUTOMATION (this is not a JS alert)
     Go to https://techglobal-training.netlify.app/
     Click on "Practices" dropdown in the header
     Select the "Frontend Testing" option
     Click on the "Dynamic Tables" card
     Click on the "ADD PRODUCT" button
     Validate the modal title equals "Add New Product"
     */

    @BeforeMethod
    public void setPage(){
        techGlobalFrontendTestingHomePage = new TechGlobalFrontendTestingHomePage();
        techGlobalDynamicTablesPage = new TechGlobalDynamicTablesPage();
        techGlobalFrontendTestingHomePage.getFrontendTestingPage();
        techGlobalFrontendTestingHomePage.clickOnCard("Dynamic Tables");
    }

    @Test(priority = 1, description = "Pop up validation")
    public void popupValidation(){
        techGlobalDynamicTablesPage.addProductButton.click();
        Assert.assertTrue(techGlobalDynamicTablesPage.modalCard.isDisplayed());
        Assert.assertEquals(techGlobalDynamicTablesPage.modalCard.getText(), "Add New Product");
    }
}
