import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class InventoryTest extends BaseTest {

    //test cu legatura din InventoryPage clasa unde sta toate locaturile si le unim in testul asta
    @Test
    public void itemsTest(){
        //log in
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterValueToUsername("standard_user");
        loginPage.enterValueToPassword("secret_sauce");
        loginPage.clickOntheLoginButton();
        //check that there are 6 items on the page
        InventoryPage inventoryPage = new InventoryPage(driver);
       assertEquals(6,inventoryPage.itemCount());
       //ne arata ca 6 bucatii sectiunii
 assertTrue(inventoryPage.allItemsAreDisplayed()); // ne arataca testul e true
        //check that all item names are displayed
        assertTrue(inventoryPage.allItemsNamesAreDisplayed());
        //all item names are NOT empty
assertTrue(inventoryPage.allItemNameAreNotEmpty());
//all items name starts with "Sauce Labs"
        assertTrue("Sauce Labs Backpack",inventoryPage.allItenmNamesStartsWithSauceLabs());
    }
    @Test
    public  void sortPriceLowToHigt(){
        //log in
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterValueToUsername("standard_user");
        loginPage.enterValueToPassword("secret_sauce");
        loginPage.clickOntheLoginButton();
        //check that there are 6 items on the page
        InventoryPage inventoryPage = new InventoryPage(driver);
        assertTrue(inventoryPage.allItemsAreDisplayed()); // ne arataca testul e true
        //check that all item names are displayed
        inventoryPage.choosePriceLowToHigtSortOption();
        //check that sort is correct
      inventoryPage.checkPriceSortFromLowToHigh();
    }
    @Test
    public  void sortPriceHigtToLow(){
        //log in
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterValueToUsername("standard_user");
        loginPage.enterValueToPassword("secret_sauce");
        loginPage.clickOntheLoginButton();
        //check that there are 6 items on the page
        InventoryPage inventoryPage = new InventoryPage(driver);
        assertTrue(inventoryPage.allItemsAreDisplayed()); // ne arataca testul e true
        //check that all item names are displayed
        inventoryPage.choosePriceHigtToLowSortOption();
        //check that sort is correct
        inventoryPage.checkPriceSortFromHighToLow();
    }
    //Check that sort by name works correctly:
    //1.Alph order
    @Test
    public void sortNameAlphOrder(){
        //log in
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterValueToUsername("standard_user");
        loginPage.enterValueToPassword("secret_sauce");
        loginPage.clickOntheLoginButton();
        //check that there are 6 items on the page
        InventoryPage inventoryPage = new InventoryPage(driver);
        assertTrue(inventoryPage.allItemsAreDisplayed()); // ne arataca testul e true
        //check that all item names are displayed
        inventoryPage.choosePriceAtoZSortOption();
        inventoryPage.checkPriceSorthAtoZ();

    }
    //2.reverse olph order
    @Test
    public void sortNameReverseOrder(){
        //log in
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterValueToUsername("standard_user");
        loginPage.enterValueToPassword("secret_sauce");
        loginPage.clickOntheLoginButton();
        //check that there are 6 items on the page
        InventoryPage inventoryPage = new InventoryPage(driver);
        assertTrue(inventoryPage.allItemsAreDisplayed()); // ne arataca testul e true
        //check that all item names are displayed
        inventoryPage.choosePriceZtoASortOption();
        inventoryPage.checkPriceSorthZtoA();

    }
}
