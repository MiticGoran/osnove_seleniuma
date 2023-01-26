package p26_01_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak6 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://cms.demo.katalon.com/");
        if (driver.findElement(By.className("menu-toggle")).isDisplayed()){
            System.out.println("Is visible");
        } else {
            System.out.println("Not visible");
        }
        Dimension newDimension = new Dimension(700, 700);
        driver.manage().window().setSize(newDimension);
        if (driver.findElement(By.className("menu-toggle")).isDisplayed()){
            System.out.println("Is visible");
        } else {
            System.out.println("Not visible");
        }

        Thread.sleep(5000);
        driver.quit();
    }
}
