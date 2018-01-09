package controllers;

import com.avaje.ebean.Ebean;
import models.User;
import play.mvc.Controller;
import play.mvc.Http;
import play.mvc.Result;
import services.UserService;

public class UserController extends Controller {
   private UserService userService = UserService.USER_SERVICE;

    public Result addUser() {
        try {
            Http.RequestBody body = request().body();
            User user = User.getUser(body.asJson());
            return  ok(Ebean.json().toJson(
                 userService.createUser(user)
            ));
        } catch (Exception e) {
            System.out.println(e);
            return badRequest("{\"err\":\"Creating user failed! Check all conditions\"}");
        }
    }

    public Result changeUser() {
      try {
          Http.RequestBody body = request().body();
          User user = User.getUser(body.asJson());
          return ok(Ebean.json().toJson(
                  userService.changeUser(user)
          ));
      } catch (Exception e) {
          System.out.println(e);
          return badRequest("Changing information failed");
      }
    }

    public Result getUserInfo(String username) {
        try {
            return ok(Ebean.json().toJson(
                userService.getUser(username)
            ));
        } catch (Exception e) {
            System.out.println(e);
            return badRequest("failed!");
        }
    }
}
