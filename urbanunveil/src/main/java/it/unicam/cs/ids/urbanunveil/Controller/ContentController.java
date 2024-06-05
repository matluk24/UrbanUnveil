package it.unicam.cs.ids.urbanunveil.Controller;

import org.springframework.web.bind.annotation.RestController;

import it.unicam.cs.ids.urbanunveil.Service.ContentService;

@RestController
public class ContentController {

	
	ContentService contentService;
	
	public ContentController(ContentService c) {
		contentService = c;
	}
}
