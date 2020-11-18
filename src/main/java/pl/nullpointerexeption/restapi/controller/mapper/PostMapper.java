package pl.nullpointerexeption.restapi.controller.mapper;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import pl.nullpointerexeption.restapi.controller.model.PostModel;
import pl.nullpointerexeption.restapi.controller.view.PostView;
import pl.nullpointerexeption.restapi.repository.entity.Post;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PostMapper {

    public static List<PostView> mapToPostViews(List<Post> posts) {
        if (posts == null) {
            return new ArrayList<>();
        }
        return posts.stream()
                .map(PostMapper::mapToPostView)
                .collect(Collectors.toList());
    }

    public static PostView mapToPostView(Post post) {
        if (post == null) {
            return null;
        }
        return new PostView(post.getId(),
                post.getCreated(),
                post.getModified(),
                post.getTitle(),
                post.getContent(),
                post.getUser().getId(),
                CommentMapper.mapToCommentViews(post.getComments()));
    }

    public static Post mapToPost(PostModel postModel) {
        return Post.builder()
                .title(postModel.getTitle())
                .content(postModel.getContent())
                .build();
    }
}
