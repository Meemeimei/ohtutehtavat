package ohtu;

import java.util.Random;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Tester {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "/home/eemitant/Desktop/chromedriver");
        WebDriver driver = new ChromeDriver();

        driver.get("http://localhost:4567");

        sleep(2);

        WebElement element = driver.findElement(By.linkText("login"));
        element.click();

        sleep(2);

        element = driver.findElement(By.name("username"));
        element.sendKeys("pekka");
        element = driver.findElement(By.name("password"));
        element.sendKeys("akkep");
        element = driver.findElement(By.name("login"));

        sleep(2);
        element.submit();

        sleep(3);

        driver.get("http://localhost:4567");

        sleep(2);

        element = driver.findElement(By.linkText("login"));
        element.click();

        sleep(2);

        element = driver.findElement(By.name("username"));
        element.sendKeys("pekka");
        element = driver.findElement(By.name("password"));
        element.sendKeys("asd");
        element = driver.findElement(By.name("login"));

        sleep(2);
        element.submit();

        sleep(3);

        driver.get("http://localhost:4567");

        sleep(2);

        element = driver.findElement(By.linkText("register new user"));
        element.click();

        sleep(2);

        element = driver.findElement(By.name("username"));
        element.sendKeys(createUsername());
        element = driver.findElement(By.name("password"));
        element.sendKeys("yykaakoo123");
        element = driver.findElement(By.name("signup"));

        sleep(2);
        element.submit();

        sleep(3);

        driver.get("http://localhost:4567");

        sleep(2);

        element = driver.findElement(By.linkText("register new user"));
        element.click();

        sleep(2);

        element = driver.findElement(By.name("username"));
        element.sendKeys(createUsername());
        element = driver.findElement(By.name("password"));
        element.sendKeys("neeviikuu456");
        element = driver.findElement(By.name("passwordConfirmation"));
        element.sendKeys("neeviikuu456");
        element = driver.findElement(By.name("signup"));

        sleep(2);
        element.submit();

        sleep(2);
        element = driver.findElement(By.linkText("continue to application mainpage"));
        element.click();
        element = driver.findElement(By.linkText("logout"));
        element.click();

        sleep(3);

        driver.quit();
    }

    private static void sleep(int n) {
        try {
            Thread.sleep(n * 1000);
        } catch (Exception e) {
        }
    }

    private static String createUsername() {
        Random r = new Random();
        return("neeviikuu" + r.nextInt(100000));
    }
}
