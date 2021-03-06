package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pom.MainPOM;

public class Waits extends MainPOM {

    //Class of Waits


    public Waits(WebDriver driver) {
        super(driver);
    }

    public void waitUntilClickable(WebElement webelement) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(webelement));

    }


    public void waitUntilVisible(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(element));
        //System.out.println("Waits driver is: " + driver);
    }

    public void alertPresented(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.alertIsPresent());

    }


    //TODO pls rethink this idea
   /* public void waitUntilAttributenotEmpty(WebElement element, Attribute href) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.attributeToBeNotEmpty(element, "href"));
    }*/


}
