package com.flashcard.cards.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flashcard.cards.entities.ClassName;

public interface ClassNameRepository extends JpaRepository<ClassName, Long>{

}
