import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class dateTimePicker extends MyJunit{
    @Test
    public void dateTimePicker(){
        driver.get("https://demoqa.com/date-picker");
        WebElement txtCalEle = driver.findElement(By.id("datePickerMonthYearInput"));
        txtCalEle.sendKeys(Keys.CONTROL,"a");
        txtCalEle.sendKeys(Keys.DELETE);
        txtCalEle.sendKeys("3/11/2024");
        txtCalEle.sendKeys(Keys.ENTER);
    }
}
