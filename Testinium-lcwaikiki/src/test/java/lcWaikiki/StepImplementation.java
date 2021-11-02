package lcWaikiki;

import element.*;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.concurrent.TimeUnit;

import java.util.Random;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

public class StepImplementation {
    final static Logger logger = Logger.getLogger(StepImplementation.class);
    public static WebDriver driver;
    public static String url = "https://www.lcwaikiki.com/tr-TR/TR";

    @Test
    @Order(1)
    public void t9loginWebsite() {
        System.setProperty("webdriver.chrome.driver", "src/test/webdriver/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
        driver.get(url);
        assertEquals(url, driver.getCurrentUrl());
        logger.info(driver.getCurrentUrl() + " sayfasındasınız. ");
    }

    @Test
    @Order(2)
    public void t8login() throws InterruptedException {
        click(MainPageElement.girisyapButton);
        waitBySecond(2);
        sendKeys(LoginPageElement.epostaInput, "evrenkoruk@gmail.com");
        waitBySecond(2);
        sendKeys(LoginPageElement.passwordInput, "evren123");
        waitBySecond(2);
        click(LoginPageElement.loginButton2);
        waitBySecond(2);
    }

    @Test
    @Order(3)
    public void t7loginControl() throws InterruptedException {
        elemmentControlExists(MainPageElement.myAccount);
        waitBySecond(2);
    }

    @Test
    @Order(4)
    public void t6searchText() throws InterruptedException {
        clear(MainPageElement.searchBox);
        sendKeys(MainPageElement.searchBox, "pantolon");
        waitBySecond(2);
        click(MainPageElement.searchButton);
        waitBySecond(2);
    }

    @Test
    @Order(5)
    public void t5scroll() throws InterruptedException {

        waitBySecond(2);
        scroll(1000);
        waitBySecond(2);
    }

    @Test
    @Order(6)
    public void t4seemoreproducts() throws InterruptedException {

        waitBySecond(2);
        click(ProductPageElement.lazyloadtextbutton);
        waitBySecond(10);
    }

    @Test
    @Order(7)
    public void t3selectRandomProduct() throws InterruptedException {
        randomElementclick(ProductPageElement.productList);
        waitBySecond(10);
    }

    @Test
    @Order(8)
    public void t2addBasket() throws InterruptedException {
        click(ProductDetailPageElement.addBasket);
        waitBySecond(2);
        click(ProductDetailPageElement.addSize);
        waitBySecond(2);
        click(ProductDetailPageElement.addBasket);
        waitBySecond(2);
    }

    @Test
    @Order(9)
    public void priceComparison() throws InterruptedException {
        String price1 = getText(ProductDetailPageElement.productPrice2);
        assertEquals(price1.replace(".","").replace(" ",""), ProductDetailPageElement.price.replace(".","").replace(" ",""));
    }

    @Test
    @Order(10)
    public void myBasket() throws InterruptedException {
        click(BasketPageElement.myBasket);
        waitBySecond(2);
        click(BasketPageElement.increase2);
        waitBySecond(2);
    }

    @Test
    @Order(11)
    public void emptyBasket() throws InterruptedException {
        click(BasketPageElement.removeButton);
        waitBySecond(2);
        click(BasketPageElement.deleteButton);
        waitBySecond(2);
        elemmentControlExists(BasketPageElement.emptyControl);
    }
    @Test
    @Order(12)
    public void t1driverClose() throws InterruptedException {
        waitBySecond(10);
        driver.quit();
    }


    //-----Helper-------------//

    public void click(By byElement) {

        driver.findElement(byElement).click();
        logger.info(byElement + " elementine tıklandı");

    }

    public void scroll(int x) {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,x)", "");

    }

    public void assertTrue(Boolean b) {

        assertTrue(b);
        logger.info(b + "true degerine sahip");

    }

    public void sendKeys(By byElement, String text) {

        driver.findElement(byElement).sendKeys(text);
        logger.info(byElement + " elementine " + text + "yazildi. ");
    }

    public String getText(By byElement) {
        logger.info(byElement + " elementinden deger okundu.");
        return driver.findElement(byElement).getText().toString();
    }

    public void clear(By byElement) {
        driver.findElement(byElement).clear();
        logger.info(byElement + " elementinden deger okundu.");

    }

    public void waitBySecond(int seconds) throws InterruptedException {
        TimeUnit.SECONDS.sleep(seconds);
        logger.info(seconds + " saniye beklendi. ");

    }

    public Boolean elemmentControlExists(By byElement) {
        Boolean isPresent = driver.findElements(byElement).size() > 0;
        Boolean b = true;
        if (isPresent == true) {
            b = true;
            logger.info(byElement + " elementi var");
        } else {
            b = false;
            logger.info(byElement + " elementi yok");
        }
        return b;
    }

    public void randomElementclick(By byElement) {
        List<WebElement> elementList = driver.findElements(byElement);
        Random r = new Random();
        int a = r.nextInt(elementList.size());
        elementList.get(a).click();

        List<WebElement> priceList = driver.findElements(byElement);
        ProductDetailPageElement.price = getText(ProductPageElement.priceList);
    }

}