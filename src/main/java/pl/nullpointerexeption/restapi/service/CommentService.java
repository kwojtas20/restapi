package pl.nullpointerexeption.restapi.service;

import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import pl.nullpointerexeption.restapi.controller.mapper.CommentMapper;
import pl.nullpointerexeption.restapi.controller.model.CommentModel;
import pl.nullpointerexeption.restapi.controller.view.CommentView;
import pl.nullpointerexeption.restapi.repository.CommentRepository;
import pl.nullpointerexeption.restapi.repository.PostRepository;
import pl.nullpointerexeption.restapi.repository.entity.Comment;
import pl.nullpointerexeption.restapi.repository.entity.Post;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {

    public static final int PAGE_SIZE = 10;

    private final CommentRepository commentRepository;
    private final PostRepository postRepository;

    @Cacheable(cacheNames = "SingleComment", key = "#id")
    public CommentView getSingleComment(Long id) {
        return CommentMapper.mapToCommentView(commentRepository.findById(id).orElseThrow());
    }

    public CommentView addComment(CommentModel commentModel) {
        Post post = postRepository.findById(commentModel.getPostId()).orElseThrow();
        Comment comment = CommentMapper.mapToComment(commentModel);
        comment.setPost(post);
        return CommentMapper.mapToCommentView(commentRepository.save(comment));
    }

    public List<CommentView> getComments(int page, Sort.Direction sort) {
        return CommentMapper.mapToCommentViews(commentRepository.findAllComments(
                PageRequest.of(page, PAGE_SIZE, Sort.by(sort, "id"))
        ));
    }

    @CachePut(cacheNames = "SingleComment", key = "#result.id")
    public CommentView editComment(Long id, CommentModel comment) {
        Comment commentEdited = commentRepository.findById(id).orElseThrow();
        commentEdited.setContent(comment.getContent());
        return CommentMapper.mapToCommentView(commentRepository.save(commentEdited));
    }

    public void deleteComment(Long commentId) {
        commentRepository.deleteById(commentId);
    }
}
