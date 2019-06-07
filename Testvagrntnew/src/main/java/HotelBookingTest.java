import com.sun.javafx.PlatformUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import org.openqa.selenium.By;

public class HotelBookingTest {

//    WebDriver driver = new ChromeDriver();
    WebDriver driver = new FirefoxDriver();
    

    @Test
    public void shouldBeAbleToSearchForHotels() {
        setDriverPath();

        driver.get("https://www.cleartrip.com/");
        waitFor(2000);

        driver.findElement(By.linkText("Hotels")).click();
        WebElement autoOptions= driver.findElement(By.id("Tags"));
        autoOptions.sendKeys("Indiranagar, Bangalore");
        waitFor(5000);

        driver.findElement(By.id("ui-id-3")).click();
        driver.findElement(By.id("Tags")).click();
        
        driver.findElement(By.id("travellersOnhome")).sendKeys("1 room, 2 adults");
        waitFor(2000);
        driver.findElement(By.id("SearchHotelsButton")).click();
        waitFor(3000);

        driver.quit();

    }

    private void waitFor(int durationInMilliSeconds) {
        try {
            Thread.sleep(durationInMilliSeconds);
        } catch (InterruptedException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }

    private void setDriverPath() {
        if (PlatformUtil.isMac()) {
            System.setProperty("webdriver.chrome.driver", "chromedriver");
        }
        if (PlatformUtil.isWindows()) {
            System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        }
        if (PlatformUtil.isLinux()) {
            System.setProperty("webdriver.chrome.driver", "chromedriver_linux");
        }
    }

}
