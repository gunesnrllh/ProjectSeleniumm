package com.testinium.driver.methods;

import com.testinium.driver.BaseTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class Methods {
    WebDriver driver;
    FluentWait<WebDriver> wait;
    JavascriptExecutor jsdriever;
    Logger logger = LogManager.getLogger(Methods.class);


    public Methods(){
        driver= BaseTest.driver;
        wait=new FluentWait<>(driver);
        wait.withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofMillis(300))
                .ignoring(NoSuchElementException.class);
        jsdriever=(JavascriptExecutor) driver;
    }

    public WebElement findElement(By by){
        return wait.until(ExpectedConditions.presenceOfElementLocated(by));

    }

    public void click(By by){
        findElement(by).click();
    }
    public void waitBySecond(long seconds) {
        try {
            Thread.sleep(seconds * 1000);

        } catch (InterruptedException e) {
            e.printStackTrace();}
    }

    public void sendKeys(By by,String text){
        findElement(by).sendKeys(text);
    }
    public void upDateKeys(By by,String text){
        findElement(by).clear();
        findElement(by).sendKeys(text);
    }

    public boolean isElementVisible(By by){

        try {

            wait.until(ExpectedConditions.visibilityOfElementLocated(by));
            logger.info("True");
                return true;}
        catch (Exception e){

            logger.info("false"+e.getMessage());
            return false;
        }
    }

    public void scrollWithAction(By by){
        Actions actions=new Actions(driver);
        actions.moveToElement(findElement(by)).build().perform();

    }
    public void favoritesCheck(){
        click(By.cssSelector(".menu.top.my-list"));
        click(By.linkText("Favorilerim"));
        Assert.assertTrue(isElementVisible(By.cssSelector(".limit")));
    }

    public Select getSelect(By by) {
        return new Select(this.findElement(by));
    }

    public void selectByText(By by, String text) {
        this.getSelect(by).selectByVisibleText(text);
    }

    public String getAttribute(By by, String attributeName) {
        return this.findElement(by).getAttribute(attributeName);
    }
    public String getText(By by)
    {
        return findElement(by).getText();
    }

    public void goToFav(){
        click(By.cssSelector(".menu.top.my-list"));
        click(By.linkText("Favorilerim"));
    }




}
