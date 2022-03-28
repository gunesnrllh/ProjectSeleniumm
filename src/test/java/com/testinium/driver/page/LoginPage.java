package com.testinium.driver.page;

import com.testinium.driver.methods.Methods;
import org.junit.Assert;
import org.openqa.selenium.By;

public class LoginPage {
    Methods methods;
    public LoginPage(){
        methods=new Methods();
    }

    public void login(){

        try {methods.waitBySecond(5);
            methods.click(By.cssSelector(".menu-top-button.login>a"));
            methods.waitBySecond(5);
            methods.sendKeys(By.id("login-email"),"nurullah.gunes@testinium.com");
            methods.sendKeys(By.id("login-password"),"1q2w3e4r5t");
            methods.waitBySecond(5);
            methods.click(By.cssSelector(".ky-btn.ky-btn-orange.w-100.ky-login-btn"));
            methods.waitBySecond(5);
            Assert.assertTrue(methods.isElementVisible(By.cssSelector(".fa.fa-key.fa-fw")));
            System.out.println("Login olundu.");

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("login olunamadı");
        }

    }

}
