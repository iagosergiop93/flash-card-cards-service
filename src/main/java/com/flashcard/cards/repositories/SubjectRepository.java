package com.flashcard.cards.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flashcard.cards.entities.Subject;

public interface SubjectRepository extends JpaRepository<Subject, Long> {

}
