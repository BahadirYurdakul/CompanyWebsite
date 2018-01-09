package controllers;

import com.avaje.ebean.Ebean;
import models.Token;
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
            System.out.println(body.asText());
            return  ok(Ebean.json().toJson(
                 userService.createUser(user)
            ));
        } catch (Exception e) {
            e.printStackTrace();
            return badRequest(Ebean.json().toJson("Creating user failed! Check all conditions"));
        }
    }

    public Result changeUser() {
      try {
          Http.RequestBody body = request().body();
          String username = Token.getUsernameFromToken(request().getHeader("user"));
          User user = User.getUser(body.asJson());
          user.setUsername(username);
          return ok(Ebean.json().toJson(
                  userService.changeUser(user)
          ));
      } catch (Exception e) {
          e.printStackTrace();
          return badRequest(Ebean.json().toJson("Changing information failed"));
      }
    }

    public Result getUserInfo()     {
        String username = Token.getUsernameFromToken(request().getHeader("token"));
        try {
            return ok(Ebean.json().toJson(
                userService.getUser(username)
            ));
        } catch (Exception e) {
            e.printStackTrace();
            return badRequest(Ebean.json().toJson("failed!"));
        }
    }

    public Result createToken() {
       try {
           Http.RequestBody body = request().body();
           Token tokenObj = Token.getToken(body.asJson());
           if(userService.checkUser(tokenObj)) {
               String tokenString = tokenObj.createToken();
               session().remove("user");
               return ok(Token.tokenToJsonString(tokenString));
           }
           return unauthorized("username or password wrong");
       } catch (Exception e) {
           e.printStackTrace();
           return badRequest("Login failed!");
       }
    }

    public Result getUsername(String token) {
        return ok(Token.getUsernameFromToken(token));
    }

}
