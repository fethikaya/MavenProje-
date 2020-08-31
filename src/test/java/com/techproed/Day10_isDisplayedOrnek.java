package com.techproed;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Day10_isDisplayedOrnek {
    static WebDriver driver;

    @BeforeClass
    public static void setUp () {
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @AfterClass
    public static void sayfaKapat (){
        driver.quit();

    }


    @Before
    public void SayfaAclis (){
        driver.get("http://bestbuy.com");
    }



    @Test
    public void test1 (){
        String baslik = driver.getTitle();
        Assert.assertTrue(baslik.contains("Best"));
    }

  @Test
    public void test2 (){
      WebElement logo = driver.findElement(By.xpath("//img[@class= 'logo']"));
      boolean gorunuyorMu = logo.isDisplayed();
      Assert.assertTrue(gorunuyorMu);
  }

  @Test
    public void test3 (){
        WebElement meksiko = driver.findElement(By.xpath("//img[@alt= 'Mexico']"));
      boolean link = meksiko.isDisplayed();
      Assert.assertTrue(link);
  }
}
