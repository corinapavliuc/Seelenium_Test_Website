import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CardPage extends BasePage {
    //la fiecare pagina noua facem aparte pagina
    //aici punem driver fara el nu lucreaza testele si sa fie
    // mai scurte si mai usor de gasit ,lacatori
    WebDriver driver; //aceasta este cutia cu driver
    public CardPage(WebDriver driver) {
        super(driver);//ne ajuta sa unim cu BasePage
    }
    @FindBy(className = "cart_item")
    private List<WebElement> addedItems;
    public int getAddedItemsQuantity(){ //cate bucati sunt acolo ne trebuie cifra
        return addedItems.size();
    }

    //daca se corespunde cu numele cu produsul in cos
    @FindBy(className = "inventory_item_name")
    private List<WebElement> itemNames;
    public String getNameOfFirstItem(){
        return itemNames.get(0).getText(); //pentru text
    }

    //checkoutbutton
    @FindBy(id = "checkout")
    private WebElement checkoutButton;
    public void  setCheckoutButton(){
        checkoutButton.click();
    }
}
