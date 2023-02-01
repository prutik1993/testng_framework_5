package scripts;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.TechGlobalFrontendTestingHomePage;
import pages.TechGlobalSortableTablesPage;
import utilities.TableHandler;
import utilities.TextHandler;

import java.util.List;

public class TechGlobalSortableTablesTest extends TechGlobalBase{
    @BeforeMethod
    public void setPage(){
        techGlobalFrontendTestingHomePage = new TechGlobalFrontendTestingHomePage();
        techGlobalSortableTablesPage = new TechGlobalSortableTablesPage();
        techGlobalFrontendTestingHomePage.getFrontendTestingPage();
        techGlobalFrontendTestingHomePage.clickOnCard("Sortable Tables");
    }
    /**
     * TEST1
     * Go to https://techglobal-training.netlify.app/
     * Click on "Practices" dropdown in the header
     * Select the "Frontend Testing" option
     * Click on the "Sortable Tables" card
     * Click on the Quantity sort button to toggle Ascending Order
     * Verify that the Quantity column of the table is sorted in ascending order
     */
    @Test(priority = 1, description = "Sort table by asc and validate it is sorted by quantity ")
    public void validateSortAscByQuantity(){
        techGlobalSortableTablesPage.ascByQuantity.click();

        List<WebElement> quantityColumnElements = TableHandler.getTableColumn(driver,1);

        List<Integer> quantityColumn = TextHandler.returnListOfInteger(quantityColumnElements);

        for (int i = 1; i < quantityColumn.size(); i++) {
            Assert.assertTrue(quantityColumn.get(i) >= quantityColumn.get(i - 1));
        }
    }
    /**
     * TEST2
     * Go to https://techglobal-training.netlify.app/
     * Click on "Practices" dropdown in the header
     * Select the "Frontend Testing" option
     * Click on the "Sortable Tables" card
     * Click on the Quantity sort button to toggle descending order
     * Verify that the Quantity column of the table is sorted in descending order
     */
    @Test(priority = 2, description = "Validate that table quantity  data is sorted by descending order")
    public void validateSortedDescendingOrder(){
        techGlobalSortableTablesPage.descByQuantity.click();

        List<WebElement> quantityColumnElements = TableHandler.getTableColumn(driver,1);
        List<Integer> quantityColumn = TextHandler.returnListOfInteger(quantityColumnElements);

        for (int i = 1; i < quantityColumn.size(); i++) {
           Assert.assertTrue(quantityColumn.get(i) <= quantityColumn.get(i - 1));
        }
    }
    /**
     * TEST3
     * Go to https://techglobal-training.netlify.app/
     * Click on "Practices" dropdown in the header
     * Select the "Frontend Testing" option
     * Click on the "Sortable Tables" card
     * Click on the Price sort button to toggle Ascending Order
     * Verify that the Price column of the table is sorted in ascending order
     */
    @Test(priority = 3,description = "Validate that table data is sorted in ascending order in price column")
    public void validateAscendingOrderInPriceColumn(){
        techGlobalSortableTablesPage.ascByPrice.click();

        List<WebElement> priceColumnElements = TableHandler.getTableColumn(driver,3);
        List<Integer> priceColumn = TextHandler.returnListOfInteger(priceColumnElements);

        for (int i = 0; i < priceColumn.size()-1; i++) {
            Assert.assertTrue(priceColumn.get(i) <= priceColumn.get(i + 1));
        }
    }
    /**
     * TEST4
     * Go to https://techglobal-training.netlify.app/
     * Click on "Practices" dropdown in the header
     * Select the "Frontend Testing" option
     * Click on the "Sortable Tables" card
     * Click on the Price sort button to toggle descending order
     * Verify that the Price column of the table is sorted in descending order
     */
    @Test(priority = 3,description = "Validate that table data is sorted in ascending order in price column")
    public void validateDescendingOrderInPriceColumn(){
        techGlobalSortableTablesPage.descByPrice.click();

        List<WebElement> priceColumnElements = TableHandler.getTableColumn(driver,3);
        List<Integer> priceColumn = TextHandler.returnListOfInteger(priceColumnElements);

        for (int i = 0; i < priceColumn.size()-1; i++) {
            Assert.assertTrue(priceColumn.get(i) >= priceColumn.get(i + 1));
        }
    }

}
