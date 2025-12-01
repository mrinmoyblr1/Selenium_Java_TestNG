package Selenium;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
public class e2e {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Users/mrinmoy/IdeaProjects/Introduction/src/main/java/chromedriver");
        WebDriver driver = new ChromeDriver();
        //driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        Thread.sleep(2000);
        driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
        Thread.sleep(2000);
//        driver.findElement(By.xpath("//*[@text='Bengaluru (BLR)']")).click();
        driver.findElement(By.xpath("//a[@value='DEL']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@id='ctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA']")).click();
        //  driver.findElement(By.xpath("(//a[@value='MAA'])[2]")).click();
        driver.findElement(By.cssSelector("#ctl00_mainContent_view_date1")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector(".ui-state-default.ui-state-active")).click();
        if (driver.findElement(By.id("Div1")).getDomAttribute("style").contains("opacity: 0.5")) {
            System.out.println("It's  disabled");
            Assert.assertTrue(true);
        } else {
            Assert.fail();
        }
        driver.findElement(By.cssSelector("input[name*='SeniorCitizenDiscount']")).click();
        Assert.assertTrue(driver.findElement(By.cssSelector("input[name*='SeniorCitizenDiscount']")).isSelected());
        driver.findElement(By.id("divpaxinfo")).click();
        Thread.sleep(3000);
        for (int i = 0; i < 5; i++) {
            driver.findElement(By.id("hrefIncAdt")).click();
        }
        driver.findElement(By.id("btnclosepaxoption")).click();
        Thread.sleep(2000);
        System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
        Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(), "6 Adult");
        WebElement staticDropdown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
        Select dropdown = new Select(staticDropdown);
        dropdown.selectByValue("INR");
        System.out.println(dropdown.getFirstSelectedOption().getText());
        dropdown.selectByIndex(2);
        System.out.println(dropdown.getFirstSelectedOption().getText());
        dropdown.selectByVisibleText("USD");
        System.out.println(dropdown.getFirstSelectedOption().getText());
        Assert.assertEquals("USD", dropdown.getFirstSelectedOption().getText());
//        driver.findElement(By.cssSelector("input[name='ctl00$mainContent$btn_FindFlights']")).click();
        driver.findElement(By.id("ctl00_mainContent_btn_FindFlights")).click();
//        driver.findElement(By.cssSelector("#ctl00_mainContent_btn_FindFlights")).click();
//        driver.findElement(By.xpath("//input[@value='Search']")).click();
        driver.quit();
    }
}
