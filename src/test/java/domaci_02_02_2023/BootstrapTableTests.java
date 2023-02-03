package domaci_02_02_2023;

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

public class BootstrapTableTests {
    private WebDriver driver;
    private WebDriverWait wait;
    private String baseUrl = "https://s.bootsnipp.com/";
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
    @Test(priority = 1)
    @Description("TC-1: Edit Row")
    public void editRow()  {
        this.driver.get(this.baseUrl + "/iframe/K5yrx");
        Assert.assertEquals(this.driver.getTitle(), "Table with Edit and Update Data - Bootsnipp.com",
                "Invalid Title, not on Table with Edit and Update Data!");
        this.driver.findElement
                (By.xpath("//button[@data-uid='1'][contains(@class, 'update')]"))
                .click();
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("modal-content")));
        this.driver.findElement(By.id("fn")).clear();
        this.driver.findElement(By.id("ln")).clear();
        this.driver.findElement(By.id("mn")).clear();
        this.driver.findElement(By.id("fn")).sendKeys("Goran");
        this.driver.findElement(By.id("ln")).sendKeys("Mitic");
        this.driver.findElement(By.id("mn")).sendKeys("Mita");
        this.driver.findElement(By.id("up")).click();
        this.wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("modal-content")));
        Assert.assertEquals(this.driver.findElement(By.id("f1")).getText(), "Goran",
                "Invalid first name");
        Assert.assertEquals(this.driver.findElement(By.id("l1")).getText(), "Mitic",
                "Invalid last name");
        Assert.assertEquals(this.driver.findElement(By.id("m1")).getText(), "Mita",
                "Invalid middle name");
    }
    @Test(priority = 2)
    @Description("TC-2: Delete Row")
    public void deleteRow(){
        this.driver.get(this.baseUrl + "/iframe/K5yrx");
        Assert.assertEquals(this.driver.getTitle(), "Table with Edit and Update Data - Bootsnipp.com",
                "Invalid Title, not on Table with Edit and Update Data!");
        this.driver.findElement
                        (By.xpath("//button[@data-uid='1'][contains(@class, 'delete')]"))
                .click();
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("del")));
        List<WebElement> lista1 = this.driver.findElements(By.xpath("//*[tbody]//td"));
        this.driver.findElement(By.id("del")).click();
        this.wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("del")));
        List<WebElement> lista2 = this.driver.findElements(By.xpath("//*[tbody]//td"));
        Assert.assertFalse(lista1.size() == (lista2.size() - 1),
                "Row not deleted");
    }
    @Test(priority = 3)
    @Description("TC-3: Take a Screenshot")
    public void takeScreenshot() throws IOException {
        this.driver.get(this.baseUrl + "/iframe/K5yrx");
        Assert.assertEquals(this.driver.getTitle(), "Table with Edit and Update Data - Bootsnipp.com",
                "Invalid Title, not on Table with Edit and Update Data!");
        new Helper().takeScreenshot(this.driver, "screenshots/screenshot1.jpg");
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
