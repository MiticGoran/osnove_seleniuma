package domaci_26_01_2023;

import helper.Helper;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

//        Zadatak
//        Niz todo-a (niz stringova) koje treba da uneti. Niz je:
//        Visit Paris
//        Visit Prague
//        Visit London
//        Visit New York
//        Visit Belgrade
//        Maksimizirati prozor
//        Ucitati stranicu https://example.cypress.io/todo
//        Program petljom prolazi kroz niz todo-a i svaki unosi na stranicu
//        Nakon svakog unosa todo-a, unosi se enter
//        Validira da li je novi todo dodat na stranici
//        Na kraju programa proci petljom i izbrisati svaki todo sa stranice (klikom na x dugme svakog todo-a)
//        Validirati da je na kraju programa broj todo-a na stranici 0.
//        Cekanje od 5s
//        Zatvorite pretrazivac

public class Zadatak1 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        ArrayList<String> todo = new ArrayList<String>();
        todo.add("Visit Paris");
        todo.add("Visit Prague");
        todo.add("Visit London");
        todo.add("Visit New York");
        todo.add("Visit Belgrade");
        Helper h1 = new Helper();

        driver.manage().window().maximize();
        driver.get("https://example.cypress.io/todo");

        for (int i = 0; i < todo.size(); i++) {
            driver.findElement(By.className("new-todo")).sendKeys(todo.get(i), Keys.ENTER);
            h1.elementExist(driver, By.xpath("//section[@class='main']/ul/li/div/label"));
            if (h1.elementExist(driver, By.xpath("//section[@class='main']/ul/li/div/label"))) {
                System.out.println("Dodat");
            } else {
                System.out.println("Nije dodat");
            }
        }
        Actions actions = new Actions(driver);
        List<WebElement> todoElementi = driver.findElements(By.xpath("//ul[@class='todo-list']/li"));
        WebElement todo1 = driver.findElement(By.xpath("//ul[@class='todo-list']/li"));
        WebElement t1 = driver.findElement(By.xpath("//button[contains(@class, 'destroy')]"));

        for (int i = 0; i < todoElementi.size(); i++) {
            actions.moveToElement(todo1).perform();
            Thread.sleep(500);
            actions.moveToElement(t1).click();
        }

        // sve sam zivo probao, uradi prvo brisanje i onda u sledecem program pukne

        Thread.sleep(5000);
        driver.quit();
    }
}