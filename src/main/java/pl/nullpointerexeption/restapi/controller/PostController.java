package pl.nullpointerexeption.restapi.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.nullpointerexeption.restapi.controller.dto.PostDto;
import pl.nullpointerexeption.restapi.controller.view.PostView;
import pl.nullpointerexeption.restapi.model.Post;
import pl.nullpointerexeption.restapi.service.PostService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/posts")
public class PostController {

    private final PostService postService;

    @GetMapping // Ta adnotacja oznacza utworzenie metody rest GET pod adresem /posts
    public List<PostView> getPosts(@RequestParam(required = false) Integer page,
                                   @RequestParam(required = false) Sort.Direction sortDirection) {
        return postService.getPosts(
                checkPageNumber(page),
                checkSortDirection(sortDirection)
        );
    }

    @GetMapping("/comments")
    public List<PostView> getPostsWithComment(@RequestParam(required = false) Integer page,
                                              @RequestParam(required = false) Sort.Direction sortDirection) {
        return postService.getPostsWithComments(
                checkPageNumber(page),
                checkSortDirection(sortDirection)
        );
    }

    @GetMapping("/{id}")
    public PostView getSinglePost(@PathVariable Long id) {
        return postService.getSinglePost(id);
    }

    @PostMapping
    public Post addPost(@RequestBody PostDto postDto) {
        return postService.addPost(postDto);
    }

    @PutMapping("/{id}")
    public Post editPost(@PathVariable Long id, @RequestBody PostDto postDto) {
        return postService.editPost(id, postDto);
    }

    private int checkPageNumber(Integer page) {
        return page != null && page >= 0 ? page : 0;
    }

    private Sort.Direction checkSortDirection(Sort.Direction sort) {
        return sort != null ? sort : Sort.Direction.ASC;
    }
}
