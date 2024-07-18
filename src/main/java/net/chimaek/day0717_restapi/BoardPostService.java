package net.chimaek.day0717_restapi;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class BoardPostService {

    List<BoardPost> boardPosts = new ArrayList<>();
    private Long nextPostId = 1L;
    private Long nextCommentId = 1L;

    public BoardPostDTO createBoardPost(BoardPostDTO boardPostDTO) {
        BoardPost boardPost = convertToBoardPostEntity(boardPostDTO);
        boardPost.setId(nextPostId++);
        boardPost.setCreateAt(LocalDateTime.now());
        boardPosts.add(boardPost);
        return convertToBoardPostDto(boardPost);
    }

    private BoardPost convertToBoardPostEntity(BoardPostDTO boardPostDTO) {
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

    private BoardPostDTO convertToBoardPostDto(BoardPost boardPost) {
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

    private Comment convertToCommentEntity(CommentDTO commentDTO) {
        Comment comment = new Comment();
        comment.setId(commentDTO.getId());
        comment.setContent(commentDTO.getContent());
        comment.setAuthor(commentDTO.getAuthor());
        return comment;
    }

    private CommentDTO convertToCommentDto(Comment comment) {
        CommentDTO commentDTO = new CommentDTO();
        commentDTO.setId(comment.getId());
        commentDTO.setContent(comment.getContent());
        commentDTO.setAuthor(comment.getAuthor());
        commentDTO.setCreateAt(comment.getCreateAt());
        return commentDTO;
    }

    public List<BoardPostDTO> getAllBoardPostsDto() {
        return boardPosts.stream().map(this::convertToBoardPostDto).collect(Collectors.toList());
    }

    public BoardPostDTO getBoardPostDtoById(Long id) {
        log.info("헿헿헿");
        return boardPosts.stream()
            .filter(b -> b.getId().equals(id))
            .map(this::convertToBoardPostDto)
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException("그런 글 없습니다."));
    }

    public void deleteBoardPost(Long id) {
        boardPosts.remove(findBoardPostById(id));
    }

    private BoardPost findBoardPostById(Long id) {
        return boardPosts.stream()
            .filter(post -> post.getId().equals(id))
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException("id에 해당하는 글을 찾을수 없습니다."));
    }

    public BoardPostDTO updateBoardPost(Long id, BoardPostDTO updateBoardPostDto) {
        BoardPost boardPostById = findBoardPostById(id);
        boardPostById.setTitle(updateBoardPostDto.getTitle());
        boardPostById.setContent(updateBoardPostDto.getContent());
        boardPostById.setAuthor(updateBoardPostDto.getAuthor());
        boardPostById.setUpdateAt(LocalDateTime.now());
        return convertToBoardPostDto(boardPostById);
    }

    public CommentDTO createComment(Long postId, CommentDTO createCommentDTO) {
        BoardPost boardPostById = findBoardPostById(postId);
        Comment comment = convertToCommentEntity(createCommentDTO);
        comment.setId(nextCommentId++);
        comment.setCreateAt(LocalDateTime.now());
        boardPostById.addComment(comment);
        return convertToCommentDto(comment);
    }

    public void deleteComment(Long postId, Long commentId) {
        BoardPost boardPost = findBoardPostById(postId);
        Comment commentById = findCommentById(commentId, boardPost);
        boardPost.removeComment(commentById);
    }

    private Comment findCommentById(Long commentId, BoardPost boardPost) {
        return boardPost.getComments().stream()
            .filter(c -> c.getId().equals(commentId))
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException("댓글을 찾을 수 없습니다."));
    }
}
