package p03_02_2023;

import com.sun.org.glassfish.gmbal.Description;
import helper.Helper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class KatalonShopTests {
    private WebDriver driver;
    private WebDriverWait wait;
    private String baseUrl = "https://cms.demo.katalon.com/";
    @BeforeClass
    public void beforeClass() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        this.driver = new ChromeDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        this.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
    }
    @BeforeMethod
    public void beforeMethod() {
        this.driver.get(this.baseUrl);
    }
    @Test(priority = 10)
    @Description("TC-1: Adding product with quantity to the cart")
    public void addingProductWithQuantity(){
        this.driver.get(this.baseUrl + "/product/flying-ninja/");
        this.driver.findElement(By.xpath("//input[@title='Qty']")).clear();
        this.driver.findElement(By.xpath("//input[@title='Qty']")).sendKeys("3");
        this.driver.findElement(By.name("add-to-cart")).click();
        Assert.assertTrue(this.driver.findElement(By.className("woocommerce-message"))
                .getText().contains("Flying Ninja"), "Invalid Text, 'Flying Ninja' Not Found");
        this.driver.findElement(By.xpath("//a[@tabindex='1']")).click();
        Assert.assertTrue(this.driver.getCurrentUrl().contains("/cart"), "Wrong URL");
        List<WebElement> lista = driver.findElements(By.xpath("//*[@class='product-name']/a"));
        Assert.assertTrue(lista.size() == 1, "Products in cart not 1");
    }
    @Test(priority = 20)
    @Description("TC-2: Removing product from cart")
    public void removingProductFromCart(){
        this.driver.findElement(By.xpath
                ("//div[@id='primary-menu']//li[@class='page_item page-item-8']/a")).click();
        Assert.assertTrue(this.driver.getCurrentUrl().contains("/cart"), "Wrong URL");
        List<WebElement> lista = driver.findElements(By.xpath("//*[@class='product-name']/a"));
        Assert.assertTrue(lista.size() == 1, "Products in cart not 1");
        driver.findElement(By.xpath("//td[@class='product-remove']/a")).click();
        Assert.assertTrue
                (driver.findElement(By.xpath("//p[@class='cart-empty woocommerce-info']"))
                        .getText().equals("Your cart is currently empty."), "Your cart is not empty");
    }
    @Test(priority = 30)
    @Description("TC-3: Verify error is displayed when username is missing")
    public void errorIsDisplayedWithMissingUsername(){
        this.driver.findElement(By.xpath
                ("//div[@id='primary-menu']//li[@class='page_item page-item-10']/a")).click();
        driver.findElement(By.name("login")).click();
        Assert.assertEquals
                (driver.findElement(By.xpath("//ul[@class='woocommerce-error']/li"))
                        .getText(), "Error: Username is required."
                        , "Error notification not found!");
    }
    @Test(priority = 40)
    @Description("TC-4: Verify error is displayed when password is missing")
    public void errorIsDisplayedWithMissingPassword(){
        this.driver.findElement(By.xpath
                ("//div[@id='primary-menu']//li[@class='page_item page-item-10']/a")).click();
        driver.findElement(By.id("username")).sendKeys("customer");
        driver.findElement(By.name("login")).click();
        Assert.assertEquals
                (driver.findElement(By.xpath("//ul[@class='woocommerce-error']/li"))
                                .getText(), "ERROR: The password field is empty."
                        , "Error notification not found!");
    }
    @Test(priority = 50)
    @Description("TC-5: VVerify error is displayed when password is wrong")
    public void errorIsDisplayedWithWrongPassword(){
        this.driver.findElement(By.xpath
                ("//div[@id='primary-menu']//li[@class='page_item page-item-10']/a")).click();
        driver.findElement(By.id("username")).sendKeys("customer");
        driver.findElement(By.id("password")).sendKeys("invalidpassword");
        driver.findElement(By.name("login")).click();
        Assert.assertEquals
                (driver.findElement(By.xpath("//ul[@class='woocommerce-error']/li"))
                                .getText(), "ERROR: The password you entered for " +
                                "the username customer is incorrect. Lost your password?"
                        , "Error notification not found!");
    }
    @Test(priority = 60)
    @Description("TC-6: Verify error is displayed when user does not exist")
    public void errorIsDisplayedWhenUserDoesNotExist(){
        this.driver.findElement(By.xpath
                ("//div[@id='primary-menu']//li[@class='page_item page-item-10']/a")).click();
        driver.findElement(By.id("username")).sendKeys("invaliduser");
        driver.findElement(By.id("password")).sendKeys("pass1234");
        driver.findElement(By.name("login")).click();
        Assert.assertEquals
                (driver.findElement(By.xpath("//ul[@class='woocommerce-error']/li"))
                                .getText(), "ERROR: Invalid username. Lost your password?"
                        , "Error notification not found!");
    }
    @Test(priority = 70)
    @Description("TC-7: Verify successful login")
    public void successfulLogin(){
        this.driver.findElement(By.xpath
                ("//div[@id='primary-menu']//li[@class='page_item page-item-10']/a")).click();
        driver.findElement(By.id("username")).sendKeys("customer");
        driver.findElement(By.id("password")).sendKeys("crz7mrb.KNG3yxv1fbn");
        driver.findElement(By.name("login")).click();
        Assert.assertTrue(driver.findElement
                (By.xpath("//div[@class='woocommerce-MyAccount-content']/p[1]"))
                .getText().contains("Hello Katalon Parlitul_Changed"), "Cannot login with valid data!");
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("End of test");
    }
    @AfterClass
    public void afterClass() throws InterruptedException {
        Thread.sleep(5000);
        this.driver.quit();
    }
}
