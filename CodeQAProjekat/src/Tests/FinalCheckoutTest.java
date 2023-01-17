package Tests;

import org.junit.Test;

import WebPages.CartPage;
import WebPages.FinalCheckoutPage;
import WebPages.FirstCheckoutPage;
import WebPages.LoginPage;
import WebPages.SecondCheckoutPage;
import WebPages.StorePage;

public class FinalCheckoutTest extends BaseTest
{
    public LoginPage loginPage;
    public StorePage storePage;
    public CartPage cartPage;
    public FirstCheckoutPage check1Page;
    public SecondCheckoutPage check2Page;
    public FinalCheckoutPage checkoutPage;

    String standardUsername = "standard_user";
    String password = "secret_sauce";
    String expectedFinalCheckoutText = "THANK YOU FOR YOUR ORDER";

    String firstName = "Branislav";
    String lastName = "Vujic";
    String zipCode = "11000";

    //  Ovaj test proverava uspesnu kupovinu:
    @Test
    public void verifySuccesfullCheckoutTest()
    {
        loginPage = new LoginPage(driver);
        storePage = new StorePage(driver);
        cartPage = new CartPage(driver);
        check1Page = new FirstCheckoutPage(driver);
        check2Page = new SecondCheckoutPage(driver);
        checkoutPage = new FinalCheckoutPage(driver);

        loginPage.basePage();
        loginPage.login(standardUsername, password);
        
        storePage.addProductsToCart();
        storePage.clickOnShoppingCart();

        cartPage.clickOnCheckoutButton();

        check1Page.fillOutFormsAndProceedToCheckOut(firstName, lastName, zipCode);

        check2Page.clickOnFinishButton();
 
        checkoutPage.verifyTextVisibility(expectedFinalCheckoutText);
        waitAtEndOfTest();

    }

}
