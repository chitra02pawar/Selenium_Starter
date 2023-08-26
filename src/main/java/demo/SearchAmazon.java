package demo;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;


public class SearchAmazon {
    ChromeDriver driver;
    public SearchAmazon()
    {
        System.out.println("Constructor: TestCase");
        WebDriverManager.chromedriver().timeout(30).setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    public void endTest()
    {
        System.out.println("End Test: TestCase");
        driver.close();
        driver.quit();

    }

    public  void searchAmazon(){

        System.out.println("Start Test case: SearchAmazon");
        driver.get("http://www.google.com/");
        driver.findElement(By.id("APjFqb")).sendKeys("Amazon");
        driver.findElement(By.id("APjFqb")).sendKeys(Keys.RETURN);
        boolean searchResult = driver.findElement(By.xpath("//span[@data-dtld = 'amazon.in']")).isDisplayed();
        System.out.println("Amazon.in is present on the page : "+searchResult);

        System.out.println("end Test case: SearchAmazon");
    }

}
