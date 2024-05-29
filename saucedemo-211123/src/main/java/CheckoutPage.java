import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage extends BasePage{
    //aici punem driver fara el nu lucreaza testele si sa fie
    // mai scurte si mai usor de gasit ,lacatori
    WebDriver driver; //aceasta este cutia cu driver

    public CheckoutPage(WebDriver driver) {
        //acesta este automat constructor
        //unim cutia
        super(driver);//ne ajuta sa unim cu BasePage
    }

    @FindBy(id = "first-name")
    private WebElement firstName;

    //last-name
    @FindBy(id = "last-name")
    private WebElement lastName;

    //postal-code
    @FindBy(id = "postal-code")
    private WebElement postalCode;

    //button
    @FindBy(id = "continue")
    private WebElement button;

    public void enterValueToFirstname(String firstnameValue) {
        //String usernameValue am scris deoarece ne trebuie sa adugam text in el
        firstName.sendKeys(firstnameValue);

    }
    public void enterValueToLastname(String lastnameValue) {
        //String usernameValue am scris deoarece ne trebuie sa adugam text in el
        lastName.sendKeys(lastnameValue);

    }

    public void enterValueToPostcode(String postCodeValue) {
        //String usernameValue am scris deoarece ne trebuie sa adugam text in el
        postalCode.sendKeys(postCodeValue);

    }
   public void setButton(){
        button.click();
   }
}

