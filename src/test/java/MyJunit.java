import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utills.Utills;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class MyJunit {
    WebDriver driver;
    @BeforeAll
    public void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }
    @Order(1)
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
    @Order(2)
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
    @Order(3)
    @Test
    public void clickButton(){
        driver.get("https://demoqa.com/buttons");
        List <WebElement> buttonEle = driver.findElements(By.cssSelector("[type=button]"));
        Actions actions = new Actions(driver);
        actions.doubleClick(buttonEle.get(1)).perform();
        actions.contextClick(buttonEle.get(2)).perform();
        actions.click(buttonEle.get(3)).perform();

    }
    @Order(4)
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
    @Order(5)
    @Test
    public void dateTimePicker(){
        driver.get("https://demoqa.com/date-picker");
        WebElement txtCalEle = driver.findElement(By.id("datePickerMonthYearInput"));
        txtCalEle.sendKeys(Keys.CONTROL,"a");
        txtCalEle.sendKeys(Keys.DELETE);
        txtCalEle.sendKeys("3/11/2024");
        txtCalEle.sendKeys(Keys.ENTER);
    }
    @Order(6)
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
    @Order(7)
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
    @Order(8)
    @Test
    public void selectSpecialDropDown(){
        driver.get("https://demoqa.com/select-menu");
        driver.findElement(By.className("css-1hwfws3")).click();
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.ARROW_DOWN).perform();
        actions.sendKeys(Keys.ARROW_DOWN).perform();
        actions.sendKeys(Keys.ENTER).perform();
    }
    @Order(9)
    @Test
    public void mouseHover(){
        driver.get("https://daffodilvarsity.edu.bd/");
        List <WebElement> menuEle = driver.findElements(By.className("megamenu-item"));
        Actions actions = new Actions(driver);
        actions.moveToElement(menuEle.get(0)).perform();
    }
    @Order(10)
    @Test
    public void modal(){
        driver.get("https://demoqa.com/modal-dialogs");
        driver.findElement(By.id("showSmallModal")).click();
        String Stext = driver.findElement(By.className("modal-body")).getText();
        System.out.println(Stext);
        driver.findElement(By.id("closeSmallModal")).click();

    }
    @Order(11)
   @Test
    public void uploadImage(){
        driver.get("https://demoqa.com/upload-download");
        driver.findElement(By.id("uploadFile")).sendKeys("D:\\Java\\Junit_testing\\src\\test\\resources\\autumn-season-leafs-plant-scene-generative-ai.jpg");
    }
    @Order(12)
    @Test
    public void downloadImage(){
        driver.get("https://demoqa.com/upload-download");
        driver.findElement(By.id("downloadButton")).click();
    }
    @Order(13)
    @DisplayName("new tab is working fine")
    @Test
    public void tabHandle() {
        driver.get("https://demoqa.com/browser-windows");
        driver.findElement(By.id("tabButton")).click();

        ArrayList<String> arrayList = new ArrayList(driver.getWindowHandles());
        driver.switchTo().window(arrayList.get(1));
        String actualText = driver.findElement(By.id("sampleHeading")).getText();
        String expectedText = "This is a sample page";
        Assertions.assertTrue(actualText.contains(expectedText));
        driver.close();
        driver.switchTo().window(arrayList.get(0));
    }
    @Order(14)
    @Test
    public void childWindowHandle(){
        driver.get("https://demoqa.com/browser-windows");
        driver.findElement(By.id("windowButton")).click();
        String mainWindow = driver.getWindowHandle();
        Set<String> allWindow = driver.getWindowHandles();
        Iterator<String> it = allWindow.iterator();
        while(it.hasNext()){
            String childWindow = it.next();
            if(!mainWindow.equalsIgnoreCase(childWindow)){
                driver.switchTo().window(childWindow);
                String actualText = driver.findElement(By.id("sampleHeading")).getText();
                String expectedText = "This is a sample page";
                Assertions.assertTrue(actualText.contains(expectedText));
            }
        }
        driver.close();
        driver.switchTo().window(mainWindow);
    }
    @Order(15)
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
    @Order(16)
    @Test
    public void iframe(){
        driver.get("https://demoqa.com/frames");
        driver.switchTo().frame("frame1");
        String actualText = driver.findElement(By.id("sampleHeading")).getText();
        String expectedText = "This is a sample page";
        Assertions.assertTrue(actualText.contains(expectedText));
        driver.switchTo().defaultContent();
    }

    @AfterAll
    public void closeTest(){
        driver.close();
        driver.quit();
    }
}
