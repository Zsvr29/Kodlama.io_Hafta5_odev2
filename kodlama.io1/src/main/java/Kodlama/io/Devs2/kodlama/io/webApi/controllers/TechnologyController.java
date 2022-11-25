package Kodlama.io.Devs2.kodlama.io.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Kodlama.io.Devs2.kodlama.io.business.abstracts.TechnologyService;
import Kodlama.io.Devs2.kodlama.io.business.request.technology.CreateTechnologyRequest;
import Kodlama.io.Devs2.kodlama.io.business.request.technology.DeleteTechnologyRequest;
import Kodlama.io.Devs2.kodlama.io.business.request.technology.UpdateTechonologyRequest;
import Kodlama.io.Devs2.kodlama.io.business.responses.GetAllTechnologyResponses;

@RestController
@RequestMapping("/api/technology")


public class TechnologyController {
	private TechnologyService technologyService;
	
	@Autowired
	public TechnologyController(TechnologyService technologyService) {
		this.technologyService=technologyService;
		
	}
	@GetMapping("/getAll")
	public List<GetAllTechnologyResponses> getAll(){
		return technologyService.getAll();
	}
	@PostMapping("/add")
	public void add(CreateTechnologyRequest createTechnologyRequest) {
		this.technologyService.add(createTechnologyRequest);
	}
	@PutMapping("/update")
	public void update(UpdateTechonologyRequest updateTechonologyRequest,int id) throws Exception {
		this.technologyService.update(updateTechonologyRequest,id);
	}
	
	@GetMapping("/id")
		GetAllTechnologyResponses getOne(int id) {
			return this.technologyService.getOne(id);
		}
		
	
	@DeleteMapping("/delete")
	public void delete(DeleteTechnologyRequest deleteTechnologyRequest,int id) {
		this.technologyService.delete(deleteTechnologyRequest,id);
		
		
	}
	

}
