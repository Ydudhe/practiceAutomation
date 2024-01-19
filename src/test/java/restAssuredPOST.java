import io.restassured.RestAssured;
import io.restassured.internal.util.IOUtils;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import static io.restassured.RestAssured.*;

public class restAssuredPOST {


    @Test
    public void sendPOSTRequest() throws IOException {

       RestAssured.baseURI = "https://reqres.in";
       Response response = given()
               .body("{\"email\":\"eve.holt@reqres.in\",\"password\":\"pistol\"}")
               .when()
               .post("/api/register")
               .then()
               .statusCode(200)
               .extract().response();

    }


}
