package tests;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;


import java.util.concurrent.TimeUnit;

public class test2 {

    public WebDriver driver;
    final static Logger logger = Logger.getLogger(test2.class);

    @Before
    public void setupDriver() {

        logger.info("Test Başlatıldı.");
        System.setProperty("webdriver.chrome.driver", "C:/Users/Elif/Desktop/selenium/ChromeDriver/chromedriver.exe");
        driver = new ChromeDriver();
        String url = "https://www.gittigidiyor.com/";
        driver.get(url);
        logger.info("Test Edilecek Sayfa : " + driver.getTitle());
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
    }

    @Test
    public void TestSearch() {

        WebElement searchBox = driver.findElement(By.name("k"));
        searchBox.click();
        searchBox.sendKeys("Bilgisayar");
        searchBox.sendKeys(Keys.ENTER);

        WebElement element = driver.findElement(By.xpath(".//*[@class='clearfix']/li[2]/a"));

        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("arguments[0].scrollIntoView()", element);

        element.click();
        logger.info("Yönlendirilen Sayfa : " + driver.getTitle());

        driver.findElement(By.xpath(".//*[@class='cell-border-css']/p/img")).click();
        logger.info("Yönlendirilen Sayfa : " + driver.getTitle());

        WebElement price= driver.findElement(By.id("sp-price-lowPrice"));
        String priceText= price.getText();

        WebElement basketBtn = driver.findElement(By.id("add-to-basket"));

        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].scrollIntoView()", basketBtn);

        basketBtn.click();
        driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);

        driver.findElement(By.xpath(".//*[@class='header-cart-buttons gg-d-24']/div/a")).click();
        logger.info("Yönlendirilen Sayfa : " + driver.getTitle());

        WebElement price2 = driver.findElement(By.className("new-price"));
        String priceText2= price2.getText();

        if(priceText.compareTo(priceText2)>0) {

            WebElement increase = driver.findElement(By.className("amount"));
            increase.click();
            increase.sendKeys("2");
            increase.sendKeys(Keys.ENTER);

            driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
            driver.findElement(By.className("btn-delete btn-update-item hidden-m")).click();
        }

        }

        @After
        public void quitDriver(){
            driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
            driver.quit();
            logger.info("Test tamamlandı.");

        }











    }

