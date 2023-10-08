import org.openqa.selenium.JavascriptExecutor;

public class Utils extends Junit_Assignment {

    public static void scroll(int x, int y)  {                                           // Scroll er code
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo("+x+","+y+")");

    }
}
