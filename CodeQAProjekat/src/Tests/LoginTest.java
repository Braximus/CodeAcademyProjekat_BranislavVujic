package Tests;

import org.junit.Test;

import WebPages.LoginPage;
import WebPages.StorePage;

public class LoginTest extends BaseTest
{
    public LoginPage loginPage;

    String lockedOutUsername = "locked_out_user";
    String badpassword = "seecreet_sauces";

    String badPasswordText = "Epic sadface: Username and password do not match any user in this service";
    String emptyUsernameText = "Epic sadface: Username is required";
    String emptyPasswordText = "Epic sadface: Password is required";
    String lockedOutUserText = "Epic sadface: Sorry, this user has been locked out.";
    String goToPageSignedOut = "Epic sadface: You can only access";

    String expectedTextAfterSucessfulLogin = "PRODUCTS";

    String homePageHref = "https://www.saucedemo.com/inventory.html";
    String cartPageHref = "https://www.saucedemo.com/cart.html";

    //  Ovaj test proverava uspesno logovanje na sajt:
    @Test
    public void verifySuccessfulLoginTest()
    {
        LoginPage loginPage = new LoginPage(driver);
        StorePage storePage = new StorePage(driver);

        loginPage.basePage();
        loginPage.login(standardUsername, password);
        storePage.verifySuccessfulLogin(expectedTextAfterSucessfulLogin);

        waitAtEndOfTest();
    }

    //  Ovaj test proverava uspesan logout
    @Test
    public void verifySucessfulLogoutTest()
    {
        LoginPage loginPage = new LoginPage(driver);
        StorePage storePage = new StorePage(driver);

        loginPage.basePage();
        loginPage.login(standardUsername, password);
//        storePage.verifySuccessfulLogin(expectedTextAfterSucessfulLogin);
        storePage.clickOnBurgerMenu();
        storePage.clickOnLogoutButton();
        loginPage.verifyVisibility();

        waitAtEndOfTest();
    }


    //  Ovaj test provereva nesupesan login - los password
    @Test
    public void verifyUnSuccessfulLoginBadPasswordTest()
    {
        LoginPage loginPage = new LoginPage(driver);

        loginPage.basePage();
        loginPage.login(standardUsername, badpassword);
        loginPage.verifyUnsuccesfulLogin(badPasswordText);

        waitAtEndOfTest();
    }

    //  Ovaj test proverava neuspesan login - prazan username
    @Test
    public void verifyUnSuccessfulLoginEmptyUsernameTest()
    {
        LoginPage loginPage = new LoginPage(driver);

        loginPage.basePage();
        loginPage.login("", password);
        loginPage.verifyUnsuccesfulLogin(emptyUsernameText);

        waitAtEndOfTest();
    }

    //  Ovaj test provereva nesupesan login - prazan password
    @Test
    public void verifyUnSuccessfulLoginEmptyPasswordTest()
    {
        LoginPage loginPage = new LoginPage(driver);

        loginPage.basePage();
        loginPage.login(standardUsername, "");
        loginPage.verifyUnsuccesfulLogin(emptyPasswordText);

        waitAtEndOfTest();
    }

    //  Ovaj test provereva nesupesan login - locked out user
    @Test
    public void verifyUnSuccessfulLoginLockedOutUserTest()
    {
        LoginPage loginPage = new LoginPage(driver);

        loginPage.basePage();
        loginPage.login(lockedOutUsername, password);
        loginPage.verifyUnsuccesfulLogin(lockedOutUserText);

        waitAtEndOfTest();
    }

    //  Bonus - ovaj test proverava da li korisnik moze da pristupi "Homepage-u" (ili drugoj stranici) ako nije ulogovan - pokusava direknto da udje na stranicu
    @Test
    public void verifyUnsuccesfulPageAccessAtempt()
    {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.goToPage(cartPageHref);
        loginPage.verifyUnsuccesfulGoToPageAttempt(goToPageSignedOut);

        waitAtEndOfTest();
    }

}
