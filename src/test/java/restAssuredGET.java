import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.openqa.selenium.devtools.v118.network.model.Request;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class restAssuredGET {


    @BeforeTest
    public static void setup() {
        RestAssured.baseURI = "https://reqres.in/api/users?page=2";
    }

    @Test
    public void getRequest() {

        Response response = given()
                .when()
                .get(baseURI)
                .then()
                .extract().response();

        System.out.println("Response Body  -     " + response.asPrettyString());

        System.out.println("Status Code is -  "+ response.statusCode());

        System.out.println(response.body());
    }

    @Test
    public void validateBody(){

      given()
                .when()
                .get(baseURI)
                .then()
                .assertThat()
                .statusCode(200)            // Validate if status code 200
                .body(not(isEmptyString()))       // Validate if response body is not empty
                .body("page",equalTo(2)) ;      // Validate if response body contain page = 2


    }



    }

