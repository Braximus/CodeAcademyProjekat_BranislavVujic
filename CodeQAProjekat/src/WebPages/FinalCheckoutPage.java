package WebPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FinalCheckoutPage extends BasePage
{
    public FinalCheckoutPage(WebDriver driver)
    {
        super(driver);
    }

    By thankYouMessageBy = By.className("complete-header");
    By backHomeButtonBy = By.id("back-to-products");

    public FinalCheckoutPage verifyTextVisibility(String expectedText)
    {
        String actualText = readText(thankYouMessageBy);
        checkTxtEquals(expectedText, actualText);
        return this;
    }

    public FinalCheckoutPage clickOnBackHomeButton()
    {
        click(backHomeButtonBy);
        return this;
    }

}
