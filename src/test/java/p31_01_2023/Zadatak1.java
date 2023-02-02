package p31_01_2023;

//        Napisati program koji:
//        Krairajte folder za fajlove u okviru projekta pod nazivom test_data
//        U folder skinite i postavite proizvoljnu sliku
//        Ucitava stranu https://tus.io/demo.html
//        Skrola do dela za upload fajla
//        Aploadujte sliku
//        Cekajte da se pojava dugme za download fajla

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;

public class Zadatak1 {
    public static void main(String[] args) throws InterruptedException {
        String uploadImg = new File("test_data/deadpool.png").getAbsolutePath();
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://tus.io/demo.html");
        new Actions(driver).scrollToElement(driver.findElement(By.id("js-file-input"))).perform();
        driver.findElement(By.id("js-file-input")).sendKeys(uploadImg);
        wait.until(ExpectedConditions.
                presenceOfElementLocated(By.xpath("//a[contains(text(), 'Download')]")));
        Thread.sleep(5000);
        driver.quit();
    }
}
