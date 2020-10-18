package com.flashcard.cards.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flashcard.cards.entities.Deck;

public interface DeckRepository extends JpaRepository<Deck, Long> {

}
