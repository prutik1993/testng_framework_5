package scripts;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.TechGlobalFrontendTestingHomePage;
import pages.TechGlobalSortableTablesPage;
import utilities.TableData;

import java.util.ArrayList;
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
    @Test(priority = 1, description = "Sort table by asc and valiadte it is sorted by quantity ")
    public void validateSortAscByQuantity(){
        techGlobalSortableTablesPage.ascByQuantity.click();

        List<WebElement> quantityColumnElements = TableData.getTableColumn(driver,1);
        List<Integer> quantityColumn = new ArrayList<>();

        for (WebElement element : quantityColumnElements) {
            quantityColumn.add((Integer.parseInt(element.getText())));
        }
        for (int i = 1; i < quantityColumn.size(); i++) {
            Assert.assertTrue(quantityColumn.get(i) >= quantityColumn.get(i - 1));
        }
    }
}
