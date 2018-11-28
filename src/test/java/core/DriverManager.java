package core;

import org.openqa.selenium.WebDriver;

public abstract class DriverManager {

    public WebDriver driver;

    public abstract void createWebDriver();

    //Quits the driver
    public void driverQuit() {

        if (driver != null) {
            driver.quit();
            driver = null;
        }

    }

    //returns driver object
    public WebDriver getWebDriver() {

        if (driver == null) {
            createWebDriver();

        }
        //System.out.println("DriverManager driver is: " + driver);
        return driver;
    }

}

