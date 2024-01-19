package objects;

import org.openqa.selenium.By;

public class ObjectRepository {

    public final By name = By.xpath("//input[@class='form-control ng-pristine ng-invalid ng-touched' and @name='name']");
    public static final String email = "//input[@class='form-control ng-untouched ng-pristine ng-invalid' and @name='email']";

    public static final String password = "//input[@id='exampleInputPassword1']";
    public static final String gender = "//select[@id='exampleFormControlSelect1']";

    public String genderPath(String status) {
        String empStatus = "(//div[@class='form-group'])[5]/div/label[text()='" + status + "']";
        System.out.println(empStatus);
        return empStatus;

    }
    public static final String dateOfBirth = "//input[@name='bday']";

    public static final String submitBttn = "//input[@class='btn btn-success']";



}
