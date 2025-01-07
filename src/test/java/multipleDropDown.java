import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import utills.Utills;

public class multipleDropDown extends MyJunit{
    @Test
    public void multipleDropDown(){
        driver.get("https://demoqa.com/select-menu");
        Utills.scroll(driver,400);
        Select select = new Select(driver.findElement(By.name("cars")));
        if(select.isMultiple()){
            select.selectByVisibleText("Volvo");
            select.selectByVisibleText("Audi");
        }
    }
}
