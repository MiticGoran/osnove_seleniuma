package p27_01_2023;

//        Zadatak
//        Napisati program koji ucitava stranicu Zadatak4.html
//        Skinite Zadatak4.html sa drajva. Otvorite u pretrazivacu duplim klikom na
//                fajl i Downloads-a i ikopirajte url. To je url za get u programu
//        I na stranici dodaje 5 poruka “IT Bootcamp”
//        Potrebno  je u svakoj iteraciji kliknuti na dugme Show in
//        Sacekati da se novi element pojavi pre nego sto se doda sledeci

import helper.Helper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Zadatak4 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("file:///C:/Users/Mita/Downloads/Zadatak4.html");

        Helper h1 = new Helper();

        for (int i = 0; i < 5; i++) {
            driver.findElement(By.id("showInBtn")).click();
            h1.elementExist(driver, By.id("id-"+i));
//            driver.findElement(By.id("id-"+i));
        }

        Thread.sleep(5000);
        driver.quit();
    }
}
