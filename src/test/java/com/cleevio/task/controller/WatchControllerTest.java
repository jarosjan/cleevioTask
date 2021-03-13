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
public class WatchControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private WatchService watchService;

    @Test
    public void createWatch() throws Exception {
        final String watch = "{\"title\": \"Prim\", \"price\" : \"250000\", \"description\": \"A watch with a water fountain picture\", " +
                "\"fountain\" : \"R0lGODlhAQABAIAAAAUEBAAAACwAAAAAAQABAAACAkQBADs=\"}";
        mockMvc.perform(MockMvcRequestBuilders.post("/watch")
                .content(watch)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isCreated());
    }

    @Test
    public void missingTitleAttribute() throws Exception {
        final String watch = "{\"price\" : \"250000\", \"description\": \"A watch with a water fountain picture\", " +
                "\"fountain\" : \"R0lGODlhAQABAIAAAAUEBAAAACwAAAAAAQABAAACAkQBADs=\"}";
        mockMvc.perform(MockMvcRequestBuilders.post("/watch")
                .content(watch)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andExpect(MockMvcResultMatchers
                        .jsonPath("$.errors").value("Title is mandatory."));
    }

    @Test
    public void missingPriceAttribute() throws Exception {
        final String watch = "{\"title\": \"Prim\", \"description\": \"A watch with a water fountain picture\", " +
                "\"fountain\" : \"R0lGODlhAQABAIAAAAUEBAAAACwAAAAAAQABAAACAkQBADs=\"}";
        mockMvc.perform(MockMvcRequestBuilders.post("/watch")
                .content(watch)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andExpect(MockMvcResultMatchers
                        .jsonPath("$.errors").value("Price must be greater than 1."));
    }

    @Test
    public void missingDescriptionAttribute() throws Exception {
        final String watch = "{\"title\": \"Prim\", \"price\" : \"250000\"," +
                "\"fountain\" : \"R0lGODlhAQABAIAAAAUEBAAAACwAAAAAAQABAAACAkQBADs=\"}";
        mockMvc.perform(MockMvcRequestBuilders.post("/watch")
                .content(watch)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andExpect(MockMvcResultMatchers
                        .jsonPath("$.errors").value("Description is mandatory."));
    }

    @Test
    public void missingFountainAttribute() throws Exception {
        final String watch = "{\"title\": \"Prim\", \"price\" : \"250000\", \"description\": \"A watch with a water fountain picture\"}";
        mockMvc.perform(MockMvcRequestBuilders.post("/watch")
                .content(watch)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andExpect(MockMvcResultMatchers
                        .jsonPath("$.errors").value("Photo 'fountain' must not be null."));
    }

}