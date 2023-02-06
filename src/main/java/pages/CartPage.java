package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class CartPage extends BasePage{
    public CartPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }
    public WebElement deleteButtonForRow(int row){
        return driver.findElement(By.xpath("//td[@class='product-remove']/a["+row+"]"));
    }
    public WebElement inputForCoupon(){
        return driver.findElement(By.id("coupon_code"));
    }
    public WebElement applyCouponButton(){
        return driver.findElement(By.name("apply_coupon"));
    }
    public WebElement updateCartButton(){
        return driver.findElement(By.name("update_cart"));
    }
    public List<WebElement> tableRows(){
        return driver.findElements(By.xpath("//tbody/tr/td[@class='product-remove']"));
    }
}
