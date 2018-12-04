package test;


import core.DriverFactory;
import core.DriverManager;
import core.Utilities;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utilities.Log;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class BasicTest {

    DriverManager drivermanager;

    //Must be protected or private to run from Maven

    protected static WebDriver driver;




    //Sets up the browsertype for tests

    @BeforeMethod
    public void setup() {

        drivermanager = DriverFactory.getDriverManager();
        driver = drivermanager.getWebDriver();


        //System.out.println("BasicTest driver is: " + driver);
    }

    //Quits Driver After Tests


    @AfterMethod
    public  void teardDown (ITestResult result){
        Date currentTime = Calendar.getInstance().getTime();
        String currentTimeFormatted = new SimpleDateFormat("MM_dd_yy.HH-mm-ss").format(currentTime);
        String filePath = ".\\screenshots\\" + result.getName() + " " + currentTimeFormatted + ".png";

        Log.info("Status of test is: " + result);


        // System.out.println("Current time is: " + currentTimeFormatted);

        //using ITestResult.FAILURE is equals to result.getStatus then it enter into if condition
        if (ITestResult.FAILURE == result.getStatus()) {
            try {

                Utilities.takeScreenshot(driver, filePath);

            } catch (Exception e) {
               Log.info("Exception while taking screenshot " + e.getMessage());
            }
        }
        drivermanager.driverQuit();
    }
}







