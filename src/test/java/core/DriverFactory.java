package core;


import org.openqa.selenium.remote.BrowserType;

public class DriverFactory {

    //DriverFactory is about which browsertype you want to choose by typing browsername (chrome or firefox at this point) in console
    //The default one is chrome

    public static DriverManager getDriverManager() {
        DriverManager drivermanager;

        String browser = System.getProperty("browser");
        String wrongBrowserMessage = "You have provided incorrent command after -dBrowser: " + browser + " Please use: " + BrowserType.CHROME + " or " + BrowserType.FIREFOX + " instead.";

        if (browser == null) {
            System.out.println(wrongBrowserMessage);
            return new ChromeManager();


        }


        //This switch statement decides which drivermanager should be started based on the user input via Maven command line

        switch (browser) {
            case BrowserType.CHROME:
                drivermanager = new ChromeManager();
                System.out.println("CHROME browsertype is chosen");
                break;

            case BrowserType.FIREFOX:
                drivermanager = new FirefoxManager();
                break;
            default:
                System.out.println(wrongBrowserMessage);
                drivermanager = new ChromeManager();
        }
        return drivermanager;

    }


}
