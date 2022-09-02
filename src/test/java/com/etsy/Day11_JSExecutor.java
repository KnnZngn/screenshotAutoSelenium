package com.etsy;

import com.myfirstproject.utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.io.IOException;

public class Day11_JSExecutor extends TestBase {

    @Test
    public void scrollIntoViewTest() throws InterruptedException {
        driver.get("https://techproeducation.com/");
        Thread.sleep(3000);

        WebElement weOffer = driver.findElement(By.xpath("//*[.='WE OFFER']"));
        // //*[.='WE OFFER']  dynamic x path alma yontemi

//        1. Create jsexecutor object  //casting yapariz driver i
        JavascriptExecutor js = (JavascriptExecutor)driver;//casting yapiyoruz

//        2. Execute JS commend //komut `'we offer" hedefine kadar gidecek scroll down olacak
        //!!!  onemli  ----arguments[0].scrollIntoView(true); === =>>bu jscript komutu
        //bu komuttan target a kadar git dmk
        js.executeScript("arguments[0].scrollIntoView(true);",weOffer);
        //js.executeScript("comand", webelement);
        //daha sonra bu javascript commend larini testbase koyacagiz
        //    // java script commend i burda testbase ekledik method icine koyduk ve istedgmzde cagirablrz


        Thread.sleep(3000);
//        Scroll over to the Search input that is at the top of the page
        WebElement searchBox = driver.findElement(By.xpath("//input[@type='search']"));
        js.executeScript("arguments[0].scrollIntoView(true);",searchBox);
    }

//    IMPORTANT
    @Test
    public void scrollIntoViewTest2() throws InterruptedException {
        driver.get("https://techproeducation.com/");
        Thread.sleep(3000);
        WebElement weOffer = driver.findElement(By.xpath("//*[.='WE OFFER']"));
        scrollIntoViewJS(weOffer);//coming form TestBase
        // java script commend i burda testbase ekledik method icine koyduk ve istedgmzde cagirablrz
//methodu cagirip icine hedefmzi koyuyoruz sadece
        Thread.sleep(3000);
        WebElement searchBox = driver.findElement(By.xpath("//input[@type='search']"));
        scrollIntoViewJS(searchBox);//coming from TestBase
    }

    @Test
    public void scrollAllTheWayTest() throws InterruptedException, IOException {
        driver.get("https://techproeducation.com/");
        Thread.sleep(3000);
        scrollAllDownByJS();
        takeScreenShot();
        Thread.sleep(3000);
        scrollAllUpByJS();
        takeScreenShot();
    }

//    IMPORTANT
    @Test
    public void clickByJSTests(){
        driver.get("https://techproeducation.com/");
        WebElement LMSLogin = driver.findElement(By.linkText("LMS Login"));
        clickByJS(LMSLogin);
    }

    @Test  //web element yerine yazacagmz string i atar replace yapar
    //send key ile ayni fakat click vs yok
    public void setValueByJSTest(){
        driver.get("https://techproeducation.com/");
        WebElement searchBox = driver.findElement(By.xpath("//input[@type='search']"));
        setValueByJS(searchBox,"QA");
    }

//    A LITTLE IMPORTANT
    @Test
    public void getValueByJStest(){
        driver.get("https://www.carettahotel.com/");
        WebElement checkIn = driver.findElement(By.id("checkin_date")); //bura seleiumdan ve bos dondi
//        System.out.println(checkIn.getText());//returns empty
       getValueByJS("checkin_date");//returns the value of the element whose id=checkin_date
        //bura jvascript ten gelir ve icini de okur sadece "" tirnak icinde id ile calsr bu method
        //getValueBkJS kendi method umuz iciner sadece string parameter koyariz
    }

    @Test
    public void changeBackgroundColorJSTest(){
        driver.get("https://www.carettahotel.com/");
        WebElement checkAvailability = driver.findElement(By.xpath("//input[@type='submit']"));
        changeBackgroundColorByJS(checkAvailability,"red");


        WebElement loginButton = driver.findElement(By.xpath("//a[.='Log in']"));
        addBorderWithJS(loginButton,"5px solid yellow");

    }




}
