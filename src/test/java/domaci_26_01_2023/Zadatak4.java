package domaci_26_01_2023;

//        Zadatak
//        Napisati program koji ucitava stranicu https://geodata.solutions/
//        Bira Country, State i City po vasoj zelji
//        Pritom potrebno je izvrsiti cekanje da se povaje State-ovi nakon izbora Country-a
//        I takodje je potrebno izvrsiti cekanje da se ucitaju gradovi nakon izbora State-a
//        Izabrerit Country, State i City tako da imate podatke da selektujete!


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

public class Zadatak4 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://geodata.solutions/");
        driver.findElement(By.id("countryId")).click();
        driver.findElement(By.xpath("//option[@value, 'Serbia']")).click();
        driver.findElement(By.id("stateId")).click();
        driver.findElement(By.id("cityId")).click();

        // Sajt je nedostupan, nisam uspeo da uradim do kraja. Medjutim koliko sam video padajuca linija baguje.

        Thread.sleep(5000);
        driver.quit();
    }
}
