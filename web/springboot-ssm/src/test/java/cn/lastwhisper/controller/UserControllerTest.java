package cn.cunchang.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.MultiValueMap;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@SpringBootTest
public class UserControllerTest {

    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;

    @BeforeEach
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build(); //初始化MockMvc对象
    }

    @Test
    public void getUsers() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/user/list")
                .accept(MediaType.APPLICATION_JSON)).andDo(print());
    }

    @Test
    public void getUser() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/user/detail")
                .param("id", "1")
                .accept(MediaType.APPLICATION_JSON)).andDo(print());
    }

    @Test
    public void add() throws Exception {
        MultiValueMap<String, String> map = new HttpHeaders();

        mockMvc.perform(MockMvcRequestBuilders.post("/user/add")
                .param("account", "scott")
                .param("password", "123456")
                .param("email", "1505754621@163.com")
                .param("phone", "1505754621")
                .accept(MediaType.APPLICATION_JSON)).andDo(print());
    }

    @Test
    public void update() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/user/update")
                .param("userId", "4")
                .param("email", "1505754621@qq.com")
                .accept(MediaType.APPLICATION_JSON)).andDo(print());
    }

    @Test
    public void delete() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/user/delete")
                .param("id", "4")
                .accept("application/json;charset=UTF-8")).andDo(print());
    }
}