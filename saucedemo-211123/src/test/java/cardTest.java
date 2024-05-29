import org.junit.Test;
import org.openqa.selenium.bidi.network.Header;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class cardTest extends BaseTest {
    @Test
    public void add1ItenTest(){

            LoginPage loginPage = new LoginPage(driver);
            loginPage.enterValueToUsername("standard_user");
            loginPage.enterValueToPassword("secret_sauce");
            loginPage.clickOntheLoginButton();
            InventoryPage inventoryPage = new InventoryPage(driver);
            assertTrue(inventoryPage.setInventoryList());
        //Add to cart backpack (1st item)
        inventoryPage.clickOnBackpackAddToCartButton();
//Check that cart icon has badge with text "1"
        assertEquals("1", inventoryPage.getItemsQuantityCartBadge());
//check that item name from Cart page equals to item name, which was added
        CardPage cardPage =new CardPage(driver);
        assertEquals(inventoryPage.getNameOfTheFirstItem(),cardPage.getNameOfFirstItem());
    }
    //Add 3 items to the cart
    @Test
    public void add3ItemsTest(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterValueToUsername("standard_user");
        loginPage.enterValueToPassword("secret_sauce");
        loginPage.clickOntheLoginButton();
        InventoryPage inventoryPage = new InventoryPage(driver);
        assertTrue(inventoryPage.setInventoryList());
        //Add 3 items to the cart
        inventoryPage.clickOnBackpackAddToCartButton();
        inventoryPage.clickOnBikeLightAddToCartButton();
        inventoryPage.clickOnTshirtAddToCartButton();
        //Check that cart icon has badge with text "3"
        assertEquals("3", inventoryPage.getItemsQuantityCartBadge());
    }

        @Test
        public void cart1ItemTest () {
            //auth
            LoginPage loginPage = new LoginPage(driver);
            loginPage.enterValueToUsername("standard_user");
            loginPage.enterValueToPassword("secret_sauce");
            loginPage.clickOntheLoginButton();
            InventoryPage inventoryPage = new InventoryPage(driver);
            assertTrue(inventoryPage.setInventoryList());
            //add 1 item to the cart
            inventoryPage.clickOnBackpackAddToCartButton();
            //go to Cart page
            inventoryPage.clickOnTheCartIcon();
            //check that 1 item in the list
         CardPage cardPage = new CardPage(driver);
            assertEquals(1, cardPage.getAddedItemsQuantity());
        }
    //Check that 5 items are added to the cart
    @Test
    public void cart5ItemsTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterValueToUsername("standard_user");
        loginPage.enterValueToPassword("secret_sauce");
        loginPage.clickOntheLoginButton();
        InventoryPage inventoryPage = new InventoryPage(driver);
        assertTrue(inventoryPage.setInventoryList());
        //add 5 item to the cart
        inventoryPage.clickOnBackpackAddToCartButton();
        inventoryPage.clickOnBikeLightAddToCartButton();
        inventoryPage.clickOnTshirtAddToCartButton();
        inventoryPage.clickOnJacketAddToCartButton();
        inventoryPage.clickOnOnisieAddToCartButton();
        //go to Cart page
        inventoryPage.clickOnTheCartIcon();
        //check that 5 item in the list
        CardPage cardPage = new CardPage(driver);
        assertEquals(5, cardPage.getAddedItemsQuantity());
    }
    }

