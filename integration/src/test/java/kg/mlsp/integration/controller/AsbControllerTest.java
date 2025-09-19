package kg.mlsp.integration.controller;

import kg.mlsp.integration.service.AsbFeignClient;
import kg.mlsp.security.config.SecurityConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(AsbController.class)
@Import(SecurityConfig.class)
class AsbControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AsbFeignClient asbFeignClient;

    @Test
    void testGetAddress_Unauthenticated() throws Exception {
        mockMvc.perform(get("/api/asb/get-address?pin=123"))
                .andExpect(status().isUnauthorized());
    }

    @Test
    @WithMockUser
    void testGetAddress_Authenticated() throws Exception {
        mockMvc.perform(get("/api/asb/get-address?pin=123"))
                .andExpect(status().isOk());
    }
}
