package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;

import java.util.List;

public class TechGlobalIFramesPage extends TechGlobalBasePage{
    public TechGlobalIFramesPage(){
        super();
    }
    @FindBy( css= "#name_form > p")
    public WebElement inputHeader;

    @FindBy(css = "#form_frame")
    public WebElement iFrameId;
    @FindBy(id = "first_name")
    public WebElement firstName;
     @FindBy(id = "last_name")
    public WebElement lastName;
     @FindBy(id = "submit")
    public WebElement submitButton;
     @FindBy(id = "result")
    public WebElement resultText;
     @FindBy(xpath = "//input")
    public List<WebElement> inputFields;

}
