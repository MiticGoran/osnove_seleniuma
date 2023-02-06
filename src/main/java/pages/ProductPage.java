package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPage extends BasePage{
    public ProductPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }
    public WebElement quantity(){
        return driver.findElement(By.xpath("//div[@class='quantity']/input"));
    }
    public WebElement addToCartButton(){
        return driver.findElement(By.name("add-to-cart"));
    }
    public WebElement notificationAddedToCart(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("woocommerce-message")));
    }
}
