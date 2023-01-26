package p26_01_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Zadatak1 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://s.bootsnipp.com/iframe/oV91g");

        List<WebElement> lista = driver.findElements(By.className("page_link"));

        for (int i = 0; i < lista.size(); i++) {
            lista.get(i).click();
            Thread.sleep(1000);
        }


        Thread.sleep(5000);
        driver.quit();
    }
}
