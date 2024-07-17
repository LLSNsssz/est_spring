package net.chimaek.day0717_restapi;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class BoardPostService {

    List<BoardPost> boardPosts = new ArrayList<>();
    private Long nextPostId = 1L;
    private Long nextCommentId = 1L;

    public BoardPostDTO createBoardPost(BoardPostDTO boardPostDTO) {
        return convertToBoardPostEntity(boardPostDTO);
    }

    private static BoardPost convertToBoardPostEntity(BoardPostDTO boardPostDTO) {
        BoardPost boardPost = new BoardPost();
        boardPost.setTitle(boardPostDTO.getTitle());
        boardPost.setContent(boardPostDTO.getContent());
        boardPost.setAuthor(boardPostDTO.getAuthor());
        if (boardPostDTO.getComments() != null) {
            boardPostDTO.getComments().forEach(commentDTO -> {
                Comment comment = convertToCommentEntity(commentDTO);
                comment.setBoardPost(boardPost);
                boardPost.addComment(comment);
            });
        }
        return boardPost;
    }

    private static BoardPostDTO convertToBoardPostDto(BoardPost boardPost) {
        BoardPostDTO boardPostDTO = new BoardPostDTO();
        boardPostDTO.setId(boardPost.getId());
        boardPostDTO.setTitle(boardPost.getTitle());
        boardPostDTO.setContent(boardPost.getContent());
        boardPostDTO.setAuthor(boardPost.getAuthor());
        boardPostDTO.setCreateAt(boardPost.getCreateAt());
        boardPostDTO.setUpdateAt(boardPost.getUpdateAt());

        if (boardPost.getComments() != null) {
            boardPostDTO.setComments(
                boardPost.getComments().stream().map(this::convertToCommentDto)
                    .collect(Collectors.toList())
            );
        }
        return boardPostDTO;
    }
}
