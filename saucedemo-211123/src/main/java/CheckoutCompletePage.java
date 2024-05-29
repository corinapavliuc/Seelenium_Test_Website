import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutCompletePage extends BasePage {
    //aici punem driver fara el nu lucreaza testele si sa fie
    // mai scurte si mai usor de gasit ,lacatori
    WebDriver driver; //aceasta este cutia cu driver

    public CheckoutCompletePage(WebDriver driver) {
        super(driver);//ne ajuta sa unim cu BasePage
    }
    @FindBy(className = "complete-header")
    private WebElement text;
    public boolean setTittleText() {
        return text.isDisplayed();
    }
}
