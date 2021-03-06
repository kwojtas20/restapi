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
import pl.nullpointerexeption.restapi.controller.model.PostModel;
import pl.nullpointerexeption.restapi.controller.validator.PostValidator;
import pl.nullpointerexeption.restapi.controller.view.PostView;
import pl.nullpointerexeption.restapi.service.PostService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/posts")
public class PostController {

    private final PostService postService;
    private final PostValidator postValidator;

    @GetMapping // Ta adnotacja oznacza utworzenie metody rest GET pod adresem /posts
    public List<PostView> getPosts(@RequestParam(required = false) Integer page,
                                   @RequestParam(required = false) Sort.Direction sortDirection) {
        return postService.getPosts(
                checkPageNumber(page),
                checkSortDirection(sortDirection)
        );
    }

    @GetMapping("/comments")
    public List<PostView> getPostsWithComments(@RequestParam(required = false) Integer page,
                                               @RequestParam(required = false) Sort.Direction sortDirection) {
        return postService.getPostsWithComments(
                checkPageNumber(page),
                checkSortDirection(sortDirection)
        );
    }

    @GetMapping("/{postId}/comments")
    public PostView getPostWithComments(@PathVariable Long postId) {
        return postService.getPostWithComments(postId);
    }

    @GetMapping("/{postId}")
    public PostView getSinglePost(@PathVariable Long postId) {
        return postService.getSinglePost(postId);
    }

    @PostMapping
    public PostView addPost(@RequestBody PostModel postModel) {
        postValidator.checkPostModel(postModel);
        return postService.addPost(postModel);
    }

    @PutMapping("/{postId}")
    public PostView editPost(@PathVariable Long postId, @RequestBody PostModel postModel) {
        postValidator.checkPostModel(postModel);
        return postService.editPost(postId, postModel);
    }

    @DeleteMapping("/{postId}")
    public void deletePost(@PathVariable Long postId) {
        postService.deletePost(postId);
    }

    @DeleteMapping
    public void deleteAllPosts() {
        postService.deleteAllPosts();
    }

    private int checkPageNumber(Integer page) {
        return page != null && page >= 0 ? page : 0;
    }

    private Sort.Direction checkSortDirection(Sort.Direction sort) {
        return sort != null ? sort : Sort.Direction.ASC;
    }
}
