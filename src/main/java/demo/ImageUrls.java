package demo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ImageUrls {

    ChromeDriver driver;
    public ImageUrls() {
        System.out.println("Constructor: TestCases");
        WebDriverManager.chromedriver().timeout(30).setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    }
    public void endTest() {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();

    }
    public void imageUrls() {
        System.out.println("Start Test case: Book My Show Image URLs");

        driver.get("https://in.bookmyshow.com/explore/home/chennai");
        List<WebElement> recommendedMovies = driver.findElements(By.xpath("//div[starts-with(@class,\"style__WidgetContainerBody-sc-lnhrs7-4\")]/div/a/div/div[2]/div/img"));

        for (WebElement movieList : recommendedMovies) {
            String imageUrl = movieList.getAttribute("src");
            System.out.println("Image URL: " + imageUrl);
        }

        System.out.println("end Test case: Book My Show Image URLs");
    }
}