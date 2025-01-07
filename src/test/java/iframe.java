import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class iframe extends MyJunit{
    @Test
    public void iframe(){
        driver.get("https://demoqa.com/frames");
        driver.switchTo().frame("frame1");
        String actualText = driver.findElement(By.id("sampleHeading")).getText();
        String expectedText = "This is a sample page";
        Assertions.assertTrue(actualText.contains(expectedText));
        driver.switchTo().defaultContent();
    }
}
