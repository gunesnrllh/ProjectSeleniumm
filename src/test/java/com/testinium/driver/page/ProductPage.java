package com.testinium.driver.page;

import com.testinium.driver.methods.Methods;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;

public class ProductPage {
    Methods methods;
    Logger  logger= LogManager.getLogger(ProductPage.class);

    public ProductPage(){
        methods=new Methods();
    }

    public void goMainPage(){
        methods.click(By.cssSelector("#header-bottom>div>div"));
    }
    public void goPointCat(){
        methods.click(By.xpath("//*[@id=\"mainNav\"]/div[1]/div/div[2]/a"));
        methods.waitBySecond(3);
    }


    public void selectProduct(){

        methods.sendKeys(By.id("search-input"), "oyuncak");
        methods.click(By.cssSelector(".common-sprite.button-search"));
        methods.scrollWithAction(By.xpath("//*[@id=\"product-565088\"]/div[1]/div[1]/div/a/img"));// 7. ürüne scroll işlemi
        methods.waitBySecond(3);

    }

    public void addToFav(){
        methods.click(By.xpath("//div[@class='product-cr'][7]//i[@class='fa fa-heart']"));
        methods.waitBySecond(5);
        methods.click(By.xpath("//div[@class='product-cr'][8]//i[@class='fa fa-heart']"));
        methods.waitBySecond(5);
        methods.click(By.xpath("//div[@class='product-cr'][9]//i[@class='fa fa-heart']"));
        methods.waitBySecond(5);
        methods.click(By.xpath("//div[@class='product-cr'][10]//i[@class='fa fa-heart']"));
    }
    public void checkFav(){
        try {
            methods.favoritesCheck();
            methods.waitBySecond(3);
            System.out.println("favorilere ekleme basari ile yapıldi");
        }catch (Exception e){
            System.out.println("favori ekleme yapılamadı");
        }
    }

    public void randomBookSelect(){
         //rastgele kitap seçimi
        methods.click(By.cssSelector(".add-to-cart"));// aynı sınıfa ait herhangi bir kitabın eklenmesi

    }
    public void goToFavorites(){
        try {
            methods.goToFav();
            methods.waitBySecond(3);
            System.out.println("favoriler görüntülendi");
        }catch (Exception e){
            System.out.println("favoriler görüntülenemedi");
        }
    }

    public void removeElements(){
        try {
            methods.click(By.xpath("div[@class=\"product-cr\"][3]//i[@class=\fa fa-heart-o"));// 3.sıradaki eleman silindi
            methods.waitBySecond(5);
        }catch (Exception e){
            System.out.println("eleman silinemedi");
        }
    }

    public void goHoby(){
        try {methods.scrollWithAction(By.xpath("//*[@id=\"mainNav\"]/div[1]/ul/li[1]/div[2]/ul/li[3]/span"));
            methods.waitBySecond(5);
            methods.click(By.xpath("//*[@id=\"mainNav\"]/div[1]/ul/li[1]/div[2]/ul/li[3]/div/div[1]/div/ul[2]/li[14]/a"));
            methods.waitBySecond(5);
            methods.click(By.cssSelector(".pr-img-link"));

        }catch (Exception e){
            System.out.println("hobi sekmesi görüntülenemedi");

        }
    }
    public void goTurClassics(){
        try {methods.click(By.xpath("//*[@id=\"landing-point\"]/div[4]/a[2]/img"));
            methods.waitBySecond(5);
            methods.selectByText(By.xpath("//*[@id=\"content\"]/div/div/div[1]/div/div[1]/select"),"Yüksek Oylama");
            methods.waitBySecond(5);

        }catch (Exception e){
            System.out.println("Turk klasiklerinde hata alındı");
        }
    }

    public void goToCart(){
        methods.click(By.xpath("//*[@id=\"cart-items\"]"));
        methods.click(By.xpath("//*[@id=\"js-cart\"]"));
        methods.waitBySecond(3);
    }
    public void upDateCart(){
        methods.upDateKeys(By.xpath("//*[@id=\"cart_module\"]/div[1]/table/tbody/tr/td[4]/form/input[1]"), String.valueOf(2));
        methods.click(By.xpath("//*[@id=\"cart_module\"]/div[1]/table/tbody/tr/td[4]/form/i"));


    }

    public void buyCart(){
        try {
            methods.click(By.xpath("//*[@id=\"cart_module\"]/div[4]/div[1]/a"));
            methods.waitBySecond(5);
            System.out.println("odeme alanina gecildi");
        }catch (Exception e){
            System.out.println("ödeme alanında hata alındı");
        }
    }

    public void enterInfo(){
        methods.click(By.xpath("//*[@id=\"shipping-tabs\"]/a[2]"));//var olan adresi güncelle
        methods.sendKeys(By.id("address-firstname-companyname"),"nurullah");
        methods.sendKeys(By.id("address-lastname-title"),"gunes");
        methods.selectByText(By.xpath("//*[@id=\"address-country-id\"]"),"Türkiye");
        methods.selectByText(By.xpath("//*[@id=\"address-zone-id\"]"),"İstanbul");
        methods.click(By.xpath("//*[@id=\"address-county-id\"]/option[26]"));//kartal seçilir
        methods.click(By.xpath("//*[@id=\"district\"]"));
        methods.sendKeys(By.xpath("//*[@id=\"district\"]"),"SOĞANLIK YENİ MAH");
        methods.sendKeys(By.xpath("//*[@id=\"address-address-text\"]"),"testinium plaza");
        methods.sendKeys(By.xpath("//*[@id=\"address-postcode\"]"),"34873");
        methods.sendKeys(By.xpath("//*[@id=\"address-telephone\"]"),"1234567890");
        methods.sendKeys(By.xpath("//*[@id=\"address-mobile-telephone\"]"),"5453715731");
        methods.sendKeys(By.xpath("//*[@id=\"address-tax-id\"]"),"32417228470");
        methods.click(By.id("button-checkout-continue"));
        methods.waitBySecond(5);
        methods.click(By.id("button-checkout-continue"));
        methods.waitBySecond(5);


    }
    public void payment(){
        methods.sendKeys(By.id("credit-card-owner"),"nurullah güneş");
        methods.sendKeys(By.id("credit_card_number_1"),"2331");
        methods.sendKeys(By.id("credit_card_number_2"),"1234");
        methods.sendKeys(By.id("credit_card_number_3"),"0362");
        methods.sendKeys(By.id("credit_card_number_4"),"5027");
        methods.selectByText(By.id("credit-card-expire-date-month"),"08");
        methods.selectByText(By.id("credit-card-expire-date-year"), String.valueOf(2035));
        methods.sendKeys(By.id("credit-card-security-code"),"123");
        methods.waitBySecond(3);
        methods.click(By.xpath("//*[@id=\"button-checkout-continue\"]"));

    }
    public void textControl(){
        String text = methods.getText(By.xpath("//span[@class=\"error\"]"));
        System.out.println("Alınan text:" + text);
        logger.info("Alinan text:"+ text);

    }
    public void cancelBuy(){
        try {
            methods.click(By.xpath("//a[@class=\"checkout-logo\"]"));
            methods.waitBySecond(3);
            methods.scrollWithAction(By.xpath("//a[contains(text(),\"Merhaba\")]"));
            methods.click(By.xpath("//a[contains(text(),\"Çıkış\")]"));
            System.out.println("cikis yapildi");

        }catch (Exception e){
            System.out.println("cikis adiminda hata alindi");
        }



    }

}
