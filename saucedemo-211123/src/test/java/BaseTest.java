import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.chrome.ChromeDriver;


public class BaseTest {
    //BaseTest ne ajuta sa nu scrim aceeasi lucru in fiecare test
    // dar doar sa punem extends si se conecteaza direct
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
}

    //User validUser = new User("standard_user", "secret_sauce");
