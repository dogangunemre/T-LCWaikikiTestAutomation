
package element;

import org.openqa.selenium.By;

public class BasketPageElement {

    public static By myBasket = By.xpath("//a[@data-tracking-label='Sepetim']");
    public static String increase="2";
    public static By increase2 = By.xpath("//a[@class='oq-up plus']");
    public static By removeButton = By.xpath("//i[@class='fa fa-trash-o']");
    public static By deleteButton = By.xpath("//a[@class='inverted-modal-button sc-delete ins-init-condition-tracking']");
    public static By emptyControl = By.xpath("//p[@class='cart-empty-title']");


}