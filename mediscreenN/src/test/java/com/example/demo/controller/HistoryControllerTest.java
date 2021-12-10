package com.example.demo.controller;

import com.example.demo.dto.Consultation;
import com.example.demo.dto.HistoryDTO;
import com.example.demo.model.History;
import com.example.demo.service.HistoryService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(HistoryController.class)
class HistoryControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private HistoryService historyService;

    @Test
    void getAllHistorys() {
    }

    @Test
    void getHistoryById() throws Exception {
        MvcResult mvcResult = this.mockMvc.perform(get("/patHistory/id?id=1"))
                .andDo(print())
                .andReturn();
        int status = mvcResult.getResponse().getStatus();

        //Assert
        assertEquals(200, status);

        verify(historyService, times(1)).findHistoryById(any(String.class));
    }

    @Test
    void addHistory() throws Exception {
        HistoryDTO historyDTO = new HistoryDTO();
        List<Consultation> consultations = new ArrayList<>();
        Consultation consultation = new Consultation();
        historyDTO.setIdHistory("12");
        historyDTO.setObservations("sqsq");
        historyDTO.setRecommendations("azaq");
        History history = new History();
        consultation.setId("42");
        consultation.setRecommendations("azae");
        consultation.setObservations("asasa");
        consultations.add(consultation);
        history.setConsultations(consultations);
        history.setId("12");

        when(historyService.addHistory(historyDTO)).thenReturn(history);

        this.mockMvc.perform(post("/patHistory/add")
                        .contentType(MediaType.APPLICATION_JSON)
                .content(" {\n" +
                        "    \"idHistory\": \"82\",\n" +
                        "    \"idConsultation\":  \"82\",\n" +
                        "    \"recommendations\": \"asa\",\n" +
                        "    \"observations\": \"saa\"\n" +
                        "}")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());

        verify(historyService, times(1)).addHistory(any(HistoryDTO.class));
    }

    @Test
    void updateHistory() throws Exception {
        HistoryDTO historyDTO = new HistoryDTO();
        History history = new History();

        when(historyService.updateHistory(historyDTO)).thenReturn(history);

        this.mockMvc.perform(put("/patHistory/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(" {\n" +
                                "    \"idHistory\": \"82\",\n" +
                                "    \"idConsultation\":  \"82\",\n" +
                                "    \"recommendations\": \"asa\",\n" +
                                "    \"observations\": \"saa\"\n" +
                                "}")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        verify(historyService, times(1)).updateHistory(any(HistoryDTO.class));
    }

    @Test
    void deleteHistory() throws Exception {
        //Arrange
        History history = new History();
        history.setId("21");

        //Act
        this.mockMvc.perform(MockMvcRequestBuilders
                        .delete("/patHistory/{id}", history.getId().toString())
                        .param("idConsultation", history.getId().toString())
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        //Assert
        verify(historyService, times(1)).deleteHistory(anyString(), anyString());
    }


    @Test
    void testGetAllHistorys() throws Exception {
        List<History> historyList = new ArrayList<>();
        when(historyService.findAllHistory()).thenReturn(historyList);
        //Act
        this.mockMvc.perform(get("/patHistory/historys"))
                .andExpect(status().isOk())
                .andDo(print())
                .andReturn();
        //Assert
        verify(historyService, times(1)).findAllHistory();
    }

    @Test
    void testGetHistoryById() throws Exception{
        when(historyService.findHistoryById(any(String.class)))
                .thenReturn(new History());
    }
}
