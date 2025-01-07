import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utills.Utills;

import java.util.List;

public class formAutomation extends MyJunit{
    @DisplayName("Check the automation form fillup occur or not")
    @Test
    public void formAutomation(){
        driver.get("https://demoqa.com/text-box");
        driver.findElement(By.id("userName")).sendKeys(" Test User");
        driver.findElement(By.cssSelector("[type = email]")).sendKeys(" TestUser@google.com");
        List<WebElement> addressEle = driver.findElements(By.className("form-control"));
        addressEle.get(2).sendKeys(" dhaka"); //2nd index
        addressEle.get(3).sendKeys(" narayanganj"); //3rd index
        Utills.scroll(driver,400);
        driver.findElements(By.tagName("button")).get(1).click();

        List <WebElement> formEle = driver.findElements(By.className("mb-1"));
        String name = formEle.get(0).getText();
        String email = formEle.get(1).getText();
        String currAd = formEle.get(2).getText();
        String perAd = formEle.get(3).getText();
        Assertions.assertTrue(name.contains("Test User"));
        Assertions.assertTrue(email.contains("TestUser@google.com"));
        Assertions.assertTrue(currAd.contains("dhaka"));
        Assertions.assertTrue(perAd.contains("narayanganj"));
    }
}
