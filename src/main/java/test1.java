import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.UUID;
import org.testng.Assert;
public class test1 {

    public static void main (String[] args){

        System.setProperty("webdriver.chrome.driver","C:\\Users\\admin\\Downloads\\chromedriver_win32\\chromedriver.exe");

        WebDriver obj = new ChromeDriver();
        obj.get ("https://www.aodocs.com");

        //Resize current window to the set dimension
        //obj.manage().window().maximize();

        //click request a demo button
        obj.findElement(By.xpath("//*[@id=\"DND_banner-module-1\"]/div/div/div[1]/div/div/a")).click();

        //enter first name
        obj.findElement(By.id("firstname-384ed391-59a1-4016-bc91-62bb1307edb2_3031")).sendKeys("Darine");

        //Make random email
        String RandomEmail = UUID.randomUUID().toString();

        //Now this uuid enter to your text box
        obj.findElement(By.id("email-384ed391-59a1-4016-bc91-62bb1307edb2_3031")).sendKeys(RandomEmail);


        WebDriverWait wait = new WebDriverWait(obj, 15);
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@name='company_size__c']")));


        //Open list
        obj.findElement(By.xpath("//select[@name='company_size__c']")).click();

        //Choose campany size
        obj.findElement(By.xpath("//option[contains(text(),'0-4 employees')]")).click();





        //Click submit
        obj.findElement(By.xpath("//input[@class='hs-button primary large']")).click();

        //Check error messages
        //Email error msg
        //String EmailError = obj.findElement(By.xpath("//*[@id=\"hsForm_384ed391-59a1-4016-bc91-62bb1307edb2_3031\"]/fieldset[2]/div[1]/ul/li/label")).getText();
        //Assert.assertEquals("Email must be formatted correctly.", EmailError);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[@class='hs-error-msg' and contains(@data-reactid,'lastname')]")));
        //Last name error msg
        String LastNameError = obj.findElement(By.xpath("//label[@class='hs-error-msg' and contains(@data-reactid,'lastname')]")).getText();
        Assert.assertEquals("Please complete this required field.", LastNameError);



        //check company msg
        //String CompanyError = obj.findElement(By.xpath("//*[@id=\"hsForm_384ed391-59a1-4016-bc91-62bb1307edb2_3031\"]/fieldset[3]/div[1]/ul/li/label")).getText();
        //Assert.assertEquals("Please complete this required field.", CompanyError);

        //check country msg
        //String CountryError = obj.findElement(By.xpath("//*[@id=\"hsForm_384ed391-59a1-4016-bc91-62bb1307edb2_3031\"]/fieldset[4]/div/ul/li/label")).getText();
        //Assert.assertEquals("Please select an option from the dropdown menu.", CountryError);

        //check msg field
        //String MsgError = obj.findElement(By.xpath("//*[@id=\"hsForm_384ed391-59a1-4016-bc91-62bb1307edb2_3031\"]/fieldset[6]/div/ul/li/label")).getText();
        //Assert.assertEquals("Please complete this required field.", MsgError);

        //ho did you hear about us
        //String HowDidYouError = obj.findElement(By.xpath("//*[@id=\"hsForm_384ed391-59a1-4016-bc91-62bb1307edb2_3031\"]/fieldset[7]/div/ul/li/label")).getText();
        //Assert.assertEquals("Please select an option from the dropdown menu.", HowDidYouError);

        //Complete form
        //String CompleteFormError = obj.findElement(By.xpath("//*[@id=\"hsForm_384ed391-59a1-4016-bc91-62bb1307edb2_3031\"]/div[1]/ul/li/label")).getText();
        //Assert.assertEquals("Please complete all required fields.", CompleteFormError);


        obj.quit();







    }
}
