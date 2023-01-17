package Tests;

import org.junit.Test;

import WebPages.CartPage;
import WebPages.FirstCheckoutPage;
import WebPages.LoginPage;
import WebPages.SecondCheckoutPage;
import WebPages.StorePage;

public class SecondChekoutTest extends BaseTest
{
    public LoginPage loginPage;
    public StorePage storePage;
    public CartPage cartPage;
    public FirstCheckoutPage check1Page;
    public SecondCheckoutPage check2Page;

    String standardUsername = "standard_user";
    String password = "secret_sauce";
    String firstName = "Branislav";
    String lastName = "Vujic";
    String zipCode = "11000";


    //  Ovaj test proverava da li je ispravno izracunata cena i da li se poklapa sa prikazanom totalnom cenom:
    @Test
    public void isTotalPriceCorrectTest()
    {
        loginPage = new LoginPage(driver);
        storePage = new StorePage(driver);
        cartPage = new CartPage(driver);
        check1Page = new FirstCheckoutPage(driver);
        check2Page = new SecondCheckoutPage(driver);

        loginPage.basePage();
        loginPage.login(standardUsername, password);
        
        storePage.addProductsToCart();
        storePage.clickOnShoppingCart();

        cartPage.clickOnCheckoutButton();

        check1Page.fillOutFormsAndProceedToCheckOut(firstName, lastName, zipCode);

        check2Page.checkIfTotalPriceIsCorrect();

        waitAtEndOfTest();
    }

}
