package p02_02_2023;

import com.sun.org.glassfish.gmbal.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class KatalonLoginTests {
    private WebDriver driver;
    private WebDriverWait wait;
    private String baseUrl;
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
        this.driver.get("https://cms.demo.katalon.com/");
    }
    @Test
    @Description("TC-1: Visit login page from Nav bar")
    public void visitLoginPage()  {
        this.driver.findElement(By.xpath("//li[@class = 'page_item page-item-10']/a")).click();
        Assert.assertEquals(this.driver.getTitle(), "My account – Katalon Shop",
                "Invalid Title, not on my account page!");
        Assert.assertEquals(this.driver.getCurrentUrl(), "https://cms.demo.katalon.com/my-account/",
                "Invalid URL, not on my account page!");
    }
    @Test
    @Description("TC-2: Check input types")
    public void checkInputTypes(){
        this.driver.get("https://cms.demo.katalon.com/my-account/");
        Assert.assertEquals(this.driver.findElement(By.id("username")).getAttribute("type"), "text",
                "Username type is not text");
        Assert.assertEquals(this.driver.findElement(By.id("password")).getAttribute("type"), "password",
                "Password type is not password");
        Assert.assertEquals(this.driver.findElement(By.id("rememberme")).getAttribute("type"), "checkbox",
                "Remember me checkbox type is not checkbox");
        Assert.assertFalse(this.driver.findElement(By.id("rememberme")).isSelected(),
                "Remember me checkbox should not be selected");
    }
    @Test
    @Description("TC-3: Display error when credentials are wrong")
    public void wrongCredentials(){
        this.driver.get("https://cms.demo.katalon.com/my-account/");
        this.driver.findElement(By.id("username")).sendKeys("invalidemail@gmail.com");
        this.driver.findElement(By.id("password")).sendKeys("invalid123");
        this.driver.findElement(By.xpath("//button[@value='Log in']")).click();
//        Assert.assertTrue(this.driver.findElement(By.className("woocommerce-error")).isDisplayed(),
//                "Error notification is not displayed");
        this.wait.until(ExpectedConditions.presenceOfElementLocated(By.className("woocommerce-error")));
        Assert.assertTrue(this.driver.findElement
                (By.xpath("//div[@class='woocommerce-notices-wrapper']/ul/li"))
                        .getText().contains("ERROR: Invalid email address"),
                "Error: Invalid email adress is not displayed!");
    }
    @AfterMethod
    public void afterMethod() {
        System.out.println("AFTER TEST");
    }
    @AfterClass
    public void afterClass() throws InterruptedException {
        Thread.sleep(5000);
        this.driver.quit();
    }
}
