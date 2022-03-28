package com.testinium.driver.test;

import com.testinium.driver.BaseTest;
import com.testinium.driver.page.LoginPage;
import com.testinium.driver.page.ProductPage;
import org.junit.Test;

public class CartProcess extends BaseTest {
    @Test
    public void cartProcess() {
        LoginPage loginPage = new LoginPage();
        ProductPage productPage = new ProductPage();
        loginPage.login();
        productPage.goToCart();
        productPage.upDateCart();
        productPage.buyCart();
        productPage.enterInfo();
        productPage.payment();
        productPage.textControl();
    }
}