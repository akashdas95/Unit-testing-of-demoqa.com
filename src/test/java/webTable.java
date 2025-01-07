import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class webTable extends MyJunit{
    @Test
    public void webTable(){
        driver.get("https://demoqa.com/webtables");
        WebElement table =  driver.findElement(By.className("rt-tbody"));
        List<WebElement> allRows = table.findElements(By.cssSelector("[role=rowgroup]"));
        for(WebElement row : allRows){
            List<WebElement> cells = row.findElements(By.className("rt-td"));
            for(WebElement cell: cells){
                System.out.println(cell.getText());
            }
        }
    }
}
