package com.flashcard.cards.entities;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "decks")
@SequenceGenerator(name = "id_pk", sequenceName = "decks_seq", allocationSize = 1)
@Getter @Setter @NoArgsConstructor @EqualsAndHashCode @ToString
public class Deck {
	
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_pk")
	private long id;
	
	@Column
	private String name;
	
	@Column
	private String description;
	
	@Transient
	private long themeId;
	
	@ManyToOne(targetEntity = Theme.class)
	@JsonIgnore
	private Theme theme;
	
	@Column(updatable = false, columnDefinition = "timestamp DEFAULT CURRENT_TIMESTAMP")
	private Timestamp _createdAt;
	
	@Column(columnDefinition = "timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
	private Timestamp _updatedAt;
	
}
