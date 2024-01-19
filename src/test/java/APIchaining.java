import io.restassured.http.ContentType;
import io.restassured.internal.util.IOUtils;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;


public class APIchaining {


//    🎾 API Chaining Scenario:
//
//    Let's assume we have a simple scenario where we want to:
//            - Create a user.
//            - Retrieve the created user's details.
//            - Update the user's information.
//            - Verify the updated user's details.


    private static String baseURL = "https://restful-booker.herokuapp.com"; // Replace with your API base URL


    @Test
    public void testApiChaining() throws IOException {


// Step 1:      First We create a user, extract the response JSON to get the user's ID.

        Response createUserResponse = given()
                .body(IOUtils.toByteArray(jsonBody()))
                .when()
                .post(baseURL + "/booking")
                .then()
                .statusCode(200)
                .extract()
                .response();
        int id = createUserResponse.jsonPath().getInt("bookingid");

        System.out.println(id);


// Step 2:      Then We use the extracted user ID to retrieve the user's details.


        String userId = given()
                .when()
                .get(baseURL + "/booking/{id}",id)
                .then()
                .statusCode(200)
                .extract()
                .path("id");

        System.out.println(userId);


// Step 3:      Update the user's information

        given()
                .contentType(ContentType.JSON)
                .body("{\n" +
                        "    \"firstname\": \"Yogesh Updated\",\n" +
                        "    \"lastname\": \"Dudhe Updated\",\n" +
                        "    \"totalprice\": 1500,\n" +
                        "    \"depositpaid\": true,\n" +
                        "    \"bookingdates\": {\n" +
                        "        \"checkin\": \"2018-01-01\",\n" +
                        "        \"checkout\": \"2019-01-01\"\n" +
                        "    },\n" +
                        "    \"additionalneeds\": \"Lunch\"\n" +
                        "}")
                .when()
                .put(baseURL + "/booking/{id}", id)
                .then()
                .statusCode(200);


// Step 4:      Verify the updated user's details

        given()
                .when()
                .get(baseURL + "/booking/{id}", id)
                .then()
                .statusCode(200)
                .assertThat()
                .body("firstname", equalTo("Yogesh Updated"))
                .body("lastname", equalTo("Dudhe Updated"));
    }


    private static FileInputStream jsonBody() throws FileNotFoundException {
        FileInputStream file;
        file = new FileInputStream(new File(System.getProperty("user.dir")+ "/src/test/java/Body/APIchainingBody.json"));
        return file;

    }
    }

