package com.flashcard.cards.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flashcard.cards.controllers.SubjectController;
import com.flashcard.cards.entities.Subject;
import com.flashcard.cards.entities.Theme;
import com.flashcard.cards.exceptions.BadRequest;
import com.flashcard.cards.exceptions.ServerError;
import com.flashcard.cards.repositories.SubjectRepository;
import com.flashcard.cards.repositories.ThemeRepository;

@Service
public class ThemeService {
	
	private Logger logger = LoggerFactory.getLogger(SubjectController.class);
	private ThemeRepository themeRepo;
	private SubjectRepository subjectRepo;
	
	@Autowired
	public ThemeService(ThemeRepository themeRepo, SubjectRepository subjectRepo) {
		this.themeRepo = themeRepo;
		this.subjectRepo = subjectRepo;
	}
	
	public List<Theme> getAllThemes() {
		logger.info("Inside getAllthemes");
		List<Theme> themes = null;
		try {
			themes = this.themeRepo.findAll()
						.stream()
						.map((Theme theme) -> {
							theme.setSubjectId(theme.getSubject().getId());
							return theme;
						})
						.collect(Collectors.toList());
			
		} catch (RuntimeException e) {
			e.printStackTrace();
			throw new ServerError(500, "Error fetching entity");
		} catch (Exception e) {
			e.printStackTrace();
			throw new BadRequest(400, "Error fetching entity");
		}

		return themes;
	}
	
	@Transactional
	public Theme createTheme(Theme theme) {
		logger.info("Inside createTheme");
		try {
			Optional<Subject> subjectOpt = subjectRepo.findById(theme.getSubjectId());
			if(!subjectOpt.isPresent()) throw new Exception("Subject not found");
			theme.setSubject(subjectOpt.get());
			
			themeRepo.save(theme);
			themeRepo.flush();
			
		} catch(RuntimeException e) {
			e.printStackTrace();
			throw new ServerError(500, "Error saving entity to database");
		} catch(Exception e) {
			e.printStackTrace();
			throw new BadRequest(400, "Invalid Subject");
		}
		
		return theme;
		
	}
	
	@Transactional
	public Theme updateTheme(Theme newTheme) {
		logger.info("Inside createTheme");
		try {
			
			Optional<Theme> oldThemeOpt = themeRepo.findById(newTheme.getId());
			if(!oldThemeOpt.isPresent()) throw new Exception("Theme not found");
			Theme oldTheme = oldThemeOpt.get();
			
			newTheme.setSubject(oldTheme.getSubject());
			oldTheme = newTheme;
			
			newTheme = themeRepo.save(oldTheme);
			themeRepo.flush();
			
		} catch(RuntimeException e) {
			logger.debug(e.getMessage());
			throw new ServerError(500, "Error saving entity to database");
		} catch(Exception e) {
			logger.debug(e.getMessage());
			throw new BadRequest(400, "Invalid Subject");
		}
		
		return newTheme;
		
	}
	
}
