package com.flashcard.cards.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flashcard.cards.entities.Theme;

public interface ThemeRepository extends JpaRepository<Theme, Long>{

}
