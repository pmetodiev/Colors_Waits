package HomeWork;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import javax.swing.*;

public class Colors {

    private static WebDriver driver;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files (x86)\\Webdrivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://pragmatic.bg/automation/lecture13/Config.html");
        driver.manage().window().maximize();
    }

    @Test
    public void colorMultipleSelect(){
        WebElement redElement=driver.findElement(By.xpath("//select[@name='color']//option[@value='rd']"));
        WebElement silverElement=driver.findElement(By.xpath("//select[@name='color']//option[@value='sl']"));

        Actions buildr=new Actions(driver);
        buildr.keyDown(Keys.CONTROL)
                .click(silverElement)
                .click(redElement);

        String actualColorSilver=silverElement.getText();
        Assert.assertEquals(actualColorSilver,"Silver");

        String actualColorRed=redElement.getText();
        Assert.assertEquals(actualColorRed,"Red");

    }

    @AfterMethod
    public void afterTest(){


        driver.quit();

    }


}
