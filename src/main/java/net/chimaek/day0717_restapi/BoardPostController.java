package net.chimaek.day0717_restapi;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/board-post")
public class BoardPostController {

    private final BoardPostService boardPostService;

    @Autowired
    public BoardPostController(BoardPostService boardPostService) {
        this.boardPostService = boardPostService;
    }

    @PostMapping
    public ResponseEntity<BoardPostDTO> createBoardPost(@RequestBody BoardPostDTO boardPostDTO) {
        BoardPostDTO createBoardPostDTO = boardPostService.createBoardPost(boardPostDTO);
        return ResponseEntity.ok(createBoardPostDTO);
    }

    @GetMapping
    private ResponseEntity<List<BoardPostDTO>> getAllBoardPosts() {
        List<BoardPostDTO> boardPostDTOS = boardPostService.getAllBoardPostsDto();
        return ResponseEntity.ok(boardPostDTOS);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BoardPostDTO> getBoardPostById(@PathVariable("id") Long id) {
        BoardPostDTO boardPostDTO = boardPostService.getBoardPostDtoById(id);
        return ResponseEntity.ok(boardPostDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBoardPost(@PathVariable("id") Long id) {
        boardPostService.deleteBoardPost(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<BoardPostDTO> updateBoardPost(@PathVariable("id") Long id, @RequestBody
    BoardPostDTO updateBoardPostDto) {
        BoardPostDTO updatedBoardPostDto = boardPostService.updateBoardPost(id, updateBoardPostDto);

        return ResponseEntity.ok(updatedBoardPostDto);
    }

    @PostMapping("/{postId}/comments")
    public ResponseEntity<CommentDTO> createComment(
        @PathVariable("postId") Long postId, @RequestBody CommentDTO createCommentDTO
    ) {
        CommentDTO createdCommentDTO = boardPostService.createComment(postId, createCommentDTO);
        return ResponseEntity.ok(createdCommentDTO);
    }

    @DeleteMapping("/{postId}/comments/{commentId}")
    public ResponseEntity<Void> deleteComment(@PathVariable("postId") Long postId,
        @PathVariable("commentId") Long commentId) {
        boardPostService.deleteComment(postId, commentId);
        return ResponseEntity.noContent().build();
    }
}
