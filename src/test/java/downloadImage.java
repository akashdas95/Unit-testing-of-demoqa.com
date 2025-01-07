import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class downloadImage extends MyJunit{
    @Test
    public void downloadImage(){
        driver.get("https://demoqa.com/upload-download");
        driver.findElement(By.id("downloadButton")).click();
    }
}
