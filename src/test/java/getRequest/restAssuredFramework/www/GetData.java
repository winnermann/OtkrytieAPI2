package getRequest.restAssuredFramework.www;

import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.Map;
import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.equalTo;


public class GetData
{
    Response response;

    @BeforeMethod
    public void setUp() {
        RestAssured.baseURI = "https://reqres.in/";
    }


    @Test(description = "Cценарий запроса: Get", priority = 1, timeOut = 60000 * 10)
    @Step("Step1: Получить список пользователей")
    public void test1Responsecode() {
        //Выриант 1
        response = given().
                contentType("application/json").
                when().
                get("/api/users?page=2");
        response.then().
                statusCode(200).

                body("page", equalTo(2)).
                body("per_page", equalTo(6)).
                body("total", equalTo(12)).
                body("total_pages", equalTo(2)).

                body("data.id[0]", equalTo(7)).
                body("data.email[0]", equalTo("michael.lawson@reqres.in")).
                body("data.first_name[0]", equalTo("Michael")).
                body("data.last_name[0]", equalTo("Lawson")).
                body("data.avatar[0]", equalTo("https://s3.amazonaws.com/uifaces/faces/twitter/follettkyle/128.jpg")).

                body("data.id[1]", equalTo(8)).
                body("data.email[1]", equalTo("lindsay.ferguson@reqres.in")).
                body("data.first_name[1]", equalTo("Lindsay")).
                body("data.last_name[1]", equalTo("Ferguson")).
                body("data.avatar[1]", equalTo("https://s3.amazonaws.com/uifaces/faces/twitter/araa3185/128.jpg")).

                body("data.id[2]", equalTo(9)).
                body("data.email[2]", equalTo("tobias.funke@reqres.in")).
                body("data.first_name[2]", equalTo("Tobias")).
                body("data.last_name[2]", equalTo("Funke")).
                body("data.avatar[2]", equalTo("https://s3.amazonaws.com/uifaces/faces/twitter/vivekprvr/128.jpg")).

                body("data.id[3]", equalTo(10)).
                body("data.email[3]", equalTo("byron.fields@reqres.in")).
                body("data.first_name[3]", equalTo("Byron")).
                body("data.last_name[3]", equalTo("Fields")).
                body("data.avatar[3]", equalTo("https://s3.amazonaws.com/uifaces/faces/twitter/russoedu/128.jpg")).

                body("data.id[4]", equalTo(11)).
                body("data.email[4]", equalTo("george.edwards@reqres.in")).
                body("data.first_name[4]", equalTo("George")).
                body("data.last_name[4]", equalTo("Edwards")).
                body("data.avatar[4]", equalTo("https://s3.amazonaws.com/uifaces/faces/twitter/mrmoiree/128.jpg")).

                body("data.id[5]", equalTo(12)).
                body("data.email[5]", equalTo("rachel.howell@reqres.in")).
                body("data.first_name[5]", equalTo("Rachel")).
                body("data.last_name[5]", equalTo("Howell")).
                body("data.avatar[5]", equalTo("https://s3.amazonaws.com/uifaces/faces/twitter/hebertialmeida/128.jpg")).

                body("ad.company", equalTo("StatusCode Weekly")).
                body("ad.url", equalTo("http://statuscode.org/")).
                body("ad.text", equalTo("A weekly newsletter focusing on software development, infrastructure, the server, performance, and the stack end of things.")).
                log().all();

        //Выриант 2
        JsonPath jsonPath = response.jsonPath();
        System.out.println(jsonPath.getMap("data[0]"));
        Map<String, Object> allElements = jsonPath.getMap("$");
        System.out.println(allElements.size() + "\n\n");
        System.out.println(allElements);


    }

    @Test (description = "Cценарий запроса: Post", priority = 2, timeOut = 60000 * 10)
    @Step("Step2: Создать пользователя")
    public void test2Responsecode()
    {

        response = given().
                contentType("application/json").
                body("{\"page\":1,\"per_page\":6,\"total\":12,\"total_pages\":2,\"data\":[{\"id\":1,\"email\":\"george.bluth@reqres.in\",\"first_name\":\"George\",\"last_name\":\"Bluth\",\"avatar\":\"https://s3.amazonaws.com/uifaces/faces/twitter/calebogden/128.jpg\"},{\"id\":2,\"email\":\"janet.weaver@reqres.in\",\"first_name\":\"Janet\",\"last_name\":\"Weaver\",\"avatar\":\"https://s3.amazonaws.com/uifaces/faces/twitter/josephstein/128.jpg\"},{\"id\":3,\"email\":\"emma.wong@reqres.in\",\"first_name\":\"Emma\",\"last_name\":\"Wong\",\"avatar\":\"https://s3.amazonaws.com/uifaces/faces/twitter/olegpogodaev/128.jpg\"},{\"id\":4,\"email\":\"eve.holt@reqres.in\",\"first_name\":\"Eve\",\"last_name\":\"Holt\",\"avatar\":\"https://s3.amazonaws.com/uifaces/faces/twitter/marcoramires/128.jpg\"},{\"id\":5,\"email\":\"charles.morris@reqres.in\",\"first_name\":\"Charles\",\"last_name\":\"Morris\",\"avatar\":\"https://s3.amazonaws.com/uifaces/faces/twitter/stephenmoon/128.jpg\"},{\"id\":6,\"email\":\"tracey.ramos@reqres.in\",\"first_name\":\"Tracey\",\"last_name\":\"Ramos\",\"avatar\":\"https://s3.amazonaws.com/uifaces/faces/twitter/bigmancho/128.jpg\"}],\"ad\":{\"company\":\"StatusCode Weekly\",\"url\":\"http://statuscode.org/\",\"text\":\"A weekly newsletter focusing on software development, infrastructure, the server, performance, and the stack end of things.\"}}").
                when().
                post("/api/users");
        response.then().
                statusCode(201).
                body("page", equalTo(1)).
                body("per_page", equalTo(6)).
                body("total", equalTo(12)).
                body("total_pages", equalTo(2)).

                body("data.id[0]", equalTo(1)).
                body("data.email[0]", equalTo("george.bluth@reqres.in")).
                body("data.first_name[0]", equalTo("George")).
                body("data.last_name[0]", equalTo("Bluth")).
                body("data.avatar[0]", equalTo("https://s3.amazonaws.com/uifaces/faces/twitter/calebogden/128.jpg")).
                log().all();

    }
}
