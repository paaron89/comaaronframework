package test;

import org.testng.annotations.Test;
import pom.HomePage;

public class HomeTest extends BasicTest {


    private String baseURL = "http://store.demoqa.com";

    @Test
    public void homeSearch(){
        HomePage homePage = new HomePage(driver);
        driver.get(baseURL);
        homePage.search("iphone");
    }

}
