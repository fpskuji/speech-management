package com.kuji.speechmanagementsystem.service;

import com.kuji.speechmanagementsystem.datatransferobject.SpeechDTO;
import com.kuji.speechmanagementsystem.mapper.SpeechMapper;
import com.kuji.speechmanagementsystem.model.Speech;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kuji.speechmanagementsystem.repository.SpeechManagementRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.logging.Logger;

@Service
public class SpeechManagementService {
    private final Logger logger = Logger.getLogger(SpeechManagementService.class.getName());

    @Autowired
    SpeechMapper speechMapper;

    @Autowired
    SpeechManagementRepository speechManagementRepository;

    @Autowired
    private EmailService emailService;

    public List<Speech> retrieveAll() {
        logger.info("[retrieveAll] - Enter");

        return speechManagementRepository.findAll();
    }

    public List<Speech> retrieveByAuthor(String author) {
        logger.info("[retrieveByAuthor] - Enter");

        return speechManagementRepository.findByAuthor(author);
    }

    public List<Speech> retrieveBySubject(String subject) {
        logger.info("[retrieveBySubject] - Enter");

        return speechManagementRepository.findBySubject(subject);
    }

    public List<Speech> retrieveByDate(String startDate, String endDate) {
        logger.info("[retrieveByDate] - Enter");

        LocalDate start = LocalDate.parse(startDate);
        LocalDate end = LocalDate.parse(endDate);

        return speechManagementRepository.findBySpeechDateBetween(start, end);
    }

    public Speech createSpeech(SpeechDTO speechDTO) {
        logger.info("[createSpeech] - Enter");

        Speech speech = speechMapper.toEntity(speechDTO);

        speechManagementRepository.save(speech);

        return speech;
    }

    public Speech updateSpeech(int speechId, SpeechDTO speechDTO) {
        logger.info("[updateSpeech] - Enter");

        Speech existingSpeech = speechManagementRepository.findById(speechId)
                .orElseThrow(() -> new NoSuchElementException("Speech not found"));

        Speech updatedSpeech = speechMapper.updateSpeechFromDTO(speechDTO, existingSpeech);

        return speechManagementRepository.save(updatedSpeech);
    }

    public String deleteSpeech(int speechId) {
        logger.info("[deleteSpeech] - Enter");

        Speech speech = speechManagementRepository.findById(speechId)
                .orElseThrow(() -> new NoSuchElementException("Speech not found"));
        speechManagementRepository.delete(speech);

        return "Speech successfully deleted!";
    }

    public String sendSpeech(int speechId, String recipient) throws MessagingException {
        logger.info("[sendSpeech] - Enter");

        Speech speech = speechManagementRepository.findById(speechId)
                .orElseThrow(() -> new NoSuchElementException("Speech not found"));

        emailService.sendEmail(recipient, speech.getSubject(), speech.getContent());
        return "Speech sent successfully!";
    }
}
