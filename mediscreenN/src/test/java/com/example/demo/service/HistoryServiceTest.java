package com.example.demo.service;

import com.example.demo.dto.Consultation;
import com.example.demo.dto.HistoryDTO;
import com.example.demo.model.History;
import com.example.demo.repo.HistoryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
@WebMvcTest
class HistoryServiceTest {


    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private HistoryService historyService;


    @Mock
    HistoryRepository historyRepository;

    @MockBean
    private List<History> historys;

    private History history;

    @BeforeEach
    void setUp(){
//        Consultation consultation = new Consultation();
//        List<Consultation> consultations = new ArrayList<>();
//        this.historys.add(new History("12", consultations));
//        consultation.setId("12");
//        consultation.setObservations("le patient est debout");
//        consultation.setRecommendations("le patient est assis");
//        consultations.add(consultation);
//        this.historyList.add(new History("20", consultations));
    }
    @Test
    void findAllHistory() {
        when(historyRepository.findAll()).thenReturn(historys);

        List<History> newList = historyService.findAllHistory();
        assertEquals(1, newList.size());

        verify(historyRepository, times(1)).findAll();
    }

//    @Test
//    void addHistory() {
//        History history = new History();
//        List<Consultation> consultations = new ArrayList<>();
//        Consultation consultation = new Consultation();
//        consultation.setId("42");
//        consultation.setRecommendations("azae");
//        consultation.setObservations("asasa");
//        consultations.add(consultation);
//        history.setId("zdz");
//        history.setConsultations(consultations);
//
//        HistoryDTO historyDTO = new HistoryDTO();
//        historyDTO.setIdHistory("122");
//        historyDTO.setRecommendations("adada");
//        historyDTO.setObservations("dazdada");
//        historyService.addHistory(historyDTO);
//        verify(historyRepository, times(1)).save(history);
//
//    }

    @Test
    void findHistoryById() {
    }

    @Test
    void deleteHistory() {
    }

    @Test
    void updateHistory() {
    }
}
