import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class alerts extends MyJunit{
    @Test
    public void alert() throws InterruptedException {
        driver.get("https://demoqa.com/alerts");
        driver.findElement(By.id("alertButton")).click();
        Thread.sleep(2000);
        driver.switchTo().alert().accept();
        driver.findElement(By.id("timerAlertButton")).click();
        Thread.sleep(6000);
        driver.switchTo().alert().accept();
        driver.findElement(By.id("confirmButton")).click();
        Thread.sleep(1000);
        driver.switchTo().alert().accept();
        driver.findElement(By.id("promtButton")).click();
        driver.switchTo().alert().sendKeys("akash");
        Thread.sleep(1000);
        driver.switchTo().alert().accept();
    }
}
