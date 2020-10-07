package com.flashcard.cards.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class Deck {
	
	private long id;
	private String name;
	private String description;
	private long classId;
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (classId ^ (classId >>> 32));
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Deck other = (Deck) obj;
		if (classId != other.classId)
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Deck [id=" + id + ", name=" + name + ", description=" + description + ", classId=" + classId + "]";
	}
	
}
