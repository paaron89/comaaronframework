package core;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import utilities.Log;

import java.io.File;
import java.io.IOException;

public class Utilities {



    public static void takeScreenshot(WebDriver driver, String filePath) throws IOException {

        // To create reference of TakesScreenshot
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        // Call method to capture screenshot
        File src = screenshot.getScreenshotAs(OutputType.FILE);
        // Copy files to specific location
        // result.getName() will return name of test case so that screenshot name will be same as test case name
        //DO NO CONCATENATE DATE FORMAT CONTAINING ":" ON WINDOWS!!!!!
        FileUtils.copyFile(src, new File(filePath));
        Log.info("Successfully captured a screenshot");
    }
}
