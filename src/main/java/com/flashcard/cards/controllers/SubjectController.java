package com.flashcard.cards.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.flashcard.cards.entities.Subject;
import com.flashcard.cards.services.SubjectService;


@RestController
@RequestMapping("/subjects")
public class SubjectController {
	
	private Logger logger = LoggerFactory.getLogger(SubjectController.class);
	private SubjectService subjectService;
	
	@Autowired
	public SubjectController(SubjectService subjectService) {
		this.subjectService = subjectService;
	}
	
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("/subject")
	public Subject createSubject(@RequestBody Subject subject) {
		logger.info("Subject to be created: " + subject.toString());
		
		try {
			subject = subjectService.createSubject(subject);
		} catch(Exception e) {
			throw e;
		}
		
		return subject;
	}
	
	@ResponseStatus(HttpStatus.OK)
	@GetMapping
	public List<Subject> getSubjects() {	
		return subjectService.getAllSubjects();
	}
	
	@ResponseStatus(HttpStatus.OK)
	@PutMapping("/subject")
	public Subject updateSubject(@RequestBody Subject subject) {
		logger.info("Subject to be updated: " + subject.toString());
		
		try {
			subject = subjectService.updateSubject(subject);
		} catch(Exception e) {
			throw e;
		}
		
		return subject;
	}
	
}
