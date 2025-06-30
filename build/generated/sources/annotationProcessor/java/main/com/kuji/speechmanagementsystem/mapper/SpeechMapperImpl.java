package com.kuji.speechmanagementsystem.mapper;

import com.kuji.speechmanagementsystem.datatransferobject.SpeechDTO;
import com.kuji.speechmanagementsystem.model.Speech;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-07-01T01:53:13+0800",
    comments = "version: 1.6.3, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.14.2.jar, environment: Java 17.0.12 (Oracle Corporation)"
)
@Component
public class SpeechMapperImpl implements SpeechMapper {

    @Override
    public Speech toEntity(SpeechDTO speechDTO) {
        if ( speechDTO == null ) {
            return null;
        }

        Speech speech = new Speech();

        speech.setAuthor( speechDTO.getAuthor() );
        speech.setSubject( speechDTO.getSubject() );
        speech.setContent( speechDTO.getContent() );
        if ( speechDTO.getSpeechDate() != null ) {
            speech.setSpeechDate( LocalDate.parse( speechDTO.getSpeechDate() ) );
        }

        return speech;
    }

    @Override
    public SpeechDTO toDTO(Speech speech) {
        if ( speech == null ) {
            return null;
        }

        SpeechDTO speechDTO = new SpeechDTO();

        speechDTO.setAuthor( speech.getAuthor() );
        speechDTO.setSubject( speech.getSubject() );
        speechDTO.setContent( speech.getContent() );
        if ( speech.getSpeechDate() != null ) {
            speechDTO.setSpeechDate( DateTimeFormatter.ISO_LOCAL_DATE.format( speech.getSpeechDate() ) );
        }

        return speechDTO;
    }
}
