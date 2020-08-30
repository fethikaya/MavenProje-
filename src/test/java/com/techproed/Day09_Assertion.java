package com.techproed;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Day09_Assertion {

    private static WebDriver driver;
    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }
    @Test
    public void test1(){
        driver.get("http://google.com");


        // Test Case : Google .com'un başlığı "Google arama sayfası" olsun.
       // Assert.assertEquals("5","7"); // Eğer 5 = 7 ise başarılı, değilse başarsız.

        String title = driver.getTitle();
        Assert.assertEquals("Arama", "Google");  // Test başarısız
    }

    @Test
    public void test2(){
        driver.get("http://amazon.com");
        // Amazon.com'un başlığı Amazon kelimesini içeriyor olsun.
        String title = driver.getTitle();

        boolean iceriyorMu = title.contains("Amazon"); // "true" ya da "false"
        // boolean veri tipinde bir değer giriyoruz.

        Assert.assertTrue(iceriyorMu);
    }

    @Test
    public void test3 () {
        driver.get("http://facebook.com");
        String titleFacebook = driver.getTitle();
        boolean varmi = titleFacebook.contains("Youtube");

        // Assert.assertTrue(iceriyorMu); // Bunun true olduğunu doğrula. Eğer true değilse başarsız
        Assert.assertFalse(varmi); // False olduğunu doğrula eğer yanlışsa test başarılı

    }

    @Test
    public void test4(){
        driver.get("http://google.com");
        String title = driver.getTitle();
        System.out.println("MERHABALAR..");
        Assert.assertEquals("Google Arama Sayfası",title);
        // eğer test başarısızsa içerisinde bulunulan testin kalan kısmı çalıştırmıyor.
        System.out.println("TEST DOĞRULAMA İŞLEMİ BİTTİ..");
    }
    @Test
    public void test5(){
        driver.get("http://facebook.com");
        String title = driver.getTitle();
        // Facebook.com'un title'ı Youtube kelimesini içermesin.
        boolean iceriyorMu = title.contains("Google");
        Assert.assertFalse(iceriyorMu); // False olduğunu doğrula.
        System.out.println("TEST DOĞRULAMA İŞLEMİ BİTTİ..");
    }



    @AfterClass
    public static void tearDown(){
        driver.quit();
    }
}
