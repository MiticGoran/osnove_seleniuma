package domaci_27_01_2023;

//        Zadatak
//        Ucitati stranicu https://mdbootstrap.com/docs/standard/components/toasts/#section-basic-example
//        Klik na svako dugme od PRIMARY do DARK
//        Sacekati da se toasts u desnom gornjem uglu pojavi
//        Pauza izmedju klikova 1s
//        Postavite implicitno cekanje za ucitavanje stranice i trazenje elemenata na 10s


import helper.Helper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Zadatak1 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://mdbootstrap.com/docs/standard/components/toasts/#section-basic-example");
        List<String> lista = new ArrayList<String>();
        lista.add("primary");
        lista.add("secondary");
        lista.add("success");
        lista.add("danger");
        lista.add("warning");
        lista.add("info");
        lista.add("light");
        lista.add("dark");

        Helper h1 = new Helper();

        for (int i = 0; i < lista.size(); i++) {
            driver.findElement(By.id("basic-"+lista.get(i)+"-trigger")).click();
            Thread.sleep(1000);
            h1.elementExist(driver, By.className("toast-"+lista.get(i)+""));
        }

        Thread.sleep(5000);
        driver.quit();
    }
}
