package com.flashcard.cards.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.flashcard.cards.entities.Theme;
import com.flashcard.cards.services.ThemeService;

@RestController
@RequestMapping("/themes")
public class ThemeController {
	
	private Logger logger = LoggerFactory.getLogger(SubjectController.class);
	private ThemeService themeService;
	
	public ThemeController(ThemeService themeService) {
		this.themeService = themeService;
	}
	
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("/theme")
	public Theme createTheme(@RequestBody Theme theme) {
		logger.info("Subject to be created: " + theme.toString());
		
		try {
			theme = themeService.createTheme(theme);
		} catch(Exception e) {
			throw e;
		}
		
		return theme;
	}
	
	@ResponseStatus(HttpStatus.OK)
	@GetMapping
	public List<Theme> getClasses() {	
		return themeService.getAllThemes();
	}
	
	@ResponseStatus(HttpStatus.OK)
	@PutMapping("/theme")
	public Theme updateTheme(@RequestBody Theme theme) {
		logger.info("Theme to be updated: " + theme.toString());
		
		try {
			theme = themeService.updateTheme(theme);
		} catch(Exception e) {
			throw e;
		}
		
		return theme;
	}
	
}
