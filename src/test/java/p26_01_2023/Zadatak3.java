package p26_01_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Zadatak3 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://s.bootsnipp.com/iframe/z80en");

        List<WebElement> kolona = driver.findElements(By.xpath("//*[@id='lorem']/table/tbody/tr"));

        for (int i = 0; i < kolona.size(); i++) {
            System.out.println(kolona.get(i).getText());
        }

        Thread.sleep(5000);
        driver.quit();
    }
}
