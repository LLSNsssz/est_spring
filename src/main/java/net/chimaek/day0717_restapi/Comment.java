package net.chimaek.day0717_restapi;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Comment {
    private Long id;
    private String content;
    private String author;
    private LocalDateTime createAt;
    private BoardPost boardPost;
}
