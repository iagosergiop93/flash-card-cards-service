package com.flashcard.cards.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flashcard.cards.entities.Card;

public interface CardRepository extends JpaRepository<Card, Long> {
	
}
