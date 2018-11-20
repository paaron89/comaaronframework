package pom;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage {


    WebDriver driver;

    @FindBy(id = "log")
    public WebElement usernameField;

    @FindBy(id = "pwd")
    public WebElement passwordField;



    //Builds webelements

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    //Login service
    public void login(String username, String password) {
        System.out.println("login service started");


        usernameField.clear();
        usernameField.sendKeys(username);

        passwordField.clear();
        passwordField.sendKeys(password);


    }
}
