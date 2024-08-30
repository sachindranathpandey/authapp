package form;

import play.data.validation.Constraints;

import javax.validation.Constraint;

public class PostForm {
    @Constraints.Required
    private String title;

    @Constraints.Required
    @Constraints.MaxLength(50)
    private String content;

    public PostForm(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "PostForm{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
