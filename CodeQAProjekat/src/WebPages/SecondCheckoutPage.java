package WebPages;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SecondCheckoutPage extends BasePage
{
    public SecondCheckoutPage(WebDriver driver)
    {
        super(driver);
    }

    double tax_percent = 0.08;

    By subTotalPriceBy = By.className("summary_subtotal_label");
    By taxBy = By.className("summary_tax_label");
    By totalPriceBy = By.className("summary_total_label");
    By finishButtonBy = By.id("finish");
    By cancelButtonBy = By.id("cancel");

    By itemsBy = By.className("cart_item");
    By itemPriceBy = By.className("inventory_item_price");

    public SecondCheckoutPage clickOnFinishButton()
    {
        click(finishButtonBy);
        return this;
    }

    public SecondCheckoutPage clickOnCancelButton()
    {
        click(cancelButtonBy);
        return this;
    }

    public SecondCheckoutPage checkIfTotalPriceIsCorrect()
    {
        double expectedTotalPrice = Double.parseDouble(readText(totalPriceBy).substring(8));
        double total = 0;
        
        List<WebElement> items = driver.findElements(itemsBy);

        for (WebElement i : items)
        {
            //  Pronalazim pojedinacni element, uzimam cenu, dodajem porez i sabiram u konacnu cenu:
            double price = Double.parseDouble(i.findElement(itemPriceBy).getText().substring(1));
            double tax = price * tax_percent;
            total += price + tax;
        }

        //  Posto decimale mogu da se razlikuju za jedan broj, potrebno je da se zaokruzi decimalni broj:
        DecimalFormat df = new DecimalFormat("#.##");
        df.setRoundingMode(RoundingMode.HALF_UP);
        total = Double.parseDouble(df.format(total));

        checkDoubleEquals(expectedTotalPrice, total);
       
        return this;
    }


}
