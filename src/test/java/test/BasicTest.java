package test;


import core.DriverFactory;
import core.DriverManager;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class BasicTest {

    DriverManager drivermanager;

    //Must be protected or private to run from Maven

    protected static WebDriver driver;
    private Date currentTime = Calendar.getInstance().getTime();
    private String currentTimeFormatted = new SimpleDateFormat("MM_dd_yy_HH-mm-ss").format(currentTime);



    //Sets up the browsertype for tests

    @BeforeMethod
    public void setup() {

        drivermanager = DriverFactory.getDriverManager();
        driver = drivermanager.getWebDriver();
        System.out.println("BasicTest driver is: " + driver);
    }

    //Quits Driver After Tests


    @AfterMethod
    public void teardDown (ITestResult result){



        // System.out.println("Current time is: " + currentTimeFormatted);

        //using ITestResult.FAILURE is equals to result.getStatus then it enter into if condition
        if (ITestResult.FAILURE == result.getStatus()) {
            try {
                // To create reference of TakesScreenshot
                TakesScreenshot screenshot = (TakesScreenshot) driver;
                // Call method to capture screenshot
                File src = screenshot.getScreenshotAs(OutputType.FILE);
                // Copy files to specific location
                // result.getName() will return name of test case so that screenshot name will be same as test case name
                //DO NO CONCATENATE DATE FORMAT CONTAINING ":" ON WINDOWS!!!!!
                FileUtils.copyFile(src, new File("C:\\Users\\Aron_Preszter\\IdeaProjects\\comaaronframework\\screenshots\\" + result.getName() + " " + currentTimeFormatted + ".png"));
                System.out.println("Successfully captured a screenshot");
            } catch (Exception e) {
                System.out.println("Exception while taking screenshot " + e.getMessage());
            }
        }
        drivermanager.driverQuit();
    }
}







