package tests;

import base.BaseClass;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Amazon extends BaseClass {
     @Test
    public void searchForBook() throws InterruptedException {
        driver.get("https://www.amazon.com/");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("qa testing for beginners"+ Keys.ENTER);

        driver.findElement(By.xpath("(//img[@class='s-image'])[1]")).click();

         String price=driver.findElement(By.xpath("//*[@class='a-box-inner a-accordion-row-container']//span[@id='newBuyBoxPrice']")).getText();
         Assert.assertEquals(price,"$47.49");
         driver.findElement(By.xpath("//*[@id='add-to-cart-button']")).click();

         String priceBeforeCheck=driver.findElement(By.xpath("//*[@id='hlb-subcart']//span[@class='a-color-price hlb-price a-inline-block a-text-bold']")).getText();
         Assert.assertEquals(priceBeforeCheck,"$47.49");


    }
}
