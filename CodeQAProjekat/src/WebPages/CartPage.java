package WebPages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class CartPage extends BasePage
{
    public CartPage(WebDriver driver)
    {
        super(driver);
    }

    By checkoutButonBy = By.id("checkout");
    By continueShoppingButtonBy = By.id("continue-shopping");

    By cartListBy = By.className("cart_item");

    By removeButtonBy = By.id("remove-sauce-labs-backpack");
    By priceBy = By.className("inventory_item_price");
    

    public CartPage clickOnCheckoutButton()
    {
        click(checkoutButonBy);
        return this;
    }

    public CartPage clickOnContinueShoppingButton()
    {
        click(continueShoppingButtonBy);
        return this;
    }


}
