package com.kuji.speechmanagementsystem.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Speech {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String author;
    private String subject;
    @Lob
    private String content;
    private LocalDate speechDate;

    @Override
    public String toString() {
        return "Speech{" +
                "id=" + id +
                ", author='" + author + '\'' +
                ", subject='" + subject + '\'' +
                ", content='" + content + '\'' +
                ", speechDate=" + speechDate +
                '}';
    }
}
