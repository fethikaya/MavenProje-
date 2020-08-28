package com.techproed;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Day_08IkinciOrnek {
    static WebDriver driver;

    @BeforeClass // Klass çalışınca bir kera çalışacak
    public static void setUp (){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


    }
    @AfterClass // Klass bitince en son bir kere çalışacak
    public static void tearDown () {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {

        }
        driver.quit();

    }

    @Before // Her test metdonudan önce çalışacak
    public void testenOnce (){
        driver.get("http://google.com");  // Bunu yazınca her testi google götürür.
                                        // her seferinde tüm testlere bunu yazmaya gerek kalmaz. 3 mes googye giren,
    }


    @After // Her test metodundan sonra çalışacak
    public void testenSonra () {
        WebElement sonucSayisi = driver.findElement(By.id("result-stats"));
        System.out.println(sonucSayisi.getText());
    }

    @Test
    public void test1 () {
        WebElement aramaKutusu = driver.findElement(By.name("q"));
        aramaKutusu.sendKeys("Elma");
        aramaKutusu.submit();
    }

    @Test
    public void test2 () {
        WebElement aramaKutusu1 = driver.findElement(By.name("q"));
        aramaKutusu1.sendKeys("Samsun Kulaklık");
        aramaKutusu1.submit();
    }

    @Test
    public void test3 () {
        WebElement aramaKutusu2 = driver.findElement(By.name("q"));
        aramaKutusu2.sendKeys("Çalışma Sandalyesi");
        aramaKutusu2.submit();
    }


}
