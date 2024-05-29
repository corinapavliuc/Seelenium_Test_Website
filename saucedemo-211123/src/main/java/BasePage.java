import com.google.common.eventbus.SubscriberExceptionContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    //aici punem toate datele ca sa piutem uni testele
    //adaugam constructor si copia driver
    WebDriver driver; //aceasta este cutia cu driver

    public BasePage(WebDriver driver) {
        //acesta este automat constructor
        //unim cutia
        this.driver = driver;
        PageFactory.initElements(driver, this);
        //acest e class care ne ajuta sa lucram cu testele web elementi
    }
//ca sa punem sa astepte in loc de wait
public void enterTextToElement(String text, WebElement element){
    WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
    wait.until(ExpectedConditions.elementToBeClickable(element));
element.click();
element.clear();//sa curete
element.sendKeys(text);
    }

    //click pe element
    public void clickOnElement(WebElement element){
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }
    //ne ajuta sa intoarcem testul
    public String getTextOfElement(WebElement element){
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(element));
        return element.getText();

    }
}
