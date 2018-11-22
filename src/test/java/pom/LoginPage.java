package pom;


import core.Waits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage {


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


    //Builds webelements

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }


    //Login service
    public String login(String username, String password) {

        Waits wait = new Waits(driver);

        System.out.println("login service started");

        usernameField.clear();
        usernameField.sendKeys(username);
        passwordField.clear();
        passwordField.sendKeys(password);
        loginButton.click();
        wait.waitUntilVisible(response);
        responseText = response.getText();
        System.out.println("Response is: " + responseText);


        return responseText;
    }


}
