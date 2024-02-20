package pages;

import helper.EndPoint;
import helper.Utility;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import java.io.File;
import java.util.List;
import static helper.Models.getListUsers;
import static helper.Models.postCreateUser;
import static org.assertj.core.api.Assertions.assertThat;

public class ApiPage {

    String setURL;
    Response res;

    public void prepareUrlFor(String url){
        switch (url) {
            case "GET_LIST_USERS":
                setURL = EndPoint.GET_lIST_USERS;
                break;
            case "CREATE_NEW_USERS":
                setURL = EndPoint.CREATE_NEW_USERS;
                break;
            case "DELETE_USERS":
                setURL = EndPoint.DELETE_USERS;
                break;
            default:
                System.out.println("input right url");
        }
    }

    public void hitApiGetListUsers(){
        res = getListUsers(setURL);
    }

    public void hitApiPostCreateUser(){
        res = postCreateUser(setURL);
        System.out.println(res.getBody().asString());
    }

    public void validationStatusCodeIsEquals(int status_code){
        assertThat(res.statusCode()).isEqualTo(status_code);
    }

    public void validationResponseBodyGetListUsers(){
        List<Object> id = res.jsonPath().getList("id");
        List<Object> name = res.jsonPath().getList("name");
        List<Object> email = res.jsonPath().getList("email");
        List<Object> gender = res.jsonPath().getList("gender");
        List<Object> status = res.jsonPath().getList("status");

        System.out.println(id.get(1));
        System.out.println(name.get(1));
        System.out.println(email.get(1));
        System.out.println(gender.get(1));
        System.out.println(status.get(1));

        assertThat(id.get(0)).isNotNull();
        assertThat(name.get(0)).isNotNull();
        assertThat(email.get(0)).isNotNull();
        assertThat(gender.get(0)).isIn("female", "male");
        assertThat(status.get(0)).isIn("active", "inactive");
    }

    public void validationResponseJsonWithJSONSchema(String filename){
        File JSONFile = Utility.getJSONSchemaFile(filename);
        res.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(JSONFile));
    }
}
