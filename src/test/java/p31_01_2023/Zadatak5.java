package p31_01_2023;

import helper.Helper;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Files;
import java.time.Duration;
import java.util.List;

//        Napisati program koji:
//        Ucitava stranicu https://cms.demo.katalon.com/
//        Hvata  sve href atribute svih linkova iz navigacije
//        Za svaki link proverava status da je veci ili jednak od 200 i manji od 400
//        Koristan link za citanje status koda nekog url-a
public class Zadatak5 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://cms.demo.katalon.com/");
        List<WebElement> lista = driver.findElements(By.xpath("//*[@id='primary-menu']/ul/li/a"));
        for (int i = 0; i < lista.size(); i++) {
            String url = lista.get(i).getAttribute("href");
            try {
                int statusCode = new Helper().getHTTPResponseStatusCode(url);
                if (statusCode >= 200 && statusCode < 400){
                    System.out.println(url + " is available.");
                } else {
                    System.out.println(url + " is not available.");
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        Thread.sleep(5000);
        driver.quit();
    }
}
