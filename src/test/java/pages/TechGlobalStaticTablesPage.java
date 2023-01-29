package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class TechGlobalStaticTablesPage extends TechGlobalBasePage{

    public TechGlobalStaticTablesPage(){
        super();
    }

    @FindBy(css = ".header")
    public List<WebElement> tableHeader;
    @FindBy(xpath = "(//tbody//tr)[1]/td")
    public List<WebElement> firstRow;


}
