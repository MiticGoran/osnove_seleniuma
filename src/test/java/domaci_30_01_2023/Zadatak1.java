package domaci_30_01_2023;

//        Zadatak
//        Napisati program koji testira infinity scroll.
//        Ucitati stranu https://web.dev/patterns/web-vitals-patterns/infinite-scroll/infinite-scroll/demo.html
//        Selektujte delay od 2000ms, koristeci Select klasu.
//        Skrol do Show more dugmeta koje se nalazi na dnu stranice
//        Sacekajte da dugme bude klikljivo
//        Klik na Show more dugme
//        Sacekjate da broj elemenata bude X (X je koliko se kod vas ucitava)
//        Sacekajte da dugme vise ne bude klikljivo

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Zadatak1 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(20000));
        driver.get("https://web.dev/patterns/web-vitals-patterns/infinite-scroll/infinite-scroll/demo.html");
        WebElement e1 = driver.findElement(By.id("delay-select"));
        Select select = new Select(e1);
        select.selectByVisibleText("2000ms");
        new Actions(driver).scrollToElement(driver.findElement(By.id("infinite-scroll-button"))).perform();
// iz nekog razloga kad se program pokrene, button show more nikad ne postane klikabilan cak i posle dugog cekanja
// new Actions(driver).scrollToElement(driver.findElement(By.className("footer"))).perform();
// cak i kad se odradi scroll do footera
        wait.until(ExpectedConditions.elementToBeClickable(By.id("infinite-scroll-button")));
        driver.findElement(By.id("infinite-scroll-button")).click();
        wait.until(ExpectedConditions.numberOfElementsToBe(By.id("sentinel"), 8));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("infinite-scroll-button")));

        Thread.sleep(5000);
        driver.quit();
    }
}
