//package controllers;
//
//import form.PostForm;
//import model.User;
//import play.data.Form;
//import play.data.FormFactory;
//import play.mvc.*;
//import java.util.*;
//import model.Post;
//import service.PostService;
//import javax.inject.Inject;
//import dao.UserDAO;
//
//
///**
// * This controller contains an action to handle HTTP requests
// * to the application's home page.
// */
//public class HomeController extends Controller {
//
//
//
//
//    public HomeController() {
//
//    }
//    public Result index() {
//
//        return ok(views.html.index.render());
//    }
//
//
//
//    public Result submitPost() {
//        UserDAO ud=new UserDAO();
//        User user=new User();
//        user.setEmail("test@gmail.com");
//        user.setPassword("12345");
//        return ok(views.html.newpost.render());
//    }
//
//}
