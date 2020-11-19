package pl.nullpointerexeption.restapi.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import pl.nullpointerexeption.restapi.controller.view.PostView;
import pl.nullpointerexeption.restapi.repository.PostRepository;
import pl.nullpointerexeption.restapi.repository.UserRepository;
import pl.nullpointerexeption.restapi.repository.entity.Post;
import pl.nullpointerexeption.restapi.repository.entity.User;

import javax.transaction.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@WithMockUser
class PostControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserRepository userRepository;

    @Test
    @Transactional
    void shouldGetSinglePost() throws Exception {
        // given
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
        // when
        MvcResult mvcResult = mockMvc.perform(get("/posts/" + newPost.getId()))
                .andDo(print())
                .andExpect(status().isOk())
//        .andExpect(jsonPath("$.id", Matchers.is(1)));
                .andReturn();
        //then
        PostView postView = objectMapper.readValue(mvcResult.getResponse().getContentAsString(), PostView.class);
        assertThat(postView).isNotNull();
        assertThat(postView.getId()).isEqualTo(newPost.getId());
        assertThat(postView.getTitle()).isEqualTo(newPost.getTitle());
        assertThat(postView.getContent()).isEqualTo(newPost.getContent());
    }
}
