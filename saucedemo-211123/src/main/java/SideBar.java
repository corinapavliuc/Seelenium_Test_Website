import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SideBar extends BasePage{
    WebDriver driver;
    public SideBar(WebDriver driver) {
        super(driver);//ne ajuta sa unim cu BasePage
    }
    //logout link
//Logout link
    @FindBy(id = "react-burger-menu-btn")
    private WebElement burgerMenu;
    @FindBy(id = "logout_sidebar_link")
    private WebElement logoutLink;
    public void clickOnBurgerMenuButton() {
        burgerMenu.click();
    }
        //click on Log out link
        public void followTheLogoutLink(){
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.elementToBeClickable(logoutLink));
            logoutLink.click();
        }
    }


