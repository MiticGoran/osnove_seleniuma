package p27_01_2023;

//        Zadatak
//        Napisati program koji ucitava
//        stranicu https://github.com/orgs/embedly/repositories?q=&type=all&language=&sort=
//        Klik na Type drawdown
//        Klik na Public iz drowdowna
//        Proverava da li je Clear dugme u desnom uglu prikazano
//        Kilk na Clear filter u desnom uglu

import helper.Helper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Zadatak5 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        Helper h1 = new Helper();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://github.com/orgs/embedly/repositories?q=&type=all&language=&sort=");
        WebElement type = driver.findElement(By.id("type-options"));
        type.click();
        Thread.sleep(1000);
        type.findElements(By.className("SelectMenu-item")).get(1).click();

        if (new Helper().elementExist(driver, By.className("issues-reset-query"))){
            System.out.println("Postoji");
        } else {
            System.out.println("Ne postoji");
        }

        driver.findElement(By.className("issues-reset-query")).click();
        Thread.sleep(5000);
        driver.quit();
    }
}
