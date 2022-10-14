package com.db.transform.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ControllerTest {
    @Autowired
    MockMvc mockMvc;

    @Test
    public void whenJsonConverterIsFound_thenReturnResponse() throws Exception {

        //Given
        String url = "http://localhost:8080/mapJsontoXML";

        String xml = "<RequestModel>\n" +
                "    <id>1</id>\n" +
                "    <name>javapedia.net</name>\n" +
                "    <skillSet>\n" +
                "        <skillSet>\n" +
                "            <skillName>java</skillName>\n" +
                "            <category>server programming</category>\n" +
                "        </skillSet>\n" +
                "        <skillSet>\n" +
                "            <skillName>angular</skillName>\n" +
                "            <category>frontend programming</category>\n" +
                "        </skillSet>\n" +
                "        <skillSet>\n" +
                "            <skillName>mongodb</skillName>\n" +
                "            <category>database</category>\n" +
                "        </skillSet>\n" +
                "    </skillSet>\n" +
                "</RequestModel>";

        String json = "{\n" +
                "  \"id\": 1,\n" +
                "  \"name\": \"javapedia.net\",\n" +
                "  \"skillSet\": [\n" +
                "    {\n" +
                "      \"skillName\": \"java\",\n" +
                "      \"category\": \"server programming\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"skillName\": \"angular\",\n" +
                "      \"category\": \"frontend programming\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"skillName\": \"mongodb\",\n" +
                "      \"category\": \"database\"\n" +
                "    }\n" +
                "  ]\n" +
                "}";
        // When
        this.mockMvc.perform(post(url)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))

                //Then
                .andExpect(status().isOk())
                .andExpect(content().xml(xml));
    }
}
