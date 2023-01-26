package p26_01_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Zadatak5 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.ebay.com/");

        Select izaberi = new Select(driver.findElement(By.id("gh-cat")));
//        driver.findElement(By.id("gh-cat")).click();
        izaberi.selectByVisibleText("Crafts");

        Thread.sleep(5000);
        driver.quit();
    }
}
