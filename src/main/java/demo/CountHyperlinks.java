package demo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class CountHyperlinks {

    ChromeDriver driver;
    public CountHyperlinks()
    {
        System.out.println("Constructor: TestCases");
        WebDriverManager.chromedriver().timeout(30).setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    public void endTest()
    {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();

    }


    public  void countHyperlinks(){
        System.out.println("Start Test case: CountHyperlinks");
        driver.get("https://in.bookmyshow.com/explore/home/chennai");
        List<WebElement> links = driver.findElements(By.tagName("a"));
        System.out.println("Total no. of hyperlinks present on this page: "+links.size());
        System.out.println("end Test case: CountHyperlinks");
    }

}
