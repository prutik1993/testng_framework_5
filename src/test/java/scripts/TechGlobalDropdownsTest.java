package scripts;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.TechGlobalDropdownsPage;
import pages.TechGlobalFrontendTestingHomePage;
import utilities.DropdownHandler;
import utilities.Waiter;

public class TechGlobalDropdownsTest extends TechGlobalBase{

    @BeforeMethod
    public void setPage(){
        techGlobalFrontendTestingHomePage = new TechGlobalFrontendTestingHomePage();
        techGlobalDropdownsPage = new TechGlobalDropdownsPage();

        techGlobalFrontendTestingHomePage.getFrontendTestingPage();
        techGlobalFrontendTestingHomePage.clickOnCard("Dropdowns");
    }

    @Test(priority = 1, description = "Select delivery option")
    public void SelectDeliveryOption(){
        DropdownHandler.clickOnDropdownOption(techGlobalDropdownsPage.deliveryDropdown,
                techGlobalDropdownsPage.deliveryDropdownOptions,
                "Delivery");
    }
     /*
     if i have a select tag i will use Select class to select my options
      */
    @Test(priority = 2, description = "Select iPhone 14 Pro Max Option")
    public void selectProductOption(){
        DropdownHandler.selectByVisibleText(techGlobalDropdownsPage.productDropdown,"iPhone 14 Pro Max");

//        for(WebElement element : select.getOptions()){
//            System.out.println(element.getText());
//        }
    }
    @Test(priority = 2, description = "Select yellow options")
    public void selectColorOption(){
        DropdownHandler.selectByIndex(techGlobalDropdownsPage.colorDropdown, 1);

        Waiter.pause(1);

    }
    /*
    Go to TechGlobal Training app
    Select Frontend Testing from Practices Dropdown
    Select Dropdowns card
    Select "MacBook Pro 13" option from product dropdown
    Select "Silver" option from the color dropdown
    Select "Delivery" option from devivery dropdown
    Click on SUBMIT button
    Validate "Your Silver MacBook Pro 13 will be delivered to you." message
     */

    @Test(priority = 3, description = "Validate the selected item message")
    public void validateTheItemSelected(){
        DropdownHandler.selectByIndex(techGlobalDropdownsPage.productDropdown,3);
        DropdownHandler.selectByValue(techGlobalDropdownsPage.colorDropdown,"Silver");
        DropdownHandler.clickOnDropdownOption(techGlobalDropdownsPage.deliveryDropdown,
                techGlobalDropdownsPage.deliveryDropdownOptions, "Delivery");
        techGlobalDropdownsPage.submitButton.click();
        Assert.assertEquals(techGlobalDropdownsPage.resultMessage.getText(), "Your Silver MacBook Pro 13 will be delivered to you.");
    }


}
