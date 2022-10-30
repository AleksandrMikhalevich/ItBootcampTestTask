package controller;

import app.Application;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import dto.UserDto;
import interfaces.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static entities.RoleName.CUSTOMER_USER;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author Alex Mikhalevich
 * @created 2022-10-30 15:16
 */
@SpringBootTest
@ContextConfiguration(classes = Application.class)
@AutoConfigureMockMvc
class AppControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @Test
    void shouldFindAllUsers() throws Exception {
        Page<UserDto> page = new PageImpl<>(List.of(new UserDto("Sally", "Jasonovich", "Tester",
                "sally.tester@itbootcamp.org", 3, CUSTOMER_USER)));
        when(userService.findAll()).thenReturn(page);
        List<UserDto> users = page.getContent();
        ObjectWriter objectWriter = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String outputJson = objectWriter.writeValueAsString(users);
        mockMvc.perform(get("/users").contentType(MediaType.APPLICATION_JSON).content(outputJson))
                .andExpect(status().isOk())
                .andExpect(content()
                        .contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    void shouldAddUser() throws Exception {
        UserDto user = new UserDto("Sally", "Jasonovich", "Tester",
                "sally.tester@itbootcamp.org", 3, CUSTOMER_USER);
        when(userService.addUser(user)).thenReturn(user);
        ObjectWriter objectWriter = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String inputJson = objectWriter.writeValueAsString(user);
        mockMvc.perform(post("/user").contentType(MediaType.APPLICATION_JSON).content(inputJson))
                .andExpect(status().isCreated())
                .andExpect(content()
                        .contentType(MediaType.APPLICATION_JSON));
    }
}