package WebPages;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//  Klasa koja sadrzi sve zajednicke elemente web stranica.

public class BasePage 
{
    public WebDriver        driver;
    public WebDriverWait    driverWait;

    BasePage(WebDriver driver_parametri)
    {
        driver = driver_parametri;
        driverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void waitVisibility(By elementBy)
    {
       driverWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(elementBy));
    }

    public String readText(By elementBy)
    {
        waitVisibility(elementBy);
        return driver.findElement(elementBy).getText();
    }


    public void writeText(By elementBy, String param)
    {
        waitVisibility(elementBy);
        driver.findElement(elementBy).clear();
        driver.findElement(elementBy).sendKeys(param);
    }

    public void click(By elementBy)
    {
        waitVisibility(elementBy);
        driver.findElement(elementBy).click();
    }

    public int countItems(By elementBy)
    {
        waitVisibility(elementBy);
        return driver.findElements(elementBy).size();
    }

    public void checkTxtEquals(String expectedText, String actualText)
    {
        Assert.assertEquals(expectedText, actualText);
    }

    public void checkIntEquals(int expectedNumber, int actualNumber)
    {
        Assert.assertEquals(expectedNumber, actualNumber);
    }

    public void checkDoubleEquals(double expectedNumber, double actualNumber)
    {
        Assert.assertEquals(expectedNumber, actualNumber, 0.001);
    }
    
}
