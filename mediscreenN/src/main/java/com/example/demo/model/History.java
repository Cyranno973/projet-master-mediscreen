package com.example.demo.model;

import com.example.demo.dto.Consultation;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.management.ConstructorParameters;
import java.util.List;

@Data
@Document
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class History {
    @Id
    private String id;
    private List<Consultation> consultations;
}
