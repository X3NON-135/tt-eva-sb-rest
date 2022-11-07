package spring.boot.rest.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class ShopControllerTest {
    private static final String REQUEST_PARAM_NAME = "nameFilter";
    private static final String REGEX_PATTERN = "^.*[eva].*$";
    private static final String URL_ADDRESS = "/shop/product";

    @Autowired
    private MockMvc mockMvc;

    @Test
    void getStatus_with_filterName_ok() throws Exception {
        mockMvc.perform(get(URL_ADDRESS)
                .param(REQUEST_PARAM_NAME, REGEX_PATTERN))
                .andExpect(status().isOk());
    }

    @Test
    void getProducts_ok() throws Exception {
        mockMvc.perform(get(URL_ADDRESS)
                .param(REQUEST_PARAM_NAME, REGEX_PATTERN))
                .andDo(print());
    }
}
