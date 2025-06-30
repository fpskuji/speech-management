package com.kuji.speechmanagementsystem.datatransferobject;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class SpeechDTO {
    private String author;
    private String subject;
    private String content;
    private String speechDate;
}
