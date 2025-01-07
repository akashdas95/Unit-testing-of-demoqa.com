import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import utills.Utills;

public class dropDown extends MyJunit{
    @Test
    public void dropDown() throws InterruptedException {
        driver.get("https://demoqa.com/select-menu");
        Utills.scroll(driver,100);
        Select select = new Select(driver.findElement(By.id("oldSelectMenu")));
        select.selectByVisibleText("Black");
        Thread.sleep(1000);
        select.selectByIndex(2);
        Thread.sleep(1000);
        select.selectByValue("3");
    }
}
