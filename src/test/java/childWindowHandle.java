import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.util.Iterator;
import java.util.Set;

public class childWindowHandle extends MyJunit{
    @Test
    public void childWindowHandle(){
        driver.get("https://demoqa.com/browser-windows");
        driver.findElement(By.id("windowButton")).click();
        String mainWindow = driver.getWindowHandle();
        Set<String> allWindow = driver.getWindowHandles();
        Iterator<String> it = allWindow.iterator();
        while(it.hasNext()){
            String childWindow = it.next();
            if(!mainWindow.equalsIgnoreCase(childWindow)){
                driver.switchTo().window(childWindow);
                String actualText = driver.findElement(By.id("sampleHeading")).getText();
                String expectedText = "This is a sample page";
                Assertions.assertTrue(actualText.contains(expectedText));
            }
        }
        driver.close();
        driver.switchTo().window(mainWindow);
    }
}
