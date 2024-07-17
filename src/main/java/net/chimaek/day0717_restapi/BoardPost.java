package net.chimaek.day0717_restapi;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BoardPost {

    private Long id;
    private String title;
    private String content;
    private String author;
    private LocalDateTime createAt;
    private LocalDateTime updateAt;
    private List<Comment> comments = new ArrayList<>();

    public void addComment(Comment comment) {
        comments.add(comment);
        comment.setBoardPost(this);
    }

    public void removeComment(Comment comment) {
        comments.remove(comment);
        comment.setBoardPost(null);
    }
}
