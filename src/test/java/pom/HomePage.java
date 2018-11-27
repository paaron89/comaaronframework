package pom;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.security.Provider;

public class HomePage extends MainPOM {

    WebDriver driver;

    @FindBy(name = "s")
    private WebElement searchField;

    public HomePage(WebDriver driver) {
        super(driver);

        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public void search(String searchKey){
        searchField.clear();
        searchField.sendKeys(searchKey);
        searchField.sendKeys(Keys.ENTER);
    }
}
