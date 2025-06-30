package com.kuji.speechmanagementsystem.controller;


import com.kuji.speechmanagementsystem.datatransferobject.SpeechDTO;
import com.kuji.speechmanagementsystem.model.Speech;
import com.kuji.speechmanagementsystem.service.SpeechManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.logging.Logger;

@RestController
@RequestMapping("/speech")
public class SpeechManagementController {
    private final Logger logger = Logger.getLogger(SpeechManagementController.class.getName());

    @Autowired
    SpeechManagementService speechManagementService;

    @GetMapping("/retrieveAll")
    public ResponseEntity<List<Speech>> retrieveAll() {
        logger.info("[retrieveAll] - Called");

        return ResponseEntity.ok(speechManagementService.retrieveAll());
    }

    @GetMapping("/retrieveByAuthor")
    public ResponseEntity<List<Speech>> retrieveByAuthor(@RequestParam String author) {
        logger.info("[retrieveByAuthor] - Called");

        try {
            return ResponseEntity.ok(speechManagementService.retrieveByAuthor(author));
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/retrieveBySubject")
    public ResponseEntity<List<Speech>> retrieveBySubject(@RequestParam String subject) {
        logger.info("[retrieveBySubject] - Called");

        try {
            return ResponseEntity.ok(speechManagementService.retrieveBySubject(subject));
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/retrieveByDate")
    public ResponseEntity<List<Speech>> retrieveByDate(@RequestParam String startDate, @RequestParam String endDate) {
        logger.info("[retrieveByDate] - Called");

        try {
            return ResponseEntity.ok(speechManagementService.retrieveByDate(startDate, endDate));
        } catch (DateTimeParseException e) {
            return  ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/createSpeech")
    public ResponseEntity<Speech> createSpeech(@RequestBody SpeechDTO speechDTO ) {
        logger.info("[createSpeech] - Called");

        try {
            return new ResponseEntity<Speech>(speechManagementService.createSpeech(speechDTO), HttpStatus.CREATED);
        } catch (Exception e) {
            return  ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/updateSpeech/{speechId}")
    public ResponseEntity<Speech> updateSpeech(@PathVariable int speechId, @RequestBody SpeechDTO speechDTO) {
        logger.info("[updateSpeech] - Called");

        try {
            return ResponseEntity.ok(speechManagementService.updateSpeech(speechId, speechDTO));
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }


    @DeleteMapping("/deleteSpeech/{speechId}")
    public ResponseEntity<String> deleteSpeech(@PathVariable int speechId) {
        logger.info("[deleteSpeech] - Called");

        try {
            return ResponseEntity.ok(speechManagementService.deleteSpeech(speechId));
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>("Speech ID not found!", HttpStatus.NOT_FOUND);
        }
    }


    @PostMapping("/sendSpeech/{speechId}")
    public ResponseEntity<String> sendEmail(@PathVariable int speechId,
                                            @RequestParam String recipient) {
        logger.info("[sendEmail] - Called");

        try {
            return ResponseEntity.ok(speechManagementService.sendSpeech(speechId, recipient));
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>("Speech not found!", HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>("Error sending email", HttpStatus.BAD_REQUEST);
        }
    }
}
