package com.kuji.speechmanagementsystem.mapper;

import com.kuji.speechmanagementsystem.datatransferobject.SpeechDTO;
import com.kuji.speechmanagementsystem.model.Speech;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.time.LocalDate;

@Mapper(componentModel = "spring")
public interface SpeechMapper {
    @Mapping(target = "id", ignore = true)
    Speech toEntity(SpeechDTO speechDTO);
    SpeechDTO toDTO(Speech speech);

    default Speech updateSpeechFromDTO(SpeechDTO updatedSpeech, @MappingTarget Speech existingSpeech) {
        if (updatedSpeech.getAuthor() != null && !updatedSpeech.getAuthor().isEmpty()) {
            existingSpeech.setAuthor(updatedSpeech.getAuthor());
        }

        if (updatedSpeech.getSubject() != null && !updatedSpeech.getSubject().isEmpty()) {
            existingSpeech.setSubject(updatedSpeech.getSubject());
        }

        if (updatedSpeech.getContent() != null && !updatedSpeech.getContent().isEmpty()) {
            existingSpeech.setContent(updatedSpeech.getContent());
        }

        if (updatedSpeech.getSpeechDate() != null && !updatedSpeech.getSpeechDate().isEmpty()) {
            existingSpeech.setSpeechDate(LocalDate.parse(updatedSpeech.getSpeechDate()));
        }

        return existingSpeech;
    }
}
