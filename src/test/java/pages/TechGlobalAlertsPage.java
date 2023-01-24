package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class TechGlobalAlertsPage extends TechGlobalBasePage{
    public TechGlobalAlertsPage(){
        super();
    }

    @FindBy(css = ".Alerts_buttons__EEUBD li")
    public List<WebElement> alertButtons;

    @FindBy(id = "action")
    public WebElement result;
}
