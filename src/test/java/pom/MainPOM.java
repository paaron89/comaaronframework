package pom;

import org.openqa.selenium.WebDriver;

public class MainPOM {

    public final WebDriver driver;


    public  MainPOM(WebDriver driver) {
        this.driver = driver;
        //System.out.println("MainPOM driver is: " + driver);
       // PageFactory.initElements(driver, this);

    }
}
