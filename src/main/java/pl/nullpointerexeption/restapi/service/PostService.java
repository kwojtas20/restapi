package pl.nullpointerexeption.restapi.service;

import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import pl.nullpointerexeption.restapi.controller.dto.PostDto;
import pl.nullpointerexeption.restapi.controller.mapper.PostMapper;
import pl.nullpointerexeption.restapi.controller.view.PostView;
import pl.nullpointerexeption.restapi.model.Comment;
import pl.nullpointerexeption.restapi.model.Post;
import pl.nullpointerexeption.restapi.repository.CommentRepository;
import pl.nullpointerexeption.restapi.repository.PostRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostService {

    public static final int PAGE_SIZE = 20;
    private final PostRepository postRepository;
    private final CommentRepository commentRepository;

    public List<PostView> getPosts(int page, Sort.Direction sort) {
        return PostMapper.mapToPostViews(postRepository.findAllPosts(
                PageRequest.of(page, PAGE_SIZE, Sort.by(sort, "id"))
        ));
    }

    @Cacheable(cacheNames = "SinglePost", key = "#id")
    public PostView getSinglePost(long id) {
        return PostMapper.mapToPostView(postRepository.findById(id).orElseThrow());
    }

    @Cacheable(cacheNames = "PostsWithComments")
    public List<PostView> getPostsWithComments(int pageNumber, Sort.Direction sort) {
        List<Post> allPosts = postRepository.findAllPosts(PageRequest.of(pageNumber, PAGE_SIZE,
                Sort.by(sort, "id")
        ));
        List<Long> ids = allPosts.stream()
                .map(Post::getId)
                .collect(Collectors.toList());
        List<Comment> comments = commentRepository.findAllByPostIdIn(ids);
        allPosts.forEach(post -> post.setComments(extractComments(comments, post.getId())));
        return PostMapper.mapToPostViews(allPosts);
    }

    private List<Comment> extractComments(List<Comment> comments, Long id) {
        return comments.stream()
                .filter(comment -> comment.getPostId().equals(id))
                .collect(Collectors.toList());
    }

    public Post addPost(PostDto post) {
        return postRepository.save(PostMapper.mapToPost(post));
    }

    // FIXME
    @CachePut(cacheNames = "SinglePost", key = "#result.id")
    public Post editPost(Long id, PostDto post) {
        Post postEdited = postRepository.findById(id).orElseThrow();
        postEdited.setId(id);
        postEdited.setTitle(post.getTitle());
        postEdited.setContent(post.getContent());
        return postRepository.save(postEdited);
    }

    @CacheEvict(cacheNames = "SinglePost")
    public void deletePost(long id) {
        postRepository.deleteById(id);
    }

    @CacheEvict(cacheNames = "PostsWithComments")
    public void clearPostsWithComments() {

    }

    public PostView getPostWithComments(Long postId) {
        Post post = postRepository.findById(postId).orElseThrow();
        List<Comment> comments = commentRepository.findAllByPostId(post.getId());
        post.setComments(comments);
        return PostMapper.mapToPostView(post);
    }
}
