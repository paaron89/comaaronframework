package test;


import org.testng.annotations.Test;
import pom.LoginPage;

public class LoginTest extends BasicTest {

    //TestCases for Login


    @Test
    public void loginTest() {

        LoginPage login = new LoginPage(driver);

        driver.get("http://store.demoqa.com/products-page/your-account/");
        login.login("username", "password");


    }


    @Test
    public void loginTest2() {

        LoginPage login = new LoginPage(driver);

        driver.get("http://store.demoqa.com/products-page/your-account/");
        login.login("kacsa", "máj");


    }
}
