package biswasacademy.pageObjects;

import biswasacademy.AbstractComponent.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class OrderPage extends AbstractComponent {
    WebDriver driver;

    public OrderPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // PageFactory design pattern
    @FindBy(css = "li[class='totalRow'] button[type='button']")
    WebElement checkOutEle;

    @FindBy(css = ".cartSection h3")
    List<WebElement> cartProducts;



    // Below is the method to perform login action
    public boolean verifyOrderDisplaying(String productName) {
        return cartProducts.stream().anyMatch(product -> product.getText().equalsIgnoreCase(productName));
    }

    public CheckoutPage goToCheckOut() {
        checkOutEle.click();
        return new CheckoutPage(driver);
    }
}
