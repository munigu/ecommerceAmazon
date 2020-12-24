package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class AmazonHomePage {

    public AmazonHomePage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "twotabsearchtextbox")
    public WebElement searchBox;

    @FindBy(css = ".nav-right input[type='submit']")
    public WebElement searchButton;

    @FindBy(xpath = "(//span[@class='a-size-base-plus a-color-base a-text-normal'])")
    public List<WebElement> allItems;

    @FindBy(xpath = "//span[@class='a-size-medium a-color-base a-text-normal']")
    public List<WebElement> allItems1;

    @FindBy(id = "availability_feature_div")
    public WebElement inStock;

    @FindBy(id = "acrCustomerReviewLink")
    public WebElement rating;

    @FindBy(css = "[name='submit.add-to-cart']")
    public WebElement addToCartButton;

    @FindBy(id = "attach-close_sideSheet-link")
    public WebElement popUpClose;

    @FindBy(id = "nav-cart")
    public WebElement cart;

    @FindBy(id = "sc-subtotal-amount-activecart")
    public WebElement subtotalCost;

}
