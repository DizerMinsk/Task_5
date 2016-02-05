package PageObjects;

import org.openqa.selenium.By;

/**
 * Created by Nick on 05.02.2016.
 */
public class Gmail {

    public By login = By.xpath("//input[@id='Email']");
    public By nextStep = By.xpath("//input[@id='next']");
    public By password = By.xpath("//input[@id='Passwd']");
    public By signIn = By.xpath("//input[@id='signIn']");

    public By senderLocator = By.xpath("//div[@class='UI']//tbody/tr[@class='zA zE']/td[@class='yX xY ']/div[@class='yW']/span[@class='zF']");
    public By themaLocator = By.xpath("//div[@class='UI']//tbody/tr[@class='zA zE']/td[@class='xY a4W']//b");
    public By toWrite = By.xpath("//div[@class='T-I J-J5-Ji T-I-KE L3']");
    public By recipient = By.xpath("//textarea[@class='vO'][@name='to']");
    public By thema = By.xpath("//input[@class='aoT']");
    public By textMessage = By.xpath("//div[@class='Am Al editable LW-avf']");
    public By sendButton = By.xpath("//div[@class='T-I J-J5-Ji aoO T-I-atl L3']");
    public By isSent = By.xpath("//div[@class='vh']/span[@class='ag a8k']");
}
