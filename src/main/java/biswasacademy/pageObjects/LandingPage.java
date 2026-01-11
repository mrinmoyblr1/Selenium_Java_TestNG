package biswasacademy.pageObjects;

import biswasacademy.AbstractComponent.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage extends AbstractComponent {
    WebDriver driver;

    // Constructor
    public LandingPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // PageFactory design pattern
    @FindBy(id = "userEmail")
    WebElement userEmail;

    @FindBy(id = "userPassword")
    WebElement passwordEle;

    @FindBy(id = "login")
    WebElement submit;


    public void goTo() {
        driver.get("https://rahulshettyacademy.com/client/#/auth/login");
    }

    // Action class. Below is the method to perform login Action
    public ProductCatalogue loginApplication(String email, String password) {
        userEmail.sendKeys(email);
        passwordEle.sendKeys(password);
        submit.click();
        ProductCatalogue productCatalogue = new ProductCatalogue(driver);
        return productCatalogue;


    }


}
