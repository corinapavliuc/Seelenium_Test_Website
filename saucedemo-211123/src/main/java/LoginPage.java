import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage{
    //aici punem driver fara el nu lucreaza testele si sa fie mai scurte si mai usor de gasit ,lacatori
    WebDriver driver; //aceasta este cutia cu driver

    public LoginPage(WebDriver driver) {//acesta este automat constructor
        //unim cutia
        super(driver);//ne ajuta sa unim cu BasePage
    }

    @FindBy(id = "user-name")//aici scrim locatorul
    private WebElement usernameInputField; //pageobiect trebuie sa scrim asa
    @FindBy(id = "password")
    private WebElement passwordInputField;
    @FindBy(id = "login-button")
    private WebElement loginButton;

    @FindBy(tagName = "h3")
    private WebElement errorMessage;

    public String getErrorMessageText() {
        return errorMessage.getText();
    }


    // acum generizam ca sa fie public ca sa putem unii testele
public void enterValueToUsername(String usernameValue) { //String usernameValue am scris deoarece ne trebuie sa adugam text in el
    enterTextToElement(usernameValue, usernameInputField);
    //enterTextToElement lam luat din BasePage .
    usernameInputField.sendKeys(usernameValue);
    }
    //public void enterValueToUsername(User user){
    //  enterTextToElement(user.getUsername(), usernameInputField);
    //}
    //public void enterValueToPasswordInputField(User user){
    //  enterTextToElement(user.getPassword(), passwordInputField);
    //}

    public void enterValueToPassword (String passwordValue){ // enterValueToPassword alacatuim de la noi
        enterTextToElement(passwordValue, passwordInputField);
        // enterTextToElement lam luat din BasePage .
        passwordInputField.sendKeys(passwordValue); // punem de sus de la private

    }

    public void clickOntheLoginButton() {
        clickOnElement(loginButton);
        //clickOnElement ne ajuta sa luam datele din BasePage si sa nu scrim de o suta de ori
      //  loginButton.click();
    }


    public boolean usernameInputFiledIsDisplayed(){
        return usernameInputField.isDisplayed();
    }
}

