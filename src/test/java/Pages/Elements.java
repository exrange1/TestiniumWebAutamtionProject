package Pages;

import Utilities.GWD;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Elements extends Parent {

    public Elements() {

        PageFactory.initElements(GWD.getDriver(), this);

    }

    @FindBy(css = "[data-id='10006']")
    private WebElement beymen;

    @FindBy(css = "[placeholder='Ürün, Marka Arayın']")
    public WebElement searchBar;

    @FindBy(xpath= "//button[contains(text(),'ARA')]")
    public WebElement searchButton;

    @FindBy(css = "[data-productid='1028226']")
    private WebElement product;

    @FindBy(css = "[class='o-productDetail__title']")
    public WebElement productTitle;

    @FindBy(xpath= "//div[contains(text(),'Gömlek yaka')]")
    public WebElement productInfo;


    @FindBy(id= "priceNew")
    public WebElement productPrice;

    @FindBy(css = "[class='m-form__label m-variation__label']")
    public WebElement productColor;


    @FindBy(xpath = "//div//span[contains(text(),'40')]")
    private WebElement size;

    @FindBy(id = "addBasket")
    private WebElement addToCart;


    @FindBy(css= "[title='Sepetim']")
    private WebElement Cart;


    @FindBy(xpath= "//li//span[contains(text(),'1.199')]")
    private WebElement CartPrice;

    @FindBy(id = "quantitySelect0-key-0")
    private WebElement quantityMenu;

    @FindBy(css= "[value='2']")

    private WebElement quantity;

    @FindBy(id= "removeCartItemBtn0-key-0")
    private WebElement  deleteBtn;


    @FindBy(xpath = "//div[@id='emtyCart']//strong")
    private WebElement  emptyMsg;


















    // burda string isimden weblemente ulaşıcam
    WebElement myElement;

    public void findAndSend(String strElement, String value) {

        switch (strElement) {
            case "searchBar":myElement=searchBar; break;


        }

        sendKeysFunction(myElement, value);
    }

    public void findAndClick(String strElement) {

        switch (strElement) {
            case "searchButton":myElement=searchButton;break;
            case "product":myElement=product;break;
            case "size":myElement=size;break;
            case "addToCart":myElement=addToCart;break;
            case "Cart":myElement=Cart;break;
            case "quantityMenu":myElement=quantityMenu;break;
            case "quantity":myElement=quantity;break;
            case "deleteBtn":myElement=deleteBtn;break;

        }

        clickFunction(myElement);
    }

    public void findAndContainsText(String strElement, String text) {

        switch (strElement) {
            case "beymen": myElement=beymen;break;
            case "CartPrice": myElement=CartPrice;break;
            case "emptyMsg": myElement=emptyMsg;break;

        }

        verifyContainsText(myElement, text);
    }


    public void SearchAndDelete(String strElement) {
        switch (strElement){

            case "searchBar":myElement=searchBar;break;
        }
        deleteKeysFunction(myElement);

    }


}
