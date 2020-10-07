package com.flashcard.cards.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class ClassName {
	
	private long id;
	private long authorId;
	private String name;
	private String description;
	private long subjectId;
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (authorId ^ (authorId >>> 32));
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + (int) (subjectId ^ (subjectId >>> 32));
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
		ClassName other = (ClassName) obj;
		if (authorId != other.authorId)
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
		if (subjectId != other.subjectId)
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "ClassName [id=" + id + ", authorId=" + authorId + ", name=" + name + ", description=" + description
				+ ", subjectId=" + subjectId + "]";
	}
	
}
