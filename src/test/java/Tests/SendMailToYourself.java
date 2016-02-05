package Tests;
import PageObjects.Gmail;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.TestNG;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Nick on 05.02.2016.
 */
public class SendMailToYourself {

    WebDriver driver = new FirefoxDriver();
    Gmail gmail = new Gmail();

    String login1 = "mikalai.plinda@gmail.com";
    String password1 = "qq507080qq";
    String thema1 = "Proverka";
    List<WebElement> list1 = new ArrayList<WebElement>();
    List<WebElement> list2 = new ArrayList<WebElement>();
    List<String> list3 = new ArrayList<String>();

    @BeforeTest
    public void openMail() throws InterruptedException {
        driver.get("https://gmail.com");
        WebElement waiting = (new WebDriverWait(driver,10)).until(ExpectedConditions.presenceOfElementLocated(gmail.login));
        driver.findElement(gmail.login).sendKeys(login1);
        driver.findElement(gmail.nextStep).click();
        waiting = (new WebDriverWait(driver,10)).until(ExpectedConditions.presenceOfElementLocated(gmail.password));
        driver.findElement(gmail.password).sendKeys(password1);
        driver.findElement(gmail.signIn).click();
        waiting = (new WebDriverWait(driver,10)).until(ExpectedConditions.presenceOfElementLocated(gmail.toWrite));
        driver.findElement(gmail.toWrite).click();
        waiting = (new WebDriverWait(driver,10)).until(ExpectedConditions.presenceOfElementLocated(gmail.recipient));
        driver.findElement(gmail.recipient).sendKeys(login1);
        driver.findElement(gmail.thema).sendKeys(thema1);
        driver.findElement(gmail.textMessage).sendKeys("!!!!!!!!!!!!!!!!!!!!!!!");
        driver.findElement(gmail.sendButton).click();
        waiting = (new WebDriverWait(driver,10)).until(ExpectedConditions.presenceOfElementLocated(gmail.isSent));
        waiting = null;
    }

    @Test
    public void toCheck()
    {

        driver.get("https://gmail.com");
        WebElement waiting = (new WebDriverWait(driver,10)).until(ExpectedConditions.presenceOfElementLocated(gmail.toWrite));

        list1 = driver.findElements(gmail.senderLocator);
        list2 = driver.findElements(gmail.themaLocator);

        for(int i=0; i<list1.size();i++)
        {
            list3.add(list1.get(i).getAttribute("email")+"@1"+list2.get(i).getText());
            System.out.println(list3.get(i));
        }

        boolean isThere = false;

        for(int i=0; i<list3.size();i++)
        {
            if((login1+"@"+thema1).equals(list3.get(i)))
            {
                isThere = true;
            }
        }

        Assert.assertEquals(isThere,true);

    }


    @AfterTest
    public void closeMail() {

        driver.close();

    }

}
