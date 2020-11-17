package pl.nullpointerexeption.restapi.controller.mapper;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import pl.nullpointerexeption.restapi.controller.model.CommentModel;
import pl.nullpointerexeption.restapi.controller.view.CommentView;
import pl.nullpointerexeption.restapi.repository.entity.Comment;

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
                comment.getCreated(),
                comment.getModified(),
                comment.getContent(),
                comment.getPost().getId());
    }

    public static Comment mapToComment(CommentModel commentModel) {
        return Comment.builder()
                .content(commentModel.getContent())
                .build();
    }
}
