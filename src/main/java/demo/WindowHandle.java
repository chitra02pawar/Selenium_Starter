package demo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class WindowHandle {
    ChromeDriver driver;
    public WindowHandle() {
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
    public void windowHandle() {
        System.out.println("Start Test case: Window Handle");

        driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_win_open");
        driver.switchTo().frame("iframeResult");
        driver.findElement(By.xpath("//button[text()=\"Try it\"]")).click();
        Set<String> windowHandles = driver.getWindowHandles();
        String originalWindowHandle = driver.getWindowHandle();
        for (String windowHandle : windowHandles)
            driver.switchTo().window(windowHandle);
        String newWindowUrl = driver.getCurrentUrl();
        String newWindowTitle = driver.getTitle();
        System.out.println("New Window URL: "+newWindowUrl);
        System.out.println("New Window Title: "+newWindowTitle);

        Screenshot screenshot = new AShot().takeScreenshot(driver);

        // Save the screenshot to a file
        File screenshotFile = new File("screenshot.png");
        try {
            ImageIO.write(screenshot.getImage(), "PNG", screenshotFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Screenshot saved to: " + screenshotFile.getAbsolutePath());

        driver.close();
        driver.switchTo().window(originalWindowHandle);

        System.out.println("end Test case: Window Handle");
    }
}
