package Kodlama.io.Devs2.kodlama.io.business.abstracts;

import java.util.List;

import Kodlama.io.Devs2.kodlama.io.business.request.technology.CreateTechnologyRequest;
import Kodlama.io.Devs2.kodlama.io.business.request.technology.DeleteTechnologyRequest;
import Kodlama.io.Devs2.kodlama.io.business.request.technology.UpdateTechonologyRequest;
import Kodlama.io.Devs2.kodlama.io.business.responses.GetAllTechnologyResponses;
import Kodlama.io.Devs2.kodlama.io.entities.concretes.Technology;

public interface TechnologyService {

	List<GetAllTechnologyResponses> getAll();
	Technology getById(int id);
	void add(CreateTechnologyRequest createTechnologyRequest);
	
	void update(UpdateTechonologyRequest updateTechonologyRequest);
	void delete(DeleteTechnologyRequest deleteTechnologyRequest);
	
	
	
	}
