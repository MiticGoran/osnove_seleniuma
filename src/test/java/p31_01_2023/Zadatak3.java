package p31_01_2023;

import helper.Helper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import java.io.File;
import java.io.IOException;
import java.time.Duration;
    public class Zadatak3 {
        public static void main(String[] args) throws InterruptedException {
            System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
            WebDriver driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
            driver.manage().window().maximize();
            driver.get("https://cms.demo.katalon.com/product/flying-ninja/");
            String imgSrc = driver.findElement
                            (By.className("zoomImg")).getAttribute("src");
            String destPath = new File("downloads/flying-ninja1.jpg").getAbsolutePath();
            try {
                new Helper().downloadUsingStream(imgSrc, destPath);
            } catch (IOException e) {
                e.printStackTrace();
            }
            Thread.sleep(5000);
            driver.quit();
        }



 }
