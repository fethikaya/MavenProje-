package com.techproed;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Day08_IlkOrnek {
    static WebDriver driver;  // Tüm test methotlardan çalışması için bunu burada tanımlamak gerekiyor.
                                // findElement gibi methodları ister istemez testlerin içinde kullancağız. bu yüzden ihtiyac var

    @BeforeClass // Driverlar burada oluşturulursa her test için ayrı ayrı yazmaya gerek kalmaz.
    public static void setUp (){

        WebDriverManager.chromedriver().setup();
         driver= new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void test01(){
        driver.get("http://google.com");

    }


    @AfterClass
    public static void tearDown () throws InterruptedException {
        Thread.sleep(3000);


        driver.quit();
    }

}
