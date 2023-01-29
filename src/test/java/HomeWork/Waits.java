package HomeWork;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.swing.*;
import java.time.Duration;
import java.util.List;

import static org.testng.Assert.assertTrue;

public class Waits {

    private static WebDriver driver;
//    /**
//     * opening the main page
//     */

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files (x86)\\Webdrivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.takeaway.com/bg");
        driver.manage().window().maximize();
        driver.manage().timeouts();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void takeAway(){

        WebElement okElement=driver.findElement(By.xpath("//button[@class='_908LZ _1pO2V m29-z _4R7G3 _2JFg2']"));
        okElement.click();

        WebElement editSearchElement=driver.findElement(By.xpath("//input[@id='combobox-input_0']"));
        editSearchElement.sendKeys("ulitsa Graf Ignatiev, Sofia");
        String actual=editSearchElement.getText();
        actual.contains("ulitsa Graf Ignatiev, Sofia");
        editSearchElement.click();
// Не можах да накарам търсачката да търси.
        //какво пропускам?



//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        wait.until(ExpectedConditions.titleContains("ulitsa \"Graf Ignatiev\", Sofia"));
//        assertTrue(driver.getTitle().startsWith("ulitsa Graf Ignatiev, Sofia"));
    }
}
