package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HistoryDTO {
    private String idHistory;
    private String idConsultation;
    private String recommendations;
    private String observations;
}
