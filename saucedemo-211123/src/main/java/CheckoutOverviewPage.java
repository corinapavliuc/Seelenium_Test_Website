import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutOverviewPage extends BasePage{
    //aici punem driver fara el nu lucreaza testele si sa fie
    // mai scurte si mai usor de gasit ,lacatori
    WebDriver driver; //aceasta este cutia cu driver

    public CheckoutOverviewPage(WebDriver driver) {
        //acesta este automat constructor
        //unim cutia
        super(driver);//ne ajuta sa unim cu BasePage
    }
    @FindBy(id = "finish")
    private WebElement finishButton;

    public void setFinishButton(){
        finishButton.click();
    }
}
