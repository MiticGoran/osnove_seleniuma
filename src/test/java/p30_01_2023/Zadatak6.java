package p30_01_2023;

//        Zadatak
//        Napisati program koji:
//        Ucitava stranicu https://tus.io/demo.html
//        Hvata sve linkove sa stranice
//        Skrola do svakog linka
//        Od svakog linka cita href atribut i stampa ga na ekranu

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.time.Duration;
import java.util.List;

public class Zadatak6 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(5000));
        driver.get("https://tus.io/demo.html");

//        Actions actions = new Actions(driver);
//        actions.scrollToElement(driver.findElement(By.id("offset-trigger")));
//        actions.perform();

        List<WebElement> lista = driver.findElements(By.tagName("h3"));
        for (int i = 0; i < lista.size(); i++) {
            new Actions(driver).scrollToElement(lista.get(i)).perform();
            System.out.println(lista.get(i).getText());
        }

        Thread.sleep(5000);
        driver.quit();
    }
}
