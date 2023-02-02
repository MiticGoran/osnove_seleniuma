package p31_01_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;

//            Napisati program koji:
//            Kreirati screenshots folder u projektu
//            Ucitava stranicu https://cms.demo.katalon.com/
//            Kreira screenshot stranice
//            Sacuvati screenshot u folderu screenshots pod imenom screenshot1.jpg
//            Koristan link
//        Zadatak (Za vezbanje)
//        Po tekstu zadataka 4, kreirajte screenshot i sacuvajte ga u folderu screenshots po imenom screenshot-[dan]-[mesec]-[godina] [sat]-[minut]-[sekund].jpg
//        Koristan link https://www.javatpoint.com/java-date-to-string

public class Zadatak4 {
    public static void main(String[] args) throws InterruptedException, IOException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://cms.demo.katalon.com/");
        Date date = Calendar.getInstance().getTime();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh-mm-ss");
        String strDate = dateFormat.format(date);
        File f = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        Files.copy(f.toPath(), new File("screenshots/"+strDate+".jpg").toPath());

        Thread.sleep(5000);
        driver.quit();
    }
}
