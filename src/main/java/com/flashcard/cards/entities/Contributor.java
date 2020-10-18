package com.flashcard.cards.entities;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "contributors")
@SequenceGenerator(name = "id_pk", sequenceName = "contributors_seq", allocationSize = 1)
@Getter @Setter @NoArgsConstructor
public class Contributor {
	
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_pk")
	private long id;
	
	@Column
	private long userId;
	
	@Column
	private long themeId;
	
	@Column(updatable = false, columnDefinition = "timestamp DEFAULT CURRENT_TIMESTAMP")
	private Timestamp _createdAt;
	
	@Column(columnDefinition = "timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
	private Timestamp _updatedAt;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((_createdAt == null) ? 0 : _createdAt.hashCode());
		result = prime * result + ((_updatedAt == null) ? 0 : _updatedAt.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + (int) (themeId ^ (themeId >>> 32));
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
		if (_createdAt == null) {
			if (other._createdAt != null)
				return false;
		} else if (!_createdAt.equals(other._createdAt))
			return false;
		if (_updatedAt == null) {
			if (other._updatedAt != null)
				return false;
		} else if (!_updatedAt.equals(other._updatedAt))
			return false;
		if (id != other.id)
			return false;
		if (themeId != other.themeId)
			return false;
		if (userId != other.userId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Contributor [id=" + id + ", userId=" + userId + ", themeId=" + themeId + ", _createdAt=" + _createdAt
				+ ", _updatedAt=" + _updatedAt + "]";
	}
		
}
