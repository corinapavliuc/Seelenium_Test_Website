import org.junit.Test;

import static java.lang.Thread.sleep;
import static org.junit.Assert.assertTrue;

public class CheckoutTest extends  BaseTest{
    @Test
    public void succesCheckout() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterValueToUsername("standard_user");
        loginPage.enterValueToPassword("secret_sauce");
        loginPage.clickOntheLoginButton();
        InventoryPage inventoryPage = new InventoryPage(driver);
        assertTrue(inventoryPage.setInventoryList());
        //add 5 item to the cart
        inventoryPage.clickOnBackpackAddToCartButton();
        inventoryPage.clickOnBikeLightAddToCartButton();
        //go to Cart page
        inventoryPage.clickOnTheCartIcon();
        //cardpage
        CardPage cardPage = new CardPage(driver);
        cardPage.setCheckoutButton();
        //Checkout: Your Information
        CheckoutPage checkoutPage =new CheckoutPage(driver);
        checkoutPage.enterValueToFirstname("Ana");
        checkoutPage.enterValueToLastname("Muller");
        checkoutPage.enterValueToPostcode("76453");
        checkoutPage.setButton();
        sleep(5000);
       ///finish page
        CheckoutOverviewPage checkoutOverviewPage =new CheckoutOverviewPage(driver);
        checkoutOverviewPage.setFinishButton();
        //Checkout: Complete!
        CheckoutCompletePage checkoutCompletePage =new CheckoutCompletePage(driver);
        assertTrue("Thank you for your order!",checkoutCompletePage.setTittleText());
    }
}
