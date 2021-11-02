
package element;

import org.openqa.selenium.By;

public class ProductDetailPageElement {


    public static By addBasket = By.xpath("//a[@id='pd_add_to_cart']");
    public static By addSize = By.xpath("(//a[@key='1'])[1]");
    public static String price="";
    public static By productPrice = By.xpath("//row[@id='topStickyMainInfo']/div[@class='col-md-4 price-area']/span[@class='price'][1]");
    public static By productPrice2 = By.xpath("//span[@id='cartLastTotal']");




}