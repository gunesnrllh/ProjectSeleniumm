package com.testinium.driver.test;

import com.testinium.driver.BaseTest;
import com.testinium.driver.page.LoginPage;
import com.testinium.driver.page.ProductPage;
import org.junit.Test;

public class ProductPageTest extends BaseTest {
    @Test
    public void productPageTest() {
        LoginPage loginPage = new LoginPage();
        ProductPage productPage = new ProductPage();
        loginPage.login();
        /**productPage.selectProduct();
        productPage.addToFav();
        productPage.checkFav();
        productPage.goMainPage();
        productPage.goMainPage();
        productPage.goPointCat();
        productPage.goTurClassics();
        productPage.goHoby();
        productPage.randomBookSelect();
        productPage.goToFavorites();
        productPage.removeElements();
         **/
        productPage.goToCart();
        productPage.upDateCart();
        productPage.buyCart();
        productPage.enterInfo();
        productPage.payment();
        productPage.textControl();
        productPage.cancelBuy();



    }


    }



