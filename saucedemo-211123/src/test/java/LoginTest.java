import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static java.lang.Thread.sleep;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class LoginTest {
    ChromeDriver driver;

    @Before
    public void setUp() {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Tel-ran.de\\Downloads\\chromedriver-win64(1)\\chromedriver-win64"
                + "\\chromedriver.exe"); // puti unde sta driver
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");

    }

    @After
    public void tearDown() {
        driver.quit();
    }

    //test cu legatura din LoginPage clasa unde sta toate locaturile si le unim in testul asta
    @Test
    public void validDataWithPO() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);//ca sa unim testul din LoginPage locaturile
        loginPage.enterValueToUsername("standard_user");
        //aici punem din LoginPage userName
        loginPage.enterValueToPassword("secret_sauce");
        loginPage.clickOntheLoginButton();
        InventoryPage inventoryPage = new InventoryPage(driver);
        assertTrue(inventoryPage.setInventoryList()); //am luat din InvetoryPage din java sus
        assertEquals("Products", inventoryPage.setTittleText());
        sleep(3000);
    }

    //Enter the invalidPasswordWithPO
    @Test
    public void invalidPasswordWithPO() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterValueToUsername("standard_user");
        loginPage.enterValueToPassword("sdd");
        loginPage.clickOntheLoginButton();
        assertTrue(loginPage.getErrorMessageText()
                .contains("Username and password do not match any user in this service"));
    }

    @Test
    public void validData() throws InterruptedException {
        WebElement usernameInputFild = driver.findElement(By.id("user-name"));
        usernameInputFild.sendKeys("standard_user");
        sleep(3000);
        //Enter the password field
        WebElement passwordInputFild = driver.findElement(By.id("password"));
        passwordInputFild.sendKeys("secret_sauce");
        sleep(3000);

        //Click on Login Button
        WebElement button = driver.findElement(By.id("login-button"));
        button.click();
        sleep(3000);
        //Check that log in was succesful
        // WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        // WebElement inventoryList =
        //      driver.findElement(By.className("inventory_list"));
        //assertTrue(inventoryList.isDisplayed());
        //Check that log in was successful
        WebElement titleText = driver.findElement(By.cssSelector("[data-test=\"title\"]"));
        assertEquals("Products", titleText.getText());

        WebElement inventoryList = driver.findElement(By.className("inventory_list"));
        assertTrue(inventoryList.isDisplayed());

        assertTrue(driver.getCurrentUrl().contains("/inventory"));
    }

    //Enter the invalidPassword
    @Test
    public void invalidPassword() throws InterruptedException {
        WebElement usernameInputFild = driver.findElement(By.id("user-name"));
        usernameInputFild.sendKeys("standard_user");
        sleep(3000);
        WebElement passwordInputFild = driver.findElement(By.id("password"));
        passwordInputFild.sendKeys("secret_sauce");
        sleep(3000);
        WebElement button = driver.findElement(By.id("login-button"));
        button.click();
        WebElement errorMessageText = driver.findElement(By.tagName("h3"));
        assertTrue(errorMessageText.getText().contains("Username and password do not match any user in this service"));


    }

    //invalid username
    @Test
    public void invalidUsername() throws InterruptedException {
        WebElement invalidUsername = driver.findElement(By.id("user-name"));
        invalidUsername.sendKeys("sggr");
        sleep(3000);
        WebElement passwordInputFild = driver.findElement(By.id("password"));
        passwordInputFild.sendKeys("secret_sauce");
        WebElement button = driver.findElement(By.id("login-button"));
        button.click();
        WebElement errorMessageText = driver.findElement(By.tagName("h3"));
        assertTrue(errorMessageText.getText().contains("Username and password do not match any user in this service"));


    }

    //1. Empty Username
    @Test
    public void emptyUsername() {
        WebElement passwordInputFild = driver.findElement(By.id("password"));
        passwordInputFild.sendKeys("secret_sauce");
        WebElement button = driver.findElement(By.id("login-button"));
        button.click();
        WebElement errorMessageText = driver.findElement(By.tagName("h3"));
        assertTrue(errorMessageText.getText().contains("Epic sadface: Username is required"));

    }

    //2.Empty password
    @Test
    public void emptyPassword() {
        WebElement usernameInputFild = driver.findElement(By.id("user-name"));
        usernameInputFild.sendKeys("standard_user");
        WebElement button = driver.findElement(By.id("login-button"));
        button.click();
        WebElement errorMessageText = driver.findElement(By.tagName("h3"));
        assertTrue(errorMessageText.getText().contains("Epic sadface: Password is required"));

    }

    //3.Empty creds
    @Test
    public void emptyCreds() {
        WebElement button = driver.findElement(By.id("login-button"));
        button.click();
        WebElement errorMessageText = driver.findElement(By.tagName("h3"));
        assertTrue(errorMessageText.getText().contains("Epic sadface: Username is required"));

    }

    //locked_out_user
    @Test
    public void lockedUser() {
        WebElement userNameInputField = driver.findElement(By.id("user-name"));
        userNameInputField.sendKeys("locked_out_user");

        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("secret_sauce");

        WebElement buttonLogin = driver.findElement(By.id("login-button"));
        buttonLogin.click();

        WebElement header = driver.findElement(By.tagName("h3"));
        assertTrue(header.getText().contains(" Sorry, this user has been locked out."));

    }

    //ori asa  //With page object
    @Test
    public void lockedUserr() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterValueToUsername("locked_out_user");
        loginPage.enterValueToPassword("secret_sauce");
        loginPage.clickOntheLoginButton();
        assertTrue(loginPage.getErrorMessageText().contains(" Sorry, this user has been locked out."));

    }
    //log out
    //log out
    @Test
    public void successLogout() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterValueToUsername("standard_user");
        loginPage.enterValueToPassword("secret_sauce");
        loginPage.clickOntheLoginButton();
        InventoryPage inventoryPage = new InventoryPage(driver);
        //FACEM CLASS NOU CA SE DESCHIDE  PAGINA NOUA
        assertTrue(inventoryPage.setInventoryList());
        SideBar sideBar = new SideBar(driver);
        //FACEM CLASS NOU CA SE DESCHIDE  PAGINA NOUA
        sideBar.clickOnBurgerMenuButton();
        sideBar.followTheLogoutLink();
        sleep(5000);
        //Check that log out is successful
assertTrue(loginPage.usernameInputFiledIsDisplayed());
//CA SA PUTEM FOLOSI DE assertTrue TREBUIE SA IL FACEM IN CALSSA BOLLEAN
    }

    }




