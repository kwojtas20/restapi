package pl.nullpointerexeption.restapi.controller.mapper;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import pl.nullpointerexeption.restapi.controller.dto.PostDto;
import pl.nullpointerexeption.restapi.controller.view.PostView;
import pl.nullpointerexeption.restapi.model.Post;

import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PostMapper {

    public static List<Post> mapToPosts(List<PostDto> postDtos) {
        return postDtos.stream()
                .map(PostMapper::mapToPost)
                .collect(Collectors.toList());
    }

    public static List<PostView> mapToPostViews(List<Post> posts) {
        return posts.stream()
                .map(PostMapper::mapToPostView)
                .collect(Collectors.toList());
    }

    public static Post mapToPost(PostDto postDto) {
        return Post.builder()
                .title(postDto.getTitle())
                .content(postDto.getContent())
                .build();
    }

    public static PostView mapToPostView(Post post) {
        return new PostView(post.getId(),
                post.getTitle(),
                post.getContent(),
                CommentMapper.mapToCommentViews(post.getComments()),
                post.getCreated(),
                post.getModified());
    }
}
