import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class uploadImage extends MyJunit{
    @Test
    public void uploadImage(){
        driver.get("https://demoqa.com/upload-download");
        driver.findElement(By.id("uploadFile")).sendKeys("D:\\Java\\Junit_testing\\src\\test\\resources\\autumn-season-leafs-plant-scene-generative-ai.jpg");
    }
}
