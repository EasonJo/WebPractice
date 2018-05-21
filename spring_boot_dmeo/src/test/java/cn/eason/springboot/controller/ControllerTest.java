package cn.eason.springboot.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * @author Eason
 * @date Create in 16:36 15/05/2018
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ControllerTest {

    //使用 Mock 来测试 API
    private MockMvc mockMVC;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Before
    public void initMock() {
        mockMVC = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void testHello() throws Exception {
        mockMVC.perform(MockMvcRequestBuilders.get("hello").accept(MediaType.APPLICATION_JSON_UTF8)).andDo
            (MockMvcResultHandlers.print());
    }

    @Test
    public void getAll() throws Exception {
        mockMVC.perform(MockMvcRequestBuilders.get("all").accept(MediaType.APPLICATION_JSON_UTF8)).andDo(MockMvcResultHandlers.print());
    }

}
