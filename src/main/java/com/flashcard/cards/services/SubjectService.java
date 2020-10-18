package com.flashcard.cards.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flashcard.cards.controllers.SubjectController;
import com.flashcard.cards.entities.Subject;
import com.flashcard.cards.exceptions.BadRequest;
import com.flashcard.cards.exceptions.ServerError;
import com.flashcard.cards.repositories.SubjectRepository;

@Service
public class SubjectService {
	
	private Logger logger = LoggerFactory.getLogger(SubjectController.class);
	private SubjectRepository subjectRepo;
	
	@Autowired
	public SubjectService(SubjectRepository subjectRepo) {
		this.subjectRepo = subjectRepo;
	}
	
	public List<Subject> getAllSubjects() {
		logger.info("Inside getAllSubjects");
		return subjectRepo.findAll();
	}
	
	@Transactional
	public Subject createSubject(Subject subject) {
		logger.info("Inside createSubject");
		try {
			
			subjectRepo.save(subject);
			subjectRepo.flush();
			
		} catch(RuntimeException e) {
			logger.debug(e.getMessage());
			throw new ServerError(500, "Error saving entity to database");
		} catch(Exception e) {
			logger.debug(e.getMessage());
			throw new BadRequest(400, "Invalid Subject");
		}
		
		return subject;
		
	}
	
	@Transactional
	public Subject updateSubject(Subject newSubject) {
		logger.info("Inside createSubject");
		try {
			
			Optional<Subject> oldSubjectOpt = subjectRepo.findById(newSubject.getId());
			if(!oldSubjectOpt.isPresent()) throw new Exception("Subject not found");
			Subject oldSubject = oldSubjectOpt.get();
			oldSubject = newSubject;
			
			newSubject = subjectRepo.save(oldSubject);
			subjectRepo.flush();
			
		} catch(RuntimeException e) {
			logger.debug(e.getMessage());
			throw new ServerError(500, "Error saving entity to database");
		} catch(Exception e) {
			logger.debug(e.getMessage());
			throw new BadRequest(400, "Invalid Subject");
		}
		
		return newSubject;
		
	}
	
}
