package scripts;
import org.testng.Assert;
import org.testng.annotations.Test;


public class TechGlobalLogoTest extends TechGlobalBase{

    @Test
    public void validateTechGlobalLogo() {
        Assert.assertTrue(techGlobalBasePage.logo.isDisplayed());
    }

}
