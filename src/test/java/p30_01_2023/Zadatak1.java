package p30_01_2023;

//        Zadatak
//        Napisati program koji ucitava stranicu https://s.bootsnipp.com/iframe/klDWV i ceka da se
////      ucita progress bar na 100% a zatim ispisuje tekst u konzoli “Stranica ucitana”

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Zadatak1 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(5000));
        driver.get("https://s.bootsnipp.com/iframe/klDWV");
//        wait.until(ExpectedConditions.textToBe(By.id("percent"), "100%"));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@style='width: 100%;']")));
        System.out.println("Stranica ucitana.");

        Thread.sleep(5000);
        driver.quit();
    }
}
