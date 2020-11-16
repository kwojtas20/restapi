package pl.nullpointerexeption.restapi.controller.mapper;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import pl.nullpointerexeption.restapi.controller.view.CommentView;
import pl.nullpointerexeption.restapi.entity.Comment;

import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CommentMapper {

    public static List<CommentView> mapToCommentViews(List<Comment> comments) {
        return comments.stream()
                .map(CommentMapper::mapToCommentView)
                .collect(Collectors.toList());
    }

    public static CommentView mapToCommentView(Comment comment) {
        return new CommentView(comment.getId(),
                comment.getPostId(),
                comment.getContent(),
                comment.getCreated(),
                comment.getModified());
    }
}
