import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

public class selectSpecialDropDown extends MyJunit{
    @Test
    public void selectSpecialDropDown(){
        driver.get("https://demoqa.com/select-menu");
        driver.findElement(By.className("css-1hwfws3")).click();
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.ARROW_DOWN).perform();
        actions.sendKeys(Keys.ARROW_DOWN).perform();
        actions.sendKeys(Keys.ENTER).perform();
    }
}
