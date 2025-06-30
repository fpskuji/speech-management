package com.kuji.speechmanagementsystem.repository;

import com.kuji.speechmanagementsystem.model.Speech;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface SpeechManagementRepository extends JpaRepository<Speech, Integer> {
    List<Speech> findByAuthor(String author);

    List<Speech> findBySubject(String subject);

    List<Speech> findBySpeechDateBetween(LocalDate startDate, LocalDate endDate);
}
