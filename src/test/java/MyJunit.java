import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class MyJunit {
    WebDriver driver;
    @BeforeAll
    public void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    @AfterAll
    public void closeTest(){
        driver.close();
        driver.quit();
    }
}
