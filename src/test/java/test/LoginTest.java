package test;


import org.testng.annotations.Test;
import pom.LoginPage;

public class LoginTest extends BasicTest {

    //TestCases for Login

    String loginSite = "http://store.demoqa.com/products-page/your-account/";


    @Test
    public void loginTest() {

        LoginPage login = new LoginPage(driver);
        driver.get(loginSite);
        login.login("username", "password");


    }


    @Test
    public void loginTest2() {

        LoginPage login = new LoginPage(driver);
        driver.get(loginSite);
        login.login("kacsa", "máj");


    }
}
