package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class TechGlobalDynamicElementsPage extends TechGlobalBasePage{

    public TechGlobalDynamicElementsPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(css = "p[id*='box_1_']")
    public WebElement box1;

    @FindBy(css = "p[id*='box_2_']")
    public WebElement box2;
}