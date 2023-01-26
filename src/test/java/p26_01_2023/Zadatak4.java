package p26_01_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak4 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://cms.demo.katalon.com/my-account/");
        driver.findElement(By.id("rememberme")).click();

        if (driver.findElement(By.id("rememberme")).isSelected()){
            System.out.println("Checkbox is selected.");
        } else {
            System.out.println("Not selected.");
        }

        Thread.sleep(5000);
        driver.quit();
    }
}
