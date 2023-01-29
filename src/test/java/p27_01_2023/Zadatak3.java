package p27_01_2023;

//        Zadatak
//        Ucitati stranicu https://demoqa.com/modal-dialogs
//        Kliknuti na dugme Large modal
//        Proverite da li se prikazao dijalog i ispisite u konzoli odgovarajuce poruke


import helper.Helper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

public class Zadatak3 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/modal-dialogs");
        driver.findElement(By.id("showLargeModal")).click();

        Helper h1 = new Helper();

        if (h1.elementExist(driver, By.className("modal-content"))){
            System.out.println("Postoji");
        } else {
            System.out.println("Jok");
        }

        Thread.sleep(5000);
        driver.quit();
    }
}
