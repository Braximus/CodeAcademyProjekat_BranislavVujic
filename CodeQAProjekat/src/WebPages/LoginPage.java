package WebPages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage
{
    public LoginPage(WebDriver driver)
    {
        super(driver);
    }

    String baseURL = "https://www.saucedemo.com/";

   

    By usernameBy = By.id("user-name");
    By passwordBy = By.id("password");
    By loginButtonBy = By.id("login-button");

    By errorMessageBy = By.xpath("//*[@id='login_button_container']/div/form/div[3]/h3");

    By botPictureBy = By.className("bot_column");
    By loginLogoBy = By.className("login_logo");

    public LoginPage basePage()
    {
        driver.get(baseURL);
        return this;
    }

    public LoginPage verifyVisibility()
    {
        //waitVisibility(botPictureBy);
        driver.findElement(botPictureBy).isDisplayed();
        driver.findElement(loginLogoBy).isDisplayed();
        return this;
    }

    public LoginPage login(String username, String password)
    {
        writeText(usernameBy, username);
        writeText(passwordBy, password);
        click(loginButtonBy);

        return this;
    }

    public LoginPage verifyUnsuccesfulLogin(String expectedText)
    {
        String actualText = readText(errorMessageBy);
        checkTxtEquals(expectedText, actualText);
        return this;
    }

    public LoginPage verifyUnsuccesfulGoToPageAttempt(String expectedText)
    {
        String actualText = readText(errorMessageBy);
        String verificationText = actualText.substring(0, 33);
        checkTxtEquals(expectedText, verificationText);
        return this;
    }

    public LoginPage goToPage(String link)
    {
        driver.get(link);
        return this;
    }
}
