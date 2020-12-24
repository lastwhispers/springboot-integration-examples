package cn.lastwhisper.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@SpringBootTest
public class UserRestControllerTest {

    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;

    @BeforeEach
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build(); //初始化MockMvc对象
    }

    @Test
    public void getUsers() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/user")
                .accept(MediaType.APPLICATION_JSON)).andDo(print());
    }

    @Test
    public void getUser() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/user/2")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk()) //添加断言
                .andDo(MockMvcResultHandlers.print()); //添加执行
    }

    @Test
    public void add() throws Exception {
        String json = "{ \"account\": \"jerry\",\"password\": \"123456\"," +
                "\"email\": \"jerry@163.com\",\"phone\": \"15036948712\"}";

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/user")
                .contentType(MediaType.APPLICATION_JSON).content(json))
                .andExpect(MockMvcResultMatchers.status().isCreated()) //添加断言
                .andDo(MockMvcResultHandlers.print()) //添加执行
                .andReturn();//添加返回

        System.out.println("新增成功的行数：" + mvcResult.getResponse().getContentAsString());
    }

    @Test
    public void update() throws Exception {
        String json = "{ \"userId\": 5, \"email\": \"jerry@qq.com\"}";

        mockMvc.perform(MockMvcRequestBuilders.put("/user")
                .contentType(MediaType.APPLICATION_JSON).content(json))
                .andExpect(MockMvcResultMatchers.status().isCreated()) //添加断言
                .andDo(MockMvcResultHandlers.print()); //添加执行
    }

    @Test
    public void delete() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/user/5"))
                .andExpect(MockMvcResultMatchers.status().isNoContent()) //添加断言
                .andDo(MockMvcResultHandlers.print()); //添加执行
    }
}