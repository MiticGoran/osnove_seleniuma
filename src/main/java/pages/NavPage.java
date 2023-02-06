package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NavPage extends BasePage{
    public NavPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }
    public WebElement cartLink(){
        return driver.findElement(By.className("page-item-8"));
    }
    public WebElement checkoutLink(){
        return driver.findElement(By.className("page-item-9"));
    }
    public WebElement myAccountLink(){
        return driver.findElement(By.className("page-item-10"));
    }
    public WebElement samplePageLink(){
        return driver.findElement(By.className("page-item-2"));
    }
    public WebElement shopLink(){
        return driver.findElement(By.className("page_item page-item-7"));
    }

}
