package biswasacademy.pageObjects;

import biswasacademy.AbstractComponent.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CartPage extends AbstractComponent {
    WebDriver driver;

    public CartPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // PageFactory design pattern
    @FindBy(css = ".cartSection h3")
    List<WebElement> cartProducts;


    @FindBy(css = "li[class='totalRow'] button[type='button']")
    WebElement checkOutEle;


    // Below is the method to perform login action
    public boolean verifyProductDisplaying(String productName) {
        return cartProducts.stream().anyMatch(product -> product.getText().equalsIgnoreCase(productName));
    }


    public CheckoutPage goToCheckOut() {
        checkOutEle.click();
        return new CheckoutPage(driver);
    }


}
