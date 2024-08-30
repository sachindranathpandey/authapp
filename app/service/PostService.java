package service;

import model.Post;

import java.util.ArrayList;
import java.util.List;

public class PostService {
   public static  List<Post> posts=new ArrayList<>();

    public static void addPost(){
        posts.add(new Post("Java","Java is a high-level, class-based, object-oriented programming language that is designed to have as few implementation dependencies as possible"));
        posts.add(new Post("Scala","Scala is a strong statically typed high-level general-purpose programming language that supports both object-oriented programming and functional programming. Designed to be concise, many of Scala's design decisions are intended to address"));
        posts.add(new Post("Python","Python is a high-level, general-purpose programming language. Its design philosophy emphasizes code readability with the use of significant indentation. Python is dynamically typed and garbage-collected. It supports multiple programming paradigms, including structured, object-oriented and functional programming."));
        posts.add(new Post("React","React is a free and open-source front-end JavaScript library for building user interfaces based on components by Facebook Inc. It is maintained by Meta and a community of individual developers and companies. React can be used to develop single-page, mobile, or server-rendered applications with"));
    }


    public static List<Post> getPosts(){
        return posts;
    }

}
