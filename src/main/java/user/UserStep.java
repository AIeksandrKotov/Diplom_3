package user;

import api.Endpoints;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.given;

public class UserStep extends Endpoints {
    public ValidatableResponse registerUser(CreateUser createUser) {
        return given()
                .spec(requestSpecification())
                .and()
                .body(createUser).log().all()
                .when()
                .post(Endpoints.REGISTER_USER)
                .then().log().all();
    }
}
