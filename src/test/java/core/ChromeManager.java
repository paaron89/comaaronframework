package core;


import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeManager extends DriverManager {


    //Creates Chrome driver if browsertype is CHROME


    public void createWebDriver() {
        System.setProperty("webdriver.chrome.driver", "src/drivers/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        //options.addArguments("--headless");

        String headless = System.getProperty("headless");

        if (headless == "headless"){
            options.addArguments("--headless");
        }else System.out.println("The default setting is to start browser normally. In case headless run please type -Dheadless:headless");

        this.driver = new ChromeDriver(options);


    }
}
