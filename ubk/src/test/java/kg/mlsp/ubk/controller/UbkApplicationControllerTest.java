package kg.mlsp.ubk.controller;

import kg.mlsp.security.config.SecurityConfig;
import kg.mlsp.ubk.service.UbkApplicationService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(UbkApplicationController.class)
@Import(SecurityConfig.class)
class UbkApplicationControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UbkApplicationService ubkApplicationService;

    @Test
    void testGetById_Unauthenticated() throws Exception {
        mockMvc.perform(get("/applications/1"))
                .andExpect(status().isUnauthorized());
    }

    @Test
    @WithMockUser
    void testGetById_Authenticated() throws Exception {
        mockMvc.perform(get("/applications/1"))
                .andExpect(status().isOk());
    }
}
