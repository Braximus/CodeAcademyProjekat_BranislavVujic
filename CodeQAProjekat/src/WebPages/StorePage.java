package WebPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class StorePage extends BasePage
{
    public StorePage(WebDriver driver)
    {
        super(driver);
    }

    By storePageTitleBy = By.xpath( "//*[@id='header_container']/div[2]/span");
    By burgerMenuButtonBy = By.id("react-burger-menu-btn");
    By logoutButtonBy = By.id("logout_sidebar_link");
    By shoppingCartBadgeBy = By.className("shopping_cart_badge");
    By shoppingCartBy = By.id("shopping_cart_container");
    By numberofItemsBy = By.className("inventory_item");

    By addToCartButtonProduct1 = By.id("add-to-cart-sauce-labs-backpack");
    By addToCartButtonProduct2 = By.id("add-to-cart-sauce-labs-bike-light");
    By addToCartButtonProduct3 = By.id("add-to-cart-sauce-labs-bolt-t-shirt");
    By addToCartButtonProduct4 = By.id("add-to-cart-sauce-labs-fleece-jacket");
    By addToCartButtonProduct5 = By.id("add-to-cart-sauce-labs-onesie");
    By addToCartButtonProduct6 = By.id("add-to-cart-test.allthethings()-t-shirt-(red)");

    public StorePage verifySuccessfulLogin(String expectedText)
    {
        String actualText = readText(storePageTitleBy);
        checkTxtEquals(expectedText, actualText);
        return this;
    }

    public StorePage checkNumberOfProducts(int expectedNumberOfProducts)
    {
        int actualNumberOfProducts = countItems(numberofItemsBy);
        checkIntEquals(expectedNumberOfProducts, actualNumberOfProducts);
        return this;
    }

    public StorePage clickOnBurgerMenu()
    {
        click(burgerMenuButtonBy);
        return this;
    }

    public StorePage clickOnShoppingCart()
    {
        click(shoppingCartBy);
        return this;
    }

    public StorePage clickOnLogoutButton()
    {
        click(logoutButtonBy);
        return this;
    }

    public StorePage addProductsToCart()
    {
        click(addToCartButtonProduct1);
        click(addToCartButtonProduct3);
        waitVisibility(shoppingCartBadgeBy);
        return this;
    }

}
