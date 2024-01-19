import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import POMpages.submitScreen;

import java.io.FileInputStream;
import java.util.Properties;

import java.util.Properties;
import java.util.concurrent.TimeUnit;


public class testSubmitScreen{

    WebDriver driver;


    @BeforeTest
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://rahulshettyacademy.com/angularpractice/");
    }
    submitScreen test = new submitScreen(driver);
    @Test
    public void fillForm(){
        test.enterName("Yogesh");
        test.enterEmail("yogesh@email.com");
        test.selectGender("Male");
        test.selectEmployeeStatus("Student");


        test.clickSubmitBtn();
    }



}
