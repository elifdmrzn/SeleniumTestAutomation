package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.apache.log4j.Logger;


import java.util.concurrent.TimeUnit;

public class test1 {

    public  WebDriver driver;
    final static Logger logger = Logger.getLogger(test1.class);

    @Before
    public void setupDriver(){
        logger.info("Test Başlatıldı.");

        System.setProperty("webdriver.chrome.driver","C:/Users/Elif/Desktop/selenium/ChromeDriver/chromedriver.exe");
        driver = new ChromeDriver();
        String url = "https://www.gittigidiyor.com/";
        driver.get(url);
        logger.info("Test Edilecek Sayfa : " + driver.getTitle());
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }
    @Test
    public void TestHome(){

        WebElement signbtn= driver.findElement(By.xpath(".//*[@class='gekhq4-6 hnYHyk']"));
        signbtn.click();
        WebElement clk = driver.findElement(By.linkText("Giriş Yap"));
        clk.click();
        logger.info("Yönlendirilen Sayfa : " + driver.getTitle());
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        WebElement username = driver.findElement(By.id("L-UserNameField"));
        username.click();
        username.sendKeys("ttest_123");

        WebElement password = driver.findElement(By.id("L-PasswordField"));
        password.click();
        password.sendKeys("test123");
        driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
        driver.findElement(By.id("gg-login-enter")).click();
    }
    @After
    public void quitDriver(){
        driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
        driver.quit();
        logger.info("Test tamamlandı.");
    }
}
