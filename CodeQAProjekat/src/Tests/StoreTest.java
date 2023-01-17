package Tests;

import org.junit.Test;

import WebPages.CartPage;
import WebPages.LoginPage;
import WebPages.StorePage;

public class StoreTest extends BaseTest
{
    public LoginPage loginPage;
    public StorePage storePage;
    public CartPage cartPage;

    String standardUsername = "standard_user";
    String password = "secret_sauce";
    String expectedText = "PRODUCTS";
    int    expectedNumberOfProductsOnStorePage = 6;



    //  Ovaj test broji koliko produkta postoji na Store Page stranici:
    @Test
    public void checkNumberOfProductsTest()
    {
        loginPage = new LoginPage(driver);
        storePage = new StorePage(driver);

        loginPage.basePage();
        loginPage.login(standardUsername, password);
        storePage.verifySuccessfulLogin(expectedText);
        storePage.checkNumberOfProducts(expectedNumberOfProductsOnStorePage);

        waitAtEndOfTest();
    }

    //  Ovaj test proverava da li su ubaceni proizvodi u kolica:
    @Test
    public void checkAddProductsToCart()
    {
        loginPage = new LoginPage(driver);
        storePage = new StorePage(driver);

        loginPage.basePage();
        loginPage.login(standardUsername, password);
        storePage.verifySuccessfulLogin(expectedText);

        storePage.addProductsToCart();

        waitAtEndOfTest();
    }


    
}
