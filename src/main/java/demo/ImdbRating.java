package demo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class ImdbRating {
    ChromeDriver driver;
    public ImdbRating() {
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
    public void imdbRating() {
        System.out.println("Start Test case: IMDB Rating");

        driver.get("https://www.imdb.com/chart/top");
        String highestRated = driver.findElement(By.xpath("//div[@data-testid=\"chart-layout-main-column\"]/ul/li[1]/div[2]/div/div/div/a/h3")).getText();
        System.out.println("Highest Rated Movie: "+highestRated);

        String totalMovies = driver.findElement(By.xpath("//span[@data-testid=\"chart-layout-total-items\"]")).getText();
        System.out.println("Total movies included in the table: "+totalMovies);

        Select releaseDate = new Select(driver.findElement(By.id("sort-by-selector")));
        releaseDate.selectByValue("RELEASE_DATE");
        String newestMovie = driver.findElement(By.xpath("//div[@data-testid=\"chart-layout-main-column\"]/ul/li[1]/div[2]/div/div/div/a/h3")).getText();
        driver.findElement(By.id("swap-sort-order-button")).click();
        String oldestMovie = driver.findElement(By.xpath("//div[@data-testid=\"chart-layout-main-column\"]/ul/li[1]/div[2]/div/div/div/a/h3")).getText();
        releaseDate.selectByValue("USER_RATING_COUNT");
        String mostUserRating = driver.findElement(By.xpath("//div[@data-testid=\"chart-layout-main-column\"]/ul/li[1]/div[2]/div/div/div/a/h3")).getText();

        System.out.println("Oldest Movie: "+oldestMovie);
        System.out.println("Most Recent Movie: "+newestMovie);
        System.out.println("Most User Rating Movie: "+mostUserRating);

        System.out.println("end Test case: IMDB Rating");
    }
}
