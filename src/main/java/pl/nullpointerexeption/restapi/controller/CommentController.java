package pl.nullpointerexeption.restapi.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.nullpointerexeption.restapi.controller.model.CommentModel;
import pl.nullpointerexeption.restapi.controller.validator.CommentValidator;
import pl.nullpointerexeption.restapi.controller.view.CommentView;
import pl.nullpointerexeption.restapi.service.CommentService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/comments")
public class CommentController {

    private final CommentService commentService;
    private final CommentValidator commentValidator;

    @GetMapping("/{commentId}")
    public CommentView getSingleComment(@PathVariable Long commentId) {
        return commentService.getSingleComment(commentId);
    }

    @PostMapping
    public CommentView addComment(@RequestBody CommentModel commentModel) {
        commentValidator.checkCommentModel(commentModel);
        return commentService.addComment(commentModel);
    }

    @GetMapping // Ta adnotacja oznacza utworzenie metody rest GET pod adresem /posts
    public List<CommentView> getComments(@RequestParam(required = false) Integer page,
                                         @RequestParam(required = false) Sort.Direction sortDirection) {
        return commentService.getComments(
                checkPageNumber(page),
                checkSortDirection(sortDirection)
        );
    }

    @PutMapping("/{commentId}")
    public CommentView editComment(@PathVariable Long commentId, @RequestBody CommentModel commentModel) {
        commentValidator.checkCommentModel(commentModel);
        return commentService.editComment(commentId, commentModel);
    }

    @DeleteMapping("/{commentId}")
    public void deleteComment(@PathVariable Long commentId) {
        commentService.deleteComment(commentId);
    }

    @DeleteMapping
    public void deleteAllComments() {
        commentService.deleteAllComments();
    }

    private int checkPageNumber(Integer page) {
        return page != null && page >= 0 ? page : 0;
    }

    private Sort.Direction checkSortDirection(Sort.Direction sort) {
        return sort != null ? sort : Sort.Direction.ASC;
    }
}
