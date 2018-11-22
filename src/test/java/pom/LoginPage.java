package pom;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class LoginPage {


    WebDriver driver;
    String responseText;


    @FindBy(id = "log")
    private WebElement usernameField;

    @FindBy(id = "pwd")
    private WebElement passwordField;

    @FindBy(id = "login")
    private WebElement loginButton;


    //Builds webelements

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }


    //Login service
    public String login(String username, String password) {
        System.out.println("login service started");

        usernameField.clear();
        usernameField.sendKeys(username);
        passwordField.clear();
        passwordField.sendKeys(password);
        loginButton.click();

//TODO implement Waits Class it's a bit messy here
        WebElement response = driver.findElement(By.xpath("//p[@class='response']"));
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOf(response));
        String responseText = response.getText();
        System.out.println("Response is: " + responseText);


        return responseText;
    }


}
