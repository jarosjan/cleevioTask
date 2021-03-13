package com.cleevio.task.controller;

import com.cleevio.task.service.WatchService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringRunner.class)
@WebMvcTest(WatchController.class)
@AutoConfigureMockMvc
public class WatchControllerXmlTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private WatchService watchService;

    @Test
    public void createWatchXML() throws Exception {
        final String watch =
                "<watch>\n" +
                "  <title>Prim</title>\n" +
                "  <price>250000</price>\n" +
                "  <description>A watch with a water fountain picture</description>\n" +
                "  <fountain>R0lGODlhAQABAIAAAAUEBAAAACwAAAAAAQABAAACAkQBADs=</fountain>\n" +
                "</watch>";
        mockMvc.perform(MockMvcRequestBuilders.post("/watch")
                .content(watch)
                .contentType(MediaType.APPLICATION_XML))
                .andExpect(MockMvcResultMatchers.status().isCreated());
    }

    @Test
    public void missingTitleAttributeXML() throws Exception {
        final String watch =
                "<watch>\n" +
                "  <price>250000</price>\n" +
                "  <description>A watch with a water fountain picture</description>\n" +
                "  <fountain>R0lGODlhAQABAIAAAAUEBAAAACwAAAAAAQABAAACAkQBADs=</fountain>\n" +
                "</watch>";
        mockMvc.perform(MockMvcRequestBuilders.post("/watch")
                .content(watch)
                .contentType(MediaType.APPLICATION_XML))
                .andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andExpect(MockMvcResultMatchers
                        .jsonPath("$.errors").value("Title is mandatory."));
    }

    @Test
    public void missingPriceAttributeXML() throws Exception {
        final String watch =
                "<watch>\n" +
                "  <title>Prim</title>\n" +
                "  <description>A watch with a water fountain picture</description>\n" +
                "  <fountain>R0lGODlhAQABAIAAAAUEBAAAACwAAAAAAQABAAACAkQBADs=</fountain>\n" +
                "</watch>";
        mockMvc.perform(MockMvcRequestBuilders.post("/watch")
                .content(watch)
                .contentType(MediaType.APPLICATION_XML))
                .andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andExpect(MockMvcResultMatchers
                        .jsonPath("$.errors").value("Price must be greater than 1."));
    }

    @Test
    public void missingDescriptionAttributeXML() throws Exception {
        final String watch =
                "<watch>\n" +
                "  <title>Prim</title>\n" +
                "  <price>250000</price>\n" +
                "  <fountain>R0lGODlhAQABAIAAAAUEBAAAACwAAAAAAQABAAACAkQBADs=</fountain>\n" +
                "</watch>";
        mockMvc.perform(MockMvcRequestBuilders.post("/watch")
                .content(watch)
                .contentType(MediaType.APPLICATION_XML))
                .andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andExpect(MockMvcResultMatchers
                        .jsonPath("$.errors").value("Description is mandatory."));
    }

    @Test
    public void missingFountainAttributeXML() throws Exception {
        final String watch =
                "<watch>\n" +
                "  <title>Prim</title>\n" +
                "  <price>250000</price>\n" +
                "  <description>A watch with a water fountain picture</description>\n" +
                "</watch>";
        mockMvc.perform(MockMvcRequestBuilders.post("/watch")
                .content(watch)
                .contentType(MediaType.APPLICATION_XML))
                .andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andExpect(MockMvcResultMatchers
                        .jsonPath("$.errors").value("Photo 'fountain' must not be null."));
    }
}