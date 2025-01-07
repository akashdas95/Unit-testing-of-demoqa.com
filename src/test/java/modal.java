import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class modal extends MyJunit{
    @Test
    public void modal(){
        driver.get("https://demoqa.com/modal-dialogs");
        driver.findElement(By.id("showSmallModal")).click();
        String Stext = driver.findElement(By.className("modal-body")).getText();
        System.out.println(Stext);
        driver.findElement(By.id("closeSmallModal")).click();
    }
}
