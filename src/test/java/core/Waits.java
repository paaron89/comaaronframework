package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pom.LoginPage;

import javax.xml.stream.events.Attribute;

public class Waits extends LoginPage {

    //Class of Waits


    public Waits(WebDriver driver) {
        super(driver);
    }

    public void waitUntilClickable(WebElement webelement) {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.elementToBeClickable(webelement));

    }


    public void waitUntilVisible(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void alertPresented(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.alertIsPresent());

    }


    //TODO pls rethink this idea
   /* public void waitUntilAttributenotEmpty(WebElement element, Attribute href) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.attributeToBeNotEmpty(element, "href"));
    }*/


}
