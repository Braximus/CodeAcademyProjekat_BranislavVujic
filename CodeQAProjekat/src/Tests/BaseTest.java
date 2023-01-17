package Tests;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BaseTest 
{
    public WebDriver driver;
    public ChromeOptions chromeSettings;
    
    String standardUsername = "standard_user";
    String password = "secret_sauce";

    public void waitAtEndOfTest()
    {
        try
        {
            Thread.sleep(3000);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }




    @Before
    public void setup()
    {
        System.setProperty("webdriver.chromedriver", "C:\\Users\\Bane\\Desktop\\CODE academi QA\\QA Projekat\\QAProjekat\\CodeQAProjekat\\lib");
        
        chromeSettings = new ChromeOptions();
        chromeSettings.addArguments("start-maximized");
        //chromeSettings.addArguments("headless");
        driver = new ChromeDriver(chromeSettings);

    }

    @After
    public void termination()
    {
        driver.quit();
    }

}
