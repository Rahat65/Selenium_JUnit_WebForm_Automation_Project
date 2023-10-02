import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)


public class Junit_Assignment {
    WebDriver driver;

    @BeforeAll
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    //    @Test
//    public void name() {
//        driver.get("https://www.digitalunite.com/practice-webform-learners");
//        driver.findElement(By.id("edit-name")).sendKeys("Rahat Khan");
//    }

//    @Test
//    public void number() {
//        driver.get("https://www.digitalunite.com/practice-webform-learners");
//        driver.findElement(By.id("edit-number")).sendKeys("01732634618");
//    }

    @Test
    public void webformFillup() throws InterruptedException {
        driver.get("https://www.digitalunite.com/practice-webform-learners");
        driver.findElement(By.id("onetrust-reject-all-handler")).click();
        List<WebElement> infos = driver.findElements(By.className("form-control"));
        infos.get(0).sendKeys("Random");
        infos.get(1).sendKeys("01732630000");
       // scroll(0,1000);
        driver.findElement(By.xpath("//label[normalize-space()='20-30']")).click();
        driver.findElement(By.id("edit-date")).click();
        DateFormat todayDateFormat = new SimpleDateFormat("MM-dd-yyyy");
        Date currentDate = new Date();
        String todayDate = todayDateFormat.format(currentDate);
        driver.findElement(By.id("edit-date")).sendKeys(todayDate, Keys.ENTER);
        infos.get(3).sendKeys("random@gmail.com");
        infos.get(4).sendKeys(("Nothing to say"));
        driver.findElement(By.id("edit-uploadocument-upload")).sendKeys(System.getProperty("user.dir")+"/src/test/resources/Batman.jpg");
       // Thread.sleep(3000);
        scroll(0,1000);
        Thread.sleep(3000);
        driver.findElement(By.id("edit-age")).click();
        driver.findElement(By.id("edit-submit")).click();
        Thread.sleep(3000);
        ArrayList<String> w = new ArrayList(driver.getWindowHandles());
//switch to open tab
        driver.switchTo().window(w.get(0));
        String actual_message = driver.findElement(By.id("block-pagetitle-2")).getText();
        String expected_message = "Practice webform for learners";
        Assertions.assertEquals(actual_message,expected_message);
    }

//    @Test
//    public void date(){
//        driver.get("https://www.digitalunite.com/practice-webform-learners");
//        driver.findElement(By.id("onetrust-reject-all-handler")).click();
//        driver.findElement(By.id("edit-date")).click();
//        DateFormat todayDateFormat = new SimpleDateFormat("MM-dd-yyyy");
//        Date currentDate = new Date();
//        String todayDate = todayDateFormat.format(currentDate);
//        driver.findElement(By.id("edit-date")).sendKeys(todayDate, Keys.ENTER);
//    }
//
//    @Test
//    public void age() {
//        driver.get("https://www.digitalunite.com/practice-webform-learners");
//        driver.findElement(By.id("onetrust-reject-all-handler")).click();
//
//        driver.findElement(By.xpath("//label[normalize-space()='20-30']")).click();
//    }
//
//    @Test
//    public void imageUpload(){
//        driver.get("https://www.digitalunite.com/practice-webform-learners");
//        driver.findElement(By.id("onetrust-reject-all-handler")).click();
//        scroll(0,500);
//        driver.findElement(By.id("edit-uploadocument-upload")).sendKeys(System.getProperty("user.dir")+"/src/test/resources/Batman.jpg");
//    }



    public void scroll(int x, int y) {                                           // Scroll er code
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo("+x+","+y+")");

    }


}
