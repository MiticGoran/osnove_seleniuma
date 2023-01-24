package p24_01_2023;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;

//        Zadatak
//        Napisati program koji ima:
//        Niz stranica (niz stringova) koje treba da ucita. Niz je:
//        https://google.com/
//        https://youtube.com/
//        https://www.ebay.com/
//        https://www.kupujemprodajem.com/
//        Program petljom prolazi kroz niz stranica i svaku stranicu ucitava preko get ili
//        navigate i od svake stranice na ekranu ispisuje naslov stranice.
//        Kako od stranice procitati naslov imate na ovom linku
//        U prevodu u konzoli treba da se ispisu:
//        Google
//        YouTube
//        Electronics, Cars, Fashion, Collectibles & More | eBay
//        KupujemProdajem
//        Zatvara pretrazivac

public class Zadatak3 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

//        driver.get("https://google.com/");
//        System.out.println(driver.getTitle());
//        driver.get("https://youtube.com/");
//        System.out.println(driver.getTitle());
//        driver.get("https://www.ebay.com/");
//        System.out.println(driver.getTitle());
//        driver.get("https://www.kupujemprodajem.com/");
//        System.out.println(driver.getTitle());

        ArrayList<String> niz = new ArrayList<String>();
        niz.add("https://google.com/");
        niz.add("https://youtube.com/");
        niz.add("https://www.ebay.com/");
        niz.add("https://www.kupujemprodajem.com/");

        for (int i = 0; i < niz.size(); i++) {
            driver.get(niz.get(i));
            System.out.println(driver.getTitle());
            System.out.println(driver.getCurrentUrl());
        }

        Thread.sleep(5000);
        driver.quit();
    }
}
