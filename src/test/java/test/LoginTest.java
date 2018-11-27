package test;


import org.testng.Assert;
import org.testng.annotations.Test;
import pom.LoginPage;

public class LoginTest extends BasicTest {


    //TestCases for Login

    private String loginSite = "http://store.demoqa.com/products-page/your-account/";
    private String expectedResponseText = "ERROR: The password you entered for the username username is incorrect. Lost your password?";


    //TODO implement parameterized Test methods

    @Test
    public void loginTest() {
        System.out.println("LoginTest driver is: " + driver);

        LoginPage login = new LoginPage(driver);
        driver.get(loginSite);

        Assert.assertEquals(login.login("username","password"),expectedResponseText);

    }


    @Test
    //Same as loginTest1 but with other credentials
    public void loginTest2() {

        LoginPage login = new LoginPage(driver);
        driver.get(loginSite);
        Assert.assertEquals(login.login("username","password"),expectedResponseText);


    }
}
