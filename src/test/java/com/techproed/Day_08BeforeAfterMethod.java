package com.techproed;

import org.junit.*;

public class Day_08BeforeAfterMethod {

    @BeforeClass
    public static void setUp1(){
        System.out.println("SetUp Çalıştı");
    }

    @AfterClass
    public static void tearDown1 (){
        System.out.println("tearDown çalıştı");
    }

    @Before // bu annotationa sahip method her class çalışmadan önce çalışır.
    public void setUp(){
        System.out.println("BeforeClass çalıştı.");
    }
    @Test
    public void test1(){
        System.out.println("Test 1 çalıştı.");
    }

    @Test
    public void test2(){
        System.out.println("Test 2 çalıştı.");
    }


    @After // bu annotationa sahip method her classtaki tester çalıştırıldıktan sonra çalışır.
    public  void tearDown(){
        System.out.println("AfterClass çalıştı.");
    }







}
