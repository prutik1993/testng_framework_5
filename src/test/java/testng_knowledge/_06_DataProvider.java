package testng_knowledge;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utilities.Driver;

public class _06_DataProvider {
    /*
    Go to //www.google.com/
    Search for <key>
    Validate the result is more than zero
    |key|
    |Phone|
    |Spoon|
    |Airpods|
    |Mouse|
    |Pen|


    @Test(dataProvider = "searchData")
    public void validateSearchResult(String data){
        WebDriver driver = Driver.getDriver();
        driver.get("https://www.google.com/");
        driver.findElement(By.name("q")).sendKeys(data + Keys.ENTER);
        WebElement resultStatistics = driver.findElement(By.id("result-stats"));
        String result = resultStatistics.getText();
        Assert.assertTrue(Long.parseLong(result.substring(result.indexOf(" ") + 1,
                result.indexOf("results") - 1).replace(",", "")) > 0);
       Driver.quitDriver();
    }
    @Test(dataProvider = "credentials")
    public void ValidateInvalidUsernameMessage(String username, String password, String message){
        System.out.println("\n--------------\n");
        System.out.println("Username = " + username);
        System.out.println("Password = " + password);
        System.out.println("Message = " + message);
    }

    @DataProvider
    public Object[] searchData(){
        return new Object[] {"Phone", "Spoon", "Airpods", "Mouse", "Pen"};
    }

    @DataProvider
    public Object[][] credentials(){
        return new Object[][]{
                {"","","Invalid username entered!"},
                {"john","Test1234","Invalid username entered!"},
                {"TechGlobal","abcd","Invalid password entered!"}
        };
    }

     */
}
