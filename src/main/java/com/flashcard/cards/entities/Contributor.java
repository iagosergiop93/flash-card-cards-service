package com.flashcard.cards.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class Contributor {
	
	private long userId;
	private long classId;
	
	@Override
	public String toString() {
		return "Contributor [userId=" + userId + ", classId=" + classId + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (classId ^ (classId >>> 32));
		result = prime * result + (int) (userId ^ (userId >>> 32));
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
		Contributor other = (Contributor) obj;
		if (classId != other.classId)
			return false;
		if (userId != other.userId)
			return false;
		return true;
	}
		
}
