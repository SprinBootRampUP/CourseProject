package org.example.springboot.Tests;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.springframework.security.test.context.support.WithMockUser;

@SpringBootTest
public class DemoTest {

    @Autowired
    private MockMvc mockMvc;


   @Test
    public void test() throws Exception {
        mockMvc.perform(post("/login")
                        .param("username", "user")
                        .param("password", "ss"))
                .andExpect(status().is3xxRedirection())
        .andExpect(redirectedUrl("/home"));

        mockMvc.perform(get("/admin"))
                .andExpect(status().isForbidden()); // Should be forbidden
    }

    @Test
    @WithMockUser(username = "user", roles = {"USER"})
    public void testAdminAccessForbiddenForUserRole() throws Exception {
        mockMvc.perform(get("/admin"))
                .andExpect(status().isForbidden()); // Should return 403 Forbidden
    }

}
