package api;

import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class Endpoints {
    public static final String BASE_URL = "https://stellarburgers.nomoreparties.site/";
    public static RequestSpecification requestSpecification(){
        return given().log().all()
                .contentType(ContentType.JSON)
                .baseUri(Endpoints.BASE_URL);
    }
    public static final String REGISTER_USER = "/api/auth/register";
}
