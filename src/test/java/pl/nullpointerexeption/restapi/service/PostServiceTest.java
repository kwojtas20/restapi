package pl.nullpointerexeption.restapi.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.nullpointerexeption.restapi.controller.view.PostView;
import pl.nullpointerexeption.restapi.repository.PostRepository;
import pl.nullpointerexeption.restapi.repository.UserRepository;
import pl.nullpointerexeption.restapi.repository.entity.Post;
import pl.nullpointerexeption.restapi.repository.entity.User;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class PostServiceTest {

    @Autowired
    private PostService postService;

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserRepository userRepository;

    @Test
    void shouldGetSinglePost() {
        //given
        User newUser = new User();
        newUser.setFirstName("Kinga");
        newUser.setSecondName("Maria");
        newUser.setSurname("Wojtaś");
        userRepository.save(newUser);

        Post newPost = new Post();
        newPost.setTitle("Test");
        newPost.setContent("Test content");
        newPost.setUser(newUser);
        postRepository.save(newPost);
        //when
        PostView singlePost = postService.getSinglePost(newPost.getId());
        //then
        assertThat(singlePost).isNotNull();
        assertThat(singlePost.getId()).isEqualTo(newPost.getId());
    }

    @Test
    void shouldGetAllPosts() {
        //given
        User newUser = new User();
        newUser.setFirstName("Kinga");
        newUser.setSecondName("Maria");
        newUser.setSurname("Wojtaś");
        userRepository.save(newUser);

        Post newPost = new Post();
        newPost.setTitle("Test");
        newPost.setContent("Test content");
        newPost.setUser(newUser);
        postRepository.save(newPost);
        //when
        //that
    }
}