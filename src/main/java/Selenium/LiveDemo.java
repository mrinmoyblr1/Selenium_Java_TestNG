package Selenium;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import java.util.List;
import java.util.stream.Collectors;
public class LiveDemo {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Users/mrinmoy/IdeaProjects/Introduction/src/main/java/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
        // Click on columns button
        driver.findElement(By.xpath("//*[contains(text(),'Veg/fruit name')]")).click();
        // Capture all the WebElements into a list
        List<WebElement> elementsList = driver.findElements(By.xpath("//tr/td[1]"));
        // Capture the Text of each WebElement into another list
        // Below mentioned two lines do the same job
        List<String> originalList = elementsList.stream()
                .map(s -> s.getText())
                .collect(Collectors.toList());
        List<String> originalList1 = elementsList.stream()
                .map(WebElement::getText).toList();
        // Sort in the list -> Sorted List
        List<String> sortedList = originalList1.stream().sorted().toList();
        // Compare original list vs sorted list
        Assert.assertEquals(sortedList, originalList);
        sortedList.forEach(System.out::println);
        System.out.println("==============================");
        originalList.stream().forEach(System.out::println);
        System.out.println("==============================");


        // Below code is to find the price of a particular vegetable from the table consisting of pagination
        List<String> price;
        do {
            List<WebElement> rows = driver.findElements(By.xpath("//tr/td[1]"));
            // Scan the name column with "Rice" and print the price of the Rice
            price = rows.stream()
                    .filter(s -> s.getText().contains("Rice"))
                    .map(s -> getPriceVeggie(s)).collect(Collectors.toList());
            price.forEach(a -> System.out.println(a));
            if (price.size() < 1) {
                driver.findElement(By.cssSelector("[aria-label='Next']")).click();
            }
        }
        while (price.size() < 1);
        Thread.sleep(2000);
        driver.quit();
    }


    private static String getPriceVeggie(WebElement s) {
        String pricevalue = s.findElement(By.xpath("following-sibling::td[1]")).getText();
        return pricevalue;
    }
}
