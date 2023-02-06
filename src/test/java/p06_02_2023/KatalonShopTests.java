package p06_02_2023;

import com.sun.org.glassfish.gmbal.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class KatalonShopTests extends BaseTest{
    @Test(priority = 10)
    @Description("TC-1: Adding product with quantity to the cart")
    public void addingProductWithQuantity(){
        driver.get(baseUrl + "/product/flying-ninja/");
        productPage.quantity().clear();
        productPage.quantity().sendKeys("3");
        productPage.addToCartButton().click();
        Assert.assertTrue(productPage.notificationAddedToCart().getText().contains("Flying Ninja"),
                "Wrong notification!");
        navPage.cartLink().click();
        Assert.assertTrue(driver.getCurrentUrl().contains("/cart"), "Wrong URL!");
        Assert.assertEquals(cartPage.tableRows().size(), 1, "Product number is not 1!");
    }
    @Test(priority = 20)
    @Description("TC-2: Removing product from cart")
    public void removingProductFromCart() throws InterruptedException {
        navPage.cartLink().click();
        Assert.assertTrue(driver.getCurrentUrl().contains("/cart"), "Wrong URL!");
        Assert.assertEquals(cartPage.tableRows().size(), 1, "Product number is not 1!");
        cartPage.deleteButtonForRow(1).click();
        Thread.sleep(1000);
        Assert.assertEquals(cartPage.tableRows().size(), 0, "Product number is not 0!");
    }
}
