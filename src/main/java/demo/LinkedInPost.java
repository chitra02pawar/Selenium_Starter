package demo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class LinkedInPost {

    ChromeDriver driver;
    public LinkedInPost()
    {
        System.out.println("Constructor: TestCases");
        WebDriverManager.chromedriver().timeout(30).setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    }

    public void endTest()
    {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();

    }

    public  void linkedInViewsImpression(){
        System.out.println("Start Test case: LinkedInPost");

        driver.get("https://www.linkedin.com/login");
        driver.findElement(By.id("username")).sendKeys("testuser@gmail.com");
        driver.findElement(By.id("password")).sendKeys("testuser123");
        driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();
        String profileViews = driver.findElement(By.xpath("//a[@href=\"/me/profile-views/\"]/div/div[2]/span")).getText();
        String profileImpressions = driver.findElement(By.xpath("//div[@class=\"entity-list-wrapper \"]/ul/li[2]/a/div/div[2]/span")).getText();
        int profileViewsCount = Integer.parseInt(profileViews);
        int profileImpressionCount = Integer.parseInt(profileImpressions);
        System.out.println("Profile Views: "+profileViewsCount);
        System.out.println("Profile Impression: "+profileImpressionCount);

        System.out.println("end Test case: LinkedInPost");
    }

    public  void linkedInPost() throws InterruptedException {
        System.out.println("Start Test case: LinkedInPost");

        driver.get("https://www.linkedin.com/login");
        driver.findElement(By.id("username")).sendKeys("testuser@gmail.com");
        driver.findElement(By.id("password")).sendKeys("testuser123");
        driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();
        driver.findElement(By.xpath("//div[@class = \"share-box-feed-entry__top-bar\"]/button")).click();
        driver.findElement(By.className("share-unified-settings-entry-button")).click();
        driver.findElement(By.id("CONNECTIONS_ONLY")).click();
        driver.findElement(By.xpath("//div[@class=\"share-box-footer__main-actions\"]/button[2]")).click();
        driver.findElement(By.xpath("//div[@data-placeholder = \"What do you want to talk about?\"]")).sendKeys("Hello Friends!");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//div[@class=\"share-box_actions\"]/button/span")).click();
        boolean postPresent = driver.findElement(By.xpath("//span[contains(text(),\"Hello Friends!\")]")).isDisplayed();
        System.out.println("Post is posted successfully and displayed: "+postPresent);

        System.out.println("end Test case: LinkedInPost");
    }

}
