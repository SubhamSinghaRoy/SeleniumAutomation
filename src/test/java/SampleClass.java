import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class SampleClass {

    WebDriver driver;

    @BeforeTest
    public void setup(){

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.amazon.in/");
    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void testMethod() throws InterruptedException {
        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Iphone 12");
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        Thread.sleep(3000);
    }
}
