package biswasacademy.pageObjects;

import biswasacademy.AbstractComponent.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ProductCatalogue extends AbstractComponent {
    WebDriver driver;
    @FindBy(className = "card-body")
    List<WebElement> products;
    @FindBy(css = ".ng-animating")
    WebElement spinner;
    By productsBy = By.className("card-body");
    By addToCartBy = By.cssSelector(".card-body button:last-of-type");
    By toastMessage = By.cssSelector("#toast-container");
    By getProductNameLocator = By.cssSelector("b");

    public ProductCatalogue(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //    By ng-animating- By.cssSelector(".ng-animating");
    //Action methods
    public List<WebElement> getProductList() {
        waitForElementToAppear(productsBy);
        return products;
    }

    public WebElement getProductByName(String productName) {
        WebElement prod = getProductList().stream().
                filter(product -> product.findElement(getProductNameLocator)
                        .getText().equalsIgnoreCase(productName)).findFirst().orElse(null);
        return prod;
    }

    public void addProductToCart(String productName) {
        WebElement prod = getProductByName(productName);
        prod.findElement(addToCartBy).click();
        waitForElementToAppear(toastMessage);
        //waitForElementToDisappear(spinner);
    }
}
