package pl.nullpointerexeption.restapi.controller.mapper;

import org.junit.jupiter.api.Test;
import pl.nullpointerexeption.restapi.controller.model.PostModel;
import pl.nullpointerexeption.restapi.controller.view.PostView;
import pl.nullpointerexeption.restapi.repository.entity.Post;
import pl.nullpointerexeption.restapi.repository.entity.User;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PostMapperTest {

    @Test
    void shouldMapToPostViews() {
        //given
        Post post1 = new Post();
        post1.setContent("post1");
        post1.setTitle("tutuł1");
        post1.setId(1L);
        post1.setCreated(LocalDateTime.of(2020, Month.AUGUST, 1, 12, 45));
        post1.setModified(LocalDateTime.of(2019, Month.AUGUST, 1, 12, 45));
        post1.setUser(new User());

        Post post2 = new Post();
        post2.setContent("post2");
        post2.setTitle("tutuł2");
        post2.setId(2L);
        post2.setCreated(LocalDateTime.of(2020, Month.AUGUST, 1, 12, 45));
        post2.setModified(LocalDateTime.of(2019, Month.AUGUST, 1, 12, 45));
        post2.setUser(new User());

        List<Post> posts = new ArrayList<>();
        posts.add(post1);
        posts.add(post2);
        //when
        List<PostView> postViews = PostMapper.mapToPostViews(posts);
        //then
        assertThat(postViews).isNotNull();
        assertThat(postViews.size()).isEqualTo(posts.size());
    }

    @Test
    void shouldMapToPostView() {
        //given
        Post post1 = new Post();
        post1.setContent("post1");
        post1.setTitle("tutuł1");
        post1.setId(1L);
        post1.setCreated(LocalDateTime.of(2020, Month.AUGUST, 1, 12, 45));
        post1.setModified(LocalDateTime.of(2019, Month.AUGUST, 1, 12, 45));
        post1.setUser(new User());
        //when
        PostView postView = PostMapper.mapToPostView(post1);
        //than
        assertThat(postView).isNotNull();
        assertThat(postView.getContent()).isEqualTo(post1.getContent());
        assertThat(postView.getTitle()).isEqualTo(post1.getTitle());
        assertThat(postView.getId()).isEqualTo(post1.getId());
        assertThat(postView.getCreated()).isEqualTo(post1.getCreated());
        assertThat(postView.getModified()).isEqualTo(post1.getModified());
    }

    @Test
    void shouldReturnNullWhenPostIsNull() {
        //when
        PostView postView = PostMapper.mapToPostView(null);
        //expect
        assertNull(postView);
    }

    @Test
    void shouldReturnEmptyListNullWhenPostListIsNull() {
        //when
        List<PostView> postViews = PostMapper.mapToPostViews(null);
        //expect
        assertTrue(postViews.isEmpty());
    }

    @Test
    void shouldMapToPosts() {
        //given
        List<PostModel> postModels = new ArrayList<>();
        postModels.add(new PostModel("tytył1", "post1", 1L));
        postModels.add(new PostModel("tytył2", "post2", 2L));
        //when
        List<Post> posts = PostMapper.mapToPosts(postModels);
        //than
        assertThat(posts).isNotNull();
        assertThat(posts.size()).isEqualTo(postModels.size());
    }

    @Test
    void shouldMapToPost() {
        //given
        PostModel postModel = new PostModel("tytuł1", "post1", 1L);
        Post.builder().content("post1");
        Post.builder().title("tytuł1");
        Post.builder().build();
        //when
        Post post = PostMapper.mapToPost(postModel);
        //than
        assertThat(post).isNotNull();
        assertThat(post.getTitle()).isEqualTo(postModel.getTitle());
        assertThat(post.getContent()).isEqualTo(postModel.getContent());
    }

    @Test
    void shouldReturnNullWhenPostModelIsNull() {
        //when
        Post post = PostMapper.mapToPost(null);
        //expect
        assertNull(post);
    }

    @Test
    void shouldReturnEmptyListWhenPostModelListIsNull() {
        //when
        List<Post> posts = PostMapper.mapToPosts(null);
        //expect
        assertTrue(posts.isEmpty());
    }
}