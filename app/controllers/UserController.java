package controllers;


import com.fasterxml.jackson.databind.JsonNode;
import dao.UserDAO;
import jakarta.transaction.Transactional;
import model.User;
import play.data.Form;
import play.data.FormFactory;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Http;
import play.mvc.Result;
import javax.inject.Inject;
import java.net.http.HttpRequest;
import java.util.List;

public class UserController extends Controller {

    private final UserDAO userDAO;
    private final FormFactory formFactory;

    @Inject
    public UserController(UserDAO userDAO, FormFactory formFactory) {
        this.userDAO = userDAO;
        this.formFactory = formFactory;
    }

    public Result createUser(Http.Request request) {

        User user = Json.fromJson(request.body().asJson(), User.class);
        System.out.println(user);

        if (user == null) {
            return badRequest("Invalid JSON data");
        }

        try {
            userDAO.createUser(user);
            return ok("User created successfully");
        } catch (Exception e) {
            return internalServerError("Error saving user: " + e.getMessage());
        }
       // Form<User> userForm = formFactory.form(User.class).bindFromRequest(request);
//        User userForm = Json.fromJson(request.body().asJson(), User.class);
//
//        if (userForm.hasErrors()) {
//            return badRequest(userForm.errorsAsJson());
//        }
//        User user = userForm.get();
//        System.out.println(user);
//        userDAO.createUser(user);
//        return ok("User created");
    }

    public Result getUser(Long id) {
        User user = userDAO.getUser(id);
        if (user == null) {
            return notFound("User not found");
        }
        return ok(play.libs.Json.toJson(user));
    }

//
public Result updateUser(Http.Request request, Long id) {
    System.out.println("In controller");

    // Retrieve the existing user from the database
    User existingUser = userDAO.getUser(id);
    System.out.println(existingUser);
    if (existingUser == null) {
        return notFound("User not found");
    }

    // Parse the JSON body to create a User object
    JsonNode json = request.body().asJson();
    if (json == null) {
        return badRequest("Invalid JSON data");
    }

    User user = Json.fromJson(json, User.class);
    System.out.println("Json User"+user);

    // Optionally validate the user object here
    if (user == null) {
        return badRequest("User data is invalid");
    }

    // Retain existing user credentials
    existingUser.setEmail(user.getEmail());
    existingUser.setPassword(user.getPassword());

    // Update the user in the database
    userDAO.updateUser(user);

    return ok("User updated");
}



public Result deleteUser(Http.Request request, Long id) {
    System.out.println("deleteUser controller");
        userDAO.deleteUser(id);
        return ok("User deleted");
    }


    @Transactional
    public Result listUsers(Http.Request request) {

        System.out.println("Hit " + request);
        List<User> users = userDAO.getAllUsers();
        return ok(play.libs.Json.toJson(users));
    }
}
