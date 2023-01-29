package p27_01_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Zadatak1 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("file:///C:/Users/Mita/Downloads/Zadatak4.html");

//        boolean elementExist = true;
//
//        try {
//            WebElement div = driver.findElement(By.id("id-0"));
//        } catch(NoSuchElementException error){
//            elementExist = false;
//        }
//        if (elementExist){
//            System.out.println("Element postoji");
//        } else {
//            System.out.println("Element ne postoji");
//        }

        List<WebElement> divs = driver.findElements(By.id("id-0"));
        if (divs.size() > 0){
            System.out.println("Postoji");
        } else {
            System.out.println("Ne postoji");
        }


        Thread.sleep(5000);
        driver.quit();
    }
}
