import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class clickButton extends MyJunit{
    @Test
    public void clickButton(){
        driver.get("https://demoqa.com/buttons");
        List<WebElement> buttonEle = driver.findElements(By.cssSelector("[type=button]"));
        Actions actions = new Actions(driver);
        actions.doubleClick(buttonEle.get(1)).perform();
        actions.contextClick(buttonEle.get(2)).perform();
        actions.click(buttonEle.get(3)).perform();

    }
}
