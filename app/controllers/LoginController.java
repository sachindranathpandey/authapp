package controllers;

import model.User;
import play.mvc.Result;
import play.mvc.Controller;

public class LoginController extends Controller {
    public Result userLogin() {

        return ok(play.libs.Json.toJson("login"));
    }
}
