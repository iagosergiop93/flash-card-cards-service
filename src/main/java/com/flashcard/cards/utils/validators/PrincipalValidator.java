package com.flashcard.cards.utils.validators;

import com.flashcard.cards.dtos.Principal;
import com.flashcard.cards.exceptions.BadRequest;

public class PrincipalValidator {
	
	public static void validate(Principal obj) throws BadRequest {
		if(obj == null || obj.getUsername() == null || obj.getUsername().equals("") ||
				obj.getRole() == null || obj.getId() == 0) {
			
			throw new BadRequest(400, "Missing field");
		}
		
	}
	
}
