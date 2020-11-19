package pl.nullpointerexeption.restapi.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class LoginControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void shouldLoginAndGetContent() throws Exception {
        // when
        MvcResult loginResult = mockMvc.perform(post("/login")
                .content("{\"username\": \"string\", \"password\": \"string\"}"))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
        String token = loginResult.getResponse().getHeader("Authorization");

        mockMvc.perform(get("/secured")
                .header("Authorization", token)
        )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("secured"));

        mockMvc.perform(get("/secured")
                .header("Authorization", "wrongToken")
        )
                .andDo(print())
                .andExpect(status().isUnauthorized());

        mockMvc.perform(get("/secured"))
                .andDo(print())
                .andExpect(status().isUnauthorized());
    }
}
