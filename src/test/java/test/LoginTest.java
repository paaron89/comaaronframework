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
    private String expectedResponseText2 = "ERROR: Invalid username. Lost your password?";


    //TODO implement parameterized Test methods

    @Test
    public void loginTest1() {

        Log.startLog("Login1");
        Log.info("TestInfo");

        // System.out.println("LoginTest driver is: " + driver);

        LoginPage login = new LoginPage(driver);
        driver.get(loginSite);

        Assert.assertEquals(login.login("username", "password"), expectedResponseText);

        Log.endLog("Login1");

    }


    @Test
    //Same as loginTest1 but with other credentials
    public void loginTest2() {

        LoginPage login = new LoginPage(driver);
        driver.get(loginSite);
        Assert.assertEquals(login.login("username2", "password2"), expectedResponseText2);


    }

    //DataProvider with txt file
    //TODO use other Dataprovider file instead of txt
    @QAFDataProvider(dataFile = ".\\src\\main\\resources\\loginTestData.txt")
    @Test
    //Same as loginTest with DataProvider
    public void loginTest3DataProvider(Map<String, String> data) {

        LoginPage login = new LoginPage(driver);
        driver.get(loginSite);

        //Uses "UserName" label and "Password"  and "ExpectedresultMsg" labels from txt file

        Assert.assertEquals(data.get("ExpectedResultMsg"),
                (login.loginDataProvider(data.get("UserName"), data.get("Password"))));


    }


}
