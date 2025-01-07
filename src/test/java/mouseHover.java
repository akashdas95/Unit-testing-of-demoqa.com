import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class mouseHover extends MyJunit{
    @Test
    public void mouseHover(){
        driver.get("https://daffodilvarsity.edu.bd/");
        List<WebElement> menuEle = driver.findElements(By.className("megamenu-item"));
        Actions actions = new Actions(driver);
        actions.moveToElement(menuEle.get(0)).perform();
    }
}
