package controllers;

import com.avaje.ebean.Ebean;
import com.google.gson.Gson;
import models.User;
import play.mvc.Controller;
import play.mvc.Http;
import play.mvc.Result;
//import services.UserService;

public class UserController extends Controller {
//    private UserService userService = UserService.USER_SERVICE;

    public Result addUser() {
        try {
//            Http.RequestBody body = request().body();
//            User user = new Gson().fromJson(body.asText(), User.class);
//            return  ok(Ebean.json().toJson(
//                    userService.createUser(user)
//            ));
            return  null;
        } catch (Exception e) {
            System.out.println(e);
            return badRequest("Creating user failed! Check all conditions");
        }
    }

    public Result changeUser() {
        // FIXME: 23.11.2017 add JSON validator and Object caster
        return null;
    }

    public Result getUserInfo(String username) {
        // FIXME: 23.11.2017 add JSON validator and Object caster
        return  null;
    }
}
