package impl;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import models.api.User;
import services.IAuthService;

import static io.restassured.RestAssured.given;
import static app_context.RunContext.put;

public class AuthServiceImpl implements IAuthService {
    private final String SERVICE = "auth/";

    @Override
    public User createUser(User user) {
        String url = URI + SERVICE + "create/";

        Response r = given().contentType(ContentType.JSON).body(user).post(url);

        if (r.statusCode() == 200) {
            return r.as(User.class);
        } else {
            return null;
        }
    }

    @Override
    public User login(User user) {
        String url = URI + SERVICE + "login/";
        return getUser(url, user);
    }

    private User getUser(String url, User user) {
        Response r = given().contentType(ContentType.JSON).body(user).post(url);

        if (r.statusCode() == 200) {
            var cookies = r.getCookies();
            put("cookies", cookies);
            put("user", r.as(User.class));
            return r.as(User.class);
        } else return null;
    }
}
