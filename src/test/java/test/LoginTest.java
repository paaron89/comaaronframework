package test;


import com.qmetry.qaf.automation.testng.dataprovider.QAFDataProvider;
import utilities.Log;
import org.testng.Assert;
import org.testng.annotations.Test;
import pom.LoginPage;

import java.util.Map;

public class LoginTest extends BasicTest {


    //TestCases for Login

    private String loginSite = "http://store.demoqa.com/products-page/your-account/";
    private String expectedResponseText = "ERROR: The password you entered for the username username is incorrect. Lost your password?";


    //TODO implement parameterized Test methods

    @Test
    public void loginTest() {

        Log.startLog("Login");
        Log.info("TestInfo");

        // System.out.println("LoginTest driver is: " + driver);

        LoginPage login = new LoginPage(driver);
        driver.get(loginSite);

        Assert.assertEquals(login.login("username", "password"), expectedResponseText);

        Log.endLog("Login");

    }


    @Test
    //Same as loginTest1 but with other credentials
    public void loginTest2() {

        LoginPage login = new LoginPage(driver);
        driver.get(loginSite);
        Assert.assertEquals(login.login("username", "password"), expectedResponseText);


    }
    @QAFDataProvider(dataFile = ".\\src\\main\\resources\\loginTestData.txt")
    @Test
    //Same as loginTest with DataProvider
    public void loginTest3DataProvider(Map<String, String> data) {

        LoginPage login = new LoginPage(driver);
        driver.get(loginSite);

        login.loginDataProvider(data.get("UserName"), data.get("Password"));


    }


}
