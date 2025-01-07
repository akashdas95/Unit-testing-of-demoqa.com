import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class VisitURL extends MyJunit{
    @DisplayName("Visit URL and check title is Correct or not")
    @Test
    public void visitUrl(){
        driver.get("https://demoqa.com/elements");
        String CurrUrl = driver.getCurrentUrl();
        String actualRes = driver.getTitle();
        String expectedRes = "DEMOQA";
        Assertions.assertEquals(actualRes,expectedRes);
        Assertions.assertTrue(CurrUrl.contains("elements"));
        System.out.println(driver.getPageSource());
    }
}
