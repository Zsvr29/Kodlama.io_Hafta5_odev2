package Kodlama.io.Devs2.kodlama.io.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Kodlama.io.Devs2.kodlama.io.business.abstracts.LanguageService;
import Kodlama.io.Devs2.kodlama.io.business.request.language.CreateLanguageRequest;
import Kodlama.io.Devs2.kodlama.io.business.request.language.DeleteLanguageRequest;
import Kodlama.io.Devs2.kodlama.io.business.request.language.UpdateLanguageRequest;
import Kodlama.io.Devs2.kodlama.io.business.responses.GetAllLanguageResponses;
import Kodlama.io.Devs2.kodlama.io.entities.concretes.Language;

@RestController
@RequestMapping("/api/languages")

public class LanguagesController {
	private LanguageService languageService;
	
	@Autowired
	public LanguagesController(LanguageService languageService) {
		this.languageService=languageService;
		
	}
	@GetMapping("/getAll")
	public List<GetAllLanguageResponses> getAll(){
		return languageService.getAll();
	}
	@PostMapping("/add")
   public void add(CreateLanguageRequest createLanguageRequest) {
		this.languageService.add(createLanguageRequest);
	}
	@GetMapping("/getById")
	public Language getById(int id) {
		
		return languageService.getById(id);
	}
	
	@PutMapping("/update")
	public void update(UpdateLanguageRequest updateLanguageRequest) {
	this.languageService.update(updateLanguageRequest);

}
	@DeleteMapping("/delete")
	public void delete(DeleteLanguageRequest deleteLanguageRequest) {
		languageService.delete(deleteLanguageRequest);
	}

}



