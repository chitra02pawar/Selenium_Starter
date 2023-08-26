package demo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class NestedFrames {

    ChromeDriver driver;
    public NestedFrames() {
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
    public void nestedFrames() {
        System.out.println("Start Test case: Nested Frames");

        driver.get("https://the-internet.herokuapp.com/nested_frames");
        driver.switchTo().frame("frame-top");
        driver.switchTo().frame("frame-left");
        String leftFrameText = driver.findElement(By.tagName("body")).getText();
        System.out.println("Left Frame Text: "+leftFrameText);

        driver.switchTo().parentFrame();
        driver.switchTo().frame("frame-middle");
        String middleFrameText = driver.findElement(By.id("content")).getText();
        System.out.println("Middle Frame Text: "+middleFrameText);

        driver.switchTo().parentFrame();
        driver.switchTo().frame("frame-right");
        String rightFrameText = driver.findElement(By.tagName("body")).getText();
        System.out.println("Right Frame Text: "+rightFrameText);

        driver.switchTo().defaultContent();
        driver.switchTo().frame("frame-bottom");
        String bottomFrameText = driver.findElement(By.tagName("body")).getText();
        System.out.println("Bottom Frame Text: "+bottomFrameText);
        driver.switchTo().defaultContent();

        System.out.println("end Test case: Nested Frames");
    }
}
