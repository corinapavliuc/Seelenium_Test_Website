import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Double.parseDouble;
import static java.util.Collections.reverseOrder;
import static java.util.Collections.sort;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class InventoryPage extends BasePage { //la fiecare pagina noua facem aparte pagina
    //aici punem driver fara el nu lucreaza testele si sa fie
    // mai scurte si mai usor de gasit ,lacatori
    WebDriver driver; //aceasta este cutia cu driver

    public InventoryPage(WebDriver driver) {
        //acesta este automat constructor
        //unim cutia
        super(driver);//ne ajuta sa unim cu BasePage
    }

    @FindBy(css = "[data-test=\"title\"]")
    private WebElement tittleText;

    @FindBy(className = "inventory_list")
    private WebElement inventoryList;

    @FindBy(id = "react-burger-menu-btn")
    private WebElement button;

    //6 items
    @FindBy(className = "inventory_item")
    private List<WebElement> items;

    public int itemCount() {
        return items.size();
    }


    public boolean setInventoryList() {
        return inventoryList.isDisplayed();//boolean ne da voie vozvraseat ori true ori false
    }

    public String setTittleText() {
       return  getTextOfElement(tittleText);

        //getTextOfElement de la BasePage ne ajuta s afacem testul mai rapid si scurt
        //return tittleText.getText();//String ne ajuta sa apara testul

    }

    //all 6 items is displayed
    public boolean allItemsAreDisplayed() {
        boolean displayed = true; //artam ca tot trebuie sa fie true
        for (WebElement item : items) {
            if (!item.isDisplayed()) {
                // daca cumva va da  nu se vede elementul va fii
                // false atunci trebuie sa fie tot false
                displayed = false;


            }
        }
        return displayed;
    }

    //all 6 items name is diplayed
    @FindBy(className = "inventory_item_name")
    private List<WebElement> itemNames;

    //adauga un produs in cos
    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    private WebElement addToCardBackPack;

    //adauga in cos bike
    @FindBy(id = "add-to-cart-sauce-labs-bike-light")
    private WebElement addToCardBikeLight;

    //aduga in cos tshirt
    @FindBy(id = "add-to-cart-sauce-labs-bolt-t-shirt")
    private WebElement addToCardTshirt;
    //apasa pe cos

    @FindBy(className = "shopping_cart_badge")
    private WebElement cartBadge;

    @FindBy(className = "shopping_cart_link")
    private WebElement cartIcon; //icon din cus

    //aduga jacket produs in cos
    @FindBy(id = "add-to-cart-sauce-labs-fleece-jacket")
    private WebElement addToCardJacket;

    //adauga Onisie in produs in cos
    @FindBy(id = "add-to-cart-sauce-labs-onesie")
    private WebElement addToCardOniesie;

    @FindBy(css = "[data-test=\"product-sort-container\"]")
    private WebElement sortDropDown;

    //locator price(Low-to hith)
    @FindBy(css = "[value=\"lohi\"]")
    private WebElement priceLowHith;
    @FindBy(className = "inventory_item_price")
    private List<WebElement> inventoryPrice;

    //locator la HigtToLowSort
    @FindBy(css = "[value=\"hilo\"]")
    private WebElement priceHithLow;

    //locator la AtoZ
    @FindBy(css = "[value=\"az\"]")
    private WebElement priceAtoZ;


    //locator la ZtoA
    @FindBy(css = "[value=\"za\"]")
    private WebElement priceZtoA;

    public boolean allItemsNamesAreDisplayed() {
        boolean displayed = true;
        for (WebElement itemName : itemNames) {
            if (!itemName.isDisplayed()) {
                displayed = false;
            }
        }
        return displayed;
    }

    public boolean allItemNameAreNotEmpty() {
        boolean notEmpty = true;
        for (WebElement itemName : itemNames) {
            if (itemName.getText().isEmpty()) {
                //daca este gol va fii false
                notEmpty = false;
            }
        }
        return notEmpty;
    }

    public boolean allItenmNamesStartsWithSauceLabs() {
        boolean startsWithSauceLabs = true;
        for (WebElement itemName : itemNames) {
            if (!itemName.getText().startsWith("Sauce Labs")) {
                startsWithSauceLabs = false;
            }
        }
        return startsWithSauceLabs;
    }

    //adauga un produs in cos
    public void clickOnBackpackAddToCartButton() {
        addToCardBackPack.click();
    }

    //adauga in cos bike
    public void clickOnBikeLightAddToCartButton() {
        addToCardBikeLight.click();
    }

    //aduga in cos tshirt
    public void clickOnTshirtAddToCartButton() {
        addToCardTshirt.click();
    }

    //apasa pe cos

    public String getItemsQuantityCartBadge() {
        return cartBadge.getText();
    }

    public void clickOnTheCartIcon() {
        cartIcon.click(); //dam click pe icon
    }

    //aduga jacket produs in cos
    public void clickOnJacketAddToCartButton() {
        addToCardJacket.click();
    }

    //adauga Onisie in produs in cos
    public void clickOnOnisieAddToCartButton() {
        addToCardOniesie.click();
    }

    public String getNameOfTheFirstItem() {
        return itemNames.get(0).getText(); //pentru a cauta textul
    }


    ///PriceLowToHigt
    public void choosePriceLowToHigtSortOption() {
        sortDropDown.click();
        priceLowHith.click();
    }

    public boolean checkPriceSortFromLowToHigh() {
        List<Double> actualPrices = new ArrayList<>();
        for (WebElement price : inventoryPrice) {
            actualPrices.add(parseDouble(price.getText().substring(1)));
            //substring ne ajuta sa taiem dolar si sa inceapa cu cifre
        }
        List<Double> expectedPrices = new ArrayList<>(actualPrices);
        sort(expectedPrices);//ne ajuta sa sortam toate preturiele
        return actualPrices.equals(expectedPrices);
    }

    //HigtToLowSort
    public void choosePriceHigtToLowSortOption() {
        sortDropDown.click();
        priceHithLow.click();
    }

    public boolean checkPriceSortFromHighToLow() {
        List<Double> actualPrices = new ArrayList<>();
        for (WebElement price : inventoryPrice) {
            actualPrices.add(parseDouble(price.getText().substring(1)));
            //substring ne ajuta sa taiem dolar si sa inceapa cu cifre
        }
        List<Double> expectedPrices = new ArrayList<>(actualPrices);
        sort(expectedPrices, reverseOrder());
        //ne ajuta sa sortam toate preturiele
        //reverseOrder() ne ajuta sa sortam invers obiectelee
        return actualPrices.equals(expectedPrices);
    }

    //AtoZ
    public void choosePriceAtoZSortOption() {
        sortDropDown.click();
        priceAtoZ.click();
    }

    public boolean checkPriceSorthAtoZ() {
        List<Double> actualPrices = new ArrayList<>();
        for (WebElement price : inventoryPrice) {
            actualPrices.add(parseDouble(price.getText().substring(1)));
            //substring ne ajuta sa taiem dolar si sa inceapa cu cifre
        }
        List<Double> expectedPrices = new ArrayList<>(actualPrices);
        sort(expectedPrices);//ne ajuta sa sortam toate preturiele
        return actualPrices.equals(expectedPrices);
    }

    //locator la ZtoA
    public void choosePriceZtoASortOption() {
        sortDropDown.click();
        priceZtoA.click();
    }

    public boolean checkPriceSorthZtoA() {
        List<Double> actualPrices = new ArrayList<>();
        for (WebElement price : inventoryPrice) {
            actualPrices.add(parseDouble(price.getText().substring(1)));
            //substring ne ajuta sa taiem dolar si sa inceapa cu cifre
        }
        List<Double> expectedPrices = new ArrayList<>(actualPrices);
        sort(expectedPrices, reverseOrder());
        //ne ajuta sa sortam toate preturiele
        //reverseOrder() ne ajuta sa sortam invers obiectelee
        return actualPrices.equals(expectedPrices);
    }
}
