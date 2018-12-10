package pom;


import core.Waits;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Map;


public class LoginPage extends MainPOM {


    public WebDriver driver;

    private String responseText;


    @FindBy(id = "log")
    private WebElement usernameField;

    @FindBy(id = "pwd")
    private WebElement passwordField;

    @FindBy(id = "login")
    private WebElement loginButton;

    @FindBy(xpath = "//p[@class='response']")
    private WebElement response;

    public LoginPage(WebDriver driver) {
        super(driver);


        this.driver = driver;
        PageFactory.initElements(driver, this);

    }


    //Login service
    public String login(String username, String password) {
        //System.out.println("LoginPage driver is: " + driver);
        Waits wait = new Waits(driver);


        usernameField.clear();
        usernameField.sendKeys(username);
        passwordField.clear();
        passwordField.sendKeys(password);
        loginButton.click();
        wait.waitUntilVisible(response);
        responseText = response.getText();


        return responseText;
    }


    public String  loginDataProvider(String userName, String password) {
        //System.out.println("LoginPage driver is: " + driver);
        Waits wait = new Waits(driver);


        usernameField.clear();
        usernameField.sendKeys(userName);
        passwordField.clear();
        passwordField.sendKeys(password);
        loginButton.click();
        wait.waitUntilVisible(response);
        responseText = response.getText();


        return responseText;
    }


}
