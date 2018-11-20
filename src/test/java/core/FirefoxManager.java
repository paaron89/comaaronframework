package core;


import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;


public class FirefoxManager extends DriverManager {


    //Creates Firefox driver if Drivertype is Firefox

    public void createWebDriver() {
        System.setProperty("webdriver.gecko.driver", "src/drivers/geckodriver.exe");
        FirefoxOptions option = new FirefoxOptions();
        this.driver = new FirefoxDriver(option);

    }
}
