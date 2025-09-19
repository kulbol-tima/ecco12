package kg.mlsp.esp.controller;

import kg.mlsp.security.config.SecurityConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(EspHomeController.class)
@Import(SecurityConfig.class)
class EspHomeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testGetInfo_Unauthenticated() throws Exception {
        mockMvc.perform(get("/test"))
                .andExpect(status().isUnauthorized());
    }

    @Test
    @WithMockUser
    void testGetInfo_Authenticated() throws Exception {
        mockMvc.perform(get("/test"))
                .andExpect(status().isOk());
    }
}
