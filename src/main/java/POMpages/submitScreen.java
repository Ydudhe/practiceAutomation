package POMpages;

import objects.ObjectRepository;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.Date;

public class submitScreen extends ObjectRepository{



    WebDriver driver;

    public submitScreen(WebDriver driver){
        this.driver=driver;
    }

    public void enterName(String nameToEnter){

        driver.findElement(name).sendKeys(nameToEnter);

    }

    public void enterEmail(String emailToEnter){

        driver.findElement(By.xpath(email)).sendKeys(emailToEnter);

    }


    public void enterPassword(String passwordToEnter){

        driver.findElement(By.xpath(password)).sendKeys(passwordToEnter);

    }

    public void selectGender(String genderToSelect){

      WebElement dropdown =  driver.findElement(By.xpath(gender));

        Select drp = new Select(dropdown);
        drp.selectByVisibleText(genderToSelect);

    }

    public void selectEmployeeStatus(String status){

     driver.findElement(By.xpath(genderPath(status))).click();

    }

    public void selectDOB(int day, String month, int year){


    }


    public void clickSubmitBtn(){

        driver.findElement(By.xpath(submitBttn)).click();

    }



}
