import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.util.ArrayList;

public class tabHandle extends MyJunit{
    @DisplayName("new tab is working fine")
    @Test
    public void tabHandle() {
        driver.get("https://demoqa.com/browser-windows");
        driver.findElement(By.id("tabButton")).click();

        ArrayList<String> arrayList = new ArrayList(driver.getWindowHandles());
        driver.switchTo().window(arrayList.get(1));
        String actualText = driver.findElement(By.id("sampleHeading")).getText();
        String expectedText = "This is a sample page";
        Assertions.assertTrue(actualText.contains(expectedText));
        driver.close();
        driver.switchTo().window(arrayList.get(0));
    }
}
