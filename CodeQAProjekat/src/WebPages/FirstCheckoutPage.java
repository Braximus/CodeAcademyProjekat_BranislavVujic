package WebPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FirstCheckoutPage extends BasePage
{
    public FirstCheckoutPage(WebDriver driver)
    {
        super(driver);
    }

    By formFirstNameBy = By.id("first-name");
    By formLastNameBy = By.id("last-name");
    By formZipCodeBy = By.id("postal-code");
    By continueButtonBy = By.id("continue");
    By cancelButtonBy = By.id("cancel");

    public FirstCheckoutPage fillOutFormsAndProceedToCheckOut(String firstName, String lastName, String zipCode)
    {
        writeText(formFirstNameBy, firstName);
        writeText(formLastNameBy, lastName);
        writeText(formZipCodeBy, zipCode);
        click(continueButtonBy);
        return this;
    }

    public FirstCheckoutPage clickOnCancelButton()
    {
        click(cancelButtonBy);
        return this;
    }
    

}
