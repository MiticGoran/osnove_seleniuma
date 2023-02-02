package p31_01_2023;

//        Napisati program koji:
//        Ucitava stranu https://blueimp.github.io/jQuery-File-Upload/
//        Uploadujte sliku
//        Ceka se da se pojavi slika u listi uploadovanih fajlova
//        Koristite uslov da boje elemenata bude 1.
//        Klik na Start dugme u okviru item-a koji se uploadovao
//        Ceka se da se pojavi delete dugme pored itema
//        Klik na delete dugme pored itema
//        Ceka se da se element obrise
//        Koristite da broj elemenata bude 0

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;

public class Zadatak2 {
    public static void main(String[] args) throws InterruptedException {
        String uploadImg = new File("test_data/deadpool.png").getAbsolutePath();
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://blueimp.github.io/jQuery-File-Upload/");
        driver.findElement(By.name("files[]")).sendKeys(uploadImg);
        wait.until(ExpectedConditions.
                numberOfElementsToBe(By.xpath("//table[@role='presentation']/tbody/tr"), 1));
        driver.findElement(By.xpath("//*[@id='fileupload']/table/tbody/tr/td[4]/button[2]")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@data-type='DELETE']")));
        driver.findElement(By.xpath("//button[@data-type='DELETE']")).click();
        wait.until(ExpectedConditions.
                numberOfElementsToBe(By.xpath("//table[@role='presentation']/tbody/tr"), 0));

        Thread.sleep(5000);
        driver.quit();
    }
}
